package com.voole.trdpay.controller.manager.system.log;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.voole.trdpay.controller.manager.BaseController;
import com.voole.trdpay.service.system.log.ISystemLogService;
import com.voole.trdpay.vo.PageMessageVo;
import com.voole.trdpay.vo.system.log.SysytemLogVo;

/**
 * @ClassName: SettingsController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月14日 下午4:13:05
 * 
 */
@RequestMapping("/systemLogsController/")
@Controller
public class SystemLogsController extends BaseController {
	private static final Logger LOGGER = Logger.getLogger(SystemLogsController.class);
	@Reference
	private ISystemLogService systemLogService;

	@RequestMapping("turnSystemLogs.do")
	public ModelAndView turnSystemLogs() {
		return new ModelAndView("system/log/loglist");
	}

	@RequestMapping("querySystemLogs.do")
	@ResponseBody
	public PageMessageVo querySystemLogs(PageMessageVo pmv, SysytemLogVo sysytemLogqc) {
		try {
			sysytemLogqc.setPmv(pmv);
			List<SysytemLogVo> rules = this.systemLogService.querySystemLogs(sysytemLogqc);
			pmv.setAaData(rules);
			Integer totalsize = this.systemLogService.querySystemLogsCount(sysytemLogqc);
			pmv.setiTotalRecords(totalsize);
			pmv.setiTotalDisplayRecords(totalsize);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return pmv;
	}
}
