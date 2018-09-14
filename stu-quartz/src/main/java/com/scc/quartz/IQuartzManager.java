package com.scc.quartz;

import java.util.Map;

import org.quartz.Job;

/**
 * @ClassName: IQuartzManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年4月18日 下午3:48:50
 * 
 */
public interface IQuartzManager {
	/**
	 * 
	 * @Title: addJob
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年4月18日 下午3:49:09
	 * @param job_key
	 * @param cls
	 * @param delay 单位分钟
	 * @param interval 单位秒
	 * @param args
	 * @return
	 */
	boolean addAndStartJob(String job_key, Class<? extends Job> cls, Integer delay, Integer interval,
			Map<String, Object> args);

	/**
	 * 
	 * @Title: deleteJob
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年4月18日 下午3:49:16
	 * @param job_key
	 * @return
	 */
	boolean deleteJob(String job_key);
}