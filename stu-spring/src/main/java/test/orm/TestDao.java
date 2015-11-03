/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月2日 下午7:08:54
*/
package test.orm;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import test.controller.TestVO;

/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月2日 下午7:08:54
 */
@Component
public class TestDao extends BaseDao implements ITestDao{
	@Transactional
	public int add(){
		getJdbcTemplate().update("INSERT INTO t_boy ( name, age) VALUES ('张三', 18);");
		System.out.println(1/0);
		return 1;
	}

	/* (non-Javadoc)
	 * @see test.orm.ITestDao#add(test.controller.TestVO)
	 */
	public void add(TestVO testVo) {
		getJdbcTemplate().update("INSERT INTO t_boy ( name, age) VALUES ('"+testVo.getName()+"', "+testVo.getAge()+");");
	}
}
