package com.voole.datasync.vo.system.user;

import java.io.Serializable;
import java.util.List;

import com.voole.datasync.entry.sytem.user.UserEntry;
import com.voole.datasync.vo.PageMessageVo;
import com.voole.datasync.vo.system.function.FunctionVo;
import com.voole.datasync.vo.system.rule.RuleVo;

/**
 * @ClassName: User
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午1:45:42
 * 
 */
public class UserVo extends UserEntry implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 上午9:49:08
	 */
	private static final long serialVersionUID = -4898563024719633371L;
	private Integer start;
	private Integer size;
	private List<RuleVo> rules;
	private List<FunctionVo> functions;
	private List<FunctionVo> allFunctions;
	private PageMessageVo pmv;

	/**
	 * @return the start
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午4:02:18
	 */
	public Integer getStart() {
		return this.start;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午4:02:18
	 * @param start the start to set
	 */
	public void setStart(Integer start) {
		this.start = start;
	}

	/**
	 * @return the size
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午4:02:18
	 */
	public Integer getSize() {
		return this.size;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午4:02:18
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * @return the rules
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:48:56
	 */
	public List<RuleVo> getRules() {
		return this.rules;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:48:56
	 * @param rules the rules to set
	 */
	public void setRules(List<RuleVo> rules) {
		this.rules = rules;
	}

	/**
	 * @return the functions
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:48:56
	 */
	public List<FunctionVo> getFunctions() {
		return this.functions;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:48:56
	 * @param functions the functions to set
	 */
	public void setFunctions(List<FunctionVo> functions) {
		this.functions = functions;
	}

	/**
	 * @return the pmv
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午3:35:54
	 */
	public PageMessageVo getPmv() {
		return this.pmv;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午3:35:54
	 * @param pmv the pmv to set
	 */
	public void setPmv(PageMessageVo pmv) {
		this.pmv = pmv;
	}

	/**
	 * @return the allFunctions
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月21日 下午1:32:57
	 */
	public List<FunctionVo> getAllFunctions() {
		return this.allFunctions;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月21日 下午1:32:57
	 * @param allFunctions the allFunctions to set
	 */
	public void setAllFunctions(List<FunctionVo> allFunctions) {
		this.allFunctions = allFunctions;
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
		return "UserVo [start=" + this.start + ", size=" + this.size + ", rules=" + this.rules + ", functions="
				+ this.functions + ", allFunctions=" + this.allFunctions + ", pmv=" + this.pmv + ", uid=" + this.uid
				+ ", username=" + this.username + ", passwordcode=" + this.passwordcode + ", realname=" + this.realname
				+ ", email=" + this.email + ", tel=" + this.tel + ", is_on=" + this.is_on + ", error_pw_count="
				+ this.error_pw_count + ", create_time=" + this.create_time + ", update_time=" + this.update_time
				+ ", login_time=" + this.login_time + ", version=" + this.version + "]";
	}
}
