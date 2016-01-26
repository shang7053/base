/**   
* @Title: UserService.java 
* @Package sustainable.service.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月22日 下午6:08:40   
*/
package sustainable.service.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.alibaba.dubbo.config.annotation.Service;

import sustainable.common.po.User;
import sustainable.common.service.DUserService;
import sustainable.service.dao.IUserdao;

/**
 * @ClassName: UserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年1月22日 下午6:08:40
 * 
 */
@Service
public class DUserServiceImpl implements DUserService {
    @Resource
    private IUserdao userdao;
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
     * @date 2016年1月22日 下午6:08:40
     */
    public DUserServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (非 Javadoc)
     * <p>Title: addUser</p>
     * <p>Description: </p>
     * 
     * @param user
     * 
     * @see sustainable.service.service.IUserService#addUser(sustainable.common.po.User)
     */
    @Override
    public User addUser(User user) {
        this.userdao.insertUser(user);
        return user;
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
     * @see sustainable.common.service.DUserService#validateRegist(sustainable.common.po.User)
     */
    @Override
    public User validateRegist(User user) {
        List<User> users = this.mongoTemplate.find(
                new Query(Criteria.where("uname").is(user.getUname()).and("password").is(user.getPassword())),
                User.class);
        if (null != users && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

}
