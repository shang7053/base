package com.voole.cdcenter.vo.system.log;

import java.io.Serializable;
import java.util.Date;

import com.voole.cdcenter.entry.sytem.log.SystemLogEntry;
import com.voole.cdcenter.vo.PageMessageVo;

/**
 * @ClassName: SysytemLog
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:01:57
 * 
 */
public class SysytemLogVo extends SystemLogEntry implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月21日 上午9:34:31
	 */
	private static final long serialVersionUID = -5948875843808992772L;
	private PageMessageVo pmv;
	private String username;
	private String realname;
	private String tel;
	private Date queryStart;
	private Date queryEnd;

	/**
	 * @return the pmv
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月21日 上午9:34:26
	 */
	public PageMessageVo getPmv() {
		return this.pmv;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月21日 上午9:34:26
	 * @param pmv the pmv to set
	 */
	public void setPmv(PageMessageVo pmv) {
		this.pmv = pmv;
	}

	/**
	 * @return the queryStart
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月21日 上午9:40:36
	 */
	public Date getQueryStart() {
		return this.queryStart;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月21日 上午9:40:36
	 * @param queryStart the queryStart to set
	 */
	public void setQueryStart(Date queryStart) {
		this.queryStart = queryStart;
	}

	/**
	 * @return the queryEnd
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月21日 上午9:40:36
	 */
	public Date getQueryEnd() {
		return this.queryEnd;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月21日 上午9:40:36
	 * @param queryEnd the queryEnd to set
	 */
	public void setQueryEnd(Date queryEnd) {
		this.queryEnd = queryEnd;
	}

	/**
	 * @return the username
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月21日 上午10:17:16
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月21日 上午10:17:16
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the realname
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月21日 上午10:10:14
	 */
	public String getRealname() {
		return this.realname;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月21日 上午10:10:14
	 * @param realname the realname to set
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}

	/**
	 * @return the tel
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月21日 上午10:10:14
	 */
	public String getTel() {
		return this.tel;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月21日 上午10:10:14
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
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
		return "SysytemLogVo [pmv=" + this.pmv + ", username=" + this.username + ", realname=" + this.realname
				+ ", tel=" + this.tel + ", queryStart=" + this.queryStart + ", queryEnd=" + this.queryEnd + ", lid="
				+ this.lid + ", uid=" + this.uid + ", url=" + this.url + ", param=" + this.param + ", create_time="
				+ this.create_time + "]";
	}
}
