package com.voole.cdcenter.service.system.notice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.voole.cdcenter.entry.sytem.notice.NotificationsEntry;
import com.voole.cdcenter.mapper.system.notice.INotificationsMapper;
import com.voole.cdcenter.service.system.notice.INotificationsService;
import com.voole.cdcenter.vo.system.notice.NotificationsVo;

/**
 * @ClassName: INotificationsServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:38:41
 * 
 */
@Service
public class NotificationsServiceImpl implements INotificationsService {
	@Resource
	private INotificationsMapper notificationsMapper;

	/*
	 * (非 Javadoc) <p>Title: queryNotifications</p> <p>Description: </p>
	 * 
	 * @param notificationsqc
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.cdcenter.service.system.notice.INotificationsService#queryNotifications(com.voole.cdcenter.vo.system.
	 * notice.NotificationsVo)
	 */
	@Override
	public List<NotificationsVo> queryNotifications(NotificationsVo notificationsqc) {
		return this.notificationsMapper.queryNotifications(notificationsqc);
	}

	/*
	 * (非 Javadoc) <p>Title: queryCountNotifications</p> <p>Description: </p>
	 * 
	 * @param notificationsqc
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.cdcenter.service.system.notice.INotificationsService#queryCountNotifications(com.voole.cdcenter.vo.
	 * system.notice.NotificationsVo)
	 */
	@Override
	public Integer queryCountNotifications(NotificationsVo notificationsqc) {
		Integer count = this.notificationsMapper.queryCountNotifications(notificationsqc);
		return null == count ? 0 : count;
	}

	/*
	 * (非 Javadoc) <p>Title: updateNotifications</p> <p>Description: </p>
	 * 
	 * @param notificationsEntry
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.cdcenter.service.system.notice.INotificationsService#updateNotifications(com.voole.cdcenter.entry.sytem
	 * .notice.NotificationsEntry)
	 */
	@Override
	public boolean updateNotifications(NotificationsEntry notificationsEntry) {
		return this.notificationsMapper.updateNotifications(notificationsEntry) > 0;
	}

}
