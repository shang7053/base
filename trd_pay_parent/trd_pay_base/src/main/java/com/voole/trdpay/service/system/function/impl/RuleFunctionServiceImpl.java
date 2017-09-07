package com.voole.trdpay.service.system.function.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.voole.trdpay.entry.sytem.function.RuleFunctionEntry;
import com.voole.trdpay.mapper.system.function.IRuleFunctionMapper;
import com.voole.trdpay.service.system.function.IRuleFunctionService;
import com.voole.trdpay.vo.system.function.RuleFunctionVo;

/*
import com.voole.trdpay.service.system.function.IRuleFunctionService;
import com.voole.trdpay.vo.system.function.RuleFunctionVo;*
 * @ClassName: RuleFunctionServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月15日 上午10:21:28
 * 
 */
@Service(timeout = 1200000)
public class RuleFunctionServiceImpl implements IRuleFunctionService {
	@Resource
	private IRuleFunctionMapper ruleFunctionMapper;

	/*
	 * (非 Javadoc) <p>Title: insertRuleFunction</p> <p>Description: </p>
	 * 
	 * @param rfe
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.cdcenter.service.system.function.IRuleFunctionService#insertRuleFunction(com.voole.cdcenter.entry.sytem
	 * .function.RuleFunctionEntry)
	 */
	@Override
	public boolean insertRuleFunction(RuleFunctionEntry rfe) {
		return this.ruleFunctionMapper.insertRuleFunction(rfe) > 0;
	}

	/*
	 * (非 Javadoc) <p>Title: deleteRuleFunction</p> <p>Description: </p>
	 * 
	 * @param rfe
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.cdcenter.service.system.function.IRuleFunctionService#deleteRuleFunction(com.voole.cdcenter.entry.sytem
	 * .function.RuleFunctionEntry)
	 */
	@Override
	public boolean deleteRuleFunction(RuleFunctionVo rfv) {
		return this.ruleFunctionMapper.deleteRuleFunction(rfv) > 0;
	}

}
