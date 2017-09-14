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
	private String url;
	private Long timeout;
	private String inscd;// 机构号
	private String mchntid;// 商户号
	private String terminalidPrefix;// 终端号前缀
	private String signkey;// 签名秘钥
	private String backUrl;

	/**
	 * @return the url
	 * @author shangchengcai@voole.com
	 * @date 2017年9月7日 下午6:05:08
	 */
	@DisconfFileItem(name = "spdbank.url")
	public String getUrl() {
		return this.url;
	}

	/**
	 * @return the timeout
	 * @author shangchengcai@voole.com
	 * @date 2017年9月7日 下午6:05:08
	 */
	@DisconfFileItem(name = "http.timeout")
	public Long getTimeout() {
		return this.timeout;
	}

	/**
	 * @return the inscd
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:26:14
	 */
	@DisconfFileItem(name = "spd.inscd")
	public String getInscd() {
		return this.inscd;
	}

	/**
	 * @return the mchntid
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:26:14
	 */
	@DisconfFileItem(name = "spd.mchntid")
	public String getMchntid() {
		return this.mchntid;
	}

	/**
	 * @return the terminalidPrefix
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午1:54:07
	 */
	@DisconfFileItem(name = "spd.terminalid.prefix")
	public String getTerminalidPrefix() {
		return this.terminalidPrefix;
	}

	/**
	 * @return the signkey
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午1:54:07
	 */
	@DisconfFileItem(name = "spd.sign.key")
	public String getSignkey() {
		return this.signkey;
	}

	/**
	 * @return the backUrl
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午2:42:14
	 */
	@DisconfFileItem(name = "spd.backurl")
	public String getBackUrl() {
		return this.backUrl;
	}

}
