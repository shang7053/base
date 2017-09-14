package com.voole.trdpay.vo.order;

import java.io.Serializable;

/**
 * @ClassName: OrderRet
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月8日 下午1:27:00
 * 
 */
public class OrderRet implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午1:27:55
	 */
	private static final long serialVersionUID = -1889974717101688797L;
	private String orderNum;
	private String order_status;
	private String errorDetail;

	/**
	 * @return the orderNum
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午1:27:43
	 */
	public String getOrderNum() {
		return this.orderNum;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午1:27:43
	 * @param orderNum the orderNum to set
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * @return the order_status
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午1:27:43
	 */
	public String getOrder_status() {
		return this.order_status;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午1:27:43
	 * @param order_status the order_status to set
	 */
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	/**
	 * @return the errorDetail
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午1:27:43
	 */
	public String getErrorDetail() {
		return this.errorDetail;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午1:27:43
	 * @param errorDetail the errorDetail to set
	 */
	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
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
		return "OrderRet [orderNum=" + this.orderNum + ", order_status=" + this.order_status + ", errorDetail="
				+ this.errorDetail + "]";
	}
}
