package scc.util.cache;

import java.util.Date;

import scc.util.cache.data.CacheData;


public interface ICache {
	/**
	 * 添加缓存数据
	 * @param loadDate 加载时间
	 * @param queryArgs 插叙参数
	 * @param data 缓存数据
	 * @return 是否添加成功
	 */
	void addCacheData(Date loadDate,String queryArgs,Object data);
	/**
	 * 添加缓存数据
	 * @param queryArgs 插叙参数
	 * @param data 缓存数据
	 * @return 是否添加成功
	 */
	void addCacheData(String queryArgs,CacheData data);
	/**
	 * 添加或更新缓存数据
	 * @param loadDate 加载时间
	 * @param queryArgs 插叙参数
	 * @param data 缓存数据
	 */
	void addOrUpdate(Date loadDate,String queryArgs,Object data);
	/**
	 * 添加或更新缓存数据
	 * @param queryArgs 插叙参数
	 * @param data 缓存数据
	 */
	void addOrUpdate(String queryArgs,CacheData data);
	/**
	 * 更新缓存数据
	 * @param loadDate 加载时间
	 * @param queryArgs 插叙参数
	 * @param data 缓存数据
	 */
	void updateCacheData(Date loadDate,String queryArgs,Object data);
	/**
	 * 更新缓存数据
	 * @param queryArgs 插叙参数
	 * @param data 缓存数据
	 */
	void updateCacheData(String queryArgs,CacheData data);
	/**
	 * 获取缓存数据
	 * @param queryArgs 插叙参数
	 * @return 缓存数据
	 */
	Object getCacheData(String queryArgs);
	/**
	 * 判断是否有缓存数据(若含有缓存数据但已超过设置日期同样返回false)
	 * @param queryArgs 插叙参数
	 * @return 是否存有缓存数据
	 */
	boolean hasCacheData(String queryArgs);
	/**
	 * 清除过期的数据
	 */
	void clearOverdueCache();
}
