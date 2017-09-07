package com.voole.trdpay.vo;

/**
 * @ClassName: PieVo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年8月18日 下午3:33:58
 * 
 */
public class PieVo {
	private String name;
	private Integer y;

	/**
	 * @return the name
	 * @author shangchengcai@voole.com
	 * @date 2017年8月18日 下午3:35:08
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年8月18日 下午3:35:08
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the y
	 * @author shangchengcai@voole.com
	 * @date 2017年8月18日 下午3:35:08
	 */
	public Integer getY() {
		return this.y;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年8月18日 下午3:35:08
	 * @param y the y to set
	 */
	public void setY(Integer y) {
		this.y = y;
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
		return "PieVo [name=" + this.name + ", y=" + this.y + "]";
	}
}
