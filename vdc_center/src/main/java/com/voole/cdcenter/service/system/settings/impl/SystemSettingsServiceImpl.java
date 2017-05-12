package com.voole.cdcenter.service.system.settings.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.voole.cdcenter.entry.sytem.settings.SystemSettingsEntry;
import com.voole.cdcenter.mapper.system.settings.ISystemSettingsMapper;
import com.voole.cdcenter.service.system.settings.ISystemSettingsService;
import com.voole.cdcenter.vo.system.settings.SystemSettingsVo;

/**
 * @ClassName: ISystemSettingsServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:39:04
 * 
 */
@Service
public class SystemSettingsServiceImpl implements ISystemSettingsService {
	@Resource
	private ISystemSettingsMapper systemSettingsMapper;

	/*
	 * (非 Javadoc) <p>Title: getSystemSettings</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see com.voole.datacheck.service.system.settings.ISystemSettingsService#getSystemSettings()
	 */
	@Override
	public List<SystemSettingsVo> getSystemSettings() {
		SystemSettingsVo settingsquerycase = new SystemSettingsVo();
		settingsquerycase.setIs_on(1);
		return this.systemSettingsMapper.querySystenSettings(settingsquerycase);
	}

	/*
	 * (非 Javadoc) <p>Title: querySystenSettings</p> <p>Description: </p>
	 * 
	 * @param settingsquerycase
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.datacheck.service.system.settings.ISystemSettingsService#querySystenSettings(com.voole.datacheck.vo.
	 * system.settings.SystemSettingsVo)
	 */
	@Override
	public List<SystemSettingsVo> querySystenSettings(SystemSettingsVo settingsquerycase) {
		return this.systemSettingsMapper.querySystenSettings(settingsquerycase);
	}

	/*
	 * (非 Javadoc) <p>Title: querySystenSettingsCount</p> <p>Description: </p>
	 * 
	 * @param settingsquerycase
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.datacheck.service.system.settings.ISystemSettingsService#querySystenSettingsCount(com.voole.datacheck.
	 * vo. system.settings.SystemSettingsVo)
	 */
	@Override
	public Integer querySystenSettingsCount(SystemSettingsVo settingsquerycase) {
		return this.systemSettingsMapper.querySystenSettingsCount(settingsquerycase);
	}

	/*
	 * (非 Javadoc) <p>Title: updateSystemSettings</p> <p>Description: </p>
	 * 
	 * @param sse
	 * 
	 * @return
	 * 
	 * @see com.voole.datacheck.service.system.settings.ISystemSettingsService#updateSystemSettings(com.voole.datacheck.
	 * entry. sytem.settings.SystemSettingsEntry)
	 */
	@Override
	public boolean updateSystemSettings(SystemSettingsEntry sse) {
		return this.systemSettingsMapper.updateSystemSettings(sse) > 0;
	}

	/*
	 * (非 Javadoc) <p>Title: insertSettings</p> <p>Description: </p>
	 * 
	 * @param sse
	 * 
	 * @return
	 * 
	 * @see com.voole.datacheck.service.system.settings.ISystemSettingsService#insertSettings(com.voole.datacheck.entry.
	 * sytem. settings.SystemSettingsEntry)
	 */
	@Override
	public boolean insertSettings(SystemSettingsEntry sse) {
		return this.systemSettingsMapper.insertSettings(sse) > 0;
	}

}
