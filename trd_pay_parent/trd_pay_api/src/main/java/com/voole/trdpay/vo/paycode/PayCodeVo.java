package com.voole.trdpay.vo.paycode;

import java.io.Serializable;

/**
 * @ClassName: PayCodeVo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月7日 下午5:33:50
 * 
 */
public class PayCodeVo implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月7日 下午5:37:47
	 */
	private static final long serialVersionUID = 3305598611229892651L;
	private String oemid;
	private String hid;
	private String uid;
	private String order_name;
	private String order_type;
	private String amt;
	private String chcd;

	/**
	 * @return the oemid
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午4:11:41
	 */
	public String getOemid() {
		return this.oemid;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午4:11:41
	 * @param oemid the oemid to set
	 */
	public void setOemid(String oemid) {
		this.oemid = oemid;
	}

	/**
	 * @return the hid
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午4:11:41
	 */
	public String getHid() {
		return this.hid;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午4:11:41
	 * @param hid the hid to set
	 */
	public void setHid(String hid) {
		this.hid = hid;
	}

	/**
	 * @return the uid
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午4:11:41
	 */
	public String getUid() {
		return this.uid;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午4:11:41
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the order_name
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午4:11:41
	 */
	public String getOrder_name() {
		return this.order_name;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午4:11:41
	 * @param order_name the order_name to set
	 */
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	/**
	 * @return the order_type
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午4:11:41
	 */
	public String getOrder_type() {
		return this.order_type;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午4:11:41
	 * @param order_type the order_type to set
	 */
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	/**
	 * @return the amt
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午4:11:41
	 */
	public String getAmt() {
		return this.amt;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午4:11:41
	 * @param amt the amt to set
	 */
	public void setAmt(String amt) {
		this.amt = amt;
	}

	/**
	 * @return the chcd
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午4:11:41
	 */
	public String getChcd() {
		return this.chcd;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午4:11:41
	 * @param chcd the chcd to set
	 */
	public void setChcd(String chcd) {
		this.chcd = chcd;
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
		return "PayCodeVo [oemid=" + this.oemid + ", hid=" + this.hid + ", uid=" + this.uid + ", order_name="
				+ this.order_name + ", order_type=" + this.order_type + ", amt=" + this.amt + ", chcd=" + this.chcd
				+ "]";
	}

}
