package com.voole.trdpay.vo.paycode;

import java.io.Serializable;

/**
 * @ClassName: SpdRequestArgsVo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月8日 上午9:14:56
 * 
 */
public class SpdRequestArgsVo implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:39
	 */
	private static final long serialVersionUID = 9138796049217676507L;
	private String version = "2.1";// 版本号
	private String signType = "SHA256";// 签名方式
	private String charset = "utf-8";// 编码格式
	private String orderNum;// 订单号
	private String txndir;// 交易方向Q请求 A应答
	private String busicd = "PAUT";// 交易类型
	private String respcd;// 交易结果
	private String chcd;// 渠道
	private String terminalid;// 终端号
	private String txamt;// 订单金额
	private String currency = "CNY";// 交易币种
	private String goodsList = "[]";// 商品列表
	private String channelOrderNum;// 渠道交易号
	private String consumerAccount;// 用户账号
	private String consumerId;// 渠道账号 ID
	private String errorDetail;// 错误信息
	private String sign;// 签名
	private String outOrderNum;// 外部订单号
	private String transTime;// 交易时间
	private String subject;// 订单标题
	private String attach;// 附加信息
	private String qrcode;// 二维码信息
	private String backUrl;// 异步通知地址
	// 以下回调参数
	private String chcdDiscount;// 渠道优惠
	private String merDiscount;// 商户优惠
	private String bankType;// 银行标识用户银行标识
	// 一下退款参数
	private String origOrderNum;// 原订单号

	/**
	 * @return the version
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the signType
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getSignType() {
		return this.signType;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param signType the signType to set
	 */
	public void setSignType(String signType) {
		this.signType = signType;
	}

	/**
	 * @return the charset
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getCharset() {
		return this.charset;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param charset the charset to set
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}

	/**
	 * @return the orderNum
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getOrderNum() {
		return this.orderNum;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param orderNum the orderNum to set
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * @return the txndir
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getTxndir() {
		return this.txndir;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param txndir the txndir to set
	 */
	public void setTxndir(String txndir) {
		this.txndir = txndir;
	}

	/**
	 * @return the busicd
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getBusicd() {
		return this.busicd;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param busicd the busicd to set
	 */
	public void setBusicd(String busicd) {
		this.busicd = busicd;
	}

	/**
	 * @return the respcd
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getRespcd() {
		return this.respcd;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param respcd the respcd to set
	 */
	public void setRespcd(String respcd) {
		this.respcd = respcd;
	}

	/**
	 * @return the chcd
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getChcd() {
		return this.chcd;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param chcd the chcd to set
	 */
	public void setChcd(String chcd) {
		this.chcd = chcd;
	}

	/**
	 * @return the terminalid
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getTerminalid() {
		return this.terminalid;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param terminalid the terminalid to set
	 */
	public void setTerminalid(String terminalid) {
		this.terminalid = terminalid;
	}

	/**
	 * @return the txamt
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getTxamt() {
		return this.txamt;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param txamt the txamt to set
	 */
	public void setTxamt(String txamt) {
		this.txamt = txamt;
	}

	/**
	 * @return the currency
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the goodsList
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getGoodsList() {
		return this.goodsList;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param goodsList the goodsList to set
	 */
	public void setGoodsList(String goodsList) {
		this.goodsList = goodsList;
	}

	/**
	 * @return the channelOrderNum
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getChannelOrderNum() {
		return this.channelOrderNum;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param channelOrderNum the channelOrderNum to set
	 */
	public void setChannelOrderNum(String channelOrderNum) {
		this.channelOrderNum = channelOrderNum;
	}

	/**
	 * @return the consumerAccount
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getConsumerAccount() {
		return this.consumerAccount;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param consumerAccount the consumerAccount to set
	 */
	public void setConsumerAccount(String consumerAccount) {
		this.consumerAccount = consumerAccount;
	}

	/**
	 * @return the consumerId
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getConsumerId() {
		return this.consumerId;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param consumerId the consumerId to set
	 */
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	/**
	 * @return the errorDetail
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getErrorDetail() {
		return this.errorDetail;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param errorDetail the errorDetail to set
	 */
	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

	/**
	 * @return the sign
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getSign() {
		return this.sign;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param sign the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * @return the outOrderNum
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getOutOrderNum() {
		return this.outOrderNum;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param outOrderNum the outOrderNum to set
	 */
	public void setOutOrderNum(String outOrderNum) {
		this.outOrderNum = outOrderNum;
	}

	/**
	 * @return the transTime
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getTransTime() {
		return this.transTime;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param transTime the transTime to set
	 */
	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}

	/**
	 * @return the subject
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getSubject() {
		return this.subject;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the attach
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getAttach() {
		return this.attach;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param attach the attach to set
	 */
	public void setAttach(String attach) {
		this.attach = attach;
	}

	/**
	 * @return the qrcode
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getQrcode() {
		return this.qrcode;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param qrcode the qrcode to set
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	/**
	 * @return the backUrl
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 */
	public String getBackUrl() {
		return this.backUrl;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午9:29:23
	 * @param backUrl the backUrl to set
	 */
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

	/**
	 * @return the chcdDiscount
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:59:55
	 */
	public String getChcdDiscount() {
		return this.chcdDiscount;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:59:55
	 * @param chcdDiscount the chcdDiscount to set
	 */
	public void setChcdDiscount(String chcdDiscount) {
		this.chcdDiscount = chcdDiscount;
	}

	/**
	 * @return the merDiscount
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:59:55
	 */
	public String getMerDiscount() {
		return this.merDiscount;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:59:55
	 * @param merDiscount the merDiscount to set
	 */
	public void setMerDiscount(String merDiscount) {
		this.merDiscount = merDiscount;
	}

	/**
	 * @return the bankType
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:59:55
	 */
	public String getBankType() {
		return this.bankType;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午1:59:55
	 * @param bankType the bankType to set
	 */
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	/**
	 * @return the origOrderNum
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午2:48:00
	 */
	public String getOrigOrderNum() {
		return this.origOrderNum;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午2:48:00
	 * @param origOrderNum the origOrderNum to set
	 */
	public void setOrigOrderNum(String origOrderNum) {
		this.origOrderNum = origOrderNum;
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
		return "SpdRequestArgsVo [version=" + this.version + ", signType=" + this.signType + ", charset=" + this.charset
				+ ", orderNum=" + this.orderNum + ", txndir=" + this.txndir + ", busicd=" + this.busicd + ", respcd="
				+ this.respcd + ", chcd=" + this.chcd + ", terminalid=" + this.terminalid + ", txamt=" + this.txamt
				+ ", currency=" + this.currency + ", goodsList=" + this.goodsList + ", channelOrderNum="
				+ this.channelOrderNum + ", consumerAccount=" + this.consumerAccount + ", consumerId=" + this.consumerId
				+ ", errorDetail=" + this.errorDetail + ", sign=" + this.sign + ", outOrderNum=" + this.outOrderNum
				+ ", transTime=" + this.transTime + ", subject=" + this.subject + ", attach=" + this.attach
				+ ", qrcode=" + this.qrcode + ", backUrl=" + this.backUrl + ", chcdDiscount=" + this.chcdDiscount
				+ ", merDiscount=" + this.merDiscount + ", bankType=" + this.bankType + ", origOrderNum="
				+ this.origOrderNum + "]";
	}

}
