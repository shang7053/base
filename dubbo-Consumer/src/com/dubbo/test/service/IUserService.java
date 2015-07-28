package com.dubbo.test.service;

import java.util.List;

import com.dubbo.test.po.User;

public interface IUserService {
	public void insert();
	public User getUserById(Integer id);
	public List<User> getUsers();
}
