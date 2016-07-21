package com.voole.cdcenter.vo.system.notice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: AjaxNoticationsVo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月12日 上午9:45:31
 * 
 */
public class AjaxNoticationsVo implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月12日 上午9:46:29
	 */
	private static final long serialVersionUID = 7789413027465451101L;
	private List<NotificationsVo> notifications = new ArrayList<>();
	private Integer countNotifications = 0;

	/**
	 * @return the notifications
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月12日 上午9:46:18
	 */
	public List<NotificationsVo> getNotifications() {
		return this.notifications;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月12日 上午9:46:18
	 * @param notifications the notifications to set
	 */
	public void setNotifications(List<NotificationsVo> notifications) {
		this.notifications = notifications;
	}

	/**
	 * @return the countNotifications
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月12日 上午9:46:18
	 */
	public Integer getCountNotifications() {
		return this.countNotifications;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月12日 上午9:46:18
	 * @param countNotifications the countNotifications to set
	 */
	public void setCountNotifications(Integer countNotifications) {
		this.countNotifications = countNotifications;
	}

	/*
	 * (非 Javadoc) <p>Title: toString</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AjaxNoticationsVo [notifications=" + this.notifications + ", countNotifications="
				+ this.countNotifications + "]";
	}

}
