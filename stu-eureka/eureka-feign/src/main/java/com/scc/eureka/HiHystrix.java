package com.scc.eureka;

import org.springframework.stereotype.Component;

/**
 * @ClassName: Hi
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年5月21日 下午5:41:17
 * 
 */
@Component
public class HiHystrix implements IApi {

	/*
	 * (非 Javadoc) <p>Title: go</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see com.scc.eureka.IApi#go()
	 */
	@Override
	public String go() {
		return "fail";
	}

}
