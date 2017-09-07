package com.voole.trdpay.vo.system.function;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.voole.trdpay.entry.sytem.function.FunctionEntry;
import com.voole.trdpay.vo.PageMessageVo;

/**
 * @ClassName: Function
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午1:46:12
 * 
 */
public class FunctionVo extends FunctionEntry implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 上午10:52:09
	 */
	private static final long serialVersionUID = -65306988034142339L;
	private Integer[] rids;
	private Integer[] fids;
	private List<FunctionVo> childFuncs;
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
	 * @date 2016年7月8日 上午10:52:06
	 */
	public Integer[] getRids() {
		return this.rids;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午10:52:06
	 * @param rids the rids to set
	 */
	public void setRids(Integer[] rids) {
		this.rids = rids;
	}

	/**
	 * @return the fids
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:08:50
	 */
	public Integer[] getFids() {
		return this.fids;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:08:50
	 * @param fids the fids to set
	 */
	public void setFids(Integer[] fids) {
		this.fids = fids;
	}

	/**
	 * @return the childFuncs
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:40:06
	 */
	public List<FunctionVo> getChildFuncs() {
		return this.childFuncs;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:40:06
	 * @param childFuncs the childFuncs to set
	 */
	public void setChildFuncs(List<FunctionVo> childFuncs) {
		this.childFuncs = childFuncs;
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
		return "FunctionVo [rids=" + Arrays.toString(this.rids) + ", fids=" + Arrays.toString(this.fids)
				+ ", childFuncs=" + this.childFuncs + ", fid=" + this.fid + ", fname=" + this.fname + ", furl="
				+ this.furl + ", pfid=" + this.pfid + ", menu_type=" + this.menu_type + ", sort=" + this.sort
				+ ", is_on=" + this.is_on + ", create_time=" + this.create_time + ", update_time=" + this.update_time
				+ ", version=" + this.version + "]";
	}
}
