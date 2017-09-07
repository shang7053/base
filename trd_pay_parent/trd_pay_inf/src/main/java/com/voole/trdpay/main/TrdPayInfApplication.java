package com.voole.trdpay.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import net.bull.javamelody.MonitoringFilter;

/**
 * @ClassName: Application
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月7日 上午9:50:19
 * 
 */
@SpringBootApplication
public class TrdPayInfApplication {
	public static void main(String[] args) {
		SpringApplication.run(TrdPayInfApplication.class, args);
	}

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
}
