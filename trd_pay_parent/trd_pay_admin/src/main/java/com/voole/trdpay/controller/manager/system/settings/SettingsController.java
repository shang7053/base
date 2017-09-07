package com.voole.trdpay.controller.manager.system.settings;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.voole.trdpay.controller.manager.BaseController;
import com.voole.trdpay.entry.sytem.settings.SystemSettingsEntry;
import com.voole.trdpay.service.system.settings.ISystemSettingsService;
import com.voole.trdpay.vo.AjaxRet;
import com.voole.trdpay.vo.PageMessageVo;
import com.voole.trdpay.vo.system.settings.SystemSettingsVo;

/**
 * @ClassName: SettingsController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月14日 下午4:13:05
 * 
 */
@RequestMapping("/settingsController/")
@Controller
public class SettingsController extends BaseController {
	private static final Logger LOGGER = Logger.getLogger(SettingsController.class);
	@Reference
	private ISystemSettingsService settingsService;

	@RequestMapping("turnSettings.do")
	public ModelAndView turnrule() {
		return new ModelAndView("system/settings/settingslist");
	}

	@RequestMapping("querySettings.do")
	@ResponseBody
	public PageMessageVo querySettings(PageMessageVo pmv, SystemSettingsVo settingsquerycase) {
		try {
			settingsquerycase.setPmv(pmv);
			List<SystemSettingsVo> rules = this.settingsService.querySystenSettings(settingsquerycase);
			pmv.setAaData(rules);
			Integer totalsize = this.settingsService.querySystenSettingsCount(settingsquerycase);
			pmv.setiTotalRecords(totalsize);
			pmv.setiTotalDisplayRecords(totalsize);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return pmv;
	}

	@RequestMapping("changvalue.do")
	@ResponseBody
	public AjaxRet changvalue(SystemSettingsEntry sse, HttpSession session) {
		if (null == sse) {
			return new AjaxRet(false, "操作失败");
		}
		try {
			sse.setUpdate_time(new Date());
			if (this.settingsService.updateSystemSettings(sse)) {
				this.refreshCacheConfig(this.settingsService, sse, session);
				return new AjaxRet(true, "操作成功");
			}
			return new AjaxRet(false, "操作失败，数据已被他人操作！");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new AjaxRet(false, "程序内部错误");
	}

	@RequestMapping("turnSettingsInfo.do")
	public String turnSettingsInfo(SystemSettingsVo settingsquerycase, Model model) {
		if (null == settingsquerycase) {
			return "system/settings/settingsinfo";
		}
		try {
			List<SystemSettingsVo> settingsVos = this.settingsService.querySystenSettings(settingsquerycase);
			if (null != settingsVos && settingsVos.size() == 1) {
				model.addAttribute("settingsinfo", settingsVos.get(0));
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return "system/settings/settingsinfo";
	}

	@RequestMapping("turnCreateSettings.do")
	public String turnCreateSettings() {
		return "system/settings/createsettings";
	}

	@RequestMapping("addSettings.do")
	@ResponseBody
	public AjaxRet addSettings(SystemSettingsEntry sse, HttpSession session) {
		if (null == sse) {
			return new AjaxRet(false, "添加失败");
		}
		try {
			sse.setCreate_time(new Date());
			if (this.settingsService.insertSettings(sse)) {
				this.refreshCacheConfig(this.settingsService, sse, session);
				return new AjaxRet(true, "添加成功");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new AjaxRet(false, "程序内部错误");
	}
}
