package com.voole.trdpay.entry.sytem.rule;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: UserRuleEntry
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月8日 上午9:56:13
 * 
 */
public class UserRuleEntry implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 上午9:57:42
	 */
	protected static final long serialVersionUID = -8605680549683065643L;
	protected Integer id;// 主键id
	protected Integer uid;// 用户id
	protected Integer rid;// 角色id
	protected Integer is_on;// 是否冻结0否1是
	protected Date create_time;// 创建时间
	protected Date update_time;// 修改时间
	protected Integer version;// 版本号
	protected Date create_time_start;// 创建时间开始
	protected Date create_time_end;// 创建时间结束

	/**
	 * @return the create_time_start
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:19:14
	 */

	public Date getCreate_time_start() {
		return this.create_time_start;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:19:14
	 * @param create_time_start the create_time_start to set
	 */

	public void setCreate_time_start(Date create_time_start) {
		this.create_time_start = create_time_start;
	}

	/**
	 * @return the create_time_end
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:19:14
	 */

	public Date getCreate_time_end() {
		return this.create_time_end;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:19:14
	 * @param create_time_end the create_time_end to set
	 */

	public void setCreate_time_end(Date create_time_end) {
		this.create_time_end = create_time_end;
	}

	/**
	 * @return the id
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:57:30
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:57:30
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the uid
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:57:30
	 */
	public Integer getUid() {
		return this.uid;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:57:30
	 * @param uid the uid to set
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**
	 * @return the rid
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:57:30
	 */
	public Integer getRid() {
		return this.rid;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:57:30
	 * @param rid the rid to set
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * @return the is_on
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:57:30
	 */

	public Integer getIs_on() {
		return this.is_on;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:57:30
	 * @param is_on the is_on to set
	 */

	public void setIs_on(Integer is_on) {
		this.is_on = is_on;
	}

	/**
	 * @return the create_time
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:57:30
	 */

	public Date getCreate_time() {
		return this.create_time;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:57:30
	 * @param create_time the create_time to set
	 */

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * @return the update_time
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:57:30
	 */

	public Date getUpdate_time() {
		return this.update_time;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:57:30
	 * @param update_time the update_time to set
	 */

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	/**
	 * @return the version
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:57:30
	 */

	public Integer getVersion() {
		return this.version;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:57:30
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
		return "UserRuleEntry [id=" + this.id + ", uid=" + this.uid + ", rid=" + this.rid + ", is_on=" + this.is_on
				+ ", create_time=" + this.create_time + ", update_time=" + this.update_time + ", version="
				+ this.version + "]";
	}
}
