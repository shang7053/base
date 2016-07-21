package com.voole.cdcenter.vo.system.settings;

import java.io.Serializable;

import com.voole.cdcenter.entry.sytem.settings.SystemSettingsEntry;
import com.voole.cdcenter.vo.PageMessageVo;

/**
 * @ClassName: SystemSettings
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:02:19
 * 
 */
public class SystemSettingsVo extends SystemSettingsEntry implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月14日 下午4:18:09
	 */
	private static final long serialVersionUID = -6532907863051443403L;
	private PageMessageVo pmv;

	/**
	 * @return the pmv
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午4:17:53
	 */
	public PageMessageVo getPmv() {
		return this.pmv;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月14日 下午4:17:53
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
		return "SystemSettingsVo [pmv=" + this.pmv + ", id=" + this.id + ", config_name=" + this.config_name
				+ ", config_value=" + this.config_value + ", rmark=" + this.rmark + ", is_on=" + this.is_on
				+ ", create_time=" + this.create_time + ", update_time=" + this.update_time + ", version="
				+ this.version + "]";
	}
}
