package com.voole.trdpay.vo.system.rule;

import java.io.Serializable;

import com.voole.trdpay.entry.sytem.rule.UserRuleEntry;
import com.voole.trdpay.vo.PageMessageVo;

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
	private PageMessageVo pmv;

	/**
	 * @return the pmv
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:11:26
	 */
	public PageMessageVo getPmv() {
		return this.pmv;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2017年5月24日 下午4:11:26
	 * @param pmv the pmv to set
	 */
	public void setPmv(PageMessageVo pmv) {
		this.pmv = pmv;
	}

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
