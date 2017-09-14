package com.voole.trdpay.service.order.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.ParseException;
import com.alibaba.dubbo.config.annotation.Service;
import com.voole.trdpay.conf.SystemConf;
import com.voole.trdpay.dao.order.IOrderDao;
import com.voole.trdpay.entry.order.OrderEntry;
import com.voole.trdpay.service.order.IOrderService;
import com.voole.trdpay.util.AssertUtils;
import com.voole.trdpay.util.AsyncExecutorService;
import com.voole.trdpay.util.OrderNoUtil;
import com.voole.trdpay.util.SPDRequestUtil;
import com.voole.trdpay.util.httputil.IRestClient;
import com.voole.trdpay.util.httputil.RestClientFactory;
import com.voole.trdpay.vo.order.OrderRet;
import com.voole.trdpay.vo.paycode.PayCodeRet;
import com.voole.trdpay.vo.paycode.PayCodeVo;
import com.voole.trdpay.vo.paycode.SpdRequestArgsVo;

/**
 * @ClassName: OrderServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月8日 上午10:20:14
 * 
 */
@Service(timeout = 1200000)
public class OrderServiceImpl implements IOrderService {
	private static final IRestClient RESTCLIENT = RestClientFactory.instance();
	private static final Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);
	@Resource
	private IOrderDao orderDao;
	@Resource
	private SystemConf systemConf;
	@Resource
	private AsyncExecutorService asyncExecutorService;

	/*
	 * (非 Javadoc) <p>Title: log2DB</p> <p>Description: </p>
	 * 
	 * @param payCode
	 * 
	 * @param spdRequestArgsVo
	 * 
	 * @return
	 * 
	 * @see com.voole.trdpay.service.paycode.IOrderService#log2DB(com.voole.trdpay.vo.paycode.PayCodeVo,
	 * com.voole.trdpay.vo.paycode.SpdRequestArgsVo)
	 */
	@Override
	public Boolean log2DB(PayCodeVo payCode, SpdRequestArgsVo spdRequestArgsVo) {
		try {
			OrderEntry oe = new OrderEntry();
			BeanUtils.copyProperties(payCode, oe);
			BeanUtils.copyProperties(spdRequestArgsVo, oe);
			oe.setCreate_time(new Date());
			oe.setOrder_status("0");
			oe.setAmt(Long.valueOf(payCode.getAmt()));
			oe.setTransTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(spdRequestArgsVo.getTransTime()));
			oe.setQr_transTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(spdRequestArgsVo.getTransTime()));
			this.orderDao.insert(oe);
		} catch (Exception e) {
			LOGGER.error(e);
			return false;
		}
		return true;
	}

	/*
	 * (非 Javadoc) <p>Title: findByOrderNum</p> <p>Description: </p>
	 * 
	 * @param orderNum
	 * 
	 * @return
	 * 
	 * @see com.voole.trdpay.service.order.IOrderService#findByOrderNum(java.lang.String)
	 */
	@Override
	public OrderEntry findByOrderNum(String orderNum) {
		return this.orderDao.findByOrderNum(orderNum);
	}

	/*
	 * (非 Javadoc) <p>Title: successOrder</p> <p>Description: </p>
	 * 
	 * @param data
	 * 
	 * @see com.voole.trdpay.service.order.IOrderService#successOrder(com.voole.trdpay.vo.paycode.SpdRequestArgsVo)
	 */
	@Override
	public void successOrder(SpdRequestArgsVo data) {
		try {
			LOGGER.debug("query data from db.orderNum:" + data.getOrderNum());
			OrderEntry oe = this.findByOrderNum(data.getOrderNum());
			LOGGER.debug("query sucess,data:" + data);
			if (null == oe) {
				LOGGER.debug("no data in db, will new a data:");
				oe = new OrderEntry();
			}
			BeanUtils.copyProperties(data, oe);
			oe.setTransTime(new Date());
			oe.setAply_transTime(new Date());
			oe.setOrder_status("1");
			oe.setErrorDetail(data.getErrorDetail());
			this.orderDao.updateOrInsertForAply(oe);
		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	/*
	 * (非 Javadoc) <p>Title: cancel</p> <p>Description: </p>
	 * 
	 * @param spdRequestArgsVo
	 * 
	 * @see com.voole.trdpay.service.order.IOrderService#cancel(com.voole.trdpay.vo.paycode.SpdRequestArgsVo)
	 */
	@Override
	public void cancel(SpdRequestArgsVo spdRequestArgsVo) {
		try {
			LOGGER.debug("query data from db.orderNum:" + spdRequestArgsVo.getOrderNum());
			OrderEntry oe = this.findByOrderNum(spdRequestArgsVo.getOrderNum());
			LOGGER.debug("query sucess,data:" + spdRequestArgsVo);
			if (null == oe) {
				LOGGER.debug("no data in db, will new a data:");
				oe = new OrderEntry();
			}
			// BeanUtils.copyProperties(spdRequestArgsVo, oe);
			oe.setCancel_transTime(new Date());
			oe.setTransTime(new Date());
			if ("00".equals(spdRequestArgsVo.getRespcd())) {
				oe.setOrder_status("2");
			} else {
				oe.setOrder_status("3");
			}
			oe.setRespcd(spdRequestArgsVo.getRespcd());
			oe.setOrigOrderNum(spdRequestArgsVo.getOrigOrderNum());
			oe.setOrderNum(spdRequestArgsVo.getOrderNum());
			oe.setErrorDetail(spdRequestArgsVo.getErrorDetail());
			this.orderDao.updateOrInsertForCancel(oe);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	/*
	 * (非 Javadoc) <p>Title: queryOrder</p> <p>Description: </p>
	 * 
	 * @param orderVo
	 * 
	 * @return
	 * 
	 * @see com.voole.trdpay.service.order.IOrderService#queryOrder(com.voole.trdpay.vo.order.OrderVo)
	 */
	@Override
	public List<OrderEntry> queryOrder(OrderEntry orderEntry) {
		return this.orderDao.queryOrder(orderEntry);
	}

	/*
	 * (非 Javadoc) <p>Title: queryOrderCount</p> <p>Description: </p>
	 * 
	 * @param orderVo
	 * 
	 * @return
	 * 
	 * @see com.voole.trdpay.service.order.IOrderService#queryOrderCount(com.voole.trdpay.vo.order.OrderVo)
	 */
	@Override
	public Long queryOrderCount(OrderEntry orderEntry) {
		return this.orderDao.queryOrderCount(orderEntry);
	}

	/*
	 * (非 Javadoc) <p>Title: cancelOrder</p> <p>Description: </p>
	 * 
	 * @see com.voole.trdpay.service.order.IOrderService#cancelOrder()
	 */
	@Override
	public OrderRet cancelOrder(OrderEntry order, OrderRet ret) throws Exception {
		try {
			LOGGER.debug("conllect args for spd");
			SpdRequestArgsVo spdRequestArgsVo = new SpdRequestArgsVo();
			spdRequestArgsVo.setOrderNum(OrderNoUtil.getOrderNo(order.getHid(), order.getOemid()));
			spdRequestArgsVo.setOrigOrderNum(order.getOrderNum());
			spdRequestArgsVo.setTxndir("Q");
			spdRequestArgsVo.setBusicd("REFD");
			spdRequestArgsVo
					.setTerminalid(this.systemConf.getTerminalidPrefix() + order.getOemid().toString().substring(0, 4));
			spdRequestArgsVo.setTxamt(SPDRequestUtil.getAmt(order.getAmt().toString()));
			Map<String, String> args = SPDRequestUtil.beanToMap(spdRequestArgsVo);
			args.put("inscd", this.systemConf.getInscd());
			args.put("mchntid", this.systemConf.getMchntid());
			String sign = SPDRequestUtil.getSign(args, this.systemConf.getSignkey());
			args.put("sign", sign);
			LOGGER.info("post SPD BANK!url=" + this.systemConf.getUrl() + ",timeout=" + this.systemConf.getTimeout()
					+ ",args=" + args);
			String spdret = RESTCLIENT.post(this.systemConf.getUrl(), args, this.systemConf.getTimeout());
			LOGGER.info("spd ret=" + spdret);
			AssertUtils.notNull(spdret, "未获取到相应结果!");
			Map<String, String> spdretmap = JSON.parse(spdret, Map.class);
			LOGGER.debug("conver spd ret to map,map=" + spdretmap);
			LOGGER.debug("now validate ret!");
			if (SPDRequestUtil.validateSpdRet(spdretmap, this.systemConf.getSignkey())) {
				LOGGER.info("ret validate success!");
				spdRequestArgsVo.setRespcd(spdretmap.get("respcd"));
				spdRequestArgsVo.setChannelOrderNum(spdretmap.get("channelOrderNum"));
				spdRequestArgsVo.setConsumerAccount(spdretmap.get("consumerAccount"));
				spdRequestArgsVo.setConsumerId(spdretmap.get("consumerId"));
				spdRequestArgsVo.setErrorDetail(spdretmap.get("errorDetail"));
				spdRequestArgsVo.setTransTime(spdretmap.get("transTime"));
				spdRequestArgsVo.setQrcode(spdretmap.get("qrcode"));
				LOGGER.info("async record to db");
				if ("00".equals(spdretmap.get("respcd"))) {
					ret.setOrder_status("0");
					this.asyncExecutorService.execute(() -> {
						LOGGER.debug("async record to db start");
						this.cancel(spdRequestArgsVo);
						LOGGER.debug("async record to db end");
					});
				} else {
					ret.setOrder_status("1");
				}
				ret.setErrorDetail(spdretmap.get("errorDetail"));
				LOGGER.info("final ret=" + ret);
			} else {
				LOGGER.info("ret validate faild!");
			}
		} catch (ParseException e) {
			throw e;
		}
		return ret;
	}

	/*
	 * (非 Javadoc) <p>Title: cb</p> <p>Description: </p>
	 * 
	 * @param data
	 * 
	 * @see com.voole.trdpay.service.order.IOrderService#cb(com.voole.trdpay.vo.paycode.SpdRequestArgsVo)
	 */
	@Override
	public void cb(SpdRequestArgsVo data, Map<String, String> cbtmap) throws Exception {
		try {
			LOGGER.debug("now validate ret!");
			if (SPDRequestUtil.validateSpdRet(cbtmap, this.systemConf.getSignkey())) {
				this.asyncExecutorService.execute(() -> {
					LOGGER.debug("async record to db start");
					this.successOrder(data);
					LOGGER.debug("async record to db end");
				});
			} else {
				LOGGER.info("args validate faild!");
			}
		} catch (Exception e) {
			throw e;
		}

	}

	/*
	 * (非 Javadoc) <p>Title: gengerQrCode</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see com.voole.trdpay.service.order.IOrderService#gengerQrCode()
	 */
	@Override
	public PayCodeRet gengerQrCode(PayCodeRet ret, PayCodeVo payCode) throws Exception {
		try {
			SpdRequestArgsVo spdRequestArgsVo = new SpdRequestArgsVo();
			spdRequestArgsVo.setOrderNum(OrderNoUtil.getOrderNo(payCode.getHid(), payCode.getOemid()));
			spdRequestArgsVo.setTxndir("Q");
			spdRequestArgsVo.setChcd(payCode.getChcd());
			spdRequestArgsVo.setTerminalid(
					this.systemConf.getTerminalidPrefix() + payCode.getOemid().toString().substring(0, 4));
			spdRequestArgsVo.setTxamt(SPDRequestUtil.getAmt(payCode.getAmt().toString()));
			spdRequestArgsVo.setSubject(payCode.getOrder_name());
			spdRequestArgsVo.setBackUrl(this.systemConf.getBackUrl());
			Map<String, String> args = SPDRequestUtil.beanToMap(spdRequestArgsVo);
			args.put("inscd", this.systemConf.getInscd());
			args.put("mchntid", this.systemConf.getMchntid());

			String sign = SPDRequestUtil.getSign(args, this.systemConf.getSignkey());
			args.put("sign", sign);
			LOGGER.info("post SPD BANK!url=" + this.systemConf.getUrl() + ",timeout=" + this.systemConf.getTimeout()
					+ ",args=" + args);
			String spdret = RESTCLIENT.post(this.systemConf.getUrl(), args, this.systemConf.getTimeout());
			LOGGER.info("spd ret=" + spdret);
			AssertUtils.notNull(spdret, "未获取到相应结果!");
			Map<String, String> spdretmap = JSON.parse(spdret, Map.class);
			LOGGER.debug("conver spd ret to map,map=" + spdretmap);
			LOGGER.debug("now validate ret!");
			if (SPDRequestUtil.validateSpdRet(spdretmap, this.systemConf.getSignkey())) {
				LOGGER.info("ret validate success!");
				String qrcode = spdretmap.get("qrcode");
				if (StringUtils.isNotBlank(qrcode)) {
					ret.setPayurl(qrcode);
				} else {
					ret.setPayurl("");
				}
				ret.setStatus(0);
				ret.setDesc(spdretmap.get("errorDetail"));
				ret.setOrderNum(spdretmap.get("orderNum"));
				spdRequestArgsVo.setRespcd(spdretmap.get("respcd"));
				spdRequestArgsVo.setChannelOrderNum(spdretmap.get("channelOrderNum"));
				spdRequestArgsVo.setConsumerAccount(spdretmap.get("consumerAccount"));
				spdRequestArgsVo.setConsumerId(spdretmap.get("consumerId"));
				spdRequestArgsVo.setErrorDetail(spdretmap.get("errorDetail"));
				spdRequestArgsVo.setTransTime(spdretmap.get("transTime"));
				spdRequestArgsVo.setQrcode(spdretmap.get("qrcode"));
				LOGGER.info("final ret=" + ret);
				LOGGER.info("async record to db");
				this.asyncExecutorService.execute(() -> {
					LOGGER.debug("async record to db start");
					this.log2DB(payCode, spdRequestArgsVo);
					LOGGER.debug("async record to db end");
				});
			} else {
				LOGGER.info("ret validate faild!");
				ret.setDesc("验签失败");
			}
		} catch (ParseException e) {
			throw e;
		}
		return ret;
	}

	/*
	 * (非 Javadoc) <p>Title: getTodayReceipt</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see com.voole.trdpay.service.order.IOrderService#getTodayReceipt()
	 */
	@Override
	public Double getTodayReceipt(boolean istoday) {
		return this.orderDao.getTodayReceipt(istoday);
	}

	/*
	 * (非 Javadoc) <p>Title: getTodayTotal</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see com.voole.trdpay.service.order.IOrderService#getTodayTotal()
	 */
	@Override
	public Double getTodayTotal(boolean istoday) {
		return this.orderDao.getTodayTotal(istoday);
	}

}
