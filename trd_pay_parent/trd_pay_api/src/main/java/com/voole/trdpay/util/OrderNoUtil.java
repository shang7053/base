package com.voole.trdpay.util;

import org.apache.commons.lang.StringUtils;

/**
 * @ClassName: OrderNoUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月8日 上午9:31:10
 * 
 */
public class OrderNoUtil {
	/**
	 * 
	 * @Title: getOrderNo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:49:29
	 * @param hid
	 * @param oemid
	 * @return
	 */
	public static String getOrderNo(String hid, String oemid) {
		if (StringUtils.isBlank(hid)) {
			return null;
		}
		if (StringUtils.isBlank(oemid)) {
			return null;
		}
		String input = System.currentTimeMillis() + hid.substring(0, 12) + oemid;
		return MD5.code(input, 16);
	}
}
