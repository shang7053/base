package com.voole.trdpay.service.order;

import java.util.List;
import java.util.Map;

import com.voole.trdpay.entry.order.OrderEntry;
import com.voole.trdpay.vo.order.OrderRet;
import com.voole.trdpay.vo.paycode.PayCodeRet;
import com.voole.trdpay.vo.paycode.PayCodeVo;
import com.voole.trdpay.vo.paycode.SpdRequestArgsVo;

/**
 * @ClassName: IPayCodeService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月8日 上午10:17:48
 * 
 */
public interface IOrderService {
	/**
	 * 
	 * @Title: log2DB
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 上午10:19:27
	 * @param payCode
	 * @param spdRequestArgsVo
	 * @return
	 */
	public Boolean log2DB(PayCodeVo payCode, SpdRequestArgsVo spdRequestArgsVo);

	/**
	 * @Title: findByOrderNum
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月8日 下午1:30:55
	 * @param orderNum
	 * @return
	 */
	public OrderEntry findByOrderNum(String orderNum);

	/**
	 * @Title: successOrder
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午2:06:40
	 * @param data
	 */
	public void successOrder(SpdRequestArgsVo data);

	/**
	 * @Title: cancel
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月11日 下午2:53:25
	 * @param spdRequestArgsVo
	 */
	public void cancel(SpdRequestArgsVo spdRequestArgsVo);

	/**
	 * @Title: queryOrder
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 上午10:32:05
	 * @param orderVo
	 * @return
	 */
	public List<OrderEntry> queryOrder(OrderEntry orderEntry);

	/**
	 * @Title: queryOrderCount
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 上午10:32:11
	 * @param orderVo
	 * @return
	 */
	public Long queryOrderCount(OrderEntry orderVo);

	/**
	 * @Title: cancelOrder
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @param order
	 * @param ret
	 * @return
	 * @date 2017年9月12日 下午1:45:42
	 */
	public OrderRet cancelOrder(OrderEntry order, OrderRet ret) throws Exception;

	/**
	 * @Title: cb
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年9月12日 下午2:04:08
	 * @param data
	 * @param cbtmap
	 */
	public void cb(SpdRequestArgsVo data, Map<String, String> cbtmap) throws Exception;

	/**
	 * @Title: gengerQrCode
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @param ret
	 * @param payCode
	 * @date 2017年9月12日 下午2:08:10
	 * @return
	 */
	public PayCodeRet gengerQrCode(PayCodeRet ret, PayCodeVo payCode) throws Exception;

	/**
	 * @Title: getTodayReceipt
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @param istoday
	 * @date 2017年9月12日 下午3:36:16
	 * @return
	 */
	public Double getTodayReceipt(boolean istoday);

	/**
	 * @Title: getTodayTotal
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @param istoday
	 * @date 2017年9月12日 下午3:36:20
	 * @return
	 */
	public Double getTodayTotal(boolean istoday);
}
