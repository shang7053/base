package scc.provider.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import scc.common.user.IUserDao;
import scc.common.vo.User;
@Repository
public class UserDaoImpl implements IUserDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public boolean addUser(User user) {
		return jdbcTemplate.update("INSERT INTO t_user (uname) VALUES ('"+user.getUname()+"');")>0?true:false;
	}

}
