package com.voole.trdpay.vo.home;

import java.io.Serializable;

/**
 * @ClassName: HomeVo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月12日 下午3:32:08
 * 
 */
public class HomeVo implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 下午3:33:14
	 */
	private static final long serialVersionUID = -2812710744677347223L;
	private String x;
	private Double total;
	private Double receipt;

	/**
	 * @return the x
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 下午3:33:01
	 */
	public String getX() {
		return this.x;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 下午3:33:01
	 * @param x the x to set
	 */
	public void setX(String x) {
		this.x = x;
	}

	/**
	 * @return the total
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 下午3:33:01
	 */
	public Double getTotal() {
		return this.total;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 下午3:33:01
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	/**
	 * @return the receipt
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 下午3:33:01
	 */
	public Double getReceipt() {
		return this.receipt;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 下午3:33:01
	 * @param receipt the receipt to set
	 */
	public void setReceipt(Double receipt) {
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
		return "HomeVo [x=" + this.x + ", total=" + this.total + ", receipt=" + this.receipt + "]";
	}

}
