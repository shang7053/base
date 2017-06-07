package com.voole.datasync.entry.sytem.log;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: SysytemLog
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:01:57
 * 
 */
public class SystemLogEntry implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午2:04:32
	 */
	protected static final long serialVersionUID = 4223863762145046535L;
	protected Integer lid;// 日志id
	protected Integer uid;// 用户id
	protected String url;// url
	protected String param;// 参数
	protected Integer is_on;// 是否冻结0否1是
	protected Date create_time;// 创建时间
	protected Date update_time;// 修改时间
	protected Integer version;// 版本号
	protected Date create_time_start;// 创建时间开始
	protected Date create_time_end;// 创建时间结束

	/**
	 * @return the is_on
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:44
	 */
	public Integer getIs_on() {
		return this.is_on;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:44
	 * @param is_on the is_on to set
	 */
	public void setIs_on(Integer is_on) {
		this.is_on = is_on;
	}

	/**
	 * @return the update_time
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:44
	 */
	public Date getUpdate_time() {
		return this.update_time;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:44
	 * @param update_time the update_time to set
	 */
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	/**
	 * @return the version
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:44
	 */
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:44
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the create_time_start
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:44
	 */
	public Date getCreate_time_start() {
		return this.create_time_start;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:44
	 * @param create_time_start the create_time_start to set
	 */
	public void setCreate_time_start(Date create_time_start) {
		this.create_time_start = create_time_start;
	}

	/**
	 * @return the create_time_end
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:44
	 */
	public Date getCreate_time_end() {
		return this.create_time_end;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:44
	 * @param create_time_end the create_time_end to set
	 */
	public void setCreate_time_end(Date create_time_end) {
		this.create_time_end = create_time_end;
	}

	/**
	 * @return the lid
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:23:18
	 */
	public Integer getLid() {
		return this.lid;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:23:18
	 * @param lid the lid to set
	 */
	public void setLid(Integer lid) {
		this.lid = lid;
	}

	/**
	 * @return the uid
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:23:18
	 */
	public Integer getUid() {
		return this.uid;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:23:18
	 * @param uid the uid to set
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**
	 * @return the url
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:23:18
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:23:18
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the param
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:23:18
	 */
	public String getParam() {
		return this.param;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:23:18
	 * @param param the param to set
	 */
	public void setParam(String param) {
		this.param = param;
	}

	/**
	 * @return the create_time
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:23:18
	 */
	public Date getCreate_time() {
		return this.create_time;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:23:18
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
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
		return "SysytemLogEntry [lid=" + this.lid + ", uid=" + this.uid + ", url=" + this.url + ", param=" + this.param
				+ ", create_time=" + this.create_time + "]";
	}
}
