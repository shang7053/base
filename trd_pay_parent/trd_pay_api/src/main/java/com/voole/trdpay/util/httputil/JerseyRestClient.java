package com.voole.trdpay.util.httputil;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.ParseException;

/**
 * 
 * @author yangju 2016年8月31日
 */
class JerseyRestClient implements IRestClient {
	protected Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	private Client client = ClientBuilder.newClient();

	/**
	 * get
	 * 
	 * @param url
	 */
	@Override
	public String get(String url, long timeout) {
		String result = null;
		WebTarget target = this.client.target(url);
		Response response = target.request().get();
		try {
			// if (response.getStatus() != 200) {
			// throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
			// }
			result = response.readEntity(String.class);
		} finally {
			response.close();
		}

		return result;
	}

	/**
	 * form 参数， post
	 * 
	 * @param url
	 * @param store
	 */
	@Override
	public String post(String url, Map<String, String> store, long timeout) {
		String result = null;
		WebTarget target = this.client.target(url);
		Response response = null;
		try {
			String jsondata = JSON.json(store).replaceAll("\\\\", "");
			Future<Response> fuResponse = target.request().buildPost(Entity.json(jsondata)).submit();
			response = fuResponse.get(timeout, TimeUnit.MILLISECONDS);
			result = response.readEntity(String.class);
		} catch (Exception e) {
			this.LOGGER.info("Calling the third party interface exception:" + e.getMessage());
			return result;
		} finally {
			if (response != null) {
				response.close();
			}
		}
		return result;
	}

	/**
	 * 自定义MediaType ， post
	 * 
	 * @param url
	 * @param obj
	 * @param mediaType
	 */
	private String post(String url, Object obj, MediaType mediaType) {
		String result = null;
		WebTarget target = this.client.target(url);
		Response response = target.request().post(Entity.entity(obj, mediaType));
		try {
			// if (response.getStatus() != 201) {
			// throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
			// }
			result = response.readEntity(String.class);
		} finally {
			response.close();
		}
		return result;
	}

	/**
	 * form参数， put
	 * 
	 * @param url
	 * @param store
	 */
	private String put(String url, MultivaluedMap<String, String> store) {
		String result = null;
		WebTarget target = this.client.target(url);
		Form form = new Form(store);
		Response response = target.request().put(Entity.form(form));
		try {
			// if (response.getStatus() != 200) {
			// throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
			// }
			result = response.readEntity(String.class);
		} finally {
			response.close();
		}

		return result;
	}

	/**
	 * 自定义MediaType ， put
	 * 
	 * @param url
	 * @param obj
	 * @param mediaType
	 */
	private String put(String url, Object obj, MediaType mediaType) {
		String result = null;
		WebTarget target = this.client.target(url);
		Response response = target.request().put(Entity.entity(obj, mediaType));
		try {
			// if (response.getStatus() != 200) {
			// throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
			// }
			result = response.readEntity(String.class);
		} finally {
			response.close();
		}

		return result;
	}

	/**
	 * delete
	 * 
	 * @param url
	 */
	@Override
	public String delete(String url, long timeout) {
		String result = null;
		WebTarget target = this.client.target(url);
		Response response = target.request().delete();
		try {
			// if (response.getStatus() != 204) {
			// throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
			// }
			result = response.readEntity(String.class);
		} finally {
			response.close();
		}
		return result;
	}

	/**
	 * @Title: converMap
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年9月21日 下午3:52:18
	 * @param store
	 * @return
	 */
	private MultivaluedMap<String, String> converMap(Map<String, String> original) {
		MultivaluedMap<String, String> target = new MultivaluedHashMap<>();
		if (null != original) {
			for (Entry<String, String> originalEntry : original.entrySet()) {
				target.add(originalEntry.getKey(), originalEntry.getValue());
			}
		}
		return target;
	}

	/*
	 * (非 Javadoc) <p>Title: post</p> <p>Description: </p>
	 * 
	 * @param url
	 * 
	 * @param obj
	 * 
	 * @param mediaType
	 * 
	 * @return
	 * 
	 * @see com.voole.frame.util.IRestClient#post(java.lang.String, java.lang.Object,
	 * com.voole.frame.util.RestMediaType)
	 */
	@Override
	public String post(String url, Object obj, RestMediaType mediaType, long timeout) {
		return this.post(url, obj, MediaType.valueOf(mediaType.getMediaType()));
	}

	/*
	 * (非 Javadoc) <p>Title: put</p> <p>Description: </p>
	 * 
	 * @param url
	 * 
	 * @param store
	 * 
	 * @return
	 * 
	 * @see com.voole.frame.util.IRestClient#put(java.lang.String, java.util.Map)
	 */
	@Override
	public String put(String url, Map<String, String> store, long timeout) {
		return this.put(url, this.converMap(store));
	}

	/*
	 * (非 Javadoc) <p>Title: put</p> <p>Description: </p>
	 * 
	 * @param url
	 * 
	 * @param obj
	 * 
	 * @param mediaType
	 * 
	 * @return
	 * 
	 * @see com.voole.frame.util.IRestClient#put(java.lang.String, java.lang.Object, com.voole.frame.util.RestMediaType)
	 */
	@Override
	public String put(String url, Object obj, RestMediaType mediaType, long timeout) {
		return this.put(url, obj, MediaType.valueOf(mediaType.getMediaType()));
	}

	/*
	 * (非 Javadoc) <p>Title: get</p> <p>Description: </p>
	 * 
	 * @param retClass
	 * 
	 * @param url
	 * 
	 * @return
	 * 
	 * @see com.voole.frame.util.IRestClient#get(java.lang.Class, java.lang.String)
	 */
	@Override
	public <T> T get(Class<T> retClass, String url, long timeout) {
		String ret = this.get(url, timeout);
		if (new JsonValidator().validate(ret)) {
			try {
				return JSON.parse(ret, retClass);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * (非 Javadoc) <p>Title: post</p> <p>Description: </p>
	 * 
	 * @param retClass
	 * 
	 * @param url
	 * 
	 * @param store
	 * 
	 * @return
	 * 
	 * @see com.voole.frame.util.IRestClient#post(java.lang.Class, java.lang.String, java.util.Map)
	 */
	@Override
	public <T> T post(Class<T> retClass, String url, Map<String, String> store, long timeout) {
		String ret = this.post(url, store, timeout);
		if (new JsonValidator().validate(ret)) {
			try {
				return JSON.parse(ret, retClass);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * (非 Javadoc) <p>Title: post</p> <p>Description: </p>
	 * 
	 * @param retClass
	 * 
	 * @param url
	 * 
	 * @param obj
	 * 
	 * @param mediaType
	 * 
	 * @return
	 * 
	 * @see com.voole.frame.util.IRestClient#post(java.lang.Class, java.lang.String, java.lang.Object,
	 * com.voole.frame.util.RestMediaType)
	 */
	@Override
	public <T> T post(Class<T> retClass, String url, Object obj, RestMediaType mediaType, long timeout) {
		String ret = this.post(url, obj, mediaType, timeout);
		if (new JsonValidator().validate(ret)) {
			try {
				return JSON.parse(ret, retClass);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * (非 Javadoc) <p>Title: put</p> <p>Description: </p>
	 * 
	 * @param retClass
	 * 
	 * @param url
	 * 
	 * @param store
	 * 
	 * @return
	 * 
	 * @see com.voole.frame.util.IRestClient#put(java.lang.Class, java.lang.String, java.util.Map)
	 */
	@Override
	public <T> T put(Class<T> retClass, String url, Map<String, String> store, long timeout) {
		String ret = this.put(url, store, timeout);
		if (new JsonValidator().validate(ret)) {
			try {
				return JSON.parse(ret, retClass);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * (非 Javadoc) <p>Title: put</p> <p>Description: </p>
	 * 
	 * @param retClass
	 * 
	 * @param url
	 * 
	 * @param obj
	 * 
	 * @param mediaType
	 * 
	 * @return
	 * 
	 * @see com.voole.frame.util.IRestClient#put(java.lang.Class, java.lang.String, java.lang.Object,
	 * com.voole.frame.util.RestMediaType)
	 */
	@Override
	public <T> T put(Class<T> retClass, String url, Object obj, RestMediaType mediaType, long timeout) {
		String ret = this.put(url, obj, mediaType, timeout);
		if (new JsonValidator().validate(ret)) {
			try {
				return JSON.parse(ret, retClass);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * (非 Javadoc) <p>Title: delete</p> <p>Description: </p>
	 * 
	 * @param retClass
	 * 
	 * @param url
	 * 
	 * @return
	 * 
	 * @see com.voole.frame.util.IRestClient#delete(java.lang.Class, java.lang.String)
	 */
	@Override
	public <T> T delete(Class<T> retClass, String url, long timeout) {
		String ret = this.delete(url, timeout);
		if (new JsonValidator().validate(ret)) {
			try {
				return JSON.parse(ret, retClass);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
