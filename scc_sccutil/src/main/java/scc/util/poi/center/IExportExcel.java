package scc.util.poi.center;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import scc.util.poi.exception.ExportExcelException;
/**
 * 
 * @ClassName: IExportExcel 
 * @Description: poi核心接口
 * @author scc
 * @date 2014年11月6日 下午12:41:10 
 * 
 * @param <T> 导出的类
 */
public interface IExportExcel<T> {
	/**
	 * 
	 * @Title: export 
	 * @Description: 导出接口
	 * @param exportData 要导出的数据集合
	 * @param headers 标题
	 * @param comments 注释
	 * @param title 工作表名称
	 * @param out 要输出的流
	 */
	void export(List<T> exportData,String title,OutputStream out,List<String> headers,List<String> comments);
	/**
	 * 
	 * @Title: export 
	 * @Description: 导出接口
	 * @param exportData 要导出的数据集合
	 * @param headers 标题
	 * @param title 工作表名称
	 * @param out 要输出的流
	 */
	void export(List<T> exportData,String title,OutputStream out,List<String> headers);
	/**
	 * 
	 * @Title: export 
	 * @Description: 导出接口
	 * @param exportData 要导出的数据集合
	 * @param title 工作表名称
	 * @param out 要输出的流
	 */
	void export(List<T> exportData,String title,OutputStream out);
	/**
	 * 
	 * @Title: importExcel 
	 * @Description: 导入excel数据
	 * @param is 包涵excel的输入流
	 * @param 开始读取的索引 0为第一行
	 * @return 导入的数据
	 * @throws IOException 文件找不到异常
	 */
	List<T> importExcel(InputStream is,Integer startIndex) throws ExportExcelException;
}
