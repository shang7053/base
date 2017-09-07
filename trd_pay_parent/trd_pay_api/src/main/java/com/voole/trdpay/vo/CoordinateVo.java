package com.voole.trdpay.vo;

/**
 * @ClassName: CoordinateVo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年8月17日 下午2:46:49
 * 
 */
public class CoordinateVo {
	private String x;
	private Integer y;
	private boolean drilldown = true;

	/**
	 * @return the x
	 * @author shangchengcai@voole.com
	 * @date 2017年8月17日 下午4:13:06
	 */
	public String getX() {
		return this.x;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年8月17日 下午4:13:06
	 * @param x the x to set
	 */
	public void setX(String x) {
		this.x = x;
	}

	/**
	 * @return the y
	 * @author shangchengcai@voole.com
	 * @date 2017年8月17日 下午4:13:06
	 */
	public Integer getY() {
		return this.y;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年8月17日 下午4:13:06
	 * @param y the y to set
	 */
	public void setY(Integer y) {
		this.y = y;
	}

	/**
	 * @return the drilldown
	 * @author shangchengcai@voole.com
	 * @date 2017年8月17日 下午2:50:33
	 */
	public boolean isDrilldown() {
		return this.drilldown;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2017年8月17日 下午2:50:33
	 * @param drilldown the drilldown to set
	 */
	public void setDrilldown(boolean drilldown) {
		this.drilldown = drilldown;
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
	 * @date 2017年8月17日 下午2:51:58
	 */
	public CoordinateVo() {
		super();
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
		return "CoordinateVo [x=" + this.x + ", y=" + this.y + ", drilldown=" + this.drilldown + "]";
	}

}
