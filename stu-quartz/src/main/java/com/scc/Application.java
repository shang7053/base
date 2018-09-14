package com.scc;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scc.demojob.DemoJob;
import com.scc.quartz.IQuartzManager;

/**
 * @ClassName: Application
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月7日 上午9:50:19
 * 
 */
@SpringBootApplication
@Controller
public class Application {
	@Resource
	private IQuartzManager quartzManager;

	@RequestMapping("/start")
	@ResponseBody
	public String testStart() {
		Map<String, Object> args = new HashMap<>();
		args.put("args1", "args1");
		args.put("args2", "args2");
		args.put("args3", "args3");
		args.put("args4", "args4");
		this.quartzManager.addAndStartJob("test", DemoJob.class, 0, 5, args);
		return "success";
	}

	@RequestMapping("/stop")
	@ResponseBody
	public String testStop() {
		this.quartzManager.deleteJob("test");
		return "success";
	}

	@RequestMapping("/killSelf")
	@ResponseBody
	public String testKillSelf() {
		Map<String, Object> args = new HashMap<>();
		args.put("quartzManager", this.quartzManager);
		this.quartzManager.addAndStartJob("test", DemoJob.class, 0, 5, args);
		return "success";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
