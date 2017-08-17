package com.voole.datasync.service.system.settings;

import java.util.List;

import com.voole.datasync.entry.sytem.rule.UserRuleEntry;
import com.voole.datasync.service.IBaseService;
import com.voole.datasync.vo.system.rule.UserRuleVo;

/**
 * @ClassName: IUserRuleService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月18日 上午11:17:37
 * 
 */
public interface IUserRuleService extends IBaseService {
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
	 * @date 2016年7月18日 上午11:36:44
	 * @param urv
	 */
	Boolean deleteUserRule(UserRuleVo urv);

	/**
	 * @Title: insertRuleFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月18日 上午11:36:55
	 * @param ure
	 */
	Boolean insertUserRule(UserRuleEntry ure);

}
