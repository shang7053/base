package com.scc.dbtest;

import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @ClassName: DBUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年7月11日 上午9:33:19
 * 
 */
public class DBUtil {
	private static JdbcTemplate jdbcTemplate = new JdbcTemplate();
	static {
		StringBuilder jdbcurlsb = new StringBuilder("jdbc:mysql://");
		jdbcurlsb.append("172.16.40.5:3306/canal");
		jdbcurlsb.append("?allowMultiQueries=true&useUnicode=true&characterEncoding=utf8");
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(jdbcurlsb.toString());
		dataSource.setUsername("root");
		dataSource.setPassword("mysql*()");
		dataSource.setMaxActive(3000);
		dataSource.setMinIdle(1);
		dataSource.setInitialSize(1);
		jdbcTemplate.setDataSource(dataSource);
	}

	public static void insert(String sql) {
		jdbcTemplate.execute(sql);
	}
}
