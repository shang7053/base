package com.voole.datasync.service.system.rule.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.dubbo.config.annotation.Service;
import com.voole.datasync.entry.sytem.rule.RuleEntry;
import com.voole.datasync.mapper.system.rule.IRuleMapper;
import com.voole.datasync.mapper.system.rule.IUserRuleMapper;
import com.voole.datasync.service.system.rule.IRuleService;
import com.voole.datasync.util.ListUtils;
import com.voole.datasync.vo.system.rule.RuleVo;
import com.voole.datasync.vo.system.rule.UserRuleVo;

/**
 * @ClassName: IRuleServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:38:53
 * 
 */
@Service(timeout = 1200000)
@Repository
public class RuleServiceImpl implements IRuleService {
	@Resource
	private IRuleMapper ruleMapper;
	@Resource
	private IUserRuleMapper userRuleMapper;

	/*
	 * (非 Javadoc) <p>Title: queryUserRules</p> <p>Description: </p>
	 * 
	 * @param rulequerycase
	 * 
	 * @return
	 * 
	 * @see com.voole.cdcenter.service.system.rule.IRuleService#queryUserRules(com.voole.cdcenter.vo.system.rule.RuleVo)
	 */
	@Override
	public List<RuleVo> queryUserRules(RuleVo rulequerycase) {
		UserRuleVo userRulequerycase = new UserRuleVo();
		userRulequerycase.setUid(rulequerycase.getUid());
		List<UserRuleVo> userRuleVos = this.userRuleMapper.queryUserRule(userRulequerycase);
		if (null != userRuleVos) {
			Integer[] rids = ListUtils.getTargetForIntegerArray(userRuleVos, "rid");
			rulequerycase.setRids(rids);
			return this.ruleMapper.queryRule(rulequerycase);
		}
		return null;
	}

	/*
	 * (非 Javadoc) <p>Title: queryUserRulesCount</p> <p>Description: </p>
	 * 
	 * @param rulequerycase
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.cdcenter.service.system.rule.IRuleService#queryUserRulesCount(com.voole.cdcenter.vo.system.rule.RuleVo)
	 */
	@Override
	public Integer queryUserRulesCount(RuleVo rulequerycase) {
		return this.ruleMapper.queryUserRulesCount(rulequerycase);
	}

	/*
	 * (非 Javadoc) <p>Title: updateRule</p> <p>Description: </p>
	 * 
	 * @param re
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.cdcenter.service.system.rule.IRuleService#updateRule(com.voole.cdcenter.entry.sytem.rule.RuleEntry)
	 */
	@Override
	public boolean updateRule(RuleEntry re) {
		if (this.ruleMapper.updateRule(re) > 0) {
			this.userRuleMapper.flushDbCache();
			return true;
		}
		return false;
	}

	/*
	 * (非 Javadoc) <p>Title: insertRule</p> <p>Description: </p>
	 * 
	 * @param re
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.cdcenter.service.system.rule.IRuleService#insertRule(com.voole.cdcenter.entry.sytem.rule.RuleEntry)
	 */
	@Override
	public Integer insertRule(RuleEntry re) {
		if (this.ruleMapper.insertRule(re) > 0) {
			this.userRuleMapper.flushDbCache();
			return re.getRid();
		}
		return null;
	}

	/*
	 * (非 Javadoc) <p>Title: queryRule</p> <p>Description: </p>
	 * 
	 * @param rulequerycase
	 * 
	 * @return
	 * 
	 * @see com.voole.cdcenter.service.system.rule.IRuleService#queryRule(com.voole.cdcenter.vo.system.rule.RuleVo)
	 */
	@Override
	public List<RuleVo> queryRule(RuleVo rulequerycase) {
		return this.ruleMapper.queryRule(rulequerycase);
	}

}
