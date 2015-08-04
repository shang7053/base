package scc.util;

import java.io.IOException;

import scc.util.cache.ICache;
import scc.util.cache.data.CacheData;
import scc.util.cache.impl.RedisCacheImpl;

/**
 * 
 * @ClassName: SccStringUtilFactory
 * @Description:
 * @author scc
 * @date 2014年11月17日 上午11:31:07
 * 
 */
public class SccUtilFactory {
	/**
	 * 构建缓存对象
	 * 
	 * @return 缓存对象
	 */
	public static ICache instanceCache() {
		return new RedisCacheImpl();
	}

	public static void main(String[] args) throws IOException {
		ICache cache=SccUtilFactory.instanceCache();
		cache.addCacheData("aaa", new CacheData("bbb"));
//		System.out.println(cache.getCacheData("aaa"));
	}
		
}
