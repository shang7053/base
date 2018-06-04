package com.scc.rabbit;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * @ClassName: MqMessageConsumer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年5月22日 下午12:02:19
 * 
 */
@EnableBinding(PartnerMsgSource.class)
public class PartnerMsgSourceConsumer {

	@StreamListener(PartnerMsgSource.ECM_SHOP_TEMPLATE_INPUT)
	public void receive(Message<String> message) {
		System.out.println(message.getPayload());
	}
}
