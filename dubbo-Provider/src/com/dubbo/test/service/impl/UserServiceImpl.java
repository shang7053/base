package com.dubbo.test.service.impl;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.test.po.User;
import com.dubbo.test.service.IUserService;
@Service(interfaceClass=IUserService.class,timeout=2000 )
public class UserServiceImpl implements IUserService{

	@Override
	public void insert() {
//		System.out.println("����");
	}

	@Override
	public User getUserById(Integer id) {
//		System.out.println("��ѯ��id="+id);
		return null;
	}

	@Override
	public List<User> getUsers() {
//		System.out.println("��ȡ�û�");
		return null;
	}
	
}
