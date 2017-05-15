package com.voole.datasync.entry.sytem.function;

import java.io.Serializable;
import java.util.Date;

import com.voole.datasync.entry.BaseEntry;

/**
 * @ClassName: RuleFunctionEntry
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月8日 上午10:57:56
 * 
 */
public class RuleFunctionEntry extends BaseEntry implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 上午11:02:04
	 */
	private static final long serialVersionUID = -8022648099183566614L;
	protected Integer id;// id
	protected Integer rid;// 角色id
	protected Integer fid;// 链接id

	/**
	 * @return the id
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:01:56
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:01:56
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the rid
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:01:56
	 */
	public Integer getRid() {
		return this.rid;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:01:56
	 * @param rid the rid to set
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * @return the fid
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:01:56
	 */
	public Integer getFid() {
		return this.fid;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:01:56
	 * @param fid the fid to set
	 */
	public void setFid(Integer fid) {
		this.fid = fid;
	}

	/**
	 * @return the is_on
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:01:56
	 */
	public Integer getIs_on() {
		return this.is_on;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:01:56
	 * @param is_on the is_on to set
	 */
	public void setIs_on(Integer is_on) {
		this.is_on = is_on;
	}

	/**
	 * @return the create_time
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:01:56
	 */
	public Date getCreate_time() {
		return this.create_time;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:01:56
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * @return the update_time
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:01:56
	 */
	public Date getUpdate_time() {
		return this.update_time;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:01:56
	 * @param update_time the update_time to set
	 */
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	/**
	 * @return the version
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:01:56
	 */
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:01:56
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
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
		return "RuleFunctionEntry [id=" + this.id + ", rid=" + this.rid + ", fid=" + this.fid + ", is_on=" + this.is_on
				+ ", create_time=" + this.create_time + ", update_time=" + this.update_time + ", version="
				+ this.version + "]";
	}
}
