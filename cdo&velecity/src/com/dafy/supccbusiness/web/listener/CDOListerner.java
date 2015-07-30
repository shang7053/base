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
	private static final Logger LOGGER=Logger.getLogger(CDOListerner.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		LOGGER.info("ServletContext销毁");
		LOGGER.info("获取BusinessService实例");
		BusinessService service = BusinessService.getInstance();
		if (service.isRunning() == false) {
			return;
		}
		LOGGER.info("停止LocalCache");
		LocalCache.getInstance().stop();
		LOGGER.info("停止BusinessService");
		service.stop();
		LOGGER.info("cdo 停止------------------------------");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		LOGGER.info("创建ServletContext");
		LOGGER.info("获取BusinessService实例");
		BusinessService service = BusinessService.getInstance();
		LOGGER.info("启动BusinessService");
		Return ret = service.start(SettingsPropertiesUtil.getProperties("servicebus_file"));
		if (ret.getCode() != 0) {
			LOGGER.error("BusinessService 启动失败!!! " + ret.getText());
			return;
		}
		LOGGER.info("BusinessService 启动成功------------------------------");
		LocalCache.getInstance().start();
		LOGGER.info("LocalCache 启动成功------------------------------");
		LOGGER.info("cdo 启动成功------------------------------");
	}

}
