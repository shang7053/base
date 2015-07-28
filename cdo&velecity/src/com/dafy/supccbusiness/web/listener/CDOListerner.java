package com.dafy.supccbusiness.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.cdoframework.cdolib.base.Return;
import com.cdoframework.cdolib.cache.LocalCache;
import com.dafy.supccbusiness.business.BusinessService;
import com.dafy.supccbusiness.util.SettingsPropertiesUtil;
/**
 * 加载配置文件
 * @author scc
 *
 */
public class CDOListerner implements ServletContextListener{
	private static Logger logger=Logger.getLogger(CDOListerner.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("ServletContext销毁");
		logger.info("获取BusinessService实例");
		BusinessService service = BusinessService.getInstance();
		if (service.isRunning() == false) {
			return;
		}
		logger.info("停止LocalCache");
		LocalCache.getInstance().stop();
		logger.info("停止BusinessService");
		service.stop();
		logger.info("cdo 停止------------------------------");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("创建ServletContext");
		logger.info("获取BusinessService实例");
		BusinessService service = BusinessService.getInstance();
		logger.info("启动BusinessService");
		Return ret = service.start(SettingsPropertiesUtil.getProperties("servicebus_file"));
		if (ret.getCode() != 0) {
			logger.error("BusinessService 启动失败!!! " + ret.getText());
			return;
		}
		logger.info("BusinessService 启动成功------------------------------");
		LocalCache.getInstance().start();
		logger.info("LocalCache 启动成功------------------------------");
		logger.info("cdo 启动成功------------------------------");
	}

}
