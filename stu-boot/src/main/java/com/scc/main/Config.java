package com.scc.main;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Config
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年5月21日 下午3:25:48
 * 
 */
@ConfigurationProperties(prefix = "my")
@Component
public class Config {
	private Integer age;
	private String name;

	/**
	 * @return the age
	 * @author shangchengcai@voole.com
	 * @date 2018年5月21日 下午3:26:43
	 */
	public Integer getAge() {
		return this.age;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2018年5月21日 下午3:26:43
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the name
	 * @author shangchengcai@voole.com
	 * @date 2018年5月21日 下午3:26:43
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @author shangchengcai@voole.com
	 * @date 2018年5月21日 下午3:26:43
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
		return "Config [age=" + this.age + ", name=" + this.name + "]";
	}

}
