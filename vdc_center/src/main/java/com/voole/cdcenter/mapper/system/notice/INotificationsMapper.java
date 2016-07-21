package com.voole.cdcenter.mapper.system.notice;

import java.util.List;

import com.voole.cdcenter.entry.sytem.notice.NotificationsEntry;
import com.voole.cdcenter.vo.system.notice.NotificationsVo;

/**
 * @ClassName: NotificationsMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:32:21
 * 
 */
public interface INotificationsMapper {

	/**
	 * @Title: queryNotifications
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 下午4:31:24
	 * @param notificationsqc
	 * @return
	 */
	List<NotificationsVo> queryNotifications(NotificationsVo notificationsqc);

	/**
	 * @Title: queryCountNotifications
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 下午4:47:07
	 * @param notificationsqc
	 * @return
	 */
	Integer queryCountNotifications(NotificationsVo notificationsqc);

	/**
	 * @Title: updateNotifications
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月12日 下午3:18:32
	 * @param notificationsEntry
	 * @return
	 */
	Integer updateNotifications(NotificationsEntry notificationsEntry);

}
