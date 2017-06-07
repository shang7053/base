package com.voole.datasync.service.system.notice;

import java.util.List;

import com.voole.datasync.entry.sytem.notice.NotificationsEntry;
import com.voole.datasync.service.IBaseService;
import com.voole.datasync.vo.system.notice.NotificationsVo;

/**
 * @ClassName: NotificationsMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:32:21
 * 
 */
public interface INotificationsService extends IBaseService {

	/**
	 * @Title: queryNotifications
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 下午4:30:41
	 * @param notificationsqc
	 * @return
	 */
	List<NotificationsVo> queryNotifications(NotificationsVo notificationsqc);

	/**
	 * @Title: queryCountNotifications
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 下午4:46:48
	 * @param notificationsqc
	 * @return
	 */
	Integer queryCountNotifications(NotificationsVo notificationsqc);

	/**
	 * @Title: updateNotifications
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月12日 下午3:18:03
	 * @param notificationsEntry
	 * @return
	 */
	boolean updateNotifications(NotificationsEntry notificationsEntry);

	/**
	 * @Title: updateNotifications
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月12日 下午3:18:03
	 * @param notificationsEntry
	 * @return
	 */
	boolean insertNotifications(NotificationsEntry notificationsEntry);

	/**
	 * @Title: queryUnRUnE
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年4月12日 上午9:41:17
	 * @param qc
	 * @return
	 */
	List<NotificationsVo> queryUnRUnE(NotificationsVo qc);

	/**
	 * @Title: updateNotificationsforemail
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年4月12日 上午9:41:24
	 * @param qc
	 */
	Integer updateNotificationsforemail(NotificationsVo qc);

}
