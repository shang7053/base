package com.voole.trdpay.controller.manager.home;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.voole.trdpay.controller.manager.BaseController;
import com.voole.trdpay.service.order.IOrderService;
import com.voole.trdpay.vo.home.HomeVo;

/**
 * @ClassName: HomeController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月12日 下午2:53:11
 * 
 */
@Controller
public class HomeController extends BaseController {
	@Reference
	private IOrderService orderService;

	@RequestMapping("/tohome.do")
	public String tohome() {
		return "home";
	}

	@RequestMapping("/home/getdata.do")
	@ResponseBody
	public HomeVo getdata() {
		HomeVo ret = new HomeVo();
		ret.setX(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
		ret.setReceipt(this.orderService.getTodayReceipt(true));
		ret.setTotal(this.orderService.getTodayTotal(true));
		return ret;
	}
}
