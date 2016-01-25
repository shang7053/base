/**   
* @Title: NotifyMessageConverter.java 
* @Package sustainable.common.util.jms 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月22日 下午6:13:44   
*/
package sustainable.common.util.jms;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.log4j.Logger;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * @ClassName: NotifyMessageConverter
 * @Description: 消息转换器
 * @author scc
 * @param <T>
 * @date 2016年1月22日 下午6:13:44
 * 
 */
public class SustainableMessageConverter implements MessageConverter {

    private static final Logger LOGGER = Logger.getLogger(SustainableMessageConverter.class);

    @Override
    /**
     * 转换接收到的消息为NoticeInfo对象
     */
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        LOGGER.debug("Receive JMS message :" + message);
        if (message instanceof ObjectMessage) {
            ObjectMessage oMsg = (ObjectMessage) message;
            if (oMsg instanceof ActiveMQObjectMessage) {
                ActiveMQObjectMessage aMsg = (ActiveMQObjectMessage) oMsg;
                return aMsg.getObject();
                /*
                 * try {
                 * } catch (Exception e) {
                 * LOGGER.error("Message:${} is not a instance of NoticeInfo." + message.toString());
                 * throw new JMSException(
                 * "Message:" + message.toString() + "is not a instance of NoticeInfo." + message.toString());
                 * }
                 */
            } else {
                LOGGER.error("Message:${} is not a instance of ActiveMQObjectMessage." + message.toString());
                throw new JMSException("Message:" + message.toString() + "is not a instance of ActiveMQObjectMessage."
                        + message.toString());
            }
        } else {
            LOGGER.error("Message:${} is not a instance of ObjectMessage." + message.toString());
            throw new JMSException(
                    "Message:" + message.toString() + "is not a instance of ObjectMessage." + message.toString());
        }
    }

    @Override
    /**
     * 转换NoticeInfo对象到消息
     */
    public Message toMessage(Object obj, Session session) throws JMSException, MessageConversionException {
        LOGGER.debug("Convert Notify object to JMS message:${}" + obj);
        if (null != obj) {
            ActiveMQObjectMessage msg = (ActiveMQObjectMessage) session.createObjectMessage();
            msg.setObject((Serializable) obj);
            return msg;
        } else {
            LOGGER.debug("Convert Notify object to JMS message:${}" + obj.toString());
        }
        return null;
    }
}
