package scc.util.cache.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import scc.util.cache.ICache;
import scc.util.cache.data.CacheData;
import scc.util.cache.util.SerializeUtil;

public class RedisCacheImpl implements ICache{
    private static ShardedJedisPool shardedJedisPool;//切片额客户端连接
    private static Properties p=new Properties();
    private static int keepAliveTime;
    private static final Logger LOGGER=Logger.getLogger(RedisCacheImpl.class);
    static{
    	try {
			p.load(RedisCacheImpl.class.getClassLoader().getResourceAsStream("redisconfig.properties"));
			keepAliveTime=null==p.get("keepAliveTime")?600:Integer.valueOf((String) p.get("keepAliveTime"));
			 // 池基本配置 
			JedisPoolConfig config = new JedisPoolConfig(); 
			config.setMaxActive(null==p.get("MaxActive")?20:Integer.valueOf(p.getProperty("MaxActive"))); 
	        config.setMaxIdle(null==p.get("MaxIdle")?10:Integer.valueOf(p.getProperty("MaxIdle"))); 
	        config.setMinIdle(null==p.get("MinIdle")?10:Integer.valueOf(p.getProperty("MinIdle")));
	        config.setMaxWait(null==p.get("MaxWait")?1000l:Long.valueOf(p.getProperty("MaxWait"))); 
	        config.setTestOnBorrow(null==p.get("TestOnBorrow")?false:Boolean.valueOf(p.getProperty("TestOnBorrow"))); 
	        config.setTestOnReturn(null==p.get("TestOnReturn")?false:Boolean.valueOf(p.getProperty("TestOnReturn")));
	        config.setTestWhileIdle(null==p.get("TestWhileIdle")?false:Boolean.valueOf(p.getProperty("TestWhileIdle")));
	        // slave链接 
	        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>(); 
	        shards.add(new JedisShardInfo(null==p.get("redishost")?"127.0.0.1":p.getProperty("redishost"), null==p.get("redisport")?6379:Integer.valueOf(p.getProperty("redisport")), "master")); 
	        // 构造池 
	        shardedJedisPool = new ShardedJedisPool(config, shards);
    	} catch (IOException e) {
			e.printStackTrace();
		}
    }
    private ShardedJedis getShardedJedis(){
    	return shardedJedisPool.getResource();
    }
	@Override
	public void addCacheData(Date loadDate, String queryArgs, Object data) {
		LOGGER.debug("添加缓存：参数"+queryArgs);
		ShardedJedis redis=getShardedJedis();
		redis.setex(queryArgs.getBytes(), keepAliveTime, getStrFromObj(data));
		returnResource(redis);
	}

	private void returnResource(ShardedJedis redis) {
		if(null!=redis)
			shardedJedisPool.returnResource(redis);
	}
	private byte[] getStrFromObj(Object data) {
		return SerializeUtil.serialize(data);
	}

	@Override
	public void addCacheData(String queryArgs, CacheData data) {
		LOGGER.debug("添加缓存：参数"+queryArgs);
		ShardedJedis redis=getShardedJedis();
		redis.setex(queryArgs.getBytes(), keepAliveTime, getStrFromObj(data.getData()));
		returnResource(redis);
	}

	@Override
	public void addOrUpdate(Date loadDate, String queryArgs, Object data) {
		LOGGER.debug("添加缓存：参数"+queryArgs);
		ShardedJedis redis=getShardedJedis();
		redis.setex(queryArgs.getBytes(), keepAliveTime, getStrFromObj(data));
		returnResource(redis);
	}

	@Override
	public void addOrUpdate(String queryArgs, CacheData data) {
		LOGGER.debug("添加缓存：参数"+queryArgs);
		ShardedJedis redis=getShardedJedis();
		redis.setex(queryArgs.getBytes(), keepAliveTime, getStrFromObj(data));
		returnResource(redis);
	}

	@Override
	public void updateCacheData(Date loadDate, String queryArgs, Object data) {
		LOGGER.debug("添加缓存：参数"+queryArgs);
		ShardedJedis redis=getShardedJedis();
		redis.setex(queryArgs.getBytes(), keepAliveTime, getStrFromObj(data));
		returnResource(redis);
	}

	@Override
	public void updateCacheData(String queryArgs, CacheData data) {
		LOGGER.debug("添加缓存：参数"+queryArgs);
		ShardedJedis redis=getShardedJedis();
		redis.setex(queryArgs.getBytes(), keepAliveTime, getStrFromObj(data));
		returnResource(redis);
	}

	@Override
	public Object getCacheData(String queryArgs) {
		LOGGER.debug("获取缓存：参数"+queryArgs);
		ShardedJedis redis=getShardedJedis();
		byte[] result=redis.get(queryArgs.getBytes());
		if(null==result)
			return null;
		returnResource(redis);
		return SerializeUtil. unserialize(result);
	}

	@Override
	public boolean hasCacheData(String queryArgs) {
		LOGGER.debug("判断是否含有缓存：参数"+queryArgs);
		ShardedJedis redis=getShardedJedis();
		boolean flag= redis.exists(queryArgs.getBytes());
		returnResource(redis);
		return flag;
	}

	@Override
	public void clearOverdueCache() {
		return ;
	}
	public static void main(String[] args) throws InterruptedException {
		RedisCacheImpl redis=new RedisCacheImpl();
		redis.addCacheData(null,"0001:CustomerService:getTableData:{ctel:\"13343285888\"}", "bb");
		System.out.println(redis.hasCacheData("0001:CustomerService:getTableData:{ctel:\"13343285888\"}"));
		System.out.println(redis.getCacheData("0001:CustomerService:getTableData:{ctel:\"13343285888\"}"));
	}
}
