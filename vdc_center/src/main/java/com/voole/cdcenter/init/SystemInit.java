package com.voole.cdcenter.init;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import com.voole.cdcenter.service.system.settings.ISystemSettingsService;
import com.voole.cdcenter.vo.system.settings.SystemSettingsVo;

@Repository
public class SystemInit implements ApplicationContextAware {
	@Resource
	private ServletContext servletContext;
	@Resource
	private ISystemSettingsService systemSettingsService;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.readSystemSettings();
	}

	/**
	 * @Title: readSystemSettings
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午3:08:11
	 */
	private void readSystemSettings() {
		List<SystemSettingsVo> settingsVos = this.systemSettingsService.getSystemSettings();
		if (null != settingsVos) {
			for (SystemSettingsVo systemSettingsVo : settingsVos) {
				this.servletContext.setAttribute(systemSettingsVo.getConfig_name(), systemSettingsVo.getConfig_value());
			}
		}
	}
}
