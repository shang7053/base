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

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

public class RedisConfig extends JedisPoolConfig {

	private String host = Protocol.DEFAULT_HOST;
	private int port = Protocol.DEFAULT_PORT;
	private String address = "localhost:6379";
	private int deployType = 0;
	private String sysCode;
	private int connectionTimeout = Protocol.DEFAULT_TIMEOUT;
	private int soTimeout = Protocol.DEFAULT_TIMEOUT;
	private String password;
	private int database = Protocol.DEFAULT_DATABASE;
	private String clientName;

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		if (host == null || "".equals(host)) {
			host = Protocol.DEFAULT_HOST;
		}
		this.host = host;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		if ("".equals(password)) {
			password = null;
		}
		this.password = password;
	}

	public int getDatabase() {
		return this.database;
	}

	public void setDatabase(int database) {
		this.database = database;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		if ("".equals(clientName)) {
			clientName = null;
		}
		this.clientName = clientName;
	}

	public int getConnectionTimeout() {
		return this.connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getSoTimeout() {
		return this.soTimeout;
	}

	public void setSoTimeout(int soTimeout) {
		this.soTimeout = soTimeout;
	}

	/**
	 * @return the deployType
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月15日 下午12:20:12
	 */
	public int getDeployType() {
		return this.deployType;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月15日 下午12:20:12
	 * @param deployType the deployType to set
	 */
	public void setDeployType(int deployType) {
		this.deployType = deployType;
	}

	/**
	 * @return the address
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月15日 下午12:24:24
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月15日 下午12:24:24
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the sysCode
	 * @author shangchengcai@voole.com
	 * @date 2017年5月27日 下午1:37:03
	 */
	public String getSysCode() {
		return this.sysCode;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年5月27日 下午1:37:03
	 * @param sysCode the sysCode to set
	 */
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

}
