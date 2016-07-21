package com.voole.cdcenter.vo.system.notice;

import java.io.Serializable;
import java.util.Date;

import com.voole.cdcenter.entry.sytem.notice.NotificationsEntry;
import com.voole.cdcenter.vo.PageMessageVo;

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
				+ this.start + ", size=" + this.size + ", pmv=" + this.pmv + ", nid=" + this.nid + ", title="
				+ this.title + ", context=" + this.context + ", is_read=" + this.is_read + ", create_time="
				+ this.create_time + ", read_time=" + this.read_time + ", version=" + this.version + "]";
	}

}
