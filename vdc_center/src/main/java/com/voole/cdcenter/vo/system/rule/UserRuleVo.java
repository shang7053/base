package com.voole.cdcenter.vo.system.rule;

import java.io.Serializable;

import com.voole.cdcenter.entry.sytem.rule.UserRuleEntry;

/**
 * @ClassName: UserRuleVo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月8日 上午9:58:01
 * 
 */
public class UserRuleVo extends UserRuleEntry implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 上午9:58:16
	 */
	private static final long serialVersionUID = -7706331329141565456L;

	/*
	 * (非 Javadoc) <p>Title: toString</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserRuleVo [id=" + this.id + ", uid=" + this.uid + ", rid=" + this.rid + ", is_on=" + this.is_on
				+ ", create_time=" + this.create_time + ", update_time=" + this.update_time + ", version="
				+ this.version + "]";
	}
}
