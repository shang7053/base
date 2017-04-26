package com.voole.cdcenter.controller.manager.system.notice;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.ModelAndView;

import com.voole.cdcenter.controller.BaseController;
import com.voole.cdcenter.entry.sytem.notice.NotificationsEntry;
import com.voole.cdcenter.service.system.notice.INotificationsService;
import com.voole.cdcenter.vo.AjaxRet;
import com.voole.cdcenter.vo.PageMessageVo;
import com.voole.cdcenter.vo.system.notice.AjaxNoticationsVo;
import com.voole.cdcenter.vo.system.notice.NotificationsVo;
import com.voole.cdcenter.vo.system.rule.RuleVo;
import com.voole.cdcenter.vo.system.user.UserVo;

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
    @Resource
    private INotificationsService notificationsService;

    @RequestMapping("turnnotice.do")
    public WebAsyncTask<ModelAndView> turnnotice() {
        return new WebAsyncTask<>(() -> {
            return new ModelAndView("system/notice/noticelist");
        });
    }

    @RequestMapping("queryNotice.do")
    @ResponseBody
    public WebAsyncTask<PageMessageVo> queryNotice(PageMessageVo pmv, NotificationsVo noticequerycase) {
        return new WebAsyncTask<>(() -> {
            try {
                noticequerycase.setPmv(pmv);
                List<NotificationsVo> rules = this.notificationsService.queryNotifications(noticequerycase);
                pmv.setAaData(rules);
                Integer totalsize = this.notificationsService.queryCountNotifications(noticequerycase);
                pmv.setiTotalRecords(totalsize);
                pmv.setiTotalDisplayRecords(totalsize);
                return pmv;
            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return pmv;
        });
    }

    @RequestMapping("querynotices.do")
    @ResponseBody
    public WebAsyncTask<AjaxNoticationsVo> querynotices(Date date, HttpSession session) {
        return new WebAsyncTask<>(() -> {
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
                            notificationsqc.setStart(0);
                            notificationsqc.setSize(8);
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
                this.LOGGER.error(e.getMessage(), e);
            }
            return null;
        });
    }

    @RequestMapping("setRead.do")
    @ResponseBody
    public WebAsyncTask<AjaxRet> setRead(Integer nid, Integer version) {
        return new WebAsyncTask<>(() -> {
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
                this.LOGGER.error(e.getMessage(), e);
            }
            return new AjaxRet(false, "程序内部错误");
        });
    }

    @RequestMapping("turnNoticesInfo.do")
    public WebAsyncTask<String> turnNoticesInfo(Integer nid, Model model) {
        return new WebAsyncTask<>(() -> {
            try {
                NotificationsVo notificationsVo = new NotificationsVo();
                notificationsVo.setNid(nid);
                List<NotificationsVo> notificationsVos = this.notificationsService.queryNotifications(notificationsVo);
                if (null != notificationsVos && notificationsVos.size() == 1) {
                    model.addAttribute("notifications", notificationsVos.get(0));
                }
            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return "system/notice/noticeinfo";
        });
    }
}
