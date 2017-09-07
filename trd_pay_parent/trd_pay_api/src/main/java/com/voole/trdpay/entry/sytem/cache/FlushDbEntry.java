package com.voole.trdpay.entry.sytem.cache;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: FlushDbEntry
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年6月13日 上午9:36:27
 * 
 */
public class FlushDbEntry implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2017年6月13日 上午9:38:09
	 */
	private static final long serialVersionUID = -4417409592239157318L;
	protected Integer id;// '主键',
	protected Date last_ping_date;// '上次ping通时间',
	protected Integer flush_cache_interval;// '间隔时间失效时间',
	protected Integer interval_unit;// '间隔时间失效单位，0毫秒，1秒，2分钟，3小时，4天，5月',
	protected Date update_time;// '修改时间',
	protected Date create_time;// '创建时间',
	protected Integer is_on;// '是否启动',

	/**
	 * @return the id
	 * @author shangchengcai@voole.com
	 * @date 2017年6月13日 上午9:37:52
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年6月13日 上午9:37:52
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the last_ping_date
	 * @author shangchengcai@voole.com
	 * @date 2017年6月13日 上午9:37:52
	 */
	public Date getLast_ping_date() {
		return this.last_ping_date;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年6月13日 上午9:37:52
	 * @param last_ping_date the last_ping_date to set
	 */
	public void setLast_ping_date(Date last_ping_date) {
		this.last_ping_date = last_ping_date;
	}

	/**
	 * @return the flush_cache_interval
	 * @author shangchengcai@voole.com
	 * @date 2017年6月13日 上午9:37:52
	 */
	public Integer getFlush_cache_interval() {
		return this.flush_cache_interval;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年6月13日 上午9:37:52
	 * @param flush_cache_interval the flush_cache_interval to set
	 */
	public void setFlush_cache_interval(Integer flush_cache_interval) {
		this.flush_cache_interval = flush_cache_interval;
	}

	/**
	 * @return the interval_unit
	 * @author shangchengcai@voole.com
	 * @date 2017年6月13日 上午9:37:52
	 */
	public Integer getInterval_unit() {
		return this.interval_unit;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年6月13日 上午9:37:52
	 * @param interval_unit the interval_unit to set
	 */
	public void setInterval_unit(Integer interval_unit) {
		this.interval_unit = interval_unit;
	}

	/**
	 * @return the update_time
	 * @author shangchengcai@voole.com
	 * @date 2017年6月13日 上午9:37:52
	 */
	public Date getUpdate_time() {
		return this.update_time;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年6月13日 上午9:37:52
	 * @param update_time the update_time to set
	 */
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	/**
	 * @return the create_time
	 * @author shangchengcai@voole.com
	 * @date 2017年6月13日 上午9:37:52
	 */
	public Date getCreate_time() {
		return this.create_time;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年6月13日 上午9:37:52
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * @return the is_on
	 * @author shangchengcai@voole.com
	 * @date 2017年6月13日 上午9:37:52
	 */
	public Integer getIs_on() {
		return this.is_on;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年6月13日 上午9:37:52
	 * @param is_on the is_on to set
	 */
	public void setIs_on(Integer is_on) {
		this.is_on = is_on;
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
		return "FlushDbEntry [id=" + this.id + ", flush_cache_interval=" + this.flush_cache_interval
				+ ", interval_unit=" + this.interval_unit + ", is_on=" + this.is_on + "]";
	}

}
