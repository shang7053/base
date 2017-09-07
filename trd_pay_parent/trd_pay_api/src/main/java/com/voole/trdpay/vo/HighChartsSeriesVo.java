package com.voole.trdpay.vo;

import java.util.List;

/**
 * @ClassName: HighChartsSeriesVo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年7月18日 下午1:39:47 [{ name : '同步总数', data : eval(data), tooltip: { valueDecimals: 2 } }]
 */
public class HighChartsSeriesVo<T> {
	private String name;
	private List<T> data;

	private String type;

	/**
	 * @return the type
	 * @author shangchengcai@voole.com
	 * @date 2017年8月18日 上午11:08:59
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年8月18日 上午11:08:59
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the name
	 * @author shangchengcai@voole.com
	 * @date 2017年7月18日 下午1:42:44
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年7月18日 下午1:42:44
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the data
	 * @author shangchengcai@voole.com
	 * @date 2017年8月17日 下午4:07:50
	 */
	public List<T> getData() {
		return this.data;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年8月17日 下午4:07:50
	 * @param data the data to set
	 */
	public void setData(List<T> data) {
		this.data = data;
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
		return "HighChartsSeriesVo [name=" + this.name + ", data=" + this.data + ", type=" + this.type + "]";
	}

}
