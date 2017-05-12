package com.voole.cdcenter.mapper.system.settings;

import java.util.List;

import com.voole.cdcenter.entry.sytem.settings.SystemSettingsEntry;
import com.voole.cdcenter.vo.system.settings.SystemSettingsVo;

/**
 * @ClassName: SystemSettingsMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:33:06
 * 
 */
public interface ISystemSettingsMapper {

	/**
	 * @Title: querySystenSettingsCount
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月14日 下午4:19:49
	 * @param settingsquerycase
	 * @return
	 */
	Integer querySystenSettingsCount(SystemSettingsVo settingsquerycase);

	/**
	 * @Title: querySystenSettings
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月14日 下午4:21:51
	 * @param settingsquerycase
	 * @return
	 */
	List<SystemSettingsVo> querySystenSettings(SystemSettingsVo settingsquerycase);

	/**
	 * @Title: updateSystemSettings
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月18日 下午3:53:45
	 * @param sse
	 * @return
	 */
	Integer updateSystemSettings(SystemSettingsEntry sse);

	/**
	 * @Title: insertSettings
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月18日 下午6:01:06
	 * @param sse
	 * @return
	 */
	Integer insertSettings(SystemSettingsEntry sse);

}
