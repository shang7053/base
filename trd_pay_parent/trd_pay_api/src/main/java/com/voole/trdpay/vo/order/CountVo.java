package com.voole.trdpay.vo.order;

import java.io.Serializable;

/**
 * @ClassName: HomeVo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月12日 下午3:32:08
 * 
 */
public class CountVo implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 下午3:33:14
	 */
	private static final long serialVersionUID = -2812710744677347223L;
	private Long total;
	private Long receipt;

	/**
	 * @return the total
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 下午4:05:34
	 */
	public Long getTotal() {
		return this.total;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 下午4:05:34
	 * @param total the total to set
	 */
	public void setTotal(Long total) {
		this.total = total;
	}

	/**
	 * @return the receipt
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 下午4:05:34
	 */
	public Long getReceipt() {
		return this.receipt;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 下午4:05:34
	 * @param receipt the receipt to set
	 */
	public void setReceipt(Long receipt) {
		this.receipt = receipt;
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
		return "CountVo [total=" + this.total + ", receipt=" + this.receipt + "]";
	}

}
