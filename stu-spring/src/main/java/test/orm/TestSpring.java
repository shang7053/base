/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月2日 下午1:39:48
*/
package test.orm;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.testdi.Toy;

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
		ITestDao testDao=(ITestDao) context.getBean("testDao");
		testDao.add();
	}
}
