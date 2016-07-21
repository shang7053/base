package com.voole.cdcenter.mapper.system.function;

import java.util.List;

import com.voole.cdcenter.entry.sytem.function.RuleFunctionEntry;
import com.voole.cdcenter.vo.system.function.RuleFunctionVo;

/**
 * @ClassName: IRuleFunctionMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月8日 上午11:03:09
 * 
 */
public interface IRuleFunctionMapper {

	/**
	 * @Title: queryRuleFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 上午11:09:41
	 * @param ruleFunctionquerycase
	 * @return
	 */
	List<RuleFunctionVo> queryRuleFunction(RuleFunctionVo ruleFunctionquerycase);

	/**
	 * @Title: insertRuleFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月15日 上午10:28:02
	 * @param rfe
	 * @return
	 */
	Integer insertRuleFunction(RuleFunctionEntry rfe);

	/**
	 * @Title: deleteRuleFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月15日 上午10:35:57
	 * @param rfv
	 * @return
	 */
	Integer deleteRuleFunction(RuleFunctionVo rfv);

}
