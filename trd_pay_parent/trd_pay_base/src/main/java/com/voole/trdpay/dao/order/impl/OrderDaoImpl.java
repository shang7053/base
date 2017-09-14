package com.voole.trdpay.dao.order.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;
import com.voole.trdpay.dao.order.IOrderDao;
import com.voole.trdpay.entry.order.OrderEntry;
import com.voole.trdpay.vo.order.CountVo;

/**
 * @ClassName: OrderDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月8日 下午1:14:24
 * 
 */
@Repository
public class OrderDaoImpl implements IOrderDao {
	private static final Logger LOGGER = Logger.getLogger(OrderDaoImpl.class);
	@Resource
	private MongoTemplate mongoTemplate;

	/*
	 * (非 Javadoc) <p>Title: insert</p> <p>Description: </p>
	 * 
	 * @param oe
	 * 
	 * @see com.voole.trdpay.dao.order.IOrderDao#insert(com.voole.trdpay.entry.order.OrderEntry)
	 */
	@Override
	public void insert(OrderEntry oe) {
		this.mongoTemplate.insert(oe);
	}

	/*
	 * (非 Javadoc) <p>Title: findByOrderNum</p> <p>Description: </p>
	 * 
	 * @param orderNum
	 * 
	 * @return
	 * 
	 * @see com.voole.trdpay.dao.order.IOrderDao#findByOrderNum(java.lang.String)
	 */
	@Override
	public OrderEntry findByOrderNum(String orderNum) {
		Query query = new Query();
		query.addCriteria(Criteria.where("orderNum").is(orderNum));
		return this.mongoTemplate.findOne(query, OrderEntry.class);
	}

	/*
	 * (非 Javadoc) <p>Title: updateOrInsert</p> <p>Description: </p>
	 * 
	 * @param oe
	 * 
	 * @see com.voole.trdpay.dao.order.IOrderDao#updateOrInsert(com.voole.trdpay.entry.order.OrderEntry)
	 */
	@Override
	public void updateOrInsertForAply(OrderEntry oe) {
		Query query = new Query();
		query.addCriteria(Criteria.where("orderNum").is(oe.getOrderNum()));
		Update update = new Update();
		update.set("chcdDiscount", oe.getChcdDiscount());
		update.set("merDiscount", oe.getMerDiscount());
		update.set("bankType", oe.getBankType());
		update.set("channelOrderNum", oe.getChannelOrderNum());
		update.set("consumerAccount", oe.getConsumerAccount());
		update.set("aply_transTime", oe.getAply_transTime());
		update.set("transTime", oe.getTransTime());
		update.set("order_status", oe.getOrder_status());
		update.set("respcd", oe.getRespcd());
		update.set("errorDetail", oe.getErrorDetail());
		this.mongoTemplate.upsert(query, update, oe.getClass());
	}

	/*
	 * (非 Javadoc) <p>Title: updateOrInsertForCancel</p> <p>Description: </p>
	 * 
	 * @param oe
	 * 
	 * @see com.voole.trdpay.dao.order.IOrderDao#updateOrInsertForCancel(com.voole.trdpay.entry.order.OrderEntry)
	 */
	@Override
	public void updateOrInsertForCancel(OrderEntry oe) {
		Query query = new Query();
		query.addCriteria(Criteria.where("orderNum").is(oe.getOrigOrderNum()));
		Update update = new Update();
		update.set("order_status", oe.getOrder_status());
		update.set("errorDetail", oe.getErrorDetail());
		update.set("orderNum", oe.getOrderNum());
		update.set("origOrderNum", oe.getOrigOrderNum());
		update.set("respcd", oe.getRespcd());
		update.set("cancel_transTime", oe.getCancel_transTime());
		this.mongoTemplate.upsert(query, update, oe.getClass());
	}

	/*
	 * (非 Javadoc) <p>Title: queryOrder</p> <p>Description: </p>
	 * 
	 * @param orderVo
	 * 
	 * @return
	 * 
	 * @see com.voole.trdpay.dao.order.IOrderDao#queryOrder(com.voole.trdpay.vo.order.OrderVo)
	 */
	@Override
	public List<OrderEntry> queryOrder(OrderEntry orderEntry) {
		Query query = new Query();
		if (StringUtils.isNotBlank(orderEntry.getOemid())) {
			query.addCriteria(Criteria.where("oemid").is(orderEntry.getOemid()));
		}
		if (StringUtils.isNotBlank(orderEntry.getHid())) {
			query.addCriteria(Criteria.where("hid").is(orderEntry.getHid()));
		}
		if (StringUtils.isNotBlank(orderEntry.getUid())) {
			query.addCriteria(Criteria.where("uid").is(orderEntry.getUid()));
		}
		if (StringUtils.isNotBlank(orderEntry.getOrderNum())) {
			query.addCriteria(Criteria.where("orderNum").is(orderEntry.getOrderNum()));
		}
		if (StringUtils.isNotBlank(orderEntry.getOrder_status())) {
			query.addCriteria(Criteria.where("order_status").is(orderEntry.getOrder_status()));
		}
		if (StringUtils.isNotBlank(orderEntry.getOrder_type())) {
			query.addCriteria(Criteria.where("order_type").is(orderEntry.getOrder_type()));
		}
		if (StringUtils.isNotBlank(orderEntry.getChcd())) {
			query.addCriteria(Criteria.where("chcd").is(orderEntry.getChcd()));
		}
		if (StringUtils.isNotBlank(orderEntry.getOrigOrderNum())) {
			query.addCriteria(Criteria.where("origOrderNum").is(orderEntry.getOrigOrderNum()));
		}
		if (null != orderEntry.getQueryStart() && null != orderEntry.getQueryEnd()) {
			query.addCriteria(
					Criteria.where("transTime").gte(orderEntry.getQueryStart()).lte(orderEntry.getQueryEnd()));
		}
		query.with(new Sort(Direction.DESC, "transTime"));
		if (orderEntry.getPmv() != null) {
			if (null != orderEntry.getPmv().getiDisplayStart()) {
				query.skip(orderEntry.getPmv().getiDisplayStart().intValue());
			}
			if (null != orderEntry.getPmv().getiDisplayLength()) {
				query.limit(orderEntry.getPmv().getiDisplayLength().intValue());
			}
		}
		return this.mongoTemplate.find(query, OrderEntry.class);
	}

	/*
	 * (非 Javadoc) <p>Title: queryOrderCount</p> <p>Description: </p>
	 * 
	 * @param orderEntry
	 * 
	 * @return
	 * 
	 * @see com.voole.trdpay.dao.order.IOrderDao#queryOrderCount(com.voole.trdpay.entry.order.OrderEntry)
	 */
	@Override
	public Long queryOrderCount(OrderEntry orderEntry) {
		Query query = new Query();
		if (StringUtils.isNotBlank(orderEntry.getOemid())) {
			query.addCriteria(Criteria.where("oemid").is(orderEntry.getOemid()));
		}
		if (StringUtils.isNotBlank(orderEntry.getHid())) {
			query.addCriteria(Criteria.where("hid").is(orderEntry.getHid()));
		}
		if (StringUtils.isNotBlank(orderEntry.getUid())) {
			query.addCriteria(Criteria.where("uid").is(orderEntry.getUid()));
		}
		if (StringUtils.isNotBlank(orderEntry.getOrderNum())) {
			query.addCriteria(Criteria.where("orderNum").is(orderEntry.getOrderNum()));
		}
		if (StringUtils.isNotBlank(orderEntry.getOrder_status())) {
			query.addCriteria(Criteria.where("order_status").is(orderEntry.getOrder_status()));
		}
		if (StringUtils.isNotBlank(orderEntry.getOrder_type())) {
			query.addCriteria(Criteria.where("order_status").is(orderEntry.getOrder_type()));
		}
		if (StringUtils.isNotBlank(orderEntry.getChcd())) {
			query.addCriteria(Criteria.where("chcd").is(orderEntry.getChcd()));
		}
		if (StringUtils.isNotBlank(orderEntry.getOrigOrderNum())) {
			query.addCriteria(Criteria.where("origOrderNum").is(orderEntry.getOrigOrderNum()));
		}
		if (null != orderEntry.getQueryStart() && null != orderEntry.getQueryEnd()) {
			query.addCriteria(
					Criteria.where("transTime").gte(orderEntry.getQueryStart()).lte(orderEntry.getQueryEnd()));
		}
		return this.mongoTemplate.count(query, OrderEntry.class);
	}

	/*
	 * (非 Javadoc) <p>Title: getTodayReceipt</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see com.voole.trdpay.dao.order.IOrderDao#getTodayReceipt()
	 */
	@Override
	public Double getTodayReceipt(boolean istoday) {
		Long receipt = 0L;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String todaystart = sdf.format(new Date()) + " 00:00:00";
			String todayebd = sdf.format(new Date()) + " 23:59:59";
			Criteria matchCriteria = Criteria.where("order_status").is("1");
			if (istoday) {
				matchCriteria.and("create_time").gte(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(todaystart))
						.lte(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(todayebd));
			}
			Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(matchCriteria),
					Aggregation.group("version").sum("amt").as("receipt"));
			/* 查看Group结果 */
			AggregationResults<CountVo> ar = this.mongoTemplate.aggregate(aggregation, "order", CountVo.class); // 执行
																												// aggregation命令
			List<CountVo> list = ar.getMappedResults();
			if (list.size() > 0) {
				receipt = list.get(0).getReceipt();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Double(receipt / 100.00 + "");
	}

	/*
	 * (非 Javadoc) <p>Title: getTodayTotal</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see com.voole.trdpay.dao.order.IOrderDao#getTodayTotal()
	 */
	@Override
	public Double getTodayTotal(boolean istoday) {
		Long total = 0L;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String todaystart = sdf.format(new Date()) + " 00:00:00";
			String todayebd = sdf.format(new Date()) + " 23:59:59";
			Criteria matchCriteria = Criteria.where("order_status").in("1", "2");
			if (istoday) {
				matchCriteria.and("create_time").gte(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(todaystart))
						.lte(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(todayebd));
			}
			Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(matchCriteria),
					Aggregation.group("version").sum("amt").as("total"));
			/* 查看Group结果 */
			AggregationResults<CountVo> ar = this.mongoTemplate.aggregate(aggregation, "order", CountVo.class); // 执行
																												// aggregation命令
			List<CountVo> list = ar.getMappedResults();
			if (list.size() > 0) {
				total = list.get(0).getTotal();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Double(total / 100.00 + "");
	}

	/*
	 * (非 Javadoc) <p>Title: deleteTrashData</p> <p>Description: </p>
	 * 
	 * @see com.voole.trdpay.dao.order.IOrderDao#deleteTrashData()
	 */
	@Override
	public void deleteTrashData() {
		Query query = new Query();
		query.addCriteria(Criteria.where("order_status").is("0").and("create_time")
				.gte(new Date(new Date().getTime() - 7200000L)));
		WriteResult ret = this.mongoTemplate.remove(query, OrderEntry.class);
		LOGGER.info("delete data size:" + ret.getN());

	}

}
