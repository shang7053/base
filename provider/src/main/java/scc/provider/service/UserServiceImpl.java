package scc.provider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scc.provider.dao.IUserDao;

import com.alibaba.dubbo.rpc.RpcContext;
import com.common.inter.IUserService;
import com.common.vo.User;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;

	public void insert(User user) {
//		System.out.println(RpcContext.getContext().getAttachment("index"));
		userDao.insert(user);
	}

	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}

	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
}
