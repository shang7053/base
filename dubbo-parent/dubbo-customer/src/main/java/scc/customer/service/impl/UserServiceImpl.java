package scc.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import scc.common.user.IUserDao;
import scc.common.vo.User;
import scc.customer.service.IUserService;
@Repository
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

}
