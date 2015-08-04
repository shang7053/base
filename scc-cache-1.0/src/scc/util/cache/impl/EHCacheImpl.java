package scc.util.cache.impl;

import java.util.Date;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

import scc.util.cache.ICache;
import scc.util.cache.data.CacheData;

public class EHCacheImpl implements ICache{
	private static final CacheManager MANAGER=CacheManager.getInstance();
	private static final Cache CACHE=MANAGER.getCache("supcccenter");
	private static final Logger LOGGER=Logger.getLogger(EHCacheImpl.class);
	private String getCacheInfo(){
		return "当前缓存数量："+CACHE.getSize()+",其中内存中个数："+ CACHE.getMemoryStoreSize()+",硬盘中个数："+CACHE.getDiskStoreSize();
	}
	@Override
	public void addCacheData(Date loadDate, String queryArgs, Object data) {
		LOGGER.debug(getCacheInfo()+"添加缓存：参数:"+queryArgs+",值:"+data);
		CACHE.put(new Element(queryArgs, data));
	}
	
	@Override
	public void addCacheData(String queryArgs, CacheData data) {
		LOGGER.debug(getCacheInfo()+"添加缓存：参数:"+queryArgs+",值:"+data.getData());
		addCacheData(null, queryArgs, data.getData());
	}

	@Override
	public void addOrUpdate(Date loadDate, String queryArgs, Object data) {
		LOGGER.debug(getCacheInfo()+"添加缓存：参数:"+queryArgs+",值:"+data);
		addCacheData(loadDate, queryArgs, data);
	}

	@Override
	public void addOrUpdate(String queryArgs, CacheData data) {
		LOGGER.debug(getCacheInfo()+"添加缓存：参数:"+queryArgs+",值:"+data.getData());
		addCacheData(queryArgs, data);
	}

	@Override
	public void updateCacheData(Date loadDate, String queryArgs, Object data) {
		LOGGER.debug(getCacheInfo()+"添加缓存：参数:"+queryArgs+",值:"+data);
		addCacheData(loadDate, queryArgs, data);
	}

	@Override
	public void updateCacheData(String queryArgs, CacheData data) {
		LOGGER.debug(getCacheInfo()+"添加缓存：参数:"+queryArgs+",值:"+data.getData());
		addCacheData(queryArgs, data);
	}

	@Override
	public Object getCacheData(String queryArgs) {
		LOGGER.debug(getCacheInfo()+"获取缓存：参数:"+queryArgs);
		Element e=CACHE.get(queryArgs);
		if(null==e)
			return null;
		if(e.isExpired())
			return null;
		return e.getObjectValue();
	}

	@Override
	public boolean hasCacheData(String queryArgs) {
		LOGGER.debug(getCacheInfo()+"判断是否包含缓存：参数:"+queryArgs);
		return CACHE.isKeyInCache(queryArgs)&&(null!=CACHE.get(queryArgs));
	}

	@Override
	public void clearOverdueCache() {
		return ;
	}

}
