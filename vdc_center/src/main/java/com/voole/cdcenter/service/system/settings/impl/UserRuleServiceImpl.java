package com.voole.cdcenter.service.system.settings.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.voole.cdcenter.entry.sytem.rule.UserRuleEntry;
import com.voole.cdcenter.mapper.system.rule.IUserRuleMapper;
import com.voole.cdcenter.service.system.settings.IUserRuleService;
import com.voole.cdcenter.vo.system.rule.UserRuleVo;

/**
 * @ClassName: UserRuleServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月18日 上午11:23:34
 * 
 */
@Service
public class UserRuleServiceImpl implements IUserRuleService {
	@Resource
	private IUserRuleMapper userRuleMapper;

	/*
	 * (非 Javadoc) <p>Title: deleteUserRule</p> <p>Description: </p>
	 * 
	 * @param urv
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.datacheck.service.system.settings.IUserRuleService#deleteUserRule(com.voole.datacheck.vo.system.rule.
	 * UserRuleVo)
	 */
	@Override
	public Boolean deleteUserRule(UserRuleVo urv) {
		return this.userRuleMapper.deleteUserRule(urv) > 0;
	}

	/*
	 * (非 Javadoc) <p>Title: insertRuleFunction</p> <p>Description: </p>
	 * 
	 * @param ure
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.datacheck.service.system.settings.IUserRuleService#insertRuleFunction(com.voole.datacheck.entry.sytem.
	 * rule.UserRuleEntry)
	 */
	@Override
	public Boolean insertUserRule(UserRuleEntry ure) {
		return this.userRuleMapper.insertUserRule(ure) > 0;
	}

	/*
	 * (非 Javadoc) <p>Title: queryUserRule</p> <p>Description: </p>
	 * 
	 * @param userRulequerycase
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.datacheck.service.system.settings.IUserRuleService#queryUserRule(com.voole.datacheck.vo.system.rule.
	 * UserRuleVo)
	 */
	@Override
	public List<UserRuleVo> queryUserRule(UserRuleVo userRulequerycase) {
		return this.userRuleMapper.queryUserRule(userRulequerycase);
	}

	/*
	 * (非 Javadoc) <p>Title: flushDbCache</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see com.voole.datasync.service.IBaseService#flushDbCache()
	 */
	@Override
	public Integer flushDbCache() {
		return this.userRuleMapper.flushDbCache();
	}
}
