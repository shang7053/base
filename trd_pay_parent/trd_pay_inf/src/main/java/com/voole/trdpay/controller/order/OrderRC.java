package com.voole.trdpay.controller.order;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import com.alibaba.dubbo.config.annotation.Reference;
import com.voole.trdpay.controller.BaseRc;
import com.voole.trdpay.entry.order.OrderEntry;
import com.voole.trdpay.service.order.IOrderService;
import com.voole.trdpay.util.AssertUtils;
import com.voole.trdpay.vo.order.OrderRet;
import com.voole.trdpay.vo.paycode.SpdRequestArgsVo;

/**
 * @ClassName: OrderController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月8日 下午1:24:34
 * 
 */
@RestController
@RequestMapping("order")
public class OrderRC extends BaseRc {
	@Reference
	private IOrderService orderService;

	@GetMapping("/{orderNum}")
	public WebAsyncTask<OrderRet> queryOrderStatus(@PathVariable("orderNum") String orderNum) {
		return new WebAsyncTask<>(() -> {
			this.LOGGER.debug("==================================================");
			this.LOGGER.info("query order start,orderNum:" + orderNum);
			OrderRet ret = new OrderRet();
			ret.setOrder_status("1");
			ret.setOrderNum(orderNum);
			try {
				if (StringUtils.isBlank(orderNum)) {
					AssertUtils.notNull(orderNum, "订单编号不能为空");
				}
				OrderEntry order = this.orderService.findByOrderNum(orderNum);
				this.LOGGER.debug("data:" + order);
				AssertUtils.notNull(order, "未查询到订单");
				ret.setOrder_status(order.getOrder_status());
				ret.setErrorDetail(order.getErrorDetail());
			} catch (Exception e) {
				this.LOGGER.error(e);
				ret.setErrorDetail(e.getMessage());
				this.LOGGER.info("query order end,error " + e.getMessage());
				this.LOGGER.debug("==================================================");
				return ret;
			}
			this.LOGGER.info("query order end");
			this.LOGGER.debug("==================================================");
			return ret;
		});
	}

	@GetMapping("cancel/{orderNum}")
	public WebAsyncTask<OrderRet> cancel(@PathVariable("orderNum") String orderNum) {
		return new WebAsyncTask<>(() -> {
			this.LOGGER.debug("==================================================");
			this.LOGGER.info("cancel order start,orderNum:" + orderNum);
			OrderRet ret = new OrderRet();
			ret.setOrder_status("1");
			ret.setOrderNum(orderNum);
			try {
				if (StringUtils.isBlank(orderNum)) {
					AssertUtils.notNull(orderNum, "订单编号不能为空");
				}
				OrderEntry order = this.orderService.findByOrderNum(orderNum);
				this.LOGGER.debug("data:" + order);
				AssertUtils.notNull(order, "未查询到订单");
				ret = this.orderService.cancelOrder(order, ret);
			} catch (Exception e) {
				this.LOGGER.error(e);
				ret.setErrorDetail(e.getMessage());
				this.LOGGER.info("cancel order end,error " + e.getMessage());
				this.LOGGER.debug("==================================================");
				return ret;
			}
			this.LOGGER.info("cancel order end");
			this.LOGGER.debug("==================================================");
			return ret;
		});
	}

	@GetMapping("/cb")
	public WebAsyncTask<String> cb(SpdRequestArgsVo data, HttpServletRequest request) {
		return new WebAsyncTask<>(() -> {
			this.LOGGER.debug("==================================================");
			this.LOGGER.info("recive a callback!");
			this.LOGGER.debug("data:" + data);
			try {
				AssertUtils.notNull(data, "未收到参数!");
				String querystr = request.getQueryString();
				this.LOGGER.info("http querystring=" + querystr);
				Map<String, String> cbtmap = this.getMapFromStr(querystr);
				this.LOGGER.debug("conver querystr to map,map=" + cbtmap);
				this.orderService.cb(data, cbtmap);
			} catch (Exception e) {
				this.LOGGER.error(e);
				this.LOGGER.info("callback error " + e.getMessage());
				this.LOGGER.debug("==================================================");
			}
			this.LOGGER.info("deal order callback end");
			this.LOGGER.debug("==================================================");
			return "SUCCESS";
		});
	}

}
