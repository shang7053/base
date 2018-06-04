package scc.util.string.service;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;
import java.util.Map;

/**
 * 
 * @ClassName: IStringOperate 
 * @Description: 字符串常用操作接口
 * @author scc
 * @date 2014年11月17日 上午11:31:28 
 *
 */
public interface IString {
	/**
	 * 
	 * @Title: isNull 
	 * @Description: 判断是否为空
	 * @param str 字符串对象
	 * @return
	 */
	boolean isNull(String str);
	/**
	 * 
	 * @Title: emptyString 
	 * @Description: 判断是否是空字符串,若传入为null则返回true
	 * @param str 字符串对象
	 * @return
	 */
	boolean emptyString(String str);
	/**
	 * 
	 * @Title: isNullOrEmpty 
	 * @Description: 判断是否是空字符串或者null对象
	 * @param str 字符串对象
	 * @return
	 */
	boolean isNullOrEmpty(String str);
	/**
	 * 
	 * @Title: toInt 
	 * @Description: 转换成int类型
	 * @param str 字符串对象
	 * @return 若转换成功则返回对应对象，转换失败或传入null对象则返回null
	 */
	Integer toInt(String str);
	/**
	 * 
	 * @Title: toLong 
	 * @Description: 转换成long类型
	 * @param str 字符串对象
	 * @return 若转换成功则返回对应对象，转换失败或传入null对象则返回null
	 */
	Long toLong(String str);
	/**
	 * 
	 * @Title: toShort 
	 * @Description: 转换成short类型
	 * @param str 字符串对象
	 * @return 若转换成功则返回对应对象，转换失败或传入null对象则返回null
	 */
	Short toShort(String str);
	/**
	 * 
	 * @Title: toByte 
	 * @Description: 转换成byte类型
	 * @param str 字符串对象
	 * @return 若转换成功则返回对应对象，转换失败或传入null对象则返回null
	 */
	Byte toByte(String str);
	/**
	 * 
	 * @Title: toDouble 
	 * @Description: 转换成double类型
	 * @param str 字符串对象
	 * @return 若转换成功则返回对应对象，转换失败或传入null对象则返回null
	 */
	Double toDouble(String str);
	/**
	 * 
	 * @Title: toFloat 
	 * @Description: 转换成float类型
	 * @param str 字符串对象
	 * @return 若转换成功则返回对应对象，转换失败或传入null对象则返回null
	 */
	Float toFloat(String str);
	/**
	 * 
	 * @Title: toChar 
	 * @Description: 转换成char类型,只转换传入字符的第一个字符
	 * @param str 字符串对象
	 * @return 若转换成功则返回对应对象，转换失败或传入null对象则返回null
	 */
	Character toChar(String str);
	/**
	 * 
	 * @Title: toBoolean 
	 * @Description: 转换成boolean类型
	 * @param str 字符串对象
	 * @return 若转换成功则返回对应对象，转换失败或传入null对象则返回null
	 */
	Boolean toBoolean(String str);
	/**
	 * 
	 * @Title: toBigDecimal 
	 * @Description: 转换成BigDecimal类型
	 * @param str 字符串对象
	 * @return 若转换成功则返回对应对象，转换失败或传入null对象则返回null
	 */
	BigDecimal toBigDecimal(String str);
	/**
	 * 
	 * @Title: toUpperCaseFirst 
	 * @Description: 手字母大写,若已大写则原样返回
	 * @param str 字符串对象
	 * @return 转化后的字符串
	 */
	String toUpperCaseFirst(String str);
	/**
	 * 
	 * @Title: toLowerCaseFirst 
	 * @Description: 首字母小写,若已小写则原样返回
	 * @param str 字符串对象
	 * @return 转化后的字符串
	 */
	String toLowerCaseFirst(String str);
	/**
	 * 
	 * @Title: toDate 
	 * @Description: 转换成Date类型
	 * @param date 字符串对象
	 * @param patten 转化格式
	 * @return 若转换成功则返回对应对象，转换失败或传入null对象则返回null
	 */
	Date toDate(String date,String pattern);
	/**
	 * 
	 * @Title: toDate 
	 * @Description: 转换成String类型
	 * @param date 字符串对象
	 * @param pattern 转化格式
	 * @return 若转换成功则返回对应对象，转换失败或传入null对象则报错
	 */
	String toDate(Date date,String pattern);
	/**
	 * 
	 * @Title: simpleEncryption 
	 * @Description: 简单加密
	 * @param str 加密字符串
	 * @return 加密后字符串
	 */
	String simpleEncryption(String str); 
	/**
	 * 
	 * @Title: simpleDecryption 
	 * @Description: 解密字符串
	 * @param str 加密字符串
	 * @return 解密字符串
	 */
	String simpleDecryption(String str);
	/**
	 * 
	 * @Title: getParameterFromUri 
	 * @Description: 从uri里接收参数
	 * @param requestURI 类似/sjws_soa_product/ChatServer.do?username=%E4%B8%96%E7%BA%AA%E5%BE%AE%E7%86%B5
	 * @return
	 */
	Map<String, String> getParameterFromUri(URI requestURI); 
	/**
	 * 
	 * @Title: toStringHex 
	 * @Description: 转化十六进制编码为字符串 
	 * @param hexString
	 * @return
	 */
	String toStringHex(String hexString);
}
