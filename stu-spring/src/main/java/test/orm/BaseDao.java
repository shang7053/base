/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月2日 下午7:28:38
*/
package test.orm;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月2日 下午7:28:38
 */
public class BaseDao extends JdbcDaoSupport{
	/*@Autowired
	public void setTemplate(JdbcTemplate jdbcTemplate) {
		super.setJdbcTemplate(jdbcTemplate);
	}*/
	@Autowired
	public void setdatasour(DataSource dataSource){
		super.setDataSource(dataSource);
	}
}
