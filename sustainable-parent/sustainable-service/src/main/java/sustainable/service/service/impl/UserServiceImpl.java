/**   
* @Title: UserService.java 
* @Package sustainable.service.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月22日 下午6:08:40   
*/
package sustainable.service.service.impl;

import javax.annotation.Resource;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsTemplate;

/**
 * @ClassName: UserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年1月22日 下午6:08:40
 * 
 */
public class UserServiceImpl {
    @Resource
    private JmsTemplate jmsTemplate;
    @Resource
    private ActiveMQTopic destination;

    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @author scc
     * @date 2016年1月22日 下午6:08:40
     */
    public UserServiceImpl() {
        // TODO Auto-generated constructor stub
    }

}
