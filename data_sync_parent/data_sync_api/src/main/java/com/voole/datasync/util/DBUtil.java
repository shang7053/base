package com.voole.datasync.util;

import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

public class DBUtil {
	
	static int MAXACTIVE_DELT = 20;

	public static DruidDataSource getDataSource(String url, String username, String password) {
		DruidDataSource ds = new DruidDataSource();
		// ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setMaxActive(MAXACTIVE_DELT);
		return ds;
	}
	public static JdbcTemplate getJdbcTemplate(DruidDataSource ds){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(ds);
		return jdbcTemplate;
	}
	public static JdbcTemplate getJdbcTemplate(String url, String username, String password){
		DruidDataSource ds = getDataSource(url, username, password);
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(ds);
		return jdbcTemplate;
	}
}
