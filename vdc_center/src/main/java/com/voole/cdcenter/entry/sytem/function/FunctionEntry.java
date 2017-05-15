package com.voole.cdcenter.entry.sytem.function;

import java.io.Serializable;
import java.util.Date;

import com.voole.cdcenter.entry.BaseEntry;

/**
 * @ClassName: Function
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午1:46:12
 * 
 */
public class FunctionEntry extends BaseEntry implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午2:04:24
	 */
	protected static final long serialVersionUID = -8202971391617176045L;
	protected Integer fid;// 链接id
	protected String fname;// 链接名称
	protected String furl;// 链接url
	protected Integer pfid;// 父链接id
	protected Integer menu_type;// 是否菜单0否1是
	protected Integer sort;// 排序

	/**
	 * @return the fid
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:12:52
	 */
	public Integer getFid() {
		return this.fid;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:12:52
	 * @param fid the fid to set
	 */
	public void setFid(Integer fid) {
		this.fid = fid;
	}

	/**
	 * @return the fname
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:12:52
	 */
	public String getFname() {
		return this.fname;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:12:52
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the furl
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:12:52
	 */
	public String getFurl() {
		return this.furl;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:12:52
	 * @param furl the furl to set
	 */
	public void setFurl(String furl) {
		this.furl = furl;
	}

	/**
	 * @return the pfid
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:12:52
	 */
	public Integer getPfid() {
		return this.pfid;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:12:52
	 * @param pfid the pfid to set
	 */
	public void setPfid(Integer pfid) {
		this.pfid = pfid;
	}

	/**
	 * @return the is_on
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:12:52
	 */
	@Override
	public Integer getIs_on() {
		return this.is_on;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:12:52
	 * @param is_on the is_on to set
	 */
	@Override
	public void setIs_on(Integer is_on) {
		this.is_on = is_on;
	}

	/**
	 * @return the create_time
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:12:52
	 */
	@Override
	public Date getCreate_time() {
		return this.create_time;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:12:52
	 * @param create_time the create_time to set
	 */
	@Override
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * @return the update_time
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:12:52
	 */
	@Override
	public Date getUpdate_time() {
		return this.update_time;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:12:52
	 * @param update_time the update_time to set
	 */
	@Override
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	/**
	 * @return the version
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:12:52
	 */
	@Override
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:12:52
	 * @param version the version to set
	 */
	@Override
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the menu_type
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:42:45
	 */
	public Integer getMenu_type() {
		return this.menu_type;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午11:42:45
	 * @param menu_type the menu_type to set
	 */
	public void setMenu_type(Integer menu_type) {
		this.menu_type = menu_type;
	}

	/**
	 * @return the sort
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:35:08
	 */
	public Integer getSort() {
		return this.sort;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月8日 上午9:35:08
	 * @param sort the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
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
		return "FunctionEntry [fid=" + this.fid + ", fname=" + this.fname + ", furl=" + this.furl + ", pfid="
				+ this.pfid + ", menu_type=" + this.menu_type + ", sort=" + this.sort + ", is_on=" + this.is_on
				+ ", create_time=" + this.create_time + ", update_time=" + this.update_time + ", version="
				+ this.version + "]";
	}
}
