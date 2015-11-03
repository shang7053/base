/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月2日 下午4:06:18
*/
package test.annocationdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * <p>Description: </p>
 * @author scc.
 * @since 创建时间：2015年11月2日 下午4:06:18
 */
@Repository
public class Boy {
	@Value("#{student.name}")
	private String name;
	public void test() {
		System.out.println(name+"----------"+"Boy.test()");
	}
}
