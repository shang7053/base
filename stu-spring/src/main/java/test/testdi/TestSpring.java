/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月2日 下午1:39:48
*/
package test.testdi;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月2日 下午1:39:48
 */

public class TestSpring {
	private ClassPathXmlApplicationContext context;
	@Before
	public void Before(){
		context=new ClassPathXmlApplicationContext("spring.xml");
	}
	@Test
	public void test(){
		Student s=(Student) context.getBean("student");
		s.say();
	}
	@Test
	public void test2(){
		Student s=(Student) context.getBean("student");
		s.say2();
	}
	@Test
	public void test3(){
		Student s=(Student) context.getBean("student");
		s.say3();
	}
	@Test
	public void test4(){
		Student s=(Student) context.getBean("student");
		s.say4();
	}
	@Test
	public void test5(){
		Student s=(Student) context.getBean("student");
		s.say5();
	}
	@Test
	public void test6(){
		Student s=(Student) context.getBean("student");
		s.say6();
	}
}
