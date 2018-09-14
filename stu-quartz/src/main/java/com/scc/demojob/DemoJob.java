package com.scc.demojob;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scc.quartz.IQuartzManager;

/**
 * @ClassName: DemoJob
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chengcai.shang@cmgplex.com
 * @date 2018年9月14日 上午9:25:47
 * 
 */
public class DemoJob implements Job {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoJob.class);

	/*
	 * (非 Javadoc) <p>Title: execute</p> <p>Description: </p>
	 * 
	 * @param context
	 * 
	 * @throws JobExecutionException
	 * 
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		LOGGER.info("start job");
		JobDataMap jobDataMap = context.getMergedJobDataMap();
		LOGGER.info(jobDataMap.getOrDefault("args1", "").toString());
		LOGGER.info(jobDataMap.getOrDefault("args2", "").toString());
		LOGGER.info(jobDataMap.getOrDefault("args3", "").toString());
		LOGGER.info(jobDataMap.getOrDefault("args4", "").toString());
		if (null != jobDataMap.get("quartzManager")) {
			LOGGER.info("find quartzManager!kill self key={}", context.getJobDetail().getKey().getName());
			IQuartzManager quartzManager = (IQuartzManager) jobDataMap.get("quartzManager");
			quartzManager.deleteJob(context.getJobDetail().getKey().getName());
		}
	}

}
