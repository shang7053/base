package com.voole.cdcenter.util;

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
}
