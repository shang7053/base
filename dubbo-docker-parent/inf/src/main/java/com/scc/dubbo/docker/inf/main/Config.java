package com.scc.dubbo.docker.inf.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.scc.dubbo.docker.api.util.PropertyUtil;

import net.bull.javamelody.MonitoringFilter;

/**
 * @ClassName: XMLConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月6日 下午3:45:47
 * 
 */
@Configuration
public class Config {
	@Bean
	public FilterRegistrationBean monitoringFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		MonitoringFilter monitoringFilter = new MonitoringFilter();
		registrationBean.setFilter(monitoringFilter);
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");
		registrationBean.setUrlPatterns(urlPatterns);
		registrationBean.setName("monitoring");
		return registrationBean;
	}

	@Bean
	public ApplicationConfig applicationConfig() {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName("inf");
		MonitorConfig monitorConfig = new MonitorConfig();
		monitorConfig.setProtocol("registry");
		applicationConfig.setMonitor(monitorConfig);
		return applicationConfig;
	}

	@Bean
	public ProtocolConfig protocolConfig() {
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("dubbo");
		protocol.setPort(PropertyUtil.getIntegerFromSystem("dubbo.port", 20880));
		return protocol;
	}

	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig registry = new RegistryConfig();
		registry.setProtocol("zookeeper");
		registry.setAddress(PropertyUtil.getStringFromSystem("dubbo.zk.address", "127.0.0.1:2181"));
		registry.setFile("./dubbo.cache");
		return registry;
	}
}
