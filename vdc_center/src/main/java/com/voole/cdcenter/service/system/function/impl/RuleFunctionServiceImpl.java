package com.voole.cdcenter.service.system.function.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.voole.cdcenter.entry.sytem.function.RuleFunctionEntry;
import com.voole.cdcenter.mapper.system.function.IRuleFunctionMapper;
import com.voole.cdcenter.service.system.function.IRuleFunctionService;
import com.voole.cdcenter.vo.system.function.RuleFunctionVo;

/**
 * @ClassName: RuleFunctionServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月15日 上午10:21:28
 * 
 */
@Service
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
