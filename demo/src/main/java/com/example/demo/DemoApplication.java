package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;

@RestController
@SpringBootApplication
@DisconfFile(filename = "test.properties")
public class DemoApplication {
	private static final Logger LOGGER = Logger.getLogger(DemoApplication.class);
	@Autowired
	private DemoInfoRepository demoInfoRepository;
	private String host;
	private AutoService autoService;

	/**
	 * @return the host
	 * @author shangchengcai@voole.com
	 * @date 2017年9月6日 下午5:03:12
	 */
	@DisconfFileItem(name = "host")
	public String getHost() {
		return this.host;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping(value = "/")
	String index() {
		LOGGER.info("by log4j");
		DemoInfo demoInfo = new DemoInfo();
		demoInfo.setName("张三");
		demoInfo.setAge(20);
		this.demoInfoRepository.save(demoInfo);
		demoInfo = new DemoInfo();
		demoInfo.setName("李四");
		demoInfo.setAge(30);
		this.demoInfoRepository.save(demoInfo);

		return this.demoInfoRepository.findByName("张三").toString();
	}

	@RequestMapping(value = "/conf")
	String conf() {
		return this.host;
	}
}
