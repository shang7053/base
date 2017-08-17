package com.voole.datasync.mapper.system.rule;

import java.util.List;

import com.voole.datasync.entry.sytem.rule.UserRuleEntry;
import com.voole.datasync.mapper.IBaseMapper;
import com.voole.datasync.vo.system.rule.UserRuleVo;

/**
 * @ClassName: IUserRuleMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月8日 上午9:58:47
 * 
 */
public interface IUserRuleMapper extends IBaseMapper {

	/**
	 * @Title: queryUserRule
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 上午10:15:36
	 * @param userRulequerycase
	 * @return
	 */
	List<UserRuleVo> queryUserRule(UserRuleVo userRulequerycase);

	/**
	 * @Title: deleteUserRule
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月18日 上午11:38:19
	 * @param urv
	 * @return
	 */
	Integer deleteUserRule(UserRuleVo urv);

	/**
	 * @Title: insertRuleFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月18日 上午11:38:36
	 * @param ure
	 * @return
	 */
	Integer insertUserRule(UserRuleEntry ure);

}
