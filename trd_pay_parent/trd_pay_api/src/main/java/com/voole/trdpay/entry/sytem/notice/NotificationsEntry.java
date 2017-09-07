package com.voole.trdpay.entry.sytem.notice;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Notifications
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:02:07
 * 
 */
public class NotificationsEntry implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午2:04:28
	 */
	protected static final long serialVersionUID = 8381959393219636656L;
	protected Integer nid;// id
	protected String title;// 标题
	protected String sync_code;// 同步码
	protected String context;// 正文
	protected Integer is_read;// 是否已读
	protected Integer is_email;// 是否已发邮件
	protected Date read_time;// 已读时间
	protected Integer is_on;// 是否冻结0否1是
	protected Date create_time;// 创建时间
	protected Date update_time;// 修改时间
	protected Integer version;// 版本号
	protected Date create_time_start;// 创建时间开始
	protected Date create_time_end;// 创建时间结束

	/**
	 * @return the is_on
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:54
	 */
	public Integer getIs_on() {
		return this.is_on;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:54
	 * @param is_on the is_on to set
	 */
	public void setIs_on(Integer is_on) {
		this.is_on = is_on;
	}

	/**
	 * @return the update_time
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:54
	 */
	public Date getUpdate_time() {
		return this.update_time;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:54
	 * @param update_time the update_time to set
	 */
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	/**
	 * @return the create_time_start
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:54
	 */
	public Date getCreate_time_start() {
		return this.create_time_start;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:54
	 * @param create_time_start the create_time_start to set
	 */
	public void setCreate_time_start(Date create_time_start) {
		this.create_time_start = create_time_start;
	}

	/**
	 * @return the create_time_end
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:54
	 */
	public Date getCreate_time_end() {
		return this.create_time_end;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:18:54
	 * @param create_time_end the create_time_end to set
	 */
	public void setCreate_time_end(Date create_time_end) {
		this.create_time_end = create_time_end;
	}

	/**
	 * @return the nid
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:21:05
	 */
	public Integer getNid() {
		return this.nid;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:21:05
	 * @param nid the nid to set
	 */
	public void setNid(Integer nid) {
		this.nid = nid;
	}

	/**
	 * @return the title
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:21:05
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:21:05
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the context
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:21:05
	 */
	public String getContext() {
		return this.context;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:21:05
	 * @param context the context to set
	 */
	public void setContext(String context) {
		this.context = context;
	}

	/**
	 * @return the is_read
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:21:05
	 */
	public Integer getIs_read() {
		return this.is_read;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:21:05
	 * @param is_read the is_read to set
	 */
	public void setIs_read(Integer is_read) {
		this.is_read = is_read;
	}

	/**
	 * @return the create_time
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:21:05
	 */
	public Date getCreate_time() {
		return this.create_time;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:21:05
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * @return the read_time
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:21:05
	 */
	public Date getRead_time() {
		return this.read_time;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:21:05
	 * @param read_time the read_time to set
	 */
	public void setRead_time(Date read_time) {
		this.read_time = read_time;
	}

	/**
	 * @return the version
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:21:05
	 */
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:21:05
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the is_email
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年3月31日 上午9:39:33
	 */
	public Integer getIs_email() {
		return this.is_email;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年3月31日 上午9:39:33
	 * @param is_email the is_email to set
	 */
	public void setIs_email(Integer is_email) {
		this.is_email = is_email;
	}

	/**
	 * @return the sync_code
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年3月31日 上午9:40:59
	 */
	public String getSync_code() {
		return this.sync_code;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年3月31日 上午9:40:59
	 * @param sync_code the sync_code to set
	 */
	public void setSync_code(String sync_code) {
		this.sync_code = sync_code;
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
		return "NotificationsEntry [nid=" + this.nid + ", title=" + this.title + ", context=" + this.context
				+ ", is_read=" + this.is_read + ", is_email=" + this.is_email + ", read_time=" + this.read_time
				+ ", is_on=" + this.is_on + ", create_time=" + this.create_time + ", update_time=" + this.update_time
				+ ", version=" + this.version + ", create_time_start=" + this.create_time_start + ", create_time_end="
				+ this.create_time_end + "]";
	}
}
