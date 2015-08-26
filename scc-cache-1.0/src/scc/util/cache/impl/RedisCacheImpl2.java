package scc.util.cache.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.log4j.Logger;

import redis.clients.jedis.BinaryJedisCluster;
import redis.clients.jedis.HostAndPort;
import scc.util.cache.ICache;
import scc.util.cache.data.CacheData;
import scc.util.cache.util.RedisConfig;
import scc.util.cache.util.RedisConfigVo;
import scc.util.cache.util.SerializeUtil;
import scc.util.cache.util.Shared;

public class RedisCacheImpl2 implements ICache {
	private static final Logger LOGGER = Logger
			.getLogger(RedisCacheImpl2.class);
	private static final RedisConfigVo rcv = RedisConfig.getRegisters();
	private static final int keepAliveTime = rcv.getKeepAliveTime();
	private static Boolean ISCACHEON = rcv.isCacheOn();
	private static BinaryJedisCluster cluster;
	static {
		// 池基本配置
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxIdle(rcv.getMaxIdle());
		config.setMinIdle(rcv.getMinIdle());
		config.setTestOnBorrow(rcv.isTestOnBorrow());
		config.setTestOnReturn(rcv.isTestOnReturn());
		config.setTestWhileIdle(rcv.isTestWhileIdle());
		List<Shared> shareds = rcv.getShareds();
		// slave链接
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		for (int i = 0; i < shareds.size(); i++) {
			jedisClusterNodes.add(new HostAndPort(shareds.get(i).getIp(),
					shareds.get(i).getPort()));
		}
		// 构造池
		cluster = new BinaryJedisCluster(jedisClusterNodes);
	}

	public void test() {
		cluster.set("haha".getBytes(), "heihei".getBytes());
		cluster.setex("hehe".getBytes(), 1000, "gaga".getBytes());
		System.out.println(new String(cluster.get("haha".getBytes())));
		System.out.println(new String(cluster.get("hehe".getBytes())));
	}

	@Override
	public void addCacheData(Date loadDate, String queryArgs, Object data) {
		if (ISCACHEON) {
			LOGGER.debug("添加缓存：参数" + queryArgs);
			cluster.setex(queryArgs.getBytes(), keepAliveTime, getStrFromObj(data));
		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
		}

	}

	private byte[] getStrFromObj(Object data) {
		return SerializeUtil.serialize(data);
	}

	@Override
	public void addCacheData(String queryArgs, CacheData data) {
		if (ISCACHEON) {
			LOGGER.debug("添加缓存：参数" + queryArgs);
			cluster.setex(queryArgs.getBytes(), keepAliveTime,
					getStrFromObj(data.getData()));
		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
		}
	}

	@Override
	public void addOrUpdate(Date loadDate, String queryArgs, Object data) {
		if (ISCACHEON) {
			LOGGER.debug("添加缓存：参数" + queryArgs);

			cluster.setex(queryArgs.getBytes(), keepAliveTime, getStrFromObj(data));

		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
		}
	}

	@Override
	public void addOrUpdate(String queryArgs, CacheData data) {
		if (ISCACHEON) {
			LOGGER.debug("添加缓存：参数" + queryArgs);

			cluster.setex(queryArgs.getBytes(), keepAliveTime, getStrFromObj(data));

		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
		}
	}

	@Override
	public void updateCacheData(Date loadDate, String queryArgs, Object data) {
		if (ISCACHEON) {
			LOGGER.debug("添加缓存：参数" + queryArgs);

			cluster.setex(queryArgs.getBytes(), keepAliveTime, getStrFromObj(data));

		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
		}
	}

	@Override
	public void updateCacheData(String queryArgs, CacheData data) {
		if (ISCACHEON) {
			LOGGER.debug("添加缓存：参数" + queryArgs);
			cluster.setex(queryArgs.getBytes(), keepAliveTime, getStrFromObj(data));

		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
		}
	}

	@Override
	public Object getCacheData(String queryArgs) {
		if (ISCACHEON) {
			LOGGER.debug("获取缓存：参数" + queryArgs);
			byte[] result = cluster.get(queryArgs.getBytes());
			if (null == result)
				return null;
			return SerializeUtil.unserialize(result);
		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
			return null;
		}
	}

	@Override
	public boolean hasCacheData(String queryArgs) {
		if (ISCACHEON) {
			LOGGER.debug("判断是否含有缓存：参数" + queryArgs);
			boolean flag = cluster.exists(queryArgs.getBytes());
			return flag;
		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
			return false;
		}
	}

	public void addGlobleCacheData(String queryArgs, Object data) {
		if (ISCACHEON) {
			LOGGER.debug("添加全局缓存：参数" + queryArgs);
			cluster.set(queryArgs.getBytes(), getStrFromObj(data));
		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
		}
	}

	@Override
	public void clearOverdueCache() {
		return;
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					RedisCacheImpl2 redis=new RedisCacheImpl2();
					redis.addCacheData(null,"0001:CustomerService:getTableData:{ctel:\"13343285888\"}", "bb");
					redis.hasCacheData("0001:CustomerService:getTableData:{ctel:\"13343285888\"}");
					redis.getCacheData("0001:CustomerService:getTableData:{ctel:\"13343285888\"}");					
				}
			}).start();
		}
	}
}
