package com.voole.trdpay.util.httputil;

import java.util.Map;

/**
 * @ClassName: IRestClient
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年9月21日 下午3:47:57
 * 
 */
public interface IRestClient {
	public String get(String url, long timeout);

	public String post(String url, Map<String, String> store, long timeout);

	public String post(String url, Object obj, RestMediaType mediaType, long timeout);

	public String put(String url, Map<String, String> store, long timeout);

	public String put(String url, Object obj, RestMediaType mediaType, long timeout);

	public String delete(String url, long timeout);

	public <T> T get(Class<T> retClass, String url, long timeout);

	public <T> T post(Class<T> retClass, String url, Map<String, String> store, long timeout);

	public <T> T post(Class<T> retClass, String url, Object obj, RestMediaType mediaType, long timeout);

	public <T> T put(Class<T> retClass, String url, Map<String, String> store, long timeout);

	public <T> T put(Class<T> retClass, String url, Object obj, RestMediaType mediaType, long timeout);

	public <T> T delete(Class<T> retClass, String url, long timeout);
}