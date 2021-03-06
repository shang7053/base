package com.voole.trdpay.controller.manager.system.notice;

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
import com.voole.trdpay.entry.sytem.notice.NotificationsEntry;
import com.voole.trdpay.service.system.notice.INotificationsService;
import com.voole.trdpay.vo.AjaxRet;
import com.voole.trdpay.vo.PageMessageVo;
import com.voole.trdpay.vo.system.notice.AjaxNoticationsVo;
import com.voole.trdpay.vo.system.notice.NotificationsVo;
import com.voole.trdpay.vo.system.rule.RuleVo;
import com.voole.trdpay.vo.system.user.UserVo;

/**
 * @ClassName: NoticeController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月12日 下午3:12:04
 * 
 */
@RequestMapping("/noticeController/")
@Controller
public class NoticeController extends BaseController {
	private static final Logger LOGGER = Logger.getLogger(NoticeController.class);
	@Reference
	private INotificationsService notificationsService;

	@RequestMapping("turnnotice.do")
	public ModelAndView turnnotice() {
		return new ModelAndView("system/notice/noticelist");
	}

	@RequestMapping("queryNotice.do")
	@ResponseBody
	public PageMessageVo queryNotice(PageMessageVo pmv, NotificationsVo noticequerycase) {
		try {
			noticequerycase.setPmv(pmv);
			List<NotificationsVo> rules = this.notificationsService.queryNotifications(noticequerycase);
			pmv.setAaData(rules);
			Integer totalsize = this.notificationsService.queryCountNotifications(noticequerycase);
			pmv.setiTotalRecords(Long.valueOf(totalsize));
			pmv.setiTotalDisplayRecords(Long.valueOf(totalsize));
			return pmv;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return pmv;
	}

	@RequestMapping("querynotices.do")
	@ResponseBody
	public AjaxNoticationsVo querynotices(Date date, HttpSession session) {
		try {
			AjaxNoticationsVo ajaxNoticationsVo = new AjaxNoticationsVo();
			UserVo loginUser = (UserVo) session.getAttribute("user");
			if (null == loginUser) {
				return ajaxNoticationsVo;
			}
			List<RuleVo> rules = loginUser.getRules();
			if (null != rules) {
				for (RuleVo ruleVo : rules) {
					if (ruleVo.getIs_recive_notice() == 1) {
						NotificationsVo notificationsqc = new NotificationsVo();
						notificationsqc.setIs_read(0);
						notificationsqc.setQueryStart(date);
						PageMessageVo pmv = new PageMessageVo();
						pmv.setiDisplayStart(0L);
						pmv.setiDisplayLength(8L);
						notificationsqc.setPmv(pmv);
						List<NotificationsVo> notificationsVos = this.notificationsService
								.queryNotifications(notificationsqc);
						ajaxNoticationsVo.setNotifications(notificationsVos);
						ajaxNoticationsVo.setCountNotifications(
								this.notificationsService.queryCountNotifications(notificationsqc));
						break;
					} else {
						continue;
					}
				}
			}
			return ajaxNoticationsVo;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	@RequestMapping("setRead.do")
	@ResponseBody
	public AjaxRet setRead(Integer nid, Integer version) {
		try {
			NotificationsEntry notificationsEntry = new NotificationsEntry();
			notificationsEntry.setNid(nid);
			notificationsEntry.setIs_read(1);
			notificationsEntry.setVersion(version);
			notificationsEntry.setRead_time(new Date());
			if (this.notificationsService.updateNotifications(notificationsEntry)) {
				return new AjaxRet(true, "设置成功!");
			} else {
				return new AjaxRet(false, "设置失败,该消息已被其他人处理!");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new AjaxRet(false, "程序内部错误");
	}

	@RequestMapping("setAllRead.do")
	@ResponseBody
	public AjaxRet setAllRead() {
		try {
			NotificationsEntry notificationsEntry = new NotificationsEntry();
			notificationsEntry.setIs_read(1);
			notificationsEntry.setRead_time(new Date());
			this.notificationsService.setAllRead(notificationsEntry);
			return new AjaxRet(true, "设置成功!");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new AjaxRet(false, "程序内部错误");
	}

	@RequestMapping("turnNoticesInfo.do")
	public String turnNoticesInfo(Integer nid, Model model) {
		try {
			NotificationsVo notificationsVo = new NotificationsVo();
			notificationsVo.setNid(nid);
			List<NotificationsVo> notificationsVos = this.notificationsService.queryNotifications(notificationsVo);
			if (null != notificationsVos && notificationsVos.size() == 1) {
				model.addAttribute("notifications", notificationsVos.get(0));
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return "system/notice/noticeinfo";
	}
}
