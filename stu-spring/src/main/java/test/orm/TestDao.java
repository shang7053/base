/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月2日 下午7:08:54
*/
package test.orm;

import org.springframework.transaction.annotation.Transactional;

import test.controller.TestVO;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author scc
 * @since 创建时间：2015年11月2日 下午7:08:54
 */
// @Component
public class TestDao extends BaseDao implements ITestDao {
    @Transactional
    public int add() {
        this.getJdbcTemplate().update("INSERT INTO t_boy ( name, age) VALUES ('张三', 18);");
        System.out.println(1 / 0);
        return 1;
    }

    /*
     * (non-Javadoc)
     * 
     * @see test.orm.ITestDao#add(test.controller.TestVO)
     */
    public void add(TestVO testVo) {
        this.getJdbcTemplate()
                .update("INSERT INTO t_boy ( name, age) VALUES ('" + testVo.getName() + "', " + testVo.getAge() + ");");
    }
}
