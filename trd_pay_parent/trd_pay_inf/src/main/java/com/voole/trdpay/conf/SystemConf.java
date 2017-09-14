package com.voole.trdpay.conf;

import org.springframework.stereotype.Repository;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;

/**
 * @ClassName: SystemConf
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月8日 上午9:11:36
 * 
 */
@Repository
@DisconfFile(filename = "system.properties")
public class SystemConf {
	private String priKey;

	/**
	 * @return the pubKey
	 * @author shangchengcai@voole.com
	 * @date 2017年9月7日 下午5:42:34
	 */
	@DisconfFileItem(name = "prikey")
	public String getPriKey() {
		return this.priKey;
	}

}
