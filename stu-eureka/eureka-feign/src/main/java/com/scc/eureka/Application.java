package com.scc.eureka;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: Application
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年5月21日 下午4:09:07
 * 
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
@EnableHystrixDashboard
@EnableHystrix
public class Application {
	@Resource
	private IApi api;

	@RequestMapping("go")
	public String go() {
		return this.api.go();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
