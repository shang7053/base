package com.scc;

import org.springframework.stereotype.Service;

/**
 * @ClassName: ServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年4月27日 上午10:16:47
 * 
 */
@Service
public class ServiceImpl implements IService {

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author shangchengcai@voole.com
	 * @date 2017年4月27日 上午10:16:47
	 */
	public ServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (非 Javadoc) <p>Title: test</p> <p>Description: </p>
	 * 
	 * @see com.scc.IService#test()
	 */
	@Override
	public void test() {
		System.out.println("ServiceImpl.test()");
	}

}
