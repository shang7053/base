package com.voole.trdpay.vo;

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
	private Long iTotalRecords;
	private Long iTotalDisplayRecords;
	private Long iDisplayLength;
	private Long iDisplayStart;
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
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 上午11:29:38
	 */
	public Long getiTotalRecords() {
		return this.iTotalRecords;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 上午11:29:38
	 * @param iTotalRecords the iTotalRecords to set
	 */
	public void setiTotalRecords(Long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	/**
	 * @return the iTotalDisplayRecords
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 上午11:29:38
	 */
	public Long getiTotalDisplayRecords() {
		return this.iTotalDisplayRecords;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 上午11:29:38
	 * @param iTotalDisplayRecords the iTotalDisplayRecords to set
	 */
	public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	/**
	 * @return the iDisplayLength
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 上午11:29:38
	 */
	public Long getiDisplayLength() {
		return this.iDisplayLength;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 上午11:29:38
	 * @param iDisplayLength the iDisplayLength to set
	 */
	public void setiDisplayLength(Long iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	/**
	 * @return the iDisplayStart
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 上午11:29:38
	 */
	public Long getiDisplayStart() {
		return this.iDisplayStart;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 上午11:29:38
	 * @param iDisplayStart the iDisplayStart to set
	 */
	public void setiDisplayStart(Long iDisplayStart) {
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
