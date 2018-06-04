package com.scc.eureka.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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
@RestController
public class Application {
	@Value("${server.port}")
	private int port;

	@RequestMapping("hi")
	public String hi() {
		return "this port is " + this.port;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
