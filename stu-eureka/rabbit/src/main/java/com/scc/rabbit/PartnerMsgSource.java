package com.scc.rabbit;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @ClassName: MqMessageSource
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年5月22日 下午12:01:09
 * 
 */
public interface PartnerMsgSource {
	String MESSAGE_OUTPUT = "partner_sync_out";
	String ECM_SHOP_TEMPLATE_INPUT = "partner_sync";

	@Output(MESSAGE_OUTPUT)
	MessageChannel messageOutput();

	@Input(ECM_SHOP_TEMPLATE_INPUT)
	MessageChannel messageInput();
}
