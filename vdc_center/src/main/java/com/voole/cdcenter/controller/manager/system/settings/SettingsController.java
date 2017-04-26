package com.voole.cdcenter.controller.manager.system.settings;

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
import com.voole.cdcenter.entry.sytem.settings.SystemSettingsEntry;
import com.voole.cdcenter.service.system.settings.ISystemSettingsService;
import com.voole.cdcenter.vo.AjaxRet;
import com.voole.cdcenter.vo.PageMessageVo;
import com.voole.cdcenter.vo.system.settings.SystemSettingsVo;

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
    @Resource
    private ISystemSettingsService settingsService;

    @RequestMapping("turnSettings.do")
    public WebAsyncTask<ModelAndView> turnrule() {
        return new WebAsyncTask<>(() -> {
            return new ModelAndView("system/settings/settingslist");
        });
    }

    @RequestMapping("querySettings.do")
    @ResponseBody
    public WebAsyncTask<PageMessageVo> querySettings(PageMessageVo pmv, SystemSettingsVo settingsquerycase) {
        return new WebAsyncTask<>(() -> {
            try {
                settingsquerycase.setPmv(pmv);
                List<SystemSettingsVo> rules = this.settingsService.querySystenSettings(settingsquerycase);
                pmv.setAaData(rules);
                Integer totalsize = this.settingsService.querySystenSettingsCount(settingsquerycase);
                pmv.setiTotalRecords(totalsize);
                pmv.setiTotalDisplayRecords(totalsize);
            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return pmv;
        });
    }

    @RequestMapping("changvalue.do")
    @ResponseBody
    public WebAsyncTask<AjaxRet> changeuser(SystemSettingsEntry sse, HttpSession session) {
        return new WebAsyncTask<>(() -> {
            if (null == sse) {
                return new AjaxRet(false, "操作失败");
            }
            try {
                sse.setUpdate_time(new Date());
                if (this.settingsService.updateSystemSettings(sse)) {
                    this.refreshCacheConfig(sse, session);
                    return new AjaxRet(true, "操作成功");
                }
                return new AjaxRet(false, "操作失败，数据已被他人操作！");
            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return new AjaxRet(false, "程序内部错误");
        });
    }

    @RequestMapping("turnSettingsInfo.do")
    public WebAsyncTask<String> turnSettingsInfo(SystemSettingsVo settingsquerycase, Model model) {
        return new WebAsyncTask<>(() -> {
            if (null == settingsquerycase) {
                return "system/settings/settingsinfo";
            }
            try {
                List<SystemSettingsVo> settingsVos = this.settingsService.querySystenSettings(settingsquerycase);
                if (null != settingsVos && settingsVos.size() == 1) {
                    model.addAttribute("settingsinfo", settingsVos.get(0));
                }
            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return "system/settings/settingsinfo";
        });
    }

    @RequestMapping("turnCreateSettings.do")
    public WebAsyncTask<String> turnCreateSettings() {
        return new WebAsyncTask<>(() -> {
            return "system/settings/createsettings";
        });
    }

    @RequestMapping("addSettings.do")
    @ResponseBody
    public WebAsyncTask<AjaxRet> addSettings(SystemSettingsEntry sse, HttpSession session) {
        return new WebAsyncTask<>(() -> {
            if (null == sse) {
                return new AjaxRet(false, "添加失败");
            }
            try {
                sse.setCreate_time(new Date());
                if (this.settingsService.insertSettings(sse)) {
                    this.refreshCacheConfig(sse, session);
                    return new AjaxRet(true, "添加成功");
                }
            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return new AjaxRet(false, "程序内部错误");
        });
    }
}
