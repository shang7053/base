package scc.util.cache.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.log4j.Logger;

import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;
import scc.util.cache.ICache;
import scc.util.cache.data.CacheData;
import scc.util.cache.util.RedisConfig;
import scc.util.cache.util.RedisConfigVo;
import scc.util.cache.util.SerializeUtil;
import scc.util.cache.util.Shared;

public class RedisCacheImpl implements ICache {
	private static final Logger LOGGER = Logger.getLogger(RedisCacheImpl.class);
	private static final RedisConfigVo rcv = RedisConfig.getRegisters();
	private static final int keepAliveTime = rcv.getKeepAliveTime();
	private static Boolean ISCACHEON = rcv.isCacheOn();
	private static ShardedJedisPool shardedJedisPool;// 切片额客户端连接
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
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		for (int i = 0; i < shareds.size(); i++) {
			shards.add(
					new JedisShardInfo(shareds.get(i).getIp(), shareds.get(i).getPort(), shareds.get(i).getTimeOut()));
		}
		// 构造池
		shardedJedisPool = new ShardedJedisPool(config, shards);
	}

	private ShardedJedis getShardedJedis() {
		ShardedJedis jedis;
		try {
			jedis = shardedJedisPool.getResource();
		} catch (JedisConnectionException e) {
			LOGGER.debug("redis未启动");
			return null;
		}
		return jedis;
	}

	@Override
	public void addCacheData(Date loadDate, String queryArgs, Object data) {
		if (ISCACHEON) {
			LOGGER.debug("添加缓存：参数" + queryArgs);
			ShardedJedis redis = this.getShardedJedis();
			if (null != redis) {
				redis.setex(queryArgs.getBytes(), keepAliveTime, this.getStrFromObj(data));
				this.returnResource(redis);
			} else {
				LOGGER.debug("添加缓存失败，未启动redis：参数" + queryArgs);
			}
		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
		}

	}

	private void returnResource(ShardedJedis redis) {
		if (null != redis) {
			redis.close();
		}
	}

	private byte[] getStrFromObj(Object data) {
		return SerializeUtil.serialize(data);
	}

	@Override
	public void addCacheData(String queryArgs, CacheData data) {
		if (ISCACHEON) {
			LOGGER.debug("添加缓存：参数" + queryArgs);
			ShardedJedis redis = this.getShardedJedis();
			if (null != redis) {
				redis.setex(queryArgs.getBytes(), keepAliveTime, this.getStrFromObj(data.getData()));
				this.returnResource(redis);
			} else {
				LOGGER.debug("添加缓存失败，未启动redis：参数" + queryArgs);
			}
		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
		}
	}

	@Override
	public void addOrUpdate(Date loadDate, String queryArgs, Object data) {
		if (ISCACHEON) {
			LOGGER.debug("添加缓存：参数" + queryArgs);
			ShardedJedis redis = this.getShardedJedis();
			if (null != redis) {
				redis.setex(queryArgs.getBytes(), keepAliveTime, this.getStrFromObj(data));
				this.returnResource(redis);
			} else {
				LOGGER.debug("添加缓存失败，未启动redis：参数" + queryArgs);
			}
		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
		}
	}

	@Override
	public void addOrUpdate(String queryArgs, CacheData data) {
		if (ISCACHEON) {
			LOGGER.debug("添加缓存：参数" + queryArgs);
			ShardedJedis redis = this.getShardedJedis();
			if (null != redis) {
				redis.setex(queryArgs.getBytes(), keepAliveTime, this.getStrFromObj(data));
				this.returnResource(redis);
			} else {
				LOGGER.debug("添加缓存失败，未启动redis：参数" + queryArgs);
			}
		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
		}
	}

	@Override
	public void updateCacheData(Date loadDate, String queryArgs, Object data) {
		if (ISCACHEON) {
			LOGGER.debug("添加缓存：参数" + queryArgs);
			ShardedJedis redis = this.getShardedJedis();
			if (null != redis) {
				redis.setex(queryArgs.getBytes(), keepAliveTime, this.getStrFromObj(data));
				this.returnResource(redis);
			} else {
				LOGGER.debug("添加缓存失败，未启动redis：参数" + queryArgs);
			}
		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
		}
	}

	@Override
	public void updateCacheData(String queryArgs, CacheData data) {
		if (ISCACHEON) {
			LOGGER.debug("添加缓存：参数" + queryArgs);
			ShardedJedis redis = this.getShardedJedis();
			if (null != redis) {
				redis.setex(queryArgs.getBytes(), keepAliveTime, this.getStrFromObj(data));
				this.returnResource(redis);
			} else {
				LOGGER.debug("添加缓存失败，未启动redis：参数" + queryArgs);
			}
		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
		}
	}

	@Override
	public Object getCacheData(String queryArgs) {
		if (ISCACHEON) {
			LOGGER.debug("获取缓存：参数" + queryArgs);
			ShardedJedis redis = this.getShardedJedis();
			if (null != redis) {
				byte[] result = redis.get(queryArgs.getBytes());
				if (null == result) {
					return null;
				}
				this.returnResource(redis);
				return SerializeUtil.unserialize(result);
			} else {
				LOGGER.debug("获取缓存失败，未启动redis：参数" + queryArgs);
				return null;
			}
		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
			return null;
		}
	}

	@Override
	public boolean hasCacheData(String queryArgs) {
		if (ISCACHEON) {
			LOGGER.debug("判断是否含有缓存：参数" + queryArgs);
			ShardedJedis redis = this.getShardedJedis();
			if (null != redis) {
				boolean flag = redis.exists(queryArgs.getBytes());
				this.returnResource(redis);
				return flag;
			} else {
				LOGGER.debug("判断是否含有缓存失败，未启动redis：参数" + queryArgs);
				return false;
			}
		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
			return false;
		}
	}

	public void addGlobleCacheData(String queryArgs, Object data) {
		if (ISCACHEON) {
			LOGGER.debug("添加全局缓存：参数" + queryArgs);
			ShardedJedis redis = this.getShardedJedis();
			if (null != redis) {
				redis.set(queryArgs.getBytes(), this.getStrFromObj(data));
				this.returnResource(redis);
			} else {
				LOGGER.debug("添加全局缓存失败，未启动redis：参数" + queryArgs);
			}
		} else {
			LOGGER.debug("配置禁用缓存" + queryArgs);
		}
	}

	@Override
	public void clearOverdueCache() {
		return;
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 1; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					RedisCacheImpl redis = new RedisCacheImpl();
					redis.addCacheData(null, "0001:CustomerService:getTableData:{ctel:\"13343285888\"}", "bb");
					redis.hasCacheData("0001:CustomerService:getTableData:{ctel:\"13343285888\"}");
					redis.getCacheData("0001:CustomerService:getTableData:{ctel:\"13343285888\"}");
				}
			}).start();
		}
	}
}
