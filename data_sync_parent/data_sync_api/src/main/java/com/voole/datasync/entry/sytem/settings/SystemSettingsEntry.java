package com.voole.datasync.entry.sytem.settings;

import java.io.Serializable;
import java.util.Date;

import com.voole.datasync.entry.BaseEntry;

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
	 * @return the id
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:15:10
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:15:10
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the config_name
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:15:10
	 */
	public String getConfig_name() {
		return this.config_name;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:15:10
	 * @param config_name the config_name to set
	 */
	public void setConfig_name(String config_name) {
		this.config_name = config_name;
	}

	/**
	 * @return the config_value
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:15:10
	 */
	public String getConfig_value() {
		return this.config_value;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:15:10
	 * @param config_value the config_value to set
	 */
	public void setConfig_value(String config_value) {
		this.config_value = config_value;
	}

	/**
	 * @return the is_on
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:15:10
	 */
	public Integer getIs_on() {
		return this.is_on;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:15:10
	 * @param is_on the is_on to set
	 */
	public void setIs_on(Integer is_on) {
		this.is_on = is_on;
	}

	/**
	 * @return the create_time
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:15:10
	 */
	public Date getCreate_time() {
		return this.create_time;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:15:10
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * @return the update_time
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:15:10
	 */
	public Date getUpdate_time() {
		return this.update_time;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:15:10
	 * @param update_time the update_time to set
	 */
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	/**
	 * @return the version
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:15:10
	 */
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:15:10
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the rmark
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午4:35:11
	 */
	public String getRmark() {
		return this.rmark;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午4:35:11
	 * @param rmark the rmark to set
	 */
	public void setRmark(String rmark) {
		this.rmark = rmark;
	}

	/*
	 * (非 Javadoc) <p>Title: toString</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SystemSettingsEntry [id=" + this.id + ", config_name=" + this.config_name + ", config_value="
				+ this.config_value + ", rmark=" + this.rmark + ", is_on=" + this.is_on + ", create_time="
				+ this.create_time + ", update_time=" + this.update_time + ", version=" + this.version + "]";
	}
}
