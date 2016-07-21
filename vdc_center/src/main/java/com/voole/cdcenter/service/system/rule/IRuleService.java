package com.voole.cdcenter.service.system.rule;

import java.util.List;

import com.voole.cdcenter.entry.sytem.rule.RuleEntry;
import com.voole.cdcenter.vo.system.rule.RuleVo;

/**
 * @ClassName: RuleMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:32:34
 * 
 */
public interface IRuleService {

	/**
	 * @Title: queryUserRules
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 上午9:54:31
	 * @param rulequerycase
	 * @return
	 */
	List<RuleVo> queryUserRules(RuleVo rulequerycase);

	/**
	 * @Title: queryUserRulesCount
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月14日 下午2:05:31
	 * @param rulequerycase
	 * @return
	 */
	Integer queryUserRulesCount(RuleVo rulequerycase);

	/**
	 * @Title: updateRule
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月15日 下午12:18:49
	 * @param re
	 * @return
	 */
	boolean updateRule(RuleEntry re);

	/**
	 * @Title: insertRule
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月15日 下午4:00:58
	 * @param re
	 * @return
	 */
	Integer insertRule(RuleEntry re);

	/**
	 * @Title: queryRule
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月15日 下午4:19:59
	 * @param rulequerycase
	 * @return
	 */
	List<RuleVo> queryRule(RuleVo rulequerycase);

}
