package com.voole.trdpay.util;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang.StringUtils;

/**
 * @ClassName: SPDRequestUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月12日 下午1:55:51
 * 
 */
public class SPDRequestUtil {
	/**
	 * @Title: getMapFromStr
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午3:34:22
	 * @param jsondata
	 * @return
	 */
	public static Map<String, String> getMapFromStr(String jsondata) {
		Map<String, String> ret = new HashMap<>();
		if (StringUtils.isBlank(jsondata)) {
			return ret;
		}
		String[] item = jsondata.split("&");
		for (String i : item) {
			ret.put(i.split("=")[0], StringUtils.isBlank(i.split("=")[1]) ? "" : i.split("=")[1]);
		}
		return ret;
	}

	public static boolean validateSpdRet(Map<String, String> spdretmap, String singKey) {
		// 按照字段名的 ASCII 码从小到大排序后（字典序），使⽤用 URL 键值对的格式（即 key1=value1&key2=value2…）拼接成字符串
		Map<String, String> noSignMap = getNoSignMap(spdretmap);
		String sortdata = UrlSortUtil.formatUrlMap(noSignMap, false, false);
		// 在 string1 最后直接拼接（不需要用“&”连接）双方约定的签名密钥 K1(接入时后台系统侧分配)，得到 stringSignTemp2 字符串
		sortdata = sortdata + singKey;
		// 对 stringSignTemp2 字符串进行 SHA256 运算，得到签名 sign
		String shadata = SHA256Util.getSHA256Str(sortdata);
		return shadata.equals(spdretmap.get("sign").toString());
	}

	/**
	 * @Title: getSign
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @param args
	 * @param signKey
	 * @date 2017年9月8日 下午2:44:25
	 * @return
	 */
	public static String getSign(Map<String, String> args, String signKey) {
		String url = UrlSortUtil.formatUrlMap(args, false, false);
		url = url + signKey;
		return SHA256Util.getSHA256Str(url);
	}

	public static Map<String, String> getNoSignMap(Map<String, String> map) {
		Map<String, String> noSignMap = new HashMap<>();
		for (Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().equals("sign")) {
				continue;
			}
			noSignMap.put(entry.getKey(), entry.getValue());
		}
		return noSignMap;
	}

	public static Map<String, String> beanToMap(Object obj) {
		Map<String, String> params = new HashMap<String, String>(0);
		try {
			PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
			PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
			for (PropertyDescriptor descriptor : descriptors) {
				String name = descriptor.getName();
				if (!"class".equals(name) && null != propertyUtilsBean.getNestedProperty(obj, name)) {
					params.put(name, propertyUtilsBean.getNestedProperty(obj, name).toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return params;
	}

	/**
	 * @Title: getAmt
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午2:37:12
	 * @param amt
	 * @return
	 */
	public static String getAmt(String amt) {
		if (StringUtils.isBlank(amt)) {
			return "000000000000";
		}
		StringBuilder stramt = new StringBuilder();
		int length = amt.length();
		for (int i = 0; i < 12 - length; i++) {
			stramt.append("0");
		}
		stramt.append(amt.toString());
		return stramt.toString();
	}
}
