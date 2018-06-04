package com.scc.main;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: TestConctoller
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年5月21日 下午2:51:19
 * 
 */
@Api("测试controller")
@RestController
@RequestMapping("/test")
public class TestConctoller {
	@Value("${my.name}")
	private String name;
	@Resource
	private Config config;
	@Resource
	private TestConfig testConfig;

	@ApiOperation("测试方法1")
	@GetMapping("hello")
	public String hello() {
		return "hello!";
	}

	@RequestMapping("hello2")
	public String hello2() {
		return "hello!" + this.name;
	}

	@RequestMapping("hello3")
	public String hello3() {
		return this.config.toString();
	}

	@RequestMapping("hello4")
	public String hello4() {
		return this.testConfig.toString();
	}

}
