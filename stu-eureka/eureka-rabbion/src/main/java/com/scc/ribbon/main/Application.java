package com.scc.ribbon.main;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: Application
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年5月21日 下午4:09:07
 * 
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class Application {
	@Resource
	private RestTemplate restTemplatel;

	@RequestMapping("go")
	public String go() {
		return this.restTemplatel.getForEntity("http://eureka-client/hi", String.class).getBody();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
