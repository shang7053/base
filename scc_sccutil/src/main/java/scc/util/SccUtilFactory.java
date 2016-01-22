package scc.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import scc.util.array.center.ArrayImpl;
import scc.util.array.service.IArray;
import scc.util.cache.ICache;
import scc.util.cache.data.CacheData;
import scc.util.cache.util.Dom4jUtil;
import scc.util.date.center.DateImpl;
import scc.util.date.service.IDate;
import scc.util.jsengine.center.JSEngineImpl;
import scc.util.jsengine.service.IJSEngine;
import scc.util.log.center.SccLogImpl;
import scc.util.log.service.ILog;
import scc.util.page.center.PageImpl;
import scc.util.page.service.Ipage;
import scc.util.poi.center.IExportExcel;
import scc.util.poi.exception.ExportExcelException;
import scc.util.poi.menu.ExcelType;
import scc.util.poi.typeenum.TypeName;
import scc.util.poi.util.ExportUtil;
import scc.util.propeties.center.PropertiesImpl;
import scc.util.propeties.service.IProperties;
import scc.util.string.center.StringUtilOperateImpl;
import scc.util.string.service.IString;

/**
 * 
 * @ClassName: SccStringUtilFactory
 * @Description: 字符串常用操作
 * @author scc
 * @date 2014年11月17日 上午11:31:07
 *
 */
public class SccUtilFactory {
    /**
     * 
     * @Title: instance
     * @Description: 获取字符串常用操作
     * @return 字符串常用操作接口实例
     */
    public static IString instanceString() {
        return new StringUtilOperateImpl();
    }

    /**
     * 日期工具
     * 
     * @return
     */
    public static IDate instanceDate() {
        return new DateImpl();
    }

    /**
     * 日志工具
     * 
     * @return
     */
    public static ILog instanceLog() {
        return new SccLogImpl();
    }

    /**
     * 集合工具
     * 
     * @param <T>
     * @return
     */
    public static <T> IArray<T> instanceArray(List<T> datasource, Class<T> baseClass) {
        return new ArrayImpl<T>(datasource, baseClass);
    }

    /**
     * 
     * @Title: instancePage
     * @Description: jsp转html工具
     * @return
     */
    public static Ipage instancePage() {
        return new PageImpl();
    }

    /**
     * 
     * @Title: instanceJSEngine
     * @Description: js脚本工具工具
     * @return
     */
    public static IJSEngine instanceJSEngine() {
        return new JSEngineImpl();
    }

    /**
     * 
     * @Title: instance
     * @Description: 获取接口实例
     * @param type excel版本
     * @param dataClass 数据class
     * @return 接口实例
     * @throws ExportExcelException 导出异常
     */
    public static <T> IExportExcel<T> instanceExportExcel(ExcelType type, Class<T> dataClass)
            throws ExportExcelException {
        if (("二零零三").equals(type.toString())) {
            return new ExportExcel03Impl<T>(dataClass);
        } else if (("二零零七及以上").equals(type.toString())) {
            return new ExportExcel07Impl<T>(dataClass);
        } else {
            return null;
        }
    }

    /**
     * 构建缓存对象
     * 
     * @return 缓存对象
     */
    public static ICache instanceCache() {
        return new CacheImpl();
    }

    /**
     * 构建properties对象
     * 
     * @return properties对象
     */
    public static IProperties instanceProperties() {
        return new PropertiesImpl();
    }

    private final static class CacheImpl implements ICache {

        private static Logger logger = Logger.getLogger(CacheImpl.class);
        // private static Map<String, CacheData> datas = new Hashtable<String,
        // CacheData>();
        private static final ConcurrentHashMap<String, CacheData> datas = new ConcurrentHashMap<String, CacheData>();
        private static final Integer setTime;// 缓存时间
        private static final boolean isStartCache;// 是否开启缓存
        private static boolean isStartTimer;// 是否开始定时器
        private static final Integer delay;// 定时器延迟启动时间
        private static final Integer period;// 定时器启动间隔
        private String pref;

        static {
            logger.info("初始化缓存器");
            String temp = Dom4jUtil.getAttribute("data", "time");
            setTime = ("").equals(temp) ? 0 : Integer.valueOf(temp);
            logger.debug("设置缓存时长" + setTime);
            isStartCache = ("").equals(temp) || ("0").equals(temp) ? false : true;
            logger.debug("是否启动缓存器" + isStartCache);
            String delaystr = Dom4jUtil.getAttribute("clearOverdueCacheTimer", "delay");
            logger.debug("设置缓存器垃圾清理器启动延迟" + delaystr);
            String periodstr = Dom4jUtil.getAttribute("clearOverdueCacheTimer", "period");
            logger.debug("设置缓存器垃圾清理器任务间隔" + periodstr);
            if (null != periodstr && !"".equals(periodstr.trim())) {
                delay = null == delaystr ? 0 : Integer.valueOf(delaystr);
                period = Integer.valueOf(periodstr.trim());
                isStartTimer = true;
            } else {
                isStartTimer = false;
                delay = 0;
                period = 12;
            }
            logger.info("初始化缓存器完毕，是否开启缓存：" + isStartCache + "是否启动垃圾清理器" + isStartTimer + "垃圾清理其启动延迟" + delay + "，任务间隔"
                    + period);
        }

        public CacheImpl() {
            if (isStartTimer) {
                isStartTimer = false;
                this.startTimer();
            }
        }

        @Override
        public void addCacheData(Date loadDate, String queryArgs, Object data) {
            this.addOrUpdate(loadDate, queryArgs, data);
        }

        @Override
        public void addCacheData(String queryArgs, CacheData data) {
            this.addOrUpdate(data.getLoadDate(), queryArgs, data.getData());
        }

        @SuppressWarnings("deprecation")
        @Override
        public void addOrUpdate(Date loadDate, String queryArgs, Object data) {
            logger.info("当前缓存数量" + datas.size() + "添加缓存，loadDate" + loadDate.toLocaleString() + "参数" + this.pref
                    + queryArgs + "数据" + data);
            if (isStartCache && this.validateArgs(loadDate, queryArgs, data)) {
                datas.putIfAbsent(this.pref + queryArgs, new CacheData(loadDate, data));
            }
        }

        @Override
        public void addOrUpdate(String queryArgs, CacheData data) {
            this.addOrUpdate(data.getLoadDate(), queryArgs, data.getData());
        }

        @SuppressWarnings("deprecation")
        @Override
        public void updateCacheData(Date loadDate, String queryArgs, Object data) {
            logger.info("当前缓存数量" + datas.size() + "修改缓存，loadDate" + loadDate.toLocaleString() + "参数" + this.pref
                    + queryArgs + "数据" + data);
            if (isStartCache && this.validateArgs(loadDate, queryArgs, data)) {
                datas.put(this.pref + queryArgs, new CacheData(loadDate, data));
            }
        }

        @Override
        public void updateCacheData(String queryArgs, CacheData data) {
            this.updateCacheData(data.getLoadDate(), queryArgs, data.getData());
        }

        @Override
        public Object getCacheData(String queryArgs) {
            logger.info("当前缓存数量" + datas.size() + "获取缓存，参数" + this.pref + queryArgs);
            if (isStartCache) {
                return datas.get(this.pref + queryArgs) == null ? null : datas.get(this.pref + queryArgs).getData();
            }
            return null;
        }

        @Override
        @Deprecated
        public boolean hasCacheData(String queryArgs) {
            logger.info("当前缓存数量" + datas.size() + "验证是否包换缓存，参数" + this.pref + queryArgs);
            if (isStartCache) {
                CacheData cacheData = datas.get(this.pref + queryArgs);
                if (null != cacheData) {
                    Date loadDate = cacheData.getLoadDate();
                    long time = (new Date().getTime() - loadDate.getTime());
                    if (time > Long.valueOf(setTime)) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        /**
         * 验证参数
         * 
         * @param loadDate
         *            加载时间
         * @param queryArgs
         *            查询参数
         * @param data
         *            缓存数据对
         */
        protected boolean validateArgs(Date loadDate, String queryArgs, Object data) {
            if (null == loadDate) {
                return false;
            }
            if (null == queryArgs || "".equals(queryArgs)) {
                return false;
            }
            if (null == data) {
                return false;
            }
            return true;
        }

        private void startTimer() {
            logger.debug("垃圾清理器启动");
            ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
            ses.scheduleAtFixedRate(new Runnable() {

                @Override
                public void run() {
                    logger.debug("垃圾清理器开始清理");
                    CacheImpl.this.clearOverdueCache();
                    logger.debug("垃圾清理器结束清理");
                }
            }, delay, period, TimeUnit.HOURS);
            logger.debug("垃圾清理器结束");
        }

        @Override
        public void clearOverdueCache() {
            logger.info(Thread.currentThread().getName() + "正在收集缓存脏数据");
            List<String> temp = new ArrayList<String>();
            for (Entry<String, CacheData> cachedata : datas.entrySet()) {
                long time = new Date().getTime() - cachedata.getValue().getLoadDate().getTime();
                if (time > Long.valueOf(setTime)) {
                    temp.add(cachedata.getKey());
                }
            }
            logger.debug(Thread.currentThread().getName() + "收集缓存脏数据完毕，收集到" + temp.size() + "条数据:"
                    + Arrays.toString(temp.toArray(new String[temp.size()])) + "");
            for (String s : temp) {
                logger.debug(Thread.currentThread().getName() + "开始清除：" + s);
                datas.remove(s);
                logger.debug(Thread.currentThread().getName() + "清除" + s + "完毕！");
            }
        }

        @Override
        public ICache setKeyPref(String pref) {
            if (null == pref) {
                this.pref = "";
            }
            if (null != pref) {
                this.pref = pref;
            }
            return this;
        }
    }

    private static final class ExportExcel03Impl<T> implements IExportExcel<T> {
        // private List<String> headers = new ArrayList<>();
        // private List<String> comments = new ArrayList<>();
        private Class<T> c;

        ExportExcel03Impl(Class<T> dataClass) throws ExportExcelException {
            if (null == dataClass) {
                throw new ExportExcelException("参数class不可为空");
            }
            this.c = dataClass;
        }

        @Override
        public void export(List<T> exportData, String title, OutputStream out, List<String> headers,
                List<String> comments) {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFCellStyle headerStyle = ExportUtil.createHSSFHeaderCellStyle(workbook);
            HSSFCellStyle bodyStyle = ExportUtil.createHSSFBodyCellStyle(workbook);
            HSSFFont headerFont = ExportUtil.createHSSFHeaderCellFont(workbook);
            HSSFFont bodyFont = ExportUtil.createHSSFBodyCellFont(workbook);
            headerStyle.setFont(headerFont);
            bodyStyle.setFont(bodyFont);
            HSSFSheet sheet = ExportUtil.createHssfSheet(workbook, "sheet1");
            // 声明一个画图的顶级管理器
            HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
            // 定义注释的大小和位置,详见文档
            HSSFComment comment = null;
            // 产生表格标题行
            HSSFRow row = sheet.createRow(0);
            if (null != headers) {
                for (int i = 0; i < headers.size(); i++) {
                    HSSFCell cell = row.createCell(i);
                    if (null != comments && comments.size() > 0 && !"".equals(comments.get(i))) {
                        comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
                        // 设置注释内容
                        comment.setString(new HSSFRichTextString(comments.get(i)));
                        cell.setCellComment(comment);
                    }
                    cell.setCellStyle(headerStyle);
                    HSSFRichTextString text = new HSSFRichTextString(headers.get(i));
                    text.applyFont(headerFont);
                    cell.setCellValue(text);
                }
            }
            int datalength = exportData.size() <= 60000 ? exportData.size() : 60000;
            for (int i = 0; i < datalength; i++) {
                if (null != headers && headers.size() > 0) {
                    row = sheet.createRow(i + 1);
                } else {
                    row = sheet.createRow(i);
                }
                Field[] fields = this.c.getDeclaredFields();
                int j = 0;
                if (i == 59999) {
                    sheet.addMergedRegion(new CellRangeAddress(i, i, 0, fields.length));
                    HSSFCell cell = row.createCell(j);
                    cell.setCellStyle(bodyStyle);
                    HSSFRichTextString richString = new HSSFRichTextString(
                            "对不起，您要导出的数据过多，为保证数据完整，未导出全部数据，若想导出更多，请使用excel2007版本或以上版本。");
                    richString.applyFont(bodyFont);
                    cell.setCellValue(richString);
                    break;
                }
                for (Field f : fields) {
                    String fieldName = f.getName();
                    if (fieldName.equals("serialVersionUID")) {
                        continue;
                    }
                    HSSFCell cell = row.createCell(j);
                    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Method getMethod;
                    Object value = null;
                    try {
                        getMethod = this.c.getMethod(getMethodName);
                        value = getMethod.invoke(exportData.get(i));
                    } catch (NoSuchMethodException | SecurityException | IllegalAccessException
                            | IllegalArgumentException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    cell.setCellStyle(bodyStyle);
                    if (value instanceof Date) {
                        HSSFCellStyle dateCellStyle = ExportUtil.createHSSFBodyCellStyle(workbook);
                        HSSFDataFormat format = workbook.createDataFormat();
                        dateCellStyle.setDataFormat(format.getFormat("yyyy-MM-dd HH:mm:ss"));
                        cell.setCellStyle(dateCellStyle);
                        cell.setCellValue((Date) value);
                    } else if (value instanceof Integer) {
                        cell.setCellValue((Integer) value);
                    } else if (value instanceof Short) {
                        cell.setCellValue((Short) value);
                    } else if (value instanceof Byte) {
                        cell.setCellValue((Byte) value);
                    } else if (value instanceof Long) {
                        cell.setCellValue((Long) value);
                    } else if (value instanceof Double) {
                        cell.setCellValue((Double) value);
                    } else if (value instanceof Float) {
                        cell.setCellValue((Float) value);
                    } else if (value instanceof Character) {
                        cell.setCellValue(value.toString());
                    } else if (value instanceof String) {
                        cell.setCellValue((String) value);
                    } else if (value instanceof BigDecimal) {
                        cell.setCellValue(((BigDecimal) value).doubleValue());
                    } else if (value instanceof Boolean) {
                        cell.setCellValue((Boolean) value);
                    } else if (value instanceof Collection<?>) {} else {
                        if (null == value) {
                            cell.setCellValue("");
                        } else {
                            cell.setCellValue(value.toString());
                        }
                    }
                    j++;
                }
            }
            try {
                workbook.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @SuppressWarnings("resource")
        @Override
        public List<T> importExcel(InputStream is, Integer startIndex) throws ExportExcelException {
            HSSFWorkbook book = null;
            try {
                book = new HSSFWorkbook(is);
            } catch (Exception e) {
                throw new ExportExcelException("未知错误，请检查表格格式是否为纯文本，且日期格式符合类似2015-03-31 12:00:00格式！");
            }
            HSSFSheet sheet = book.getSheetAt(0);
            int rows = sheet.getLastRowNum();
            List<T> dataList = new ArrayList<>();
            for (int i = startIndex; i <= rows; i++) {
                HSSFRow row = sheet.getRow(i);
                Field[] fields = this.c.getDeclaredFields();
                List<Field> showFields = new ArrayList<>();
                for (Field field : fields) {
                    Field f = field;
                    f.setAccessible(true);
                    if (!"serialVersionUID".endsWith(f.getName())) {
                        showFields.add(f);
                    }
                }
                if (sheet.getRow(0).getLastCellNum() - showFields.size() != 0) {
                    throw new ExportExcelException("表格列数[" + sheet.getRow(0).getLastCellNum() + "]与期望的列数["
                            + showFields.size() + "]不匹配，请先下载模板表格，然后在模板表格里造数据");
                }
                if (row != null) {
                    int cells = row.getLastCellNum();
                    T t = null;
                    try {
                        t = this.c.newInstance();
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < cells; j++) {
                        HSSFCell cell = row.getCell(j);
                        try {
                            ExportUtil.setObject(t, showFields.get(j), cell);
                        } catch (Exception e) {
                            throw new ExportExcelException("表格数据验证错误：第" + (i + 1) + "行，第" + (j + 1) + "列。期望类型"
                                    + TypeName.getTypeName(showFields.get(j).getType().getName()) + "转换值"
                                    + cell.toString() + "时，无法匹配");
                        }
                    }
                    dataList.add(t);
                }
            }
            try {
                book.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return dataList;
        }

        @Override
        public void export(List<T> exportData, String title, OutputStream out, List<String> headers) {
            this.export(exportData, title, out, headers, null);
        }

        @Override
        public void export(List<T> exportData, String title, OutputStream out) {
            this.export(exportData, title, out, null, null);
        }
    }

    private static final class ExportExcel07Impl<T> implements IExportExcel<T> {
        private Class<T> c;

        ExportExcel07Impl(Class<T> dataClass) throws ExportExcelException {
            if (null == dataClass) {
                throw new ExportExcelException("参数class不可为空");
            }
            this.c = dataClass;
        }

        @Override
        public void export(List<T> exportData, String title, OutputStream out, List<String> headers,
                List<String> comments) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFCellStyle headerStyle = ExportUtil.createXSSFHeaderCellStyle(workbook);
            XSSFCellStyle bodyStyle = ExportUtil.createXSSFBodyCellStyle(workbook);
            XSSFFont headerFont = ExportUtil.createXSSFHeaderCellFont(workbook);
            XSSFFont bodyFont = ExportUtil.createXSSFBodyCellFont(workbook);
            headerStyle.setFont(headerFont);
            bodyStyle.setFont(bodyFont);
            XSSFSheet sheet = ExportUtil.createXSSFSheet(workbook, "sheet1");
            // 声明一个画图的顶级管理器
            XSSFDrawing patriarch = sheet.createDrawingPatriarch();
            // 定义注释的大小和位置,详见文档
            XSSFComment comment = null;
            // 产生表格标题行
            XSSFRow row = sheet.createRow(0);
            if (null != headers) {
                for (int i = 0; i < headers.size(); i++) {
                    XSSFCell cell = row.createCell(i);
                    if (null != comments && comments.size() > 0 && !"".equals(comments.get(i))) {
                        comment = patriarch
                                .createCellComment(new XSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
                        // 设置注释内容
                        comment.setString(new XSSFRichTextString(comments.get(i)));
                        cell.setCellComment(comment);
                    }
                    cell.setCellStyle(headerStyle);
                    XSSFRichTextString text = new XSSFRichTextString(headers.get(i));
                    text.applyFont(headerFont);
                    cell.setCellValue(text);
                }
            }
            int datalength = exportData.size() <= 1048000 ? exportData.size() : 1048000;
            for (int i = 0; i < datalength; i++) {
                if (null != headers && headers.size() > 0) {
                    row = sheet.createRow(i + 1);
                } else {
                    row = sheet.createRow(i);
                }
                Field[] fields = this.c.getDeclaredFields();
                int j = 0;
                if (i == 1047999) {
                    sheet.addMergedRegion(new CellRangeAddress(i, i, 0, fields.length));
                    XSSFCell cell = row.createCell(j);
                    cell.setCellStyle(bodyStyle);
                    XSSFRichTextString richString = new XSSFRichTextString(
                            "对不起，您要导出的数据过多，为保证数据完整，未导出全部数据，若想导出更多，请使用excel2007版本或以上版本。");
                    richString.applyFont(bodyFont);
                    cell.setCellValue(richString);
                    break;
                }
                for (Field f : fields) {
                    String fieldName = f.getName();
                    if (fieldName.equals("serialVersionUID")) {
                        continue;
                    }
                    XSSFCell cell = row.createCell(j);
                    cell.setCellStyle(bodyStyle);
                    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Method getMethod;
                    Object value = null;
                    try {
                        getMethod = this.c.getMethod(getMethodName);
                        value = getMethod.invoke(exportData.get(i));
                    } catch (NoSuchMethodException | SecurityException | IllegalAccessException
                            | IllegalArgumentException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    cell.setCellStyle(bodyStyle);
                    if (value instanceof Date) {
                        XSSFCellStyle dateCellStyle = ExportUtil.createXSSFBodyCellStyle(workbook);
                        XSSFDataFormat format = workbook.createDataFormat();
                        dateCellStyle.setDataFormat(format.getFormat("yyyy-MM-dd HH:mm:ss"));
                        cell.setCellStyle(dateCellStyle);
                        cell.setCellValue((Date) value);
                    } else if (value instanceof Integer) {
                        cell.setCellValue((Integer) value);
                    } else if (value instanceof Short) {
                        cell.setCellValue((Short) value);
                    } else if (value instanceof Byte) {
                        cell.setCellValue((Byte) value);
                    } else if (value instanceof Long) {
                        cell.setCellValue((Long) value);
                    } else if (value instanceof Double) {
                        cell.setCellValue((Double) value);
                    } else if (value instanceof Float) {
                        cell.setCellValue((Float) value);
                    } else if (value instanceof Character) {
                        cell.setCellValue(value.toString());
                    } else if (value instanceof String) {
                        cell.setCellValue((String) value);
                    } else if (value instanceof BigDecimal) {
                        cell.setCellValue(((BigDecimal) value).doubleValue());
                    } else if (value instanceof Boolean) {
                        cell.setCellValue((Boolean) value);
                    } else if (value instanceof Collection<?>) {} else {
                        if (null == value) {
                            cell.setCellValue("");
                        } else {
                            cell.setCellValue(value.toString());
                        }
                    }
                    j++;
                }
            }
            try {
                workbook.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @SuppressWarnings("resource")
        @Override
        public List<T> importExcel(InputStream is, Integer startIndex) throws ExportExcelException {
            XSSFWorkbook book = null;
            try {
                book = new XSSFWorkbook(is);
            } catch (Exception e) {
                throw new ExportExcelException("未知错误，请检查表格格式是否为纯文本，且日期格式符合类似2015-03-31 12:00:00格式！");
            }
            XSSFSheet sheet = book.getSheetAt(0);
            int rows = sheet.getLastRowNum();
            List<T> dataList = new ArrayList<>();
            for (int i = startIndex; i <= rows; i++) {
                XSSFRow row = sheet.getRow(i);
                Field[] fields = this.c.getDeclaredFields();
                List<Field> showFields = new ArrayList<>();
                for (Field field : fields) {
                    Field f = field;
                    f.setAccessible(true);
                    if (!"serialVersionUID".endsWith(f.getName())) {
                        showFields.add(f);
                    }
                }
                if (sheet.getRow(0).getLastCellNum() - showFields.size() != 0) {
                    throw new ExportExcelException("表格列数[" + sheet.getRow(0).getLastCellNum() + "]与期望的列数["
                            + showFields.size() + "]不匹配，请先下载模板表格，然后在模板表格里造数据");
                }
                if (row != null) {
                    int cells = row.getLastCellNum();
                    T t = null;
                    try {
                        t = this.c.newInstance();
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < cells; j++) {
                        XSSFCell cell = row.getCell(j);
                        try {
                            ExportUtil.setObject(t, showFields.get(j), cell);
                        } catch (Exception e) {
                            throw new ExportExcelException("表格数据验证错误：第" + (i + 1) + "行，第" + (j + 1) + "列。期望类型"
                                    + TypeName.getTypeName(showFields.get(j).getType().getName()) + "转换值"
                                    + cell.toString() + "时，无法匹配");
                        }
                    }
                    dataList.add(t);
                }
            }
            try {
                book.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return dataList;
        }

        @Override
        public void export(List<T> exportData, String title, OutputStream out, List<String> headers) {
            this.export(exportData, title, out, headers, null);
        }

        @Override
        public void export(List<T> exportData, String title, OutputStream out) {
            this.export(exportData, title, out, null, null);
        }
    }
}
