/**   
* @Title: IUserService.java 
* @Package sustainable.service.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月22日 下午6:08:23   
*/
package sustainable.common.service;

import sustainable.common.po.User;

/**
 * @ClassName: IUserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年1月22日 下午6:08:23
 * 
 */
public interface DUserService {
    User addUser(User user);

    /**
     * @Title: validateRegist
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年1月26日 下午2:00:56
     * @param user
     * @return
     */
    User validateRegist(User user);
}
