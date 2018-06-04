package com.scc.eureka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Retryer;

/**
 * @ClassName: FeignConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年5月21日 下午5:22:18
 * 
 */
@Configuration
public class FeignConfig {
	@Bean
	public Retryer feignRetryer() {
		return new Retryer.Default();
	}
}
