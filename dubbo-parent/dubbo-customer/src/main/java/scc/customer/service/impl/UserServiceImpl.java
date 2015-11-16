package scc.customer.service.impl;

import org.springframework.stereotype.Repository;

import scc.common.user.IUserDao;
import scc.common.vo.User;
import scc.customer.service.IUserService;

import com.alibaba.dubbo.config.annotation.Reference;
@Repository
public class UserServiceImpl implements IUserService{
	//@Autowired	xml配置时使用
	@Reference
	private IUserDao userDao;
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

}
