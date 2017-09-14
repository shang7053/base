package com.voole.trdpay.vo.paycode;

import java.io.Serializable;

/**
 * @ClassName: PayCodeRet
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月7日 下午5:39:39
 * 
 */
public class PayCodeRet implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月7日 下午5:40:07
	 */
	private static final long serialVersionUID = 5901907025470240872L;
	private String payurl;
	private Integer status;
	private String orderNum;
	private String desc;

	/**
	 * @return the status
	 * @author shangchengcai@voole.com
	 * @date 2017年9月7日 下午5:40:31
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月7日 下午5:40:31
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the payurl
	 * @author shangchengcai@voole.com
	 * @date 2017年9月7日 下午5:40:00
	 */
	public String getPayurl() {
		return this.payurl;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月7日 下午5:40:00
	 * @param payurl the payurl to set
	 */
	public void setPayurl(String payurl) {
		this.payurl = payurl;
	}

	/**
	 * @return the orderNum
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午10:24:28
	 */
	public String getOrderNum() {
		return this.orderNum;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午10:24:28
	 * @param orderNum the orderNum to set
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * @return the desc
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午2:58:32
	 */
	public String getDesc() {
		return this.desc;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午2:58:32
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
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
		return "PayCodeRet [payurl=" + this.payurl + ", status=" + this.status + ", orderNum=" + this.orderNum
				+ ", desc=" + this.desc + "]";
	}

}
