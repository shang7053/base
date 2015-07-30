package com.dubbo.test.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {

	private ApplicationContext applicationContext; // SpringӦ�������Ļ���


	@SuppressWarnings("unchecked")
	public <T> T getBean(String name) throws BeansException {
		return (T) applicationContext.getBean(name);
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
			applicationContext=arg0;
	}

}
