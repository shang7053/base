package com.voole.trdpay.timer;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.voole.trdpay.dao.order.IOrderDao;

/**
 * @ClassName: SystemTimer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月12日 下午5:15:14
 * 
 */
@Repository("systemTimer")
public class SystemTimer {
	private static final Logger LOGGER = Logger.getLogger(SystemTimer.class);
	@Resource
	private IOrderDao orderDao;

	public void deleteDate() {
		LOGGER.info("delete trash data timer start");
		this.orderDao.deleteTrashData();
		LOGGER.info("delete trash data timer end");
	}
}
