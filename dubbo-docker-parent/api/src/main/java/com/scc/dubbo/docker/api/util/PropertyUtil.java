package com.scc.dubbo.docker.api.util;

import org.apache.commons.lang.StringUtils;

/**
 * @ClassName: PropertyUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年2月2日 上午11:35:46
 * 
 */
final public class PropertyUtil {

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author shangchengcai@voole.com
	 * @date 2018年2月2日 上午11:35:46
	 */
	private PropertyUtil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @Title: getIntegerFromSystem
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2018年2月2日 上午10:54:01
	 * @param valueOf
	 * @return
	 */
	public static Integer getIntegerFromSystem(String key, Integer deafultValue) {
		String env = System.getenv(key);
		if (StringUtils.isNotBlank(env)) {
			return Integer.valueOf(env);
		}
		String property = System.getProperty(key);
		if (StringUtils.isNotBlank(property)) {
			return Integer.valueOf(property);
		}
		return deafultValue;
	}

	/**
	 * @Title: getIntegerFromSystem
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2018年2月2日 上午10:54:01
	 * @param valueOf
	 * @return
	 */
	public static String getStringFromSystem(String key, String deafultValue) {
		String env = System.getenv(key);
		if (StringUtils.isNotBlank(env)) {
			return env;
		}
		String property = System.getProperty(key);
		if (StringUtils.isNotBlank(property)) {
			return property;
		}
		return deafultValue;
	}
}
