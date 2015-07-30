package com.dubbo.test.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.test.service.IUserService;
import com.dubbo.test.util.SpringContextUtil;

/**
 * Servlet implementation class TestDubbo
 */
public class TestDubbo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Test test;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDubbo() {
        super();
//        System.out.println(Arrays.toString(SpringContextUtil.getApplicationContext().getBeanDefinitionNames()));
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  // IUserService userService=SpringContextUtil.getBean("IUserService");
//	   System.out.println(Arrays.toString(SpringContextUtil.getApplicationContext().getBeanDefinitionNames()));
	   test.getUserService().insert();
	   test.getUserService().getUserById(1);
	   test.getUserService().getUsers();
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
}
