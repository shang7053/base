/**
 *    Copyright 2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.caches.redis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.ibatis.cache.Cache;

import redis.clients.jedis.BinaryJedisCluster;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Cache adapter for Redis.
 *
 * @author Eduardo Macarron
 */
public final class RedisCache implements Cache {

	private final ReadWriteLock readWriteLock = new DummyReadWriteLock();

	private String id;
	private Integer deployType;
	private static JedisPool pool;
	private static ShardedJedisPool shardedJedisPool;// 切片额客户端连接
	private static BinaryJedisCluster cluster;

	public RedisCache(final String id) {
		if (id == null) {
			throw new IllegalArgumentException("Cache instances require an ID");
		}
		RedisConfig redisConfig = RedisConfigurationBuilder.getInstance().parseConfiguration();
		String sysCode = redisConfig.getSysCode();
		if (sysCode == null || "".equals(sysCode)) {
			throw new IllegalArgumentException("sysCode is required");
		}
		this.id = sysCode + "_" + id;
		this.deployType = redisConfig.getDeployType();
		switch (redisConfig.getDeployType()) {
		case 0:
			String address = redisConfig.getAddress();
			pool = new JedisPool(address.split(":")[0], Integer.valueOf(address.split(":")[1]));
			break;
		case 1:
			// 池基本配置
			GenericObjectPoolConfig config = new GenericObjectPoolConfig();
			config.setMaxIdle(redisConfig.getMaxIdle());
			config.setMinIdle(redisConfig.getMinIdle());
			List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
			// slave链接
			for (String add : redisConfig.getAddress().split(",")) {
				shards.add(new JedisShardInfo(add.split(":")[0], Integer.valueOf(add.split(":")[1]),
						redisConfig.getConnectionTimeout()));
			}
			// 构造池
			shardedJedisPool = new ShardedJedisPool(config, shards);
			break;
		case 2:
			// slave链接
			Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
			for (String add : redisConfig.getAddress().split(",")) {
				jedisClusterNodes.add(new HostAndPort(add.split(":")[0], Integer.valueOf(add.split(":")[1])));
			}
			// 构造池
			cluster = new BinaryJedisCluster(jedisClusterNodes);
			break;

		default:
			break;
		}
	}

	private Object execute(RedisCallback callback) {
		switch (this.deployType) {
		case 0:
			Jedis jedis = pool.getResource();
			try {
				return callback.doWithRedis(jedis);
			} finally {
				jedis.close();
			}
		case 1:
			ShardedJedis shardedJedis = shardedJedisPool.getResource();
			try {
				return callback.doWithRedis(shardedJedis);
			} finally {
				shardedJedis.close();
			}
		case 2:
			return callback.doWithRedis(cluster);
		default:
			Jedis jedis2 = pool.getResource();
			try {
				return callback.doWithRedis(jedis2);
			} finally {
				jedis2.close();
			}
		}
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public int getSize() {
		return (Integer) this.execute(new RedisCallback() {
			@Override
			public Object doWithRedis(Jedis jedis) {
				Map<byte[], byte[]> result = jedis.hgetAll(RedisCache.this.id.toString().getBytes());
				return result.size();
			}

			@Override
			public Object doWithRedis(ShardedJedis jedis) {
				Map<byte[], byte[]> result = jedis.hgetAll(RedisCache.this.id.toString().getBytes());
				return result.size();
			}

			@Override
			public Object doWithRedis(BinaryJedisCluster jedis) {
				Map<byte[], byte[]> result = jedis.hgetAll(RedisCache.this.id.toString().getBytes());
				return result.size();
			}
		});
	}

	@Override
	public void putObject(final Object key, final Object value) {
		this.execute(new RedisCallback() {
			@Override
			public Object doWithRedis(Jedis jedis) {
				jedis.hset(RedisCache.this.id.toString().getBytes(), key.toString().getBytes(),
						SerializeUtil.serialize(value));
				return null;
			}

			@Override
			public Object doWithRedis(ShardedJedis jedis) {
				jedis.hset(RedisCache.this.id.toString().getBytes(), key.toString().getBytes(),
						SerializeUtil.serialize(value));
				return null;
			}

			@Override
			public Object doWithRedis(BinaryJedisCluster jedis) {
				jedis.hset(RedisCache.this.id.toString().getBytes(), key.toString().getBytes(),
						SerializeUtil.serialize(value));
				return null;
			}
		});
	}

	@Override
	public Object getObject(final Object key) {
		return this.execute(new RedisCallback() {
			@Override
			public Object doWithRedis(Jedis jedis) {
				return SerializeUtil
						.unserialize(jedis.hget(RedisCache.this.id.toString().getBytes(), key.toString().getBytes()));
			}

			@Override
			public Object doWithRedis(ShardedJedis jedis) {
				return SerializeUtil
						.unserialize(jedis.hget(RedisCache.this.id.toString().getBytes(), key.toString().getBytes()));
			}

			@Override
			public Object doWithRedis(BinaryJedisCluster jedis) {
				return SerializeUtil
						.unserialize(jedis.hget(RedisCache.this.id.toString().getBytes(), key.toString().getBytes()));
			}
		});
	}

	@Override
	public Object removeObject(final Object key) {
		return this.execute(new RedisCallback() {
			@Override
			public Object doWithRedis(Jedis jedis) {
				return jedis.hdel(RedisCache.this.id.toString(), key.toString());
			}

			@Override
			public Object doWithRedis(ShardedJedis jedis) {
				return jedis.hdel(RedisCache.this.id.toString(), key.toString());
			}

			@Override
			public Object doWithRedis(BinaryJedisCluster jedis) {
				return jedis.hdel(RedisCache.this.id.toString().getBytes(), key.toString().getBytes());
			}
		});
	}

	@Override
	public void clear() {
		this.execute(new RedisCallback() {
			@Override
			public Object doWithRedis(Jedis jedis) {
				jedis.del(RedisCache.this.id.toString());
				return null;
			}

			@Override
			public Object doWithRedis(ShardedJedis jedis) {
				jedis.del(RedisCache.this.id.toString());
				return null;
			}

			@Override
			public Object doWithRedis(BinaryJedisCluster jedis) {
				jedis.del(RedisCache.this.id.toString().getBytes());
				return null;
			}
		});

	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return this.readWriteLock;
	}

	@Override
	public String toString() {
		return "Redis {" + this.id + "}";
	}

}
