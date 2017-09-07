package com.voole.trdpay.mapper.system.notice;

import java.util.List;

import com.voole.trdpay.entry.sytem.notice.NotificationsEntry;
import com.voole.trdpay.mapper.IBaseMapper;
import com.voole.trdpay.vo.system.notice.NotificationsVo;

/**
 * @ClassName: NotificationsMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:32:21
 * 
 */
public interface INotificationsMapper extends IBaseMapper {

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

	/**
	 * @Title: updateNotifications
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月12日 下午3:18:32
	 * @param notificationsEntry
	 * @return
	 */
	Integer updateNotificationsforemail(NotificationsEntry notificationsEntry);

	/**
	 * @Title: insertNotifications
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年3月31日 上午9:44:16
	 * @param notificationsEntry
	 * @return
	 */
	Integer insertNotifications(NotificationsEntry notificationsEntry);

	/**
	 * @Title: setAllRead
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年3月31日 上午9:44:16
	 * @param notificationsEntry
	 * @return
	 */
	Integer setAllRead(NotificationsEntry notificationsEntry);

	/**
	 * @Title: queryUnRUnE
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年3月31日 下午3:50:59
	 * @param qc
	 * @return
	 */
	List<NotificationsVo> queryUnRUnE(NotificationsVo qc);

}
