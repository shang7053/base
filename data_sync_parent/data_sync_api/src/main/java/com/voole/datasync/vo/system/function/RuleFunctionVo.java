package com.voole.datasync.vo.system.function;

import java.io.Serializable;
import java.util.Arrays;

import com.voole.datasync.entry.sytem.function.RuleFunctionEntry;
import com.voole.datasync.vo.PageMessageVo;

/**
 * @ClassName: RuleFunctionVo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月8日 上午11:02:18
 * 
 */
public class RuleFunctionVo extends RuleFunctionEntry implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 上午11:02:30
	 */
	private static final long serialVersionUID = 5003767351724302910L;
	private Integer[] rids;
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

	/**
	 * @return the rids
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:05:56
	 */
	public Integer[] getRids() {
		return this.rids;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:05:56
	 * @param rids the rids to set
	 */
	public void setRids(Integer[] rids) {
		this.rids = rids;
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
		return "RuleFunctionVo [rids=" + Arrays.toString(this.rids) + ", id=" + this.id + ", rid=" + this.rid + ", fid="
				+ this.fid + ", is_on=" + this.is_on + ", create_time=" + this.create_time + ", update_time="
				+ this.update_time + ", version=" + this.version + "]";
	}
}
