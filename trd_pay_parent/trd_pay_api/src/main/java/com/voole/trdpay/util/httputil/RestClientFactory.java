package com.voole.trdpay.util.httputil;

/**
 * @ClassName: RestClentFactory
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年9月21日 下午3:43:20
 * 
 */
public class RestClientFactory {
	/**
	 * 实例化rest工具
	 * 
	 * @Title: instance
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年9月21日 下午3:46:59
	 * @return
	 */
	public static IRestClient instance() {
		return new JerseyRestClient();
	}
}
