/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月2日 下午1:44:05
*/
package test.testdi;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月2日 下午1:44:05
 */
public class Student extends Perple{
	private Teacher teacher;
	private String name;
	private Toy toy;
	private List<String> list;
	private Set<Toy> toys;
	private Map<String, Toy> detailtoys;
	private Properties properties;
	/**
	 * <p>Description: </p>
	 * @author scc
	 * @since 创建时间：2015年11月2日 下午1:50:41
	 ********************************** 
	 */
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(Teacher teacher) {
		this.teacher=teacher;
	}
	
	public void init(){
		System.out.println("init");
	}
	
	public void say2(){
		System.out.println(toy.toy()+"========="+ name);
	}
	public void destory(){
		System.out.println("destory");
	}
	public void say3(){
		for (String string : list) {
			System.out.println(string);
		}
	}
	public void say4(){
		for (Toy toy : toys) {
			System.out.println(toy.toy());
		}
	}
	public void say5(){
		for(Entry<String, Toy> toy:detailtoys.entrySet()){
			System.out.println(toy.getKey()+"========"+toy.getValue().toy());
		}
	}
	public void say6(){
		for(Entry<Object, Object> toy:properties.entrySet()){
			System.out.println(toy.getKey()+"========"+toy.getValue());
		}
	}
	/**
	 * <p>Description: 属性teacher的获取器</p>
	 * @author scc
	 * @since 创建时间：2015年11月2日 下午2:58:01
	 **********************************
	 * @return 当前类实例属性 teacher的值
	 */
	public Teacher getTeacher() {
		return teacher;
	}
	/**
	 * <p>Description:属性teacher的设置器 </p>
	 * @author scc
	 * @since 创建时间：2015年11月2日 下午2:58:01
	 **********************************
	 * @param teacher 将要设置属性teacher的值参数
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	/**
	 * <p>Description: 属性name的获取器</p>
	 * @author scc
	 * @since 创建时间：2015年11月2日 下午2:58:01
	 **********************************
	 * @return 当前类实例属性 name的值
	 */
	public String getName() {
		return name;
	}
	/**
	 * <p>Description:属性name的设置器 </p>
	 * @author scc
	 * @since 创建时间：2015年11月2日 下午2:58:01
	 **********************************
	 * @param name 将要设置属性name的值参数
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * <p>Description: 属性toy的获取器</p>
	 * @author scc
	 * @since 创建时间：2015年11月2日 下午3:02:43
	 **********************************
	 * @return 当前类实例属性 toy的值
	 */
	public Toy getToy() {
		return toy;
	}
	/**
	 * <p>Description:属性toy的设置器 </p>
	 * @author scc
	 * @since 创建时间：2015年11月2日 下午3:02:43
	 **********************************
	 * @param toy 将要设置属性toy的值参数
	 */
	public void setToy(Toy toy) {
		this.toy = toy;
	}
	/**
	 * <p>Description: 属性list的获取器</p>
	 * @author scc
	 * @since 创建时间：2015年11月2日 下午3:04:18
	 **********************************
	 * @return 当前类实例属性 list的值
	 */
	public List<String> getList() {
		return list;
	}
	/**
	 * <p>Description:属性list的设置器 </p>
	 * @author scc
	 * @since 创建时间：2015年11月2日 下午3:04:18
	 **********************************
	 * @param list 将要设置属性list的值参数
	 */
	public void setList(List<String> list) {
		this.list = list;
	}
	/**
	 * <p>Description: 属性toys的获取器</p>
	 * @author scc
	 * @since 创建时间：2015年11月2日 下午3:06:27
	 **********************************
	 * @return 当前类实例属性 toys的值
	 */
	public Set<Toy> getToys() {
		return toys;
	}
	/**
	 * <p>Description:属性toys的设置器 </p>
	 * @author scc
	 * @since 创建时间：2015年11月2日 下午3:06:27
	 **********************************
	 * @param toys 将要设置属性toys的值参数
	 */
	public void setToys(Set<Toy> toys) {
		this.toys = toys;
	}
	/**
	 * <p>Description: 属性detailtoys的获取器</p>
	 * @author scc
	 * @since 创建时间：2015年11月2日 下午3:18:04
	 **********************************
	 * @return 当前类实例属性 detailtoys的值
	 */
	public Map<String, Toy> getDetailtoys() {
		return detailtoys;
	}
	/**
	 * <p>Description:属性detailtoys的设置器 </p>
	 * @author scc
	 * @since 创建时间：2015年11月2日 下午3:18:04
	 **********************************
	 * @param detailtoys 将要设置属性detailtoys的值参数
	 */
	public void setDetailtoys(Map<String, Toy> detailtoys) {
		this.detailtoys = detailtoys;
	}
	/**
	 * <p>Description: 属性properties的获取器</p>
	 * @author scc
	 * @since 创建时间：2015年11月2日 下午3:18:45
	 **********************************
	 * @return 当前类实例属性 properties的值
	 */
	public Properties getProperties() {
		return properties;
	}
	/**
	 * <p>Description:属性properties的设置器 </p>
	 * @author scc
	 * @since 创建时间：2015年11月2日 下午3:18:45
	 **********************************
	 * @param properties 将要设置属性properties的值参数
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
