package com.voole.datasync.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.alibaba.dubbo.config.annotation.Reference;
import com.voole.datasync.service.system.notice.INotificationsService;
import com.voole.datasync.util.IPUtil;
import com.voole.datasync.util.MailUtils;
import com.voole.datasync.vo.system.notice.NotificationsVo;

/**
 * @ClassName: SyncLogStatisticsTimer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年3月31日 上午10:25:39
 * 
 */
@Repository
public class AlertEmailTimer {
	private static final Logger logger = Logger.getLogger(AlertEmailTimer.class);
	@Reference
	private INotificationsService notificationsService;
	@Value("${email.hostname}")
	private String hostname;
	@Value("${email.loginname}")
	private String loginname;
	@Value("${email.loginpwd}")
	private String loginpwd;
	@Value("${email.personal}")
	private String personal;

	public void sendEmail() {
		logger.info("timer-" + this.getClass() + "----start");
		NotificationsVo qc = new NotificationsVo();
		qc.setIs_email(0);
		List<NotificationsVo> notificationsVos = this.notificationsService.queryUnRUnE(qc);
		logger.info("find error list:" + notificationsVos);
		if (null != notificationsVos && notificationsVos.size() > 0) {
			Properties emailProp = new Properties();
			emailProp.put("email.hostname", this.hostname);
			emailProp.put("email.loginname", this.loginname);
			emailProp.put("email.loginpwd", this.loginpwd);
			emailProp.put("email.personal", this.personal);
			for (NotificationsVo notificationsVo : notificationsVos) {
				logger.info("send email:recives:" + notificationsVo.getRecive_email());
				if (StringUtils.isBlank(notificationsVo.getRecive_email())) {
					logger.info("timer-" + this.getClass() + "----end");
					return;
				}
				StringBuilder emailcontext = new StringBuilder();
				emailcontext.append("各位好,<br>");
				emailcontext.append("&emsp;基础数据同步系统，同步码:");
				emailcontext.append(notificationsVo.getSync_code());
				emailcontext.append("发生了" + notificationsVo.getSize() + "个异常，请及时登录系统查看！<br>");
				emailcontext.append("&emsp;发自于基础数据同步系统(");
				emailcontext.append(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date()));
				emailcontext.append("),IP:" + IPUtil.getIp());
				logger.info("send email:context:" + emailcontext.toString());
				MailUtils.send(emailProp, notificationsVo.getRecive_email(),
						"ERROR!sync_code:" + notificationsVo.getSync_code(), emailcontext.toString(), "text/html");
				qc.setSync_code(notificationsVo.getSync_code());
			}
			qc.setIs_email(1);
			this.notificationsService.updateNotificationsforemail(qc);
		} else {
			logger.info("no new error!");
		}
		logger.info("timer-" + this.getClass() + "----end");
	}

}
