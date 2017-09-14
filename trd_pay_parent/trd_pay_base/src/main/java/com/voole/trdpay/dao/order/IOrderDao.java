package com.voole.trdpay.dao.order;

import java.util.List;

import com.voole.trdpay.entry.order.OrderEntry;

/**
 * @ClassName: IOrderDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月8日 下午1:14:05
 * 
 */
public interface IOrderDao {

	/**
	 * @Title: insert
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午1:15:50
	 * @param oe
	 */
	void insert(OrderEntry oe);

	/**
	 * @Title: findByOrderNum
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午1:33:00
	 * @param orderNum
	 * @return
	 */
	OrderEntry findByOrderNum(String orderNum);

	/**
	 * @Title: updateOrInsert
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午2:13:33
	 * @param oe
	 */
	void updateOrInsertForAply(OrderEntry oe);

	/**
	 * @Title: updateOrInsertForCancel
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午3:56:28
	 * @param oe
	 */
	void updateOrInsertForCancel(OrderEntry oe);

	/**
	 * @Title: queryOrder
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 上午11:07:17
	 * @param orderVo
	 * @return
	 */
	List<OrderEntry> queryOrder(OrderEntry orderEntry);

	/**
	 * @Title: queryOrderCount
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 上午11:07:25
	 * @param orderVo
	 * @return
	 */
	Long queryOrderCount(OrderEntry orderEntry);

	/**
	 * @Title: getTodayReceipt
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @param istoday
	 * @date 2017年9月12日 下午3:37:53
	 * @return
	 */
	Double getTodayReceipt(boolean istoday);

	/**
	 * @Title: getTodayTotal
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @param istoday
	 * @date 2017年9月12日 下午3:37:58
	 * @return
	 */
	Double getTodayTotal(boolean istoday);

	/**
	 * @Title: deleteTrashData
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 下午5:16:56
	 */
	void deleteTrashData();

}
