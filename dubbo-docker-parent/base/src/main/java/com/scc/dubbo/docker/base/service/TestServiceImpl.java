package com.scc.dubbo.docker.base.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.scc.dubbo.docker.api.service.ITestService;
import com.scc.dubbo.docker.api.util.IPUtil;

/**
 * @ClassName: TestServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年2月2日 上午11:46:07
 * 
 */
@Service
public class TestServiceImpl implements ITestService {

	/*
	 * (非 Javadoc) <p>Title: test</p> <p>Description: </p>
	 * 
	 * @param str
	 * 
	 * @return
	 * 
	 * @see com.scc.dubbo.docker.api.service.ITestService#test(java.lang.String)
	 */
	@Override
	public String test(String str) {
		return str + " and base run on " + IPUtil.getIp();
	}

}
