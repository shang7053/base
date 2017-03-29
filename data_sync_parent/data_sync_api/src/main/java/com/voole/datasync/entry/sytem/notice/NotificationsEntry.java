package com.voole.datasync.entry.sytem.notice;

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
	protected String context;// 正文
	protected Integer is_read;// 是否已读
	protected Date create_time;// 创建时间
	protected Date read_time;// 已读时间
	protected Integer version;// 版本号

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
				+ ", is_read=" + this.is_read + ", create_time=" + this.create_time + ", read_time=" + this.read_time
				+ ", version=" + this.version + "]";
	}
}
