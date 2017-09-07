package com.voole.trdpay.vo.system.cache;

import com.voole.trdpay.entry.sytem.cache.FlushDbEntry;
import com.voole.trdpay.vo.PageMessageVo;

/**
 * @ClassName: FlushDbVo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年6月13日 上午9:38:30
 * 
 */
public class FlushDbVo extends FlushDbEntry {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2017年6月13日 上午9:38:39
	 */
	private static final long serialVersionUID = -5669220212285628138L;
	private PageMessageVo pmv;
	private String ftypename;

	public PageMessageVo getPmv() {
		return this.pmv;
	}

	public void setPmv(PageMessageVo pmv) {
		this.pmv = pmv;
	}

	public String getFtypename() {
		return this.ftypename;
	}

	public void setFtypename(String ftypename) {
		this.ftypename = ftypename;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public FlushDbVo(PageMessageVo pmv, String ftypename) {
		super();
		this.pmv = pmv;
		this.ftypename = ftypename;
	}

	public FlushDbVo() {
		super();
	}

	@Override
	public String toString() {
		return "FlushDbVo [pmv=" + this.pmv + ", ftypename=" + this.ftypename + ", id=" + id + ", last_ping_date="
				+ last_ping_date + ", flush_cache_interval=" + flush_cache_interval + ", interval_unit=" + interval_unit
				+ ", update_time=" + update_time + ", create_time=" + create_time + ", is_on=" + is_on + "]";
	}

}
