package com.voole.datasync.util.validate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import redis.clients.jedis.BinaryJedisCluster;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @ClassName: AccountValidate
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年9月23日 下午4:47:24
 * 
 */
class AccountValidate implements IAccountValidate {

	/*
	 * (非 Javadoc) <p>Title: validateMysql</p> <p>Description: </p>
	 * 
	 * @param ip
	 * 
	 * @param port
	 * 
	 * @param dbname
	 * 
	 * @param uname
	 * 
	 * @param password
	 * 
	 * @return
	 * 
	 * @see com.voole.vdccenter.util.IAccountValidate#validateMysql(java.lang.String, java.lang.Integer,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean validateMysql(String ip, Integer port, String dbname, String uname, String password) {
		return this.validateM(ip, port, dbname, uname, password);
	}

	/*
	 * (非 Javadoc) <p>Title: validateMycat</p> <p>Description: </p>
	 * 
	 * @param ip
	 * 
	 * @param port
	 * 
	 * @param dbname
	 * 
	 * @param uname
	 * 
	 * @param password
	 * 
	 * @return
	 * 
	 * @see com.voole.vdccenter.util.IAccountValidate#validateMycat(java.lang.String, java.lang.Integer,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean validateMycat(String ip, Integer port, String dbname, String uname, String password) {
		return this.validateM(ip, port, dbname, uname, password);
	}

	/*
	 * (非 Javadoc) <p>Title: validateRedis</p> <p>Description: </p>
	 * 
	 * @param ip
	 * 
	 * @param port
	 * 
	 * @param uname
	 * 
	 * @param password
	 * 
	 * @param deployType
	 * 
	 * @return
	 * 
	 * @see com.voole.vdccenter.util.IAccountValidate#validateRedis(java.lang.String, java.lang.Integer,
	 * java.lang.String, java.lang.String, com.voole.vdccenter.util.DeployType)
	 */
	@Override
	public boolean validateRedis(String ip, Integer port, String uname, String password, DeployType deployType) {
		switch (deployType.name()) {
		case "cluster":
			try {
				Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
				jedisClusterNodes.add(new HostAndPort(ip, port));
				BinaryJedisCluster cluster = new BinaryJedisCluster(jedisClusterNodes);
				cluster.append("vdc_test_kry".getBytes(), "this is a test key ! anyone can delete it!".getBytes());
				cluster.close();
			} catch (Exception e) {
				return false;
			}
			return true;
		case "stand":
			try {
				Jedis jedis = new Jedis(ip, port, 200);
				jedis.append("vdc_test_kry", "this is a test key ! anyone can delete it!");
				jedis.close();
			} catch (Exception e) {
				return false;
			}
			return true;
		case "shard":
			try {
				GenericObjectPoolConfig config = new GenericObjectPoolConfig();
				List<JedisShardInfo> shareds = new ArrayList<>();
				shareds.add(new JedisShardInfo(ip, port, 200));
				ShardedJedisPool pool = new ShardedJedisPool(config, shareds);
				ShardedJedis jedis = pool.getResource();
				jedis.append("vdc_test_kry", "this is a test key ! anyone can delete it!");
				jedis.close();
				pool.close();
			} catch (Exception e) {
				return false;
			}
			return true;

		default:
			return false;
		}
	}

	private boolean validateM(String ip, Integer port, String dbname, String uname, String password) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://" + ip + ":" + port + "/" + dbname;
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, uname, password);
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// e.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * (非 Javadoc) <p>Title: validateKafka</p> <p>Description: </p>
	 * 
	 * @param ip
	 * 
	 * @param port
	 * 
	 * @return
	 * 
	 * @see com.voole.datasync.util.validate.IAccountValidate#validateKafka(java.lang.String, java.lang.Integer)
	 */
	@Override
	public boolean validateKafka(String ip, Integer port) {
		try {
			Properties kafkaprops = new Properties();
			kafkaprops.put("zookeeper.connect", ip + ":" + port);
			kafkaprops.put("group.id", "data_sync_sdk");
			kafkaprops.put("zookeeper.session.timeout.ms", "500");
			kafkaprops.put("zookeeper.sync.time.ms", "250");
			kafkaprops.put("auto.commit.interval.ms", "1000");
			ConsumerConfig config = new ConsumerConfig(kafkaprops);
			Consumer.createJavaConsumerConnector(config);
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		}
	}
}
