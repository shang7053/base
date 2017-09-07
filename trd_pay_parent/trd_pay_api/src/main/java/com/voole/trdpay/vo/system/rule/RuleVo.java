package com.voole.trdpay.vo.system.rule;

import java.io.Serializable;
import java.util.Arrays;

import com.voole.trdpay.entry.sytem.rule.RuleEntry;
import com.voole.trdpay.util.IPage;
import com.voole.trdpay.vo.PageMessageVo;

/**
 * @ClassName: Rule
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午1:46:02
 * 
 */
public class RuleVo extends RuleEntry implements Serializable, IPage {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 上午9:54:05
	 */
	private static final long serialVersionUID = -1747222621533922924L;
	private Integer uid;
	private Integer[] rids;
	private PageMessageVo pmv;

	/**
	 * @return the uid
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:54:01
	 */
	public Integer getUid() {
		return this.uid;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:54:01
	 * @param uid the uid to set
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**
	 * @return the rids
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午10:14:58
	 */
	public Integer[] getRids() {
		return this.rids;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午10:14:58
	 * @param rids the rids to set
	 */
	public void setRids(Integer[] rids) {
		this.rids = rids;
	}

	/**
	 * @return the pmv
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午2:10:19
	 */
	@Override
	public PageMessageVo getPmv() {
		return this.pmv;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午2:10:19
	 * @param pmv the pmv to set
	 */
	@Override
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
		return "RuleVo [uid=" + this.uid + ", rids=" + Arrays.toString(this.rids) + ", pmv=" + this.pmv + ", rid="
				+ this.rid + ", rname=" + this.rname + ", is_on=" + this.is_on + ", is_recive_notice="
				+ this.is_recive_notice + ", create_time=" + this.create_time + ", update_time=" + this.update_time
				+ ", version=" + this.version + "]";
	}

}
