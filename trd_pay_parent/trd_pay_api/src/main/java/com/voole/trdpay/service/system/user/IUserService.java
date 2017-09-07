package com.voole.trdpay.service.system.user;

import java.util.List;

import com.voole.trdpay.entry.sytem.user.UserEntry;
import com.voole.trdpay.vo.system.user.UserVo;

/**
 * @ClassName: UserMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:33:18
 * 
 */
public interface IUserService {

	/**
	 * @Title: queryUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午3:27:05
	 * @param username
	 * @return
	 */
	List<UserVo> queryUser(UserVo loginUser);

	/**
	 * @Title: updateUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午5:49:56
	 * @param ue
	 */
	Boolean updateUser(UserEntry ue);

	/**
	 * @Title: queryUserCount
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月14日 下午3:32:32
	 * @param userquerycase
	 * @return
	 */
	Integer queryUserCount(UserVo userquerycase);

	/**
	 * @Title: insertUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月18日 下午2:55:52
	 * @param ue
	 * @return
	 */
	Integer insertUser(UserEntry ue);

}
