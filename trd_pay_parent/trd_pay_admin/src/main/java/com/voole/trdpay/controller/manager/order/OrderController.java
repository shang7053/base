package com.voole.trdpay.controller.manager.order;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.voole.trdpay.controller.manager.BaseController;
import com.voole.trdpay.entry.order.OrderEntry;
import com.voole.trdpay.service.order.IOrderService;
import com.voole.trdpay.vo.AjaxRet;
import com.voole.trdpay.vo.PageMessageVo;
import com.voole.trdpay.vo.order.OrderRet;

/**
 * @ClassName: OrderController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月14日 下午4:13:05
 * 
 */
@RequestMapping("/order/")
@Controller
public class OrderController extends BaseController {
	private static final Logger LOGGER = Logger.getLogger(OrderController.class);
	@Reference
	private IOrderService orderService;

	@RequestMapping("turnOrder.do")
	public ModelAndView turnrule() {
		return new ModelAndView("order/orderlist");
	}

	@RequestMapping("queryOrder.do")
	@ResponseBody
	public PageMessageVo queryOrder(PageMessageVo pmv, OrderEntry orderEntry) {
		try {
			orderEntry.setPmv(pmv);
			List<OrderEntry> rules = this.orderService.queryOrder(orderEntry);
			pmv.setAaData(rules);
			Long totalsize = this.orderService.queryOrderCount(orderEntry);
			pmv.setiTotalRecords(totalsize);
			pmv.setiTotalDisplayRecords(totalsize);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return pmv;
	}

	@RequestMapping("turnOrderInfo.do")
	public String turnOrderInfo(OrderEntry orderEntry, Model model) {
		if (null == orderEntry) {
			return "order/orderinfo";
		}
		try {
			OrderEntry orderVos = this.orderService.findByOrderNum(orderEntry.getOrderNum());
			orderVos.setAmt(orderVos.getAmt());
			if (StringUtils.isNotBlank(orderVos.getChcd())) {
				switch (orderVos.getChcd()) {
				case "ALP":
					orderVos.setChcd("支付宝");
					break;
				case "WXP":
					orderVos.setChcd("微信");
					break;
				case "BDP":
					orderVos.setChcd("百度钱包");
					break;
				default:
					break;
				}
			}
			if (StringUtils.isNotBlank(orderVos.getOrder_status())) {
				switch (orderVos.getOrder_status()) {
				case "0":
					orderVos.setOrder_status("待支付");
					break;
				case "1":
					orderVos.setOrder_status("已支付");
					break;
				case "2":
					orderVos.setOrder_status("已退款");
					break;
				case "3":
					orderVos.setOrder_status("失败");
					break;
				default:
					break;
				}
			}
			if (StringUtils.isNotBlank(orderVos.getRespcd())) {
				switch (orderVos.getRespcd()) {
				case "09":
					orderVos.setRespcd("待用户输入密码");
					break;
				case "51":
					orderVos.setRespcd("消费者账户余额不足");
					break;
				case "55":
					orderVos.setRespcd("密码错误");
					break;
				case "Y0":
					orderVos.setRespcd("付款码失效 ");
					break;
				case "Y2":
					orderVos.setRespcd("不支持的交易渠道");
					break;
				case "Y3":
					orderVos.setRespcd("订单不存在");
					break;
				case "Y5":
					orderVos.setRespcd("商家账户余额不足");
					break;
				case "YC":
					orderVos.setRespcd("交易状态不合法");
					break;
				case "YG":
					orderVos.setRespcd("原交易已退款");
					break;
				case "ZH":
					orderVos.setRespcd("交易存在风险 ");
					break;
				case "ZS":
					orderVos.setRespcd("不支持该交易类型");
					break;
				default:
					orderVos.setRespcd("成功");
					break;
				}
			}
			model.addAttribute("orderinfo", orderVos);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return "order/orderinfo";
	}

	@RequestMapping("/cancel.do")
	@ResponseBody
	public AjaxRet cancel(OrderEntry orderEntry, Model model) {
		if (null == orderEntry) {
			return new AjaxRet(false, "参数不能为空");
		}
		try {
			OrderEntry OrderVos = this.orderService.findByOrderNum(orderEntry.getOrderNum());
			model.addAttribute("orderinfo", OrderVos);
			if (null != OrderVos) {
				OrderRet orderRet = new OrderRet();
				orderRet.setOrderNum(OrderVos.getOrderNum());
				orderRet = this.orderService.cancelOrder(OrderVos, orderRet);
				if (orderRet.getOrder_status().equals("0")) {
					return new AjaxRet(true, orderRet.getErrorDetail());
				} else {
					return new AjaxRet(false, orderRet.getErrorDetail());
				}
			} else {
				return new AjaxRet(false, "未查询到订单");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new AjaxRet(false, "未知错误：" + e.getMessage());
		}
	}
}
