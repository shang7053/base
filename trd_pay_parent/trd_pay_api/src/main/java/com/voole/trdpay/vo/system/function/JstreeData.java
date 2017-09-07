package com.voole.trdpay.vo.system.function;

import java.io.Serializable;

import com.voole.trdpay.vo.PageMessageVo;

/**
 * @ClassName: JstreeData
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月13日 下午1:43:51
 * 
 */
public class JstreeData implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月13日 下午1:44:35
	 */
	private static final long serialVersionUID = 6076469342752694995L;
	private String id;
	private String parent;
	private String text;
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
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author shangchengcai@voole.com
	 * @date 2016年7月13日 下午1:49:22
	 */
	public JstreeData() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author shangchengcai@voole.com
	 * @date 2016年7月13日 下午1:49:26
	 * @param id
	 * @param parent
	 * @param text
	 */
	public JstreeData(String id, String parent, String text) {
		super();
		this.id = id;
		this.parent = parent;
		this.text = text;
	}

	/**
	 * @return the id
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月13日 下午1:45:15
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月13日 下午1:45:15
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the parent
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月13日 下午1:45:15
	 */
	public String getParent() {
		return this.parent;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月13日 下午1:45:15
	 * @param parent the parent to set
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	/**
	 * @return the text
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月13日 下午1:45:15
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月13日 下午1:45:15
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
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
		return "JstreeData [id=" + this.id + ", parent=" + this.parent + ", text=" + this.text + "]";
	}
}
