package scc.util.page.service;

import java.io.InputStream;

public interface Ipage {
	/**
	 * 
	 * @Title: writeHtml 
	 * @Description: 将页面写到指定位置
	 * @param filePath 文件位置
	 * @param info 页面字符串
	 * @param isFlush 是否清空原目录重新创建
	 */
	void writeHtml(String filePath,String info, boolean isFlush);
	/**
	 * 
	 * @Title: getHtmlCode 
	 * @Description: 获取指定页面字符串
	 * @param httpUrl 地址
	 * @return
	 */
	String getHtmlCode(String httpUrl,String charsetName,String cookie);
	/**
	 * 
	 * @Title: readHtmlFromFlie 
	 * @Description: 从文件读取html代码
	 * @param filePath 文件路径
	 * @param charsetName
	 * @return
	 */
	String readHtmlFromFlie(String filePath,String charsetName);
	/**
	 * 
	 * @Title: readHtmlFromFlie 
	 * @Description: 从文件读取html代码
	 * @param is
	 * @param charsetName
	 * @return
	 */
	String readHtmlFromFlie(InputStream is,String charsetName);
}
