package com.scc;

/**
 * @ClassName: Apple
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chengcai.shang@cmgplex.com
 * @date 2018年12月27日 下午2:08:03
 * 
 */
public class Apple {
	private String color;
	private Integer weight;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author chengcai.shang@cmgplex.com
	 * @date 2018年12月27日 下午2:15:40
	 * @param string
	 */
	public Apple(String color) {
		this.color = color;
	}

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author chengcai.shang@cmgplex.com
	 * @date 2018年12月27日 下午2:18:01
	 * @param i
	 */
	public Apple(int weight) {
		this.weight = weight;
	}

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author chengcai.shang@cmgplex.com
	 * @date 2018年12月27日 下午2:50:12
	 * @param color
	 * @param weight
	 */
	public Apple(String color, Integer weight) {
		super();
		this.color = color;
		this.weight = weight;
	}

	/**
	 * @return the color
	 * @author chengcai.shang@cmgplex.com
	 * @date 2018年12月27日 下午2:08:51
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * @author chengcai.shang@cmgplex.com
	 * @date 2018年12月27日 下午2:08:51
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the weight
	 * @author chengcai.shang@cmgplex.com
	 * @date 2018年12月27日 下午2:08:51
	 */
	public Integer getWeight() {
		return this.weight;
	}

	/**
	 * @author chengcai.shang@cmgplex.com
	 * @date 2018年12月27日 下午2:08:51
	 * @param weight the weight to set
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
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
		return "Apple [color=" + this.color + ", weight=" + this.weight + "]";
	}

}
