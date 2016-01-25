/**   
* @Title: DealJmsMessage.java 
* @Package sustainable.common.util.jms 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月25日 下午5:27:13   
*/
package sustainable.common.util.jms;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * @ClassName: DealJmsMessage
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年1月25日 下午5:27:13
 * 
 */
public abstract class DealJmsMessage implements IDealJmsMessage {

    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @author scc
     * @date 2016年1月25日 下午5:27:13
     */
    public DealJmsMessage() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (非 Javadoc)
     * <p>Title: dealMessage</p>
     * <p>Description: </p>
     * 
     * @param objectMessage
     * 
     * @see sustainable.common.util.jms.IDealJmsMessage#dealMessage(javax.jms.ObjectMessage)
     */
    @Override
    public void dealMessage(ObjectMessage objectMessage, MessageConverter messageConverter)
            throws MessageConversionException, JMSException {
        // TODO Auto-generated method stub

    }

    /*
     * (非 Javadoc)
     * <p>Title: befforeMessage</p>
     * <p>Description: </p>
     * 
     * @see sustainable.common.util.jms.IDealJmsMessage#befforeMessage()
     */
    @Override
    public void befforeMessage() {
        // TODO Auto-generated method stub

    }

    /*
     * (非 Javadoc)
     * <p>Title: endMessage</p>
     * <p>Description: </p>
     * 
     * @see sustainable.common.util.jms.IDealJmsMessage#endMessage()
     */
    @Override
    public void endMessage() {
        // TODO Auto-generated method stub

    }

    /*
     * (非 Javadoc)
     * <p>Title: onException</p>
     * <p>Description: </p>
     * 
     * @param e
     * 
     * @see sustainable.common.util.jms.IDealJmsMessage#onException(java.lang.Exception)
     */
    @Override
    public void onException(Exception e) {
        // TODO Auto-generated method stub

    }
}
