package com.scc.dubbo.docker.inf.main;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.scc.dubbo.docker.api.util.IPUtil;

/**
 * @ClassName: Application
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月7日 上午9:50:19
 * 
 */
@SpringBootApplication(scanBasePackages = "com.scc.dubbo.docker.inf")
@DubboComponentScan("com.scc.dubbo.docker.inf")
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		String remoteAddr = IPUtil.getIp();
		MDC.put("ip", remoteAddr);
		SpringApplication.run(Application.class, args);
		LOGGER.info("started……");
	}
}
