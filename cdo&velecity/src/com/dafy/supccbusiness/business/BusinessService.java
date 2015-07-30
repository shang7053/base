package com.dafy.supccbusiness.business;

import javax.xml.bind.PropertyException;

import org.apache.log4j.Logger;

import com.cdoframework.cdolib.base.Return;
import com.cdoframework.cdolib.base.Utility;
import com.cdoframework.cdolib.business.ServiceClient;
import com.cdoframework.cdolib.data.cdo.CDO;
import com.cdoframework.cdolib.servicebus.ServiceBus;
import com.dafy.supccbusiness.util.SettingsPropertiesUtil;

/**
 * BusinessService
 * 
 * @author scc
 * 
 */
public final class BusinessService {
	private static final Logger LOGGER = Logger.getLogger(BusinessService.class);
	private static BusinessService instance = new BusinessService();

	public static BusinessService getInstance() {
		return instance;
	}

	private ServiceBus serviceBus;
	private ServiceClient serviceClient;

	public boolean isRunning() {
		return this.serviceBus.isRunning();
	}

	public Return start(String strConfigResource) {
		LOGGER.info("加载serviceBus配置文件");
		String strBusinessServiceBusXML = Utility.readTextResource(
				strConfigResource, "utf-8",
				BusinessService.class.getClassLoader());
		LOGGER.info("初始化serviceBus");
		Return ret = this.serviceBus.init(strBusinessServiceBusXML,
				BusinessService.class.getClassLoader());
		if (ret.getCode() != 0) {
			return ret;
		}
		LOGGER.info("启动serviceBus");
		ret = this.serviceBus.start();
		if (ret.getCode() != 0) {
			serviceBus.destroy();
			return ret;
		}
		return Return.OK;
	}

	public void stop() {
		LOGGER.info("停止serviceBus");
		this.serviceBus.stop();
		LOGGER.info("销毁serviceBus");
		this.serviceBus.destroy();
	}

	public Return handleTrans(CDO cdoRequest, CDO cdoResponse) {
		return this.serviceClient.handleTrans(cdoRequest, cdoResponse);
	}

	private BusinessService() {
		this.serviceBus = new ServiceBus();
		String localcache_file = SettingsPropertiesUtil
				.getProperties("localcache_file");
		if (null == localcache_file) {
			try {
				throw new PropertyException("缓存文件路径不能为空localcache.xml");
			} catch (Exception e) {
				LOGGER.error("缓存文件路径不能为空localcache.xml");
				LOGGER.error(e);
				e.printStackTrace();
			}
		}
		LOGGER.info("构造serviceClient，缓存文件路径" + localcache_file);
		this.serviceClient = new ServiceClient(serviceBus, localcache_file,
				"utf-8", BusinessService.class.getClassLoader());
	}
}
