package com.scc.dubbo.docker.base.conf;

import org.springframework.stereotype.Repository;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;

/**
 * @ClassName: SystemConf
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年3月1日 下午3:10:52
 * 
 */
@Repository
@DisconfFile(filename = "system.properties")
public class SystemConf {
	private String dubbo_zk_address;

	/**
	 * @return the dubbo_zk_address
	 * @author shangchengcai@voole.com
	 * @date 2018年3月1日 下午3:11:44
	 */
	@DisconfFileItem(name = "dubbo.zk.address")
	public String getDubbo_zk_address() {
		return this.dubbo_zk_address;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2018年3月1日 下午3:11:44
	 * @param dubbo_zk_address the dubbo_zk_address to set
	 */
	public void setDubbo_zk_address(String dubbo_zk_address) {
		this.dubbo_zk_address = dubbo_zk_address;
	}

}
