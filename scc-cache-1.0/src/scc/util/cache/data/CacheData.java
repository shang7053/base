package scc.util.cache.data;

import java.util.Date;

import org.apache.log4j.Logger;


import scc.util.cache.exception.ArgsNullException;


public final class CacheData {
	private static final Logger LOGGER=Logger.getLogger(CacheData.class);
	public CacheData(Date loadDate, Object data) {
		setData(data);
		setLoadDate(loadDate);
	}
	public CacheData(Object data) {
		setData(data);
		setLoadDate(new Date());
	}
	private Date loadDate;
	private Object data;
	public Date getLoadDate() {
		return loadDate;
	}
	public void setLoadDate(Date loadDate) {
		if(null==loadDate)
			try {
				throw new ArgsNullException("参数:loadDate不可为空");
			} catch (ArgsNullException e) {
				LOGGER.error(e);
			}
		this.loadDate = loadDate;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		if(null==data)
			try {
				throw new ArgsNullException("参数:data不可为空");
			} catch (ArgsNullException e) {
				LOGGER.error(e);
			}
		this.data = data;
	}
}
