package com.voole.trdpay.util.httputil;

/**
 * @ClassName: JsonHttpClient
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年10月21日 下午5:49:06
 * 
 */
public class JsonHttpClient {
	public String get(String url, long timeout) {
		return RestClientFactory.instance().get(url, timeout);
	}
}
