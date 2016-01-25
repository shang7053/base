/**   
* @Title: QueueMessageProducer.java 
* @Package sustainable.common.util.jms 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月22日 下午6:13:02   
*/
package sustainable.common.util.jms;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * @ClassName: QueueMessageProducer
 * @Description: 消息生产者服务类
 * @author scc
 * @date 2016年1月22日 下午6:13:02
 * 
 */
public class QueueMessageProducer<T> {
    private JmsTemplate jmsTemplate;
    private Destination queue;
    private MessageConverter messageConverter;

    public void sendQueue(T t) {
        this.jmsTemplate.setMessageConverter(this.messageConverter);
        this.jmsTemplate.setPubSubDomain(false);
        this.jmsTemplate.convertAndSend(this.queue, t);
    }

    /**
     * @return the jmsTemplate
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月25日 下午5:07:35
     */
    public JmsTemplate getJmsTemplate() {
        return this.jmsTemplate;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月25日 下午5:07:35
     * @param jmsTemplate the jmsTemplate to set
     */
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    /**
     * @return the queue
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月25日 下午5:07:35
     */
    public Destination getQueue() {
        return this.queue;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月25日 下午5:07:35
     * @param queue the queue to set
     */
    public void setQueue(Destination queue) {
        this.queue = queue;
    }

    /**
     * @return the messageConverter
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月25日 下午5:07:35
     */
    public MessageConverter getMessageConverter() {
        return this.messageConverter;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月25日 下午5:07:35
     * @param messageConverter the messageConverter to set
     */
    public void setMessageConverter(MessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }

}
