package com.voole.trdpay.entry.order;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.voole.trdpay.vo.PageMessageVo;

/**
 * @ClassName: Oerder
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月8日 上午11:09:35
 * 
 */
@Document(collection = "order")
public class OrderEntry implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午11:14:59
	 */
	private static final long serialVersionUID = 5389285057782164927L;
	@Id
	private String id;// '主键',
	private String oemid;// '设备编号',
	private String hid;// 'hid',
	private String uid;// 'uid',
	private String order_name;// '订单名称',
	private String order_type;// '订单类型0单点1套餐',
	private Long amt;// '金额',
	@Indexed
	private String orderNum;// '订单号',
	private String respcd;// '回调交易结果',
	private String channelOrderNum;// '渠道交易号',
	private String consumerAccount;// '用户账号',
	private String consumerId;// '渠道账号 ID',
	private String errorDetail;// '错误信息',
	private Date transTime;// '交易时间',
	private Date qr_transTime;// '交易时间',
	private Date aply_transTime;// '交易时间',
	private Date cancel_transTime;// '交易时间',
	private String qrcode;// '二维码信息',
	private String order_status;// '订单状态',
	private Date create_time;// '创建时间',
	private String chcdDiscount;// 渠道优惠
	private String merDiscount;// 商户优惠
	private String bankType;// 银行标识用户银行标识
	private String origOrderNum;// 原订单号
	private String chcd;// 支付渠道
	private String version;
	@Transient
	private PageMessageVo pmv;
	@Transient
	private Date queryStart;
	@Transient
	private Date queryEnd;

	/**
	 * @return the pmv
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 上午10:29:16
	 */
	public PageMessageVo getPmv() {
		return this.pmv;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 上午10:29:16
	 * @param pmv the pmv to set
	 */
	public void setPmv(PageMessageVo pmv) {
		this.pmv = pmv;
	}

	/**
	 * @return the id
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the oemid
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 */
	public String getOemid() {
		return this.oemid;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 * @param oemid the oemid to set
	 */
	public void setOemid(String oemid) {
		this.oemid = oemid;
	}

	/**
	 * @return the hid
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 */
	public String getHid() {
		return this.hid;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 * @param hid the hid to set
	 */
	public void setHid(String hid) {
		this.hid = hid;
	}

	/**
	 * @return the uid
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 */
	public String getUid() {
		return this.uid;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the order_name
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 */
	public String getOrder_name() {
		return this.order_name;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 * @param order_name the order_name to set
	 */
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	/**
	 * @return the amt
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 */
	public Long getAmt() {
		return this.amt;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 * @param amt the amt to set
	 */
	public void setAmt(Long amt) {
		this.amt = amt;
	}

	/**
	 * @return the orderNum
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 */
	public String getOrderNum() {
		return this.orderNum;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 * @param orderNum the orderNum to set
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * @return the respcd
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:47:41
	 */
	public String getRespcd() {
		return this.respcd;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:47:41
	 * @param respcd the respcd to set
	 */
	public void setRespcd(String respcd) {
		this.respcd = respcd;
	}

	/**
	 * @return the channelOrderNum
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:47:41
	 */
	public String getChannelOrderNum() {
		return this.channelOrderNum;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:47:41
	 * @param channelOrderNum the channelOrderNum to set
	 */
	public void setChannelOrderNum(String channelOrderNum) {
		this.channelOrderNum = channelOrderNum;
	}

	/**
	 * @return the consumerAccount
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:47:41
	 */
	public String getConsumerAccount() {
		return this.consumerAccount;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:47:41
	 * @param consumerAccount the consumerAccount to set
	 */
	public void setConsumerAccount(String consumerAccount) {
		this.consumerAccount = consumerAccount;
	}

	/**
	 * @return the consumerId
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:47:41
	 */
	public String getConsumerId() {
		return this.consumerId;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:47:41
	 * @param consumerId the consumerId to set
	 */
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	/**
	 * @return the errorDetail
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:47:41
	 */
	public String getErrorDetail() {
		return this.errorDetail;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:47:41
	 * @param errorDetail the errorDetail to set
	 */
	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

	/**
	 * @return the transTime
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:47:41
	 */
	public Date getTransTime() {
		return this.transTime;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:47:41
	 * @param transTime the transTime to set
	 */
	public void setTransTime(Date transTime) {
		this.transTime = transTime;
	}

	/**
	 * @return the qrcode
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:47:41
	 */
	public String getQrcode() {
		return this.qrcode;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:47:41
	 * @param qrcode the qrcode to set
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	/**
	 * @return the order_status
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 */
	public String getOrder_status() {
		return this.order_status;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 * @param order_status the order_status to set
	 */
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	/**
	 * @return the create_time
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 */
	public Date getCreate_time() {
		return this.create_time;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:43:50
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * @return the order_type
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:56:34
	 */
	public String getOrder_type() {
		return this.order_type;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午5:56:34
	 * @param order_type the order_type to set
	 */
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	/**
	 * @return the qr_transTime
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:38:07
	 */
	public Date getQr_transTime() {
		return this.qr_transTime;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:38:07
	 * @param qr_transTime the qr_transTime to set
	 */
	public void setQr_transTime(Date qr_transTime) {
		this.qr_transTime = qr_transTime;
	}

	/**
	 * @return the aply_transTime
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:38:07
	 */
	public Date getAply_transTime() {
		return this.aply_transTime;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:38:07
	 * @param aply_transTime the aply_transTime to set
	 */
	public void setAply_transTime(Date aply_transTime) {
		this.aply_transTime = aply_transTime;
	}

	/**
	 * @return the cancel_transTime
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:38:07
	 */
	public Date getCancel_transTime() {
		return this.cancel_transTime;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:38:07
	 * @param cancel_transTime the cancel_transTime to set
	 */
	public void setCancel_transTime(Date cancel_transTime) {
		this.cancel_transTime = cancel_transTime;
	}

	/**
	 * @return the chcdDiscount
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:59:33
	 */
	public String getChcdDiscount() {
		return this.chcdDiscount;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:59:33
	 * @param chcdDiscount the chcdDiscount to set
	 */
	public void setChcdDiscount(String chcdDiscount) {
		this.chcdDiscount = chcdDiscount;
	}

	/**
	 * @return the merDiscount
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:59:33
	 */
	public String getMerDiscount() {
		return this.merDiscount;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:59:33
	 * @param merDiscount the merDiscount to set
	 */
	public void setMerDiscount(String merDiscount) {
		this.merDiscount = merDiscount;
	}

	/**
	 * @return the bankType
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:59:33
	 */
	public String getBankType() {
		return this.bankType;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:59:33
	 * @param bankType the bankType to set
	 */
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	/**
	 * @return the origOrderNum
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午3:57:57
	 */
	public String getOrigOrderNum() {
		return this.origOrderNum;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午3:57:57
	 * @param origOrderNum the origOrderNum to set
	 */
	public void setOrigOrderNum(String origOrderNum) {
		this.origOrderNum = origOrderNum;
	}

	/**
	 * @return the chcd
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 下午1:23:07
	 */
	public String getChcd() {
		return this.chcd;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 下午1:23:07
	 * @param chcd the chcd to set
	 */
	public void setChcd(String chcd) {
		this.chcd = chcd;
	}

	/**
	 * @return the queryStart
	 * @author shangchengcai@voole.com
	 * @date 2017年9月13日 上午9:43:15
	 */
	public Date getQueryStart() {
		return this.queryStart;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月13日 上午9:43:15
	 * @param queryStart the queryStart to set
	 */
	public void setQueryStart(Date queryStart) {
		this.queryStart = queryStart;
	}

	/**
	 * @return the queryEnd
	 * @author shangchengcai@voole.com
	 * @date 2017年9月13日 上午9:43:15
	 */
	public Date getQueryEnd() {
		return this.queryEnd;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月13日 上午9:43:15
	 * @param queryEnd the queryEnd to set
	 */
	public void setQueryEnd(Date queryEnd) {
		this.queryEnd = queryEnd;
	}

	/**
	 * @return the version
	 * @author shangchengcai@voole.com
	 * @date 2017年9月13日 上午10:35:24
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月13日 上午10:35:24
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
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
		return "OrderEntry [id=" + this.id + ", oemid=" + this.oemid + ", hid=" + this.hid + ", uid=" + this.uid
				+ ", order_name=" + this.order_name + ", order_type=" + this.order_type + ", amt=" + this.amt
				+ ", orderNum=" + this.orderNum + ", respcd=" + this.respcd + ", channelOrderNum="
				+ this.channelOrderNum + ", consumerAccount=" + this.consumerAccount + ", consumerId=" + this.consumerId
				+ ", errorDetail=" + this.errorDetail + ", transTime=" + this.transTime + ", qr_transTime="
				+ this.qr_transTime + ", aply_transTime=" + this.aply_transTime + ", cancel_transTime="
				+ this.cancel_transTime + ", qrcode=" + this.qrcode + ", order_status=" + this.order_status
				+ ", create_time=" + this.create_time + ", chcdDiscount=" + this.chcdDiscount + ", merDiscount="
				+ this.merDiscount + ", bankType=" + this.bankType + ", origOrderNum=" + this.origOrderNum + ", chcd="
				+ this.chcd + ", version=" + this.version + ", pmv=" + this.pmv + ", queryStart=" + this.queryStart
				+ ", queryEnd=" + this.queryEnd + "]";
	}

}
