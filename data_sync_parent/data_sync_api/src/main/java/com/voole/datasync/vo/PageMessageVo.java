package com.voole.datasync.vo;

import java.io.Serializable;

/**
 * @ClassName: PageMessageVo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月14日 上午11:44:13
 * 
 */
public class PageMessageVo implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月25日 下午4:50:14
	 */
	private static final long serialVersionUID = -925765116060112847L;
	private String sEcho;
	private Integer iTotalRecords;
	private Integer iTotalDisplayRecords;
	private Integer iDisplayLength;
	private Integer iDisplayStart;
	private Object aaData;

	/**
	 * @return the sEcho
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午1:57:41
	 */
	public String getsEcho() {
		return this.sEcho;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午1:57:41
	 * @param sEcho the sEcho to set
	 */
	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	/**
	 * @return the iTotalRecords
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午1:57:41
	 */
	public Integer getiTotalRecords() {
		return this.iTotalRecords;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午1:57:41
	 * @param iTotalRecords the iTotalRecords to set
	 */
	public void setiTotalRecords(Integer iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	/**
	 * @return the iTotalDisplayRecords
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午1:57:41
	 */
	public Integer getiTotalDisplayRecords() {
		return this.iTotalDisplayRecords;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午1:57:41
	 * @param iTotalDisplayRecords the iTotalDisplayRecords to set
	 */
	public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	/**
	 * @return the iDisplayLength
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午1:57:41
	 */
	public Integer getiDisplayLength() {
		return this.iDisplayLength;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午1:57:41
	 * @param iDisplayLength the iDisplayLength to set
	 */
	public void setiDisplayLength(Integer iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	/**
	 * @return the iDisplayStart
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午1:57:41
	 */
	public Integer getiDisplayStart() {
		return this.iDisplayStart;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午1:57:41
	 * @param iDisplayStart the iDisplayStart to set
	 */
	public void setiDisplayStart(Integer iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	/**
	 * @return the aaData
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午1:57:41
	 */
	public Object getAaData() {
		return this.aaData;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午1:57:41
	 * @param aaData the aaData to set
	 */
	public void setAaData(Object aaData) {
		this.aaData = aaData;
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
		return "PageMessageVo [sEcho=" + this.sEcho + ", iTotalRecords=" + this.iTotalRecords
				+ ", iTotalDisplayRecords=" + this.iTotalDisplayRecords + ", iDisplayLength=" + this.iDisplayLength
				+ ", iDisplayStart=" + this.iDisplayStart + ", aaData=" + this.aaData + "]";
	}

}
