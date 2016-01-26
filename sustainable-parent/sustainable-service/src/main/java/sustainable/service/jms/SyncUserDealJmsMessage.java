/**   
* @Title: RegistDeal.java 
* @Package sustainable.service.jms 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月25日 下午5:30:42   
*/
package sustainable.service.jms;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.springframework.data.mongodb.core.MongoTemplate;
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
public class SyncUserDealJmsMessage extends DealJmsMessage {
    @Resource
    private MongoTemplate mongoTemplate;

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
    public SyncUserDealJmsMessage() {
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
        this.mongoTemplate.save(user);
    }
}
