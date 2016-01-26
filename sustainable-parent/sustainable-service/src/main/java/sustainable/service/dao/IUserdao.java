/**   
* @Title: IUserdao.java 
* @Package sustainable.service.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月26日 上午9:32:52   
*/
package sustainable.service.dao;

import sustainable.common.po.User;

/**
 * @ClassName: IUserdao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年1月26日 上午9:32:52
 * 
 */
public interface IUserdao {
    Integer insertUser(User user);

    /**
     * @Title: findUserByUnameAndPass
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年1月26日 下午2:01:46
     * @param user
     * @return
     */
    User findUserByUnameAndPass(User user);
}
