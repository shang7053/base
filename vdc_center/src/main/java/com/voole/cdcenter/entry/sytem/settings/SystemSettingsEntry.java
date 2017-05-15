package com.voole.cdcenter.entry.sytem.settings;

import java.io.Serializable;
import java.util.Date;

import com.voole.cdcenter.entry.BaseEntry;

/**
 * @ClassName: SystemSettings
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:02:19
 * 
 */
public class SystemSettingsEntry extends BaseEntry implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午2:03:35
	 */
	protected static final long serialVersionUID = -2711988581916539071L;
	protected Integer id;// 主键id
	protected String config_name;// 名
	protected String config_value;// 值
	protected String rmark;// 说明

	/**
	 * @return the create_time
	 * @author shangchengcai@voole.com
	 * @date 2017年5月12日 下午4:08:23
	 */
	@Override
	public Date getCreate_time() {
		return this.create_time;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年5月12日 下午4:08:23
	 * @param create_time the create_time to set
	 */
	@Override
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * @return the update_time
	 * @author shangchengcai@voole.com
	 * @date 2017年5月12日 下午4:08:23
	 */
	@Override
	public Date getUpdate_time() {
		return this.update_time;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年5月12日 下午4:08:23
	 * @param update_time the update_time to set
	 */
	@Override
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	/**
	 * @return the is_on
	 * @author shangchengcai@voole.com
	 * @date 2017年5月12日 下午4:08:23
	 */
	@Override
	public Integer getIs_on() {
		return this.is_on;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年5月12日 下午4:08:23
	 * @param is_on the is_on to set
	 */
	@Override
	public void setIs_on(Integer is_on) {
		this.is_on = is_on;
	}

	/**
	 * @return the version
	 * @author shangchengcai@voole.com
	 * @date 2017年5月12日 下午4:08:23
	 */
	@Override
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年5月12日 下午4:08:23
	 * @param version the version to set
	 */
	@Override
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the id
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午2:15:10
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午2:15:10
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the config_name
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午2:15:10
	 */
	public String getConfig_name() {
		return this.config_name;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午2:15:10
	 * @param config_name the config_name to set
	 */
	public void setConfig_name(String config_name) {
		this.config_name = config_name;
	}

	/**
	 * @return the config_value
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午2:15:10
	 */
	public String getConfig_value() {
		return this.config_value;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午2:15:10
	 * @param config_value the config_value to set
	 */
	public void setConfig_value(String config_value) {
		this.config_value = config_value;
	}

	/**
	 * @return the rmark
	 * @author shangchengcai@voole.com
	 * @date 2016年7月14日 下午4:35:11
	 */
	public String getRmark() {
		return this.rmark;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2016年7月14日 下午4:35:11
	 * @param rmark the rmark to set
	 */
	public void setRmark(String rmark) {
		this.rmark = rmark;
	}

}
