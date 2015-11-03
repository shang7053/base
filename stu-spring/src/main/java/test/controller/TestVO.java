/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月3日 上午11:15:31
*/
package test.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月3日 上午11:15:31
 */
public class TestVO {
	@Size(min=3,max=5,message="{testvo.name}")
	private String name;
	@NotNull(message="{testvo.age}")
	private Integer age;
	/**
	 * <p>Description: 属性name的获取器</p>
	 * @author scc
	 * @since 创建时间：2015年11月3日 上午11:16:06
	 **********************************
	 * @return 当前类实例属性 name的值
	 */
	public String getName() {
		return name;
	}
	/**
	 * <p>Description:属性name的设置器 </p>
	 * @author scc
	 * @since 创建时间：2015年11月3日 上午11:16:06
	 **********************************
	 * @param name 将要设置属性name的值参数
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * <p>Description: 属性age的获取器</p>
	 * @author scc
	 * @since 创建时间：2015年11月3日 上午11:16:06
	 **********************************
	 * @return 当前类实例属性 age的值
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * <p>Description:属性age的设置器 </p>
	 * @author scc
	 * @since 创建时间：2015年11月3日 上午11:16:06
	 **********************************
	 * @param age 将要设置属性age的值参数
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
}
