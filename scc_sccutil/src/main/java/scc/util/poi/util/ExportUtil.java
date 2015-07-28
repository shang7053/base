package scc.util.poi.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * 
 * @ClassName: ExportUtil 
 * @Description: excel工具类
 * @author scc
 * @date 2014年11月6日 下午12:44:26 
 *
 */
public class ExportUtil {
	//标题样式
	private static Short headerFillForegroundColor;
	private static Short headerFillPattern;
	private static Short headerBorderBottom;
	private static Short headerBorderLeft;
	private static Short headerBorderRight;
	private static Short headerBorderTop;
	private static Short headerAlignment;
	//数据体样式
	private static Short bodyFillForegroundColor;
	private static Short bodyFillPattern;
	private static Short bodyBorderBottom;
	private static Short bodyBorderLeft;
	private static Short bodyBorderRight;
	private static Short bodyBorderTop;
	private static Short bodyAlignment;
	//标题字体样式
	private static Short headerFontColor;
	private static Short headerFontHeightInPoints;
	private static Short headerFontBoldweight;
	private static String headerFontName;
	//数据体字体样式
	private static Short bodyFontColor;
	private static Short bodyFontHeightInPoints;
	private static Short bodyBoldweight;
	private static String bodyFontName;
	//默认宽高度
	private static Integer sheetDefaultColumnWidth;
	private static Short sheetDefaultRowHeight;
	private static Properties p = new Properties();
	static {
		try {
			p.load(ExportUtil.class.getClassLoader().getResourceAsStream("sccpoisettings.properties"));
			headerFillForegroundColor = (Short) p.get("headerFillForegroundColor");
			headerFillPattern = (Short) p.get("headerFillPattern");
			headerBorderBottom = (Short) p.get("headerBorderBottom");
			headerBorderLeft = (Short) p.get("headerBorderLeft");
			headerBorderRight = (Short) p.get("headerBorderRight");
			headerBorderTop = (Short) p.get("headerBorderTop");
			headerAlignment = (Short) p.get("headerAlignment");

			bodyFillForegroundColor = (Short) p.get("bodyFillForegroundColor");
			bodyFillPattern = (Short) p.get("bodyFillPattern");
			bodyBorderBottom = (Short) p.get("bodyBorderBottom");
			bodyBorderLeft = (Short) p.get("bodyBorderLeft");
			bodyBorderRight = (Short) p.get("bodyBorderRight");
			bodyBorderTop = (Short) p.get("bodyBorderTop");
			bodyAlignment = (Short) p.get("bodyAlignment");

			headerFontColor = (Short) p.get("headerFontColor");
			headerFontHeightInPoints = (Short) p.get("headerFontHeightInPoints");
			headerFontBoldweight = (Short) p.get("headerBoldweight");
			headerFontName = (String) p.get("headerFontName");

			bodyFontColor = (Short) p.get("bodyFontColor");
			bodyFontHeightInPoints = (Short) p.get("bodyFontHeightInPoints");
			bodyBoldweight = (Short) p.get("bodyBoldweight");
			bodyFontName = (String) p.get("bodyFontName");
			
			sheetDefaultColumnWidth = (Integer) p.get("sheetDefaultColumnWidth");
			sheetDefaultRowHeight = (Short) p.get("sheetDefaultRowHeight");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @Title: isNull 
	 * @Description: 判断传入对象是否为空
	 * @param data 要判断的对象
	 * @return 是否为空
	 */
	private static boolean isNull(Object data) {
		return null == data;
	}
	/**
	 * 
	 * @Title: createHSSFHeaderCellStyle 
	 * @Description: 创建03版本标题单元格样式
	 * @param workbook 工作表对象
	 * @return 样式对象
	 */
	public static HSSFCellStyle createHSSFHeaderCellStyle(HSSFWorkbook workbook) {
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		if (!isNull(headerFillForegroundColor))
			style.setFillForegroundColor(headerFillForegroundColor);
		if (!isNull(headerFillPattern))
			style.setFillPattern(headerFillPattern);
		if (!isNull(headerBorderBottom))
			style.setBorderBottom(headerBorderBottom);
		if (!isNull(headerBorderLeft))
			style.setBorderLeft(headerBorderLeft);
		if (!isNull(headerBorderRight))
			style.setBorderRight(headerBorderRight);
		if (!isNull(headerBorderTop))
			style.setBorderTop(headerBorderTop);
		if (!isNull(headerAlignment))
			style.setAlignment(headerAlignment);
		return style;
	}
	/**
	 * 
	 * @Title: createXSSFHeaderCellStyle 
	 * @Description: 创建07版本及以上标题单元格样式
	 * @param workbook 工作表对象
	 * @return 样式对象
	 */
	public static XSSFCellStyle createXSSFHeaderCellStyle(XSSFWorkbook workbook) {
		// 生成一个样式
		XSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		if (!isNull(headerFillForegroundColor))
			style.setFillForegroundColor(headerFillForegroundColor);
		if (!isNull(headerFillPattern))
			style.setFillPattern(headerFillPattern);
		if (!isNull(headerBorderBottom))
			style.setBorderBottom(headerBorderBottom);
		if (!isNull(headerBorderLeft))
			style.setBorderLeft(headerBorderLeft);
		if (!isNull(headerBorderRight))
			style.setBorderRight(headerBorderRight);
		if (!isNull(headerBorderTop))
			style.setBorderTop(headerBorderTop);
		if (!isNull(headerAlignment))
			style.setAlignment(headerAlignment);
		return style;
	}
	/**
	 * 
	 * @Title: createXSSFBodyCellStyle 
	 * @Description: 创建07版本及以上数据体单元格样式
	 * @param workbook 工作表对象
	 * @return 样式对象
	 */
	public static XSSFCellStyle createXSSFBodyCellStyle(XSSFWorkbook workbook) {
		// 生成一个样式
		XSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		if (!isNull(bodyFillForegroundColor))
			style.setFillForegroundColor(bodyFillForegroundColor);
		if (!isNull(bodyFillPattern))
			style.setFillPattern(bodyFillPattern);
		if (!isNull(bodyBorderBottom))
			style.setBorderBottom(bodyBorderBottom);
		if (!isNull(bodyBorderLeft))
			style.setBorderLeft(bodyBorderLeft);
		if (!isNull(bodyBorderRight))
			style.setBorderRight(bodyBorderRight);
		if (!isNull(bodyBorderTop))
			style.setBorderTop(bodyBorderTop);
		if (!isNull(bodyAlignment))
			style.setAlignment(bodyAlignment);
		return style;
	}
	/**
	 * 
	 * @Title: createHSSFBodyCellStyle 
	 * @Description: 创建03版本数据体单元格样式
	 * @param workbook 工作表对象
	 * @return 样式对象
	 */
	public static HSSFCellStyle createHSSFBodyCellStyle(HSSFWorkbook workbook) {
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		if (!isNull(bodyFillForegroundColor))
			style.setFillForegroundColor(bodyFillForegroundColor);
		if (!isNull(bodyFillPattern))
			style.setFillPattern(bodyFillPattern);
		if (!isNull(bodyBorderBottom))
			style.setBorderBottom(bodyBorderBottom);
		if (!isNull(bodyBorderLeft))
			style.setBorderLeft(bodyBorderLeft);
		if (!isNull(bodyBorderRight))
			style.setBorderRight(bodyBorderRight);
		if (!isNull(bodyBorderTop))
			style.setBorderTop(bodyBorderTop);
		if (!isNull(bodyAlignment))
			style.setAlignment(bodyAlignment);
		return style;
	}
	/**
	 * 
	 * @Title: createHSSFHeaderCellFont 
	 * @Description: 创建03版本标题单元格字体
	 * @param workbook 工作表对象
	 * @return 字体对象
	 */
	public static HSSFFont createHSSFHeaderCellFont(HSSFWorkbook workbook) {
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		if(!isNull(headerFontName))
			font.setFontName(headerFontName);
		if(!isNull(headerFontColor))
			font.setColor(headerFontColor);
		if(!isNull(headerFontHeightInPoints))
			font.setFontHeightInPoints(headerFontHeightInPoints);
		if(!isNull(headerFontBoldweight))
			font.setBoldweight(headerFontBoldweight);
		return font;
	}
	/**
	 * 
	 * @Title: createXSSFHeaderCellFont 
	 * @Description: 创建07版本以上标题单元格字体
	 * @param workbook 工作表对象
	 * @return 字体对象
	 */
	public static XSSFFont createXSSFHeaderCellFont(XSSFWorkbook workbook) {
		// 生成一个字体
		XSSFFont font = workbook.createFont();
		if(!isNull(headerFontName))
			font.setFontName(headerFontName);
		if(!isNull(headerFontColor))
			font.setColor(headerFontColor);
		if(!isNull(headerFontHeightInPoints))
			font.setFontHeightInPoints(headerFontHeightInPoints);
		if(!isNull(headerFontBoldweight))
			font.setBoldweight(headerFontBoldweight);
		return font;
	}
	/**
	 * 
	 * @Title: createHSSFBodyCellFont 
	 * @Description: 创建03版本数据体单元格字体
	 * @param workbook 工作表对象
	 * @return 字体对象
	 */
	public static HSSFFont createHSSFBodyCellFont(HSSFWorkbook workbook) {
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		if(!isNull(bodyFontName))
			font.setFontName(bodyFontName);
		if(!isNull(bodyFontColor))
			font.setColor(bodyFontColor);
		if(!isNull(bodyFontHeightInPoints))
			font.setFontHeightInPoints(bodyFontHeightInPoints);
		if(!isNull(bodyBoldweight))
			font.setBoldweight(bodyBoldweight);
		return font;
	}
	/**
	 * 
	 * @Title: createXSSFBodyCellFont 
	 * @Description: 创建07版本以上数据体单元格字体
	 * @param workbook 工作表对象
	 * @return 字体对象
	 */
	public static XSSFFont createXSSFBodyCellFont(XSSFWorkbook workbook) {
		// 生成一个字体
		XSSFFont font = workbook.createFont();
		if(!isNull(bodyFontName))
			font.setFontName(bodyFontName);
		if(!isNull(bodyFontColor))
			font.setColor(bodyFontColor);
		if(!isNull(bodyFontHeightInPoints))
			font.setFontHeightInPoints(bodyFontHeightInPoints);
		if(!isNull(bodyBoldweight))
			font.setBoldweight(bodyBoldweight);
		return font;
	}
	/**
	 * 
	 * @Title: createHssfSheet 
	 * @Description: 创建03版本工作表
	 * @param workbook 工作表
	 * @param title 工作表标题
	 * @return 工作表对象
	 */
	public static HSSFSheet createHssfSheet(HSSFWorkbook workbook, String title) {
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		if(!isNull(sheetDefaultColumnWidth))
			sheet.setDefaultColumnWidth(sheetDefaultColumnWidth);
		// 设置表格默认列高度为15个字节
		if(!isNull(sheetDefaultRowHeight))
			sheet.setDefaultRowHeight(sheetDefaultRowHeight);
		return sheet;
	}
	/**
	 * 
	 * @Title: createXSSFSheet 
	 * @Description: 创建07版本以上的工作表
	 * @param workbook 工作表
	 * @param title 工作表名称
	 * @return 工作表对象
	 */
	public static XSSFSheet createXSSFSheet(XSSFWorkbook workbook, String title) {
		// 生成一个表格
		XSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		if(!isNull(sheetDefaultColumnWidth))
			sheet.setDefaultColumnWidth(sheetDefaultColumnWidth);
		// 设置表格默认列高度为15个字节
		if(!isNull(sheetDefaultRowHeight))
			sheet.setDefaultRowHeight(sheetDefaultRowHeight);
		return sheet;
	}
	/**
	 * 
	 * @Title: setObject 
	 * @Description: 从excel中获取值并赋值到对象里
	 * @param t 对象
	 * @param field 属性
	 * @param cell 单元格
	 * @throws IllegalArgumentException 转换异常
	 * @throws IllegalAccessException 转换异常
	 * @throws ParseException 
	 */
	public static void setObject(Object t, Field field, Cell cell) throws IllegalArgumentException, IllegalAccessException, ParseException {
		Class<?> typeClass = field.getType();
		if(null!=cell&&!"".equals(cell.toString())){
			if (typeClass.isAssignableFrom(int.class) || typeClass.isAssignableFrom(Integer.class)) {
				field.set(t, Float.valueOf(cell.toString()).intValue());
			} else if (typeClass.isAssignableFrom(byte.class) || typeClass.isAssignableFrom(Byte.class)) {
				field.set(t, Float.valueOf(cell.toString()).byteValue());
			} else if (typeClass.isAssignableFrom(short.class) || typeClass.isAssignableFrom(Short.class)) {
				field.set(t, Float.valueOf(cell.toString()).shortValue());
			} else if (typeClass.isAssignableFrom(long.class) || typeClass.isAssignableFrom(Long.class)) {
				field.set(t, Float.valueOf(cell.toString()).longValue());
			} else if (typeClass.isAssignableFrom(double.class) || typeClass.isAssignableFrom(Double.class)) {
				field.set(t, Double.valueOf(cell.toString()));
			} else if (typeClass.isAssignableFrom(float.class) || typeClass.isAssignableFrom(Float.class)) {
				field.set(t, Float.valueOf(cell.toString()));
			} else if (typeClass.isAssignableFrom(char.class) || typeClass.isAssignableFrom(Character.class)) {
				field.set(t, cell.toString().trim().toCharArray()[0]);
			} else if (typeClass.isAssignableFrom(String.class)) {
				field.set(t, cell.toString().trim());
			} else if (typeClass.isAssignableFrom(BigDecimal.class)) {
				field.set(t, new BigDecimal(cell.toString()));
			} else if (typeClass.isAssignableFrom(boolean.class) || typeClass.isAssignableFrom(Boolean.class)) {
				field.set(t, cell.toString());
			} else if (typeClass.isAssignableFrom(Date.class)) {
				String date=cell.toString();
				Date d=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);;
				field.set(t, d);
			} else {
				field.set(t, null);
			}
		}
	}
}
