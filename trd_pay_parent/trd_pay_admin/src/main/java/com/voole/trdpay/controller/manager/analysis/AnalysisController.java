package com.voole.trdpay.controller.manager.analysis;

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
@RequestMapping("analysis")
public class AnalysisController extends BaseController {
	@Reference
	private IOrderService orderService;

	@RequestMapping("/turnAnalysis.do")
	public String turnAnalysis() {
		return "analysis/analysis";
	}

	@RequestMapping("/getdata.do")
	@ResponseBody
	public HomeVo getdata() {
		HomeVo ret = new HomeVo();
		ret.setReceipt(this.orderService.getTodayReceipt(false));
		ret.setTotal(this.orderService.getTodayTotal(false));
		return ret;
	}
}
