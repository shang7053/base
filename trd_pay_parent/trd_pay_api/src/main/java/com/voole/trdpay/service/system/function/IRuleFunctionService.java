package com.voole.trdpay.service.system.function;

import com.voole.trdpay.entry.sytem.function.RuleFunctionEntry;
import com.voole.trdpay.vo.system.function.RuleFunctionVo;

/**
 * @ClassName: IRuleFunctionService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月15日 上午10:21:09
 * 
 */
public interface IRuleFunctionService {

	/**
	 * @Title: insertRuleFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月15日 上午10:27:19
	 * @param rfe
	 */
	boolean insertRuleFunction(RuleFunctionEntry rfe);

	/**
	 * @Title: deleteRuleFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月15日 上午10:35:07
	 * @param rfv
	 */
	boolean deleteRuleFunction(RuleFunctionVo rfv);

}
