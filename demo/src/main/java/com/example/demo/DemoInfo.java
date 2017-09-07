package com.example.demo;

import org.springframework.data.annotation.Id;

/**
 * @ClassName: DemoInfo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月5日 下午4:38:40
 * 
 */
public class DemoInfo {
	// id属性是给mongodb用的，用@Id注解修饰
	@Id
	private String id;

	private String name;

	private int age;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "DemoInfo [id=" + this.id + ", name=" + this.name + ", age=" + this.age + "]";
	}
}
