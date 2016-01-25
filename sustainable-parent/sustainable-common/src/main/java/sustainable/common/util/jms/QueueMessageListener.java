/**   
* @Title: QueueMessageListener.java 
* @Package sustainable.common.util.jms 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月22日 下午6:16:30   
*/
package sustainable.common.util.jms;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.log4j.Logger;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * @ClassName: QueueMessageListener
 * @Description:接收消息
 * @author scc
 * @date 2016年1月22日 下午6:16:30
 * 
 */
public class QueueMessageListener implements MessageListener {

    private static Logger logger = Logger.getLogger(QueueMessageListener.class);
    @Resource
    private MessageConverter messageConverter;

    @Resource
    private IDealJmsMessage dealJmsMessage;

    /**
     * 接收消息
     */
    @Override
    public void onMessage(Message message) {
        this.dealJmsMessage.befforeMessage();
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            this.dealJmsMessage.dealMessage(objectMessage, this.messageConverter);
        } catch (Exception e) {
            this.dealJmsMessage.onException(e);
            logger.error("处理信息时发生异常", e);
        }
        this.dealJmsMessage.endMessage();
    }

    /**
     * @return the dealJmsMessage
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月25日 下午5:28:21
     */
    public IDealJmsMessage getDealJmsMessage() {
        return this.dealJmsMessage;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2016年1月25日 下午5:28:21
     * @param dealJmsMessage the dealJmsMessage to set
     */
    public void setDealJmsMessage(IDealJmsMessage dealJmsMessage) {
        this.dealJmsMessage = dealJmsMessage;
    }
}
