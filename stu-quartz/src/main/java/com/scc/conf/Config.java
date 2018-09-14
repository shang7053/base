package com.scc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @ClassName: XMLConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月6日 下午3:45:47
 * 
 */
@Configuration
public class Config {
	/**
	 * 
	 * @Title: schedulerFactoryBean
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author chengcai.shang@cmgplex.com
	 * @date 2018年9月14日 上午9:33:24
	 * @return
	 */
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		return new SchedulerFactoryBean();
	}
}
