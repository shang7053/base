package com.voole.trdpay.vo;

import java.io.Serializable;

/**
 * @ClassName: AjaxRet
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 上午10:34:26
 * 
 */
public class AjaxRet implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 上午10:34:56
	 */
	private static final long serialVersionUID = 4948774707933061421L;
	private boolean status;
	private String info;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 上午10:35:01
	 */
	public AjaxRet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the status
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 上午10:35:06
	 */
	public boolean isStatus() {
		return this.status;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 上午10:35:06
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the info
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 上午10:35:06
	 */
	public String getInfo() {
		return this.info;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 上午10:35:06
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
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
		return "AjaxRet [status=" + this.status + ", info=" + this.info + "]";
	}

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 上午10:35:12
	 * @param status
	 * @param info
	 */
	public AjaxRet(boolean status, String info) {
		super();
		this.status = status;
		this.info = info;
	}
}
