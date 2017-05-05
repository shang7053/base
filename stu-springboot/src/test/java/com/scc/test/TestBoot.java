package com.scc.test;

import org.junit.Test;
import org.springframework.boot.SpringApplication;

import com.scc.SampleController;

/**
 * @ClassName: Test
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年5月5日 上午10:56:30
 * 
 */
public class TestBoot {

	@Test
	public void test() {
		SpringApplication.run(SampleController.class, new String[] {});
	}

}
