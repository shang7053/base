/**   
* @Title: IUserService.java 
* @Package sustainable.interactive.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月22日 下午6:01:03   
*/
package sustainable.interactive.service;

import sustainable.common.po.User;

/**
 * @ClassName: IUserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年1月22日 下午6:01:03
 * 
 */
public interface IUserService {

    /**
     * @Title: regist
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年1月22日 下午6:02:39
     * @param user
     */
    void regist(User user);

    /**
     * @Title: validateRegist
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年1月25日 下午5:59:28
     * @param user
     * @return
     */
    boolean validateRegist(User user);

    /**
     * @Title: login
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年1月25日 下午7:01:03
     * @param user
     * @return
     */
    User login(User user);

}
