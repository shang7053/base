package com.voole.datasync.entry.sytem.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: User
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午1:45:42
 * 
 */
public class UserEntry implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月7日 下午2:04:16
	 */
	protected static final long serialVersionUID = 3767171775002738509L;
	protected Integer uid;// 主键
	protected String username;// 用户名
	protected String passwordcode; // 密码
	protected String realname; // 真实姓名
	protected String email; // 邮箱
	protected String tel;// 手机号
	protected Integer is_on; // 是否冻结，0否1是
	protected Integer error_pw_count; // 密码错误重试次数
	protected Date create_time; // 创建时间
	protected Date update_time;// 更新时间
	protected Date login_time;// 登录时间
	protected Integer version;// 版本号

	/**
	 * @return the uid
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 */
	public Integer getUid() {
		return this.uid;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 * @param uid the uid to set
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**
	 * @return the username
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the passwordcode
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午3:49:39
	 */
	public String getPasswordcode() {
		return this.passwordcode;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午3:49:39
	 * @param passwordcode the passwordcode to set
	 */
	public void setPasswordcode(String passwordcode) {
		this.passwordcode = passwordcode;
	}

	/**
	 * @return the realname
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 */
	public String getRealname() {
		return this.realname;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 * @param realname the realname to set
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}

	/**
	 * @return the email
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the tel
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 */
	public String getTel() {
		return this.tel;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the is_on
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 */
	public Integer getIs_on() {
		return this.is_on;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 * @param is_on the is_on to set
	 */
	public void setIs_on(Integer is_on) {
		this.is_on = is_on;
	}

	/**
	 * @return the error_pw_count
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 */
	public Integer getError_pw_count() {
		return this.error_pw_count;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 * @param error_pw_count the error_pw_count to set
	 */
	public void setError_pw_count(Integer error_pw_count) {
		this.error_pw_count = error_pw_count;
	}

	/**
	 * @return the create_time
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 */
	public Date getCreate_time() {
		return this.create_time;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * @return the update_time
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 */
	public Date getUpdate_time() {
		return this.update_time;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 * @param update_time the update_time to set
	 */
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	/**
	 * @return the version
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 */
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月7日 下午2:08:05
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the login_time
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月12日 上午11:12:54
	 */
	public Date getLogin_time() {
		return this.login_time;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月12日 上午11:12:54
	 * @param login_time the login_time to set
	 */
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
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
		return "UserEntry [uid=" + this.uid + ", username=" + this.username + ", passwordcode=" + this.passwordcode
				+ ", realname=" + this.realname + ", email=" + this.email + ", tel=" + this.tel + ", is_on="
				+ this.is_on + ", error_pw_count=" + this.error_pw_count + ", create_time=" + this.create_time
				+ ", update_time=" + this.update_time + ", login_time=" + this.login_time + ", version=" + this.version
				+ "]";
	}
}
