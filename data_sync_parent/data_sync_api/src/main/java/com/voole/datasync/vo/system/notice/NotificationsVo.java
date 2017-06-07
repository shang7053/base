package com.voole.datasync.vo.system.notice;

import java.io.Serializable;
import java.util.Date;

import com.voole.datasync.entry.sytem.notice.NotificationsEntry;
import com.voole.datasync.vo.PageMessageVo;

/**
 * @ClassName: Notifications
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:02:07
 * 
 */
public class NotificationsVo extends NotificationsEntry implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 下午4:31:56
	 */
	private static final long serialVersionUID = -6818411976889622985L;
	private Date queryStart;
	private Date queryEnd;
	private Integer start;
	private Integer size;
	private PageMessageVo pmv;
	private String recive_email;

	/**
	 * @return the start
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月12日 下午2:36:36
	 */
	public Integer getStart() {
		return this.start;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月12日 下午2:36:36
	 * @param start the start to set
	 */
	public void setStart(Integer start) {
		this.start = start;
	}

	/**
	 * @return the size
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月12日 下午2:36:36
	 */
	public Integer getSize() {
		return this.size;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月12日 下午2:36:36
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * @return the queryStart
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月12日 上午11:16:19
	 */
	public Date getQueryStart() {
		return this.queryStart;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月12日 上午11:16:19
	 * @param queryStart the queryStart to set
	 */
	public void setQueryStart(Date queryStart) {
		this.queryStart = queryStart;
	}

	/**
	 * @return the queryEnd
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月12日 上午11:16:19
	 */
	public Date getQueryEnd() {
		return this.queryEnd;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月12日 上午11:16:19
	 * @param queryEnd the queryEnd to set
	 */
	public void setQueryEnd(Date queryEnd) {
		this.queryEnd = queryEnd;
	}

	/**
	 * @return the pmv
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月15日 上午10:00:10
	 */
	public PageMessageVo getPmv() {
		return this.pmv;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月15日 上午10:00:10
	 * @param pmv the pmv to set
	 */
	public void setPmv(PageMessageVo pmv) {
		this.pmv = pmv;
	}

	/**
	 * @return the recive_email
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年3月31日 下午4:12:40
	 */
	public String getRecive_email() {
		return this.recive_email;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年3月31日 下午4:12:40
	 * @param recive_email the recive_email to set
	 */
	public void setRecive_email(String recive_email) {
		this.recive_email = recive_email;
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
		return "NotificationsVo [queryStart=" + this.queryStart + ", queryEnd=" + this.queryEnd + ", start="
				+ this.start + ", size=" + this.size + ", pmv=" + this.pmv + ", recive_email=" + this.recive_email
				+ ", nid=" + this.nid + ", title=" + this.title + ", sync_code=" + this.sync_code + ", context="
				+ this.context + ", is_read=" + this.is_read + ", is_email=" + this.is_email + ", read_time="
				+ this.read_time + ", is_on=" + this.is_on + ", create_time=" + this.create_time + ", update_time="
				+ this.update_time + ", version=" + this.version + ", create_time_start=" + this.create_time_start
				+ ", create_time_end=" + this.create_time_end + "]";
	}

}
