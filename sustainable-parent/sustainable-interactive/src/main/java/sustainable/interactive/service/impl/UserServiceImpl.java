/**   
* @Title: UserServiceImpl.java 
* @Package sustainable.interactive.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月22日 下午6:01:21   
*/
package sustainable.interactive.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.dubbo.config.annotation.Reference;

import scc.util.SccUtilFactory;
import scc.util.cache.ICache;
import scc.util.cache.data.CacheData;
import sustainable.common.po.User;
import sustainable.common.service.DUserService;
import sustainable.common.util.jms.PhoneNoticeInfo;
import sustainable.common.util.jms.QueueMessageProducer;
import sustainable.interactive.service.IUserService;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年1月22日 下午6:01:21
 * 
 */
@Repository
public class UserServiceImpl implements IUserService {
    @Resource
    private QueueMessageProducer<User> registQueueMessageProducer;
    @Reference
    private DUserService dUserService;

    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @author scc
     * @date 2016年1月22日 下午6:01:21
     */
    public UserServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (非 Javadoc)
     * <p>Title: regist</p>
     * <p>Description: </p>
     * 
     * @param user
     * 
     * @see sustainable.interactive.service.IUserService#regist(sustainable.interactive.vo.User)
     */
    @Override
    public void regist(User user) {
        PhoneNoticeInfo noticeInfo = new PhoneNoticeInfo();
        noticeInfo.setNoticeContent("Hello Word");
        noticeInfo.setNoticeTitle("hello Word");
        noticeInfo.setReceiver("hello");
        noticeInfo.setReceiverPhone("1111111");
        this.registQueueMessageProducer.sendQueue(user);
    }

    /*
     * (非 Javadoc)
     * <p>Title: validateRegist</p>
     * <p>Description: </p>
     * 
     * @param user
     * 
     * @return
     * 
     * @see sustainable.interactive.service.IUserService#validateRegist(sustainable.interactive.vo.User)
     */
    @Override
    public boolean validateRegist(User user) {
        user = this.dUserService.validateRegist(user);
        if (user == null) {
            return false;
        }
        ICache cache = SccUtilFactory.instanceCache();
        cache.addCacheData("login:" + user, new CacheData(user));
        return true;
    }

    /*
     * (非 Javadoc)
     * <p>Title: login</p>
     * <p>Description: </p>
     * 
     * @param user
     * 
     * @return
     * 
     * @see sustainable.interactive.service.IUserService#login(sustainable.common.po.User)
     */
    @Override
    public User login(User user) {
        ICache cache = SccUtilFactory.instanceCache();
        if (cache.hasCacheData("login:" + user)) {
            return (User) cache.getCacheData("login:" + user);
        } else {
            user = this.dUserService.validateRegist(user);
            if (null != user) {
                cache.addCacheData("login:" + user, new CacheData(user));
                return user;
            }
        }
        return null;
    }

}
