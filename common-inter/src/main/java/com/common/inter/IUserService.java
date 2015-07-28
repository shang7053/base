package com.common.inter;

import java.util.List;

import com.common.vo.User;


public interface IUserService {
	public void insert(User user);
	public User getUserById(Integer id);
	public List<User> getUsers();
}
