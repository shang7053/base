package com.scc.rabbit;

/**
 * @ClassName: Entry
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年5月22日 下午1:28:03
 * 
 */
public class Entry {
	private Integer age;
	private String name;

	/**
	 * @return the age
	 * @author shangchengcai@voole.com
	 * @date 2018年5月22日 下午1:28:32
	 */
	public Integer getAge() {
		return this.age;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2018年5月22日 下午1:28:32
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the name
	 * @author shangchengcai@voole.com
	 * @date 2018年5月22日 下午1:28:32
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2018年5月22日 下午1:28:32
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
		return "Entry [age=" + this.age + ", name=" + this.name + "]";
	}
}
