package com.scc.dubbo.docker.inf.rc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping(value = "map")
	@ResponseBody
	public String map(HttpServletRequest request) throws DocumentException, IOException {
		Map<String, String> map = this.getMapFromRequest(request);
		return map.toString();
	}

	/**
	 * @Title: getMapFromRequest
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2018年2月6日 上午9:52:26
	 * @param request
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	private Map<String, String> getMapFromRequest(HttpServletRequest request) throws DocumentException, IOException {
		Map<String, String> map = new HashMap<String, String>();
		String xmlstr = this.convertStreamToString(request.getInputStream());
		System.out.println(xmlstr);
		Document doc = DocumentHelper.parseText(xmlstr);
		Element root = doc.getRootElement();
		List<Element> list = root.elements();
		for (Element ele : list) {
			map.put(ele.getName(), ele.getText());
		}
		return map;
	}

	public String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
