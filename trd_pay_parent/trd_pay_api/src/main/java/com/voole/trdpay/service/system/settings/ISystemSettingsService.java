package com.voole.trdpay.service.system.settings;

import java.util.List;

import com.voole.trdpay.entry.sytem.settings.SystemSettingsEntry;
import com.voole.trdpay.vo.system.settings.SystemSettingsVo;

/**
 * @ClassName: SystemSettingsMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:33:06
 * 
 */
public interface ISystemSettingsService {

	/**
	 * @Title: getSystemSettings
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午3:08:47
	 * @return
	 */
	List<SystemSettingsVo> getSystemSettings();

	/**
	 * @Title: querySystenSettings
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月14日 下午4:18:50
	 * @param settingsquerycase
	 * @return
	 */
	List<SystemSettingsVo> querySystenSettings(SystemSettingsVo settingsquerycase);

	/**
	 * @Title: querySystenSettingsCount
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月14日 下午4:18:56
	 * @param settingsquerycase
	 * @return
	 */
	Integer querySystenSettingsCount(SystemSettingsVo settingsquerycase);

	/**
	 * @Title: updateSystemSettings
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月18日 下午3:53:02
	 * @param sse
	 * @return
	 */
	boolean updateSystemSettings(SystemSettingsEntry sse);

	/**
	 * @Title: insertSettings
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月18日 下午6:00:23
	 * @param sse
	 * @return
	 */
	boolean insertSettings(SystemSettingsEntry sse);

}
