package com.scc.main;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试类不要放到测试包下，否则加载不到业务代码。
 * 
 * @ClassName: SCtest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年5月21日 下午2:55:46
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SCtest {
	@LocalServerPort
	private int port;
	private URL base;
	@Autowired
	private TestRestTemplate template;

	/**
	 * @Title: printresult
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2018年5月21日 下午3:30:34
	 */
	private void printresult() {
		ResponseEntity<String> response = this.template.getForEntity(this.base.toString(), String.class);
		System.out.println(response.getBody());
	}

	@Test
	public void gethello() throws MalformedURLException {
		this.base = new URL("http://localhost:" + this.port + "/test/hello");
		this.printresult();
	}

	@Test
	public void gethello2() throws MalformedURLException {
		this.base = new URL("http://localhost:" + this.port + "/test/hello2");
		this.printresult();
	}

	@Test
	public void gethello3() throws MalformedURLException {
		this.base = new URL("http://localhost:" + this.port + "/test/hello3");
		this.printresult();
	}

	@Test
	public void gethello4() throws MalformedURLException {
		this.base = new URL("http://localhost:" + this.port + "/test/hello4");
		this.printresult();
	}
}
