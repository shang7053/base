package com.voole.trdpay.mapper.system.rule;

import java.util.List;

import com.voole.trdpay.entry.sytem.rule.RuleEntry;
import com.voole.trdpay.vo.system.rule.RuleVo;

/**
 * @ClassName: RuleMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:32:34
 * 
 */
public interface IRuleMapper {

	/**
	 * @Title: queryRule
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 上午10:20:17
	 * @param rulequerycase
	 * @return
	 */
	List<RuleVo> queryRule(RuleVo rulequerycase);

	/**
	 * @Title: queryUserRulesCount
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月14日 下午2:06:14
	 * @param rulequerycase
	 * @return
	 */
	Integer queryUserRulesCount(RuleVo rulequerycase);

	/**
	 * @Title: updateRuleFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月15日 上午11:59:42
	 * @param rfe
	 * @return
	 */
	Integer updateRule(RuleEntry re);

	/**
	 * @Title: insertRule
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月15日 下午4:01:47
	 * @param re
	 * @return
	 */
	Integer insertRule(RuleEntry re);

}
