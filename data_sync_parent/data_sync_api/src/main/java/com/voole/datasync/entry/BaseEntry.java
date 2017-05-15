package com.voole.datasync.entry;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: BaseEntry
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年5月15日 下午1:29:37
 * 
 */
public class BaseEntry implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2017年5月15日 下午1:30:11
	 */
	private static final long serialVersionUID = -6151229310326361134L;
	protected Integer is_on;// 是否启用
	protected Date create_time;// 创建时间
	protected Date update_time;// 更新时间
	protected Integer version;// 版本号

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author shangchengcai@voole.com
	 * @date 2017年5月15日 下午1:29:37
	 */
	public BaseEntry() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the is_on
	 * @author shangchengcai@voole.com
	 * @date 2017年5月15日 下午1:29:55
	 */
	public Integer getIs_on() {
		return this.is_on;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年5月15日 下午1:29:55
	 * @param is_on the is_on to set
	 */
	public void setIs_on(Integer is_on) {
		this.is_on = is_on;
	}

	/**
	 * @return the create_time
	 * @author shangchengcai@voole.com
	 * @date 2017年5月15日 下午1:29:55
	 */
	public Date getCreate_time() {
		return this.create_time;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年5月15日 下午1:29:55
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * @return the update_time
	 * @author shangchengcai@voole.com
	 * @date 2017年5月15日 下午1:29:55
	 */
	public Date getUpdate_time() {
		return this.update_time;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年5月15日 下午1:29:55
	 * @param update_time the update_time to set
	 */
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	/**
	 * @return the version
	 * @author shangchengcai@voole.com
	 * @date 2017年5月15日 下午1:29:55
	 */
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年5月15日 下午1:29:55
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

}
