package com.scc.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
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
@EnableBinding(PartnerMsgSource.class)
@RestController
public class Application {
	@Value("${server.port}")
	private int port;

	@Autowired
	@Output(PartnerMsgSource.MESSAGE_OUTPUT)
	private MessageChannel channel;

	@RequestMapping("hi")
	public String hi() {
		this.channel.send(MessageBuilder.withPayload("{\"age\":10,\"name\":\"scc\"}").build());
		return "success";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
