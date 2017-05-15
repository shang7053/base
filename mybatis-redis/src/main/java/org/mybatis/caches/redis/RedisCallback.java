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

import redis.clients.jedis.BinaryJedisCluster;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

public interface RedisCallback {
	/**
	 * 单机
	 * 
	 * @Title: doWithRedis
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年5月15日 下午12:33:30
	 * @param jedis
	 * @return
	 */
	Object doWithRedis(Jedis jedis);

	/**
	 * 分片
	 * 
	 * @Title: doWithRedis
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年5月15日 下午12:33:45
	 * @param jedis
	 * @return
	 */
	Object doWithRedis(ShardedJedis jedis);

	/**
	 * 集群
	 * 
	 * @Title: doWithRedis
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年5月15日 下午12:33:51
	 * @param jedis
	 * @return
	 */
	Object doWithRedis(BinaryJedisCluster jedis);
}
