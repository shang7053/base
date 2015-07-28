package scc.util.propeties.service;

import java.util.Properties;

public interface IProperties {

	/**
	 * 
	 * @Title: readValue 
	 * @Description:  读取值
	 * @param fileName 文件名
	 * @param key key值
	 * @return value值
	 */
	public abstract String readValue(String fileName, String key);

	/**
	 * 
	 * @Title: writeProperties 
	 * @Description: 写入或者更新值
	 * @param fileName 文件名
	 * @param parameterName key值
	 * @param parameterValue value值
	 */
	public abstract void writeProperties(String fileName, String parameterName, String parameterValue);

	/**
	 * 
	 * @Title: isFileExist 
	 * @Description: 在src下是否存在filename文件
	 * @param fileName 文件名
	 * @return
	 */
	public abstract boolean isFileExist(String fileName);

	/**
	 * 
	 * @Title: isPrepertiesExist 
	 * @Description: 属性key是否存在
	 * @param fileName
	 * @param key
	 * @return
	 */
	public abstract boolean isPrepertiesExist(String fileName, String key);
	/**
	 * 
	 * @Title: getProperties 
	 * @Description: 获取Properties
	 * @param fileName
	 * @return
	 */
	public abstract Properties getProperties(String fileName);

}