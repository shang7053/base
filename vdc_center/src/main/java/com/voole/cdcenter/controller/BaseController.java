package com.voole.cdcenter.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.voole.cdcenter.entry.sytem.settings.SystemSettingsEntry;
import com.voole.cdcenter.service.system.settings.ISystemSettingsService;
import com.voole.cdcenter.vo.system.settings.SystemSettingsVo;

/**
 * @ClassName: BaseController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月12日 上午11:40:06
 * 
 */
public class BaseController {
    protected final Logger LOGGER = Logger.getLogger(this.getClass());
    @Resource
    private ServletContext servletContext;
    @Resource
    private ISystemSettingsService systemSettingsService;

    /**
     * 
     * @Title: initBinder
     * @Description: 类型转换器
     * @param binder 参数
     * @throws ServletException
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) throws ServletException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * @Title: refreshCacheConfig
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author shangchengcai@voole.com
     * @date 2016年7月18日 下午5:46:14
     */
    protected void refreshCacheConfig(SystemSettingsEntry sse, HttpSession session) {
        if (sse.getIs_on() == 0) {
            session.getServletContext().removeAttribute(sse.getConfig_name());
            return;
        }
        if (null != sse.getId()) {
            SystemSettingsVo settingsquerycase = new SystemSettingsVo();
            settingsquerycase.setId(sse.getId());
            List<SystemSettingsVo> settingsVos = this.systemSettingsService.querySystenSettings(settingsquerycase);
            if (null != settingsVos && settingsVos.size() == 1) {
                session.getServletContext().setAttribute(settingsVos.get(0).getConfig_name(),
                        settingsVos.get(0).getConfig_value());
            }
        } else {
            session.getServletContext().setAttribute(sse.getConfig_name(), sse.getConfig_value());
        }
    }
}
