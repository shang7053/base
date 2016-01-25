/**   
* @Title: IDealJmsMessage.java 
* @Package sustainable.common.util.jms 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月25日 下午5:21:14   
*/
package sustainable.common.util.jms;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * @ClassName: IDealJmsMessage
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年1月25日 下午5:21:14
 * 
 */
interface IDealJmsMessage {
    /**
     * 
     * @Title: dealMessage
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年1月25日 下午5:31:25
     * @param objectMessage
     * @param messageConverter
     * @throws JMSException
     * @throws MessageConversionException
     */
    void dealMessage(ObjectMessage objectMessage, MessageConverter messageConverter)
            throws MessageConversionException, JMSException;

    /**
     * 
     * @Title: befforeMessage
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年1月25日 下午5:31:28
     */
    void befforeMessage();

    /**
     * 
     * @Title: endMessage
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年1月25日 下午5:31:31
     */
    void endMessage();

    /**
     * 
     * @Title: onException
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年1月25日 下午5:31:34
     * @param e
     */
    void onException(Exception e);
}
