/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月3日 上午9:25:03
*/
package test.orm;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月3日 上午9:25:03
 */
public class NameDao {
	static DataSource dataSource;
	public static void main(String[] args) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
		namedParameterJdbcTemplate.update("INSERT t_table (id , name ,age) values(:id,:name,:age)", new HashMap<String, Object>());
	}
}
