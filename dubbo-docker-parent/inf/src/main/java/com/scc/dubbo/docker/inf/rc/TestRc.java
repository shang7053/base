package com.scc.dubbo.docker.inf.rc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.scc.dubbo.docker.api.service.ITestService;
import com.scc.dubbo.docker.api.util.IPUtil;

/**
 * @ClassName: TestRc
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年2月2日 下午1:09:06
 * 
 */
@RestController
@RequestMapping("test")
public class TestRc {
	@Reference
	private ITestService testService;

	@RequestMapping("hello")
	@ResponseBody
	public String hello() {
		return this.testService.test("inf run on " + IPUtil.getIp());
	}

}
