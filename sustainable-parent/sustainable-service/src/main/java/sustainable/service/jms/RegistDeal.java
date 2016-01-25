/**   
* @Title: RegistDeal.java 
* @Package sustainable.service.jms 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月25日 下午5:30:42   
*/
package sustainable.service.jms;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import sustainable.common.po.User;
import sustainable.common.util.jms.DealJmsMessage;

/**
 * @ClassName: RegistDeal
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年1月25日 下午5:30:42
 * 
 */
public class RegistDeal extends DealJmsMessage {

    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @author scc
     * @date 2016年1月25日 下午5:30:42
     */
    public RegistDeal() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (非 Javadoc)
     * <p>Title: dealMessage</p>
     * <p>Description: </p>
     * 
     * @param objectMessage
     * 
     * @see sustainable.common.util.jms.DealJmsMessage#dealMessage(javax.jms.ObjectMessage)
     */
    @Override
    public void dealMessage(ObjectMessage objectMessage, MessageConverter messageConverter)
            throws MessageConversionException, JMSException {
        User user = (User) messageConverter.fromMessage(objectMessage);
        System.out.println("uname:" + user.getUname());
        System.out.println("password:" + user.getPassword());
        System.out.println("model:" + objectMessage.getJMSDeliveryMode());
        System.out.println("destination:" + objectMessage.getJMSDestination());
        System.out.println("type:" + objectMessage.getJMSType());
        System.out.println("messageId:" + objectMessage.getJMSMessageID());
        System.out.println("time:" + objectMessage.getJMSTimestamp());
        System.out.println("expiredTime:" + objectMessage.getJMSExpiration());
        System.out.println("priority:" + objectMessage.getJMSPriority());
    }
}
