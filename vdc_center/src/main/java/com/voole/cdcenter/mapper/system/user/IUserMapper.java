package com.voole.cdcenter.mapper.system.user;

import java.util.List;

import com.voole.cdcenter.entry.sytem.user.UserEntry;
import com.voole.cdcenter.vo.system.user.UserVo;

/**
 * @ClassName: UserMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:33:18
 * 
 */
public interface IUserMapper {

	/**
	 * @Title: queryUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午3:30:38
	 * @param querycase
	 * @return
	 */
	List<UserVo> queryUser(UserVo querycase);

	/**
	 * @Title: updateUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午3:37:48
	 * @param loginUser
	 * @return
	 */
	Integer updateUser(UserEntry loginUser);

	/**
	 * @Title: queryUserCount
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月14日 下午3:34:02
	 * @param userquerycase
	 * @return
	 */
	Integer queryUserCount(UserVo userquerycase);

	/**
	 * @Title: insertUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月18日 下午2:57:25
	 * @param ue
	 * @return
	 */
	Integer insertUser(UserEntry ue);

}
