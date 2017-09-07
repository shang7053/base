package com.voole.trdpay.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * @ClassName: ListUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月8日 上午10:04:57
 * 
 */
public class ListUtils {
	public static <T> Integer[] getTargetForIntegerArray(List<T> list, String propertyName) {
		if (null == list || StringUtils.isBlank(propertyName)) {
			return new Integer[] { -1 };
		}
		List<Integer> ret = new ArrayList<>();
		for (T t : list) {
			Class<T> c = (Class<T>) t.getClass();
			try {
				Field f = getFiled(c, propertyName);
				if (f.getType().isAssignableFrom(Integer.class)) {
					f.setAccessible(true);
					ret.add((Integer) f.get(t));
				}
			} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				continue;
			}
		}
		if (ret.size() == 0) {
			return new Integer[] { -1 };
		}
		return ret.toArray(new Integer[ret.size()]);
	}

	public static <T> String[] getTargetForStringArray(List<T> list, String propertyName) {
		if (null == list || StringUtils.isBlank(propertyName)) {
			return new String[] {};
		}
		List<String> ret = new ArrayList<>();
		for (T t : list) {
			Class<T> c = (Class<T>) t.getClass();
			try {
				Field f = getFiled(c, propertyName);
				if (f.getType().isAssignableFrom(String.class)) {
					f.setAccessible(true);
					ret.add((String) f.get(t));
				}
			} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				continue;
			}
		}
		if (ret.size() == 0) {
			return new String[] {};
		}
		return ret.toArray(new String[ret.size()]);
	}

	/**
	 * @Title: getFiled
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @param <T>
	 * @date 2016年7月8日 上午10:38:35
	 * @param c
	 * @param propertyName
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	private static <T> Field getFiled(Class<T> c, String propertyName) {
		if (c.isAssignableFrom(Object.class)) {
			return null;
		}
		Field f;
		try {
			f = c.getDeclaredField(propertyName);
			return f;
		} catch (NoSuchFieldException | SecurityException e) {
			// e.printStackTrace();
			return getFiled(c.getSuperclass(), propertyName);
		}
	}

	/**
	 * @Title: str2list
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @param <T>
	 * @date 2017年4月5日 下午2:27:09
	 * @param reg_col_ids
	 * @param string
	 * @param class1
	 * @return
	 */
	public static List<Integer> str2list(String str, String split) {
		List<Integer> ret = new ArrayList<>();
		if (StringUtils.isNotBlank(str)) {
			String[] strsplit = str.split(split);
			for (String string : strsplit) {
				ret.add(Integer.valueOf(string.trim()));
			}
		}
		return ret;
	}

	/**
	 * @Title: str2list
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @param <T>
	 * @date 2017年4月5日 下午2:27:09
	 * @param reg_col_ids
	 * @param string
	 * @param class1
	 * @return
	 */
	public static List<String> str2strlist(String str, String split) {
		List<String> ret = new ArrayList<>();
		if (StringUtils.isNotBlank(str)) {
			String[] strsplit = str.split(split);
			for (String string : strsplit) {
				ret.add(string.trim());
			}
		}
		return ret;
	}
}
