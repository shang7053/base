package com.scc.quartz.impl;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.scc.quartz.IQuartzManager;

/**
 * @ClassName: QuartzManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月30日 下午2:26:12
 * 
 */
@Service
public class QuartzManagerImpl implements IQuartzManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(QuartzManagerImpl.class);
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	private static String JOB_GROUP_NAME = "EXTJWEB_JOBGROUP_NAME";

	/*
	 * (非 Javadoc) <p>Title: addJob</p> <p>Description: </p>
	 * 
	 * @param job_key
	 * 
	 * @param cls
	 * 
	 * @param delay
	 *
	 * @param interval
	 * 
	 * @param args
	 * 
	 * @see com.voole.datacheck.util.quartz.IQuartzManager#addJob(java.lang.String, java.lang.Class, java.lang.String,
	 * java.util.Map)
	 */
	@Override
	public boolean addAndStartJob(String job_key, Class<? extends Job> cls, Integer delay, Integer interval,
			Map<String, Object> args) {
		LOGGER.info("add job:jobName-" + job_key + ",cls-" + cls + ",delay-" + delay);
		Preconditions.checkArgument(StringUtils.isNotBlank(job_key), "jobName can not be null");
		Preconditions.checkArgument(cls != null, "cls can not be null");
		try {
			JobDetail jobDetail = JobBuilder.newJob(cls).withIdentity(job_key, JOB_GROUP_NAME).build();// 任务名，任务组，任务执行类
			jobDetail.getJobDataMap().putAll(args);
			// 触发器
			TriggerKey triggerKey = TriggerKey.triggerKey(job_key, JOB_GROUP_NAME);
			// 表达式调度构建器
			SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(interval).repeatForever();
			// .withRepeatCount(0);
			Long currentdatetime = System.currentTimeMillis();
			Date rundate = new Date(currentdatetime + ((null == delay ? 60 : delay) * 60 * 1000));
			SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).startAt(rundate)
					.withSchedule(scheduleBuilder).build();
			this.getScheduler().scheduleJob(jobDetail, trigger);
			return true;
		} catch (Exception e) {
			LOGGER.error("", e);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @Title: getScheduler
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年4月18日 下午5:43:52
	 * @return
	 */
	private Scheduler getScheduler() {
		return this.schedulerFactoryBean.getScheduler();
	}

	/*
	 * (非 Javadoc) <p>Title: deleteJob</p> <p>Description: </p>
	 * 
	 * @param job_key
	 * 
	 * @return
	 * 
	 * @see com.voole.datacheck.util.quartz.IQuartzManager#deleteJob(java.lang.String)
	 */
	@Override
	public boolean deleteJob(String job_key) {
		LOGGER.info("deleteJob:job_name-" + job_key);
		Preconditions.checkArgument(StringUtils.isNotBlank(job_key), "jobName can not be null");
		JobKey jobKey = JobKey.jobKey(job_key, JOB_GROUP_NAME);
		try {
			if (this.getScheduler().checkExists(jobKey)) {
				this.getScheduler().pauseJob(jobKey);
				this.getScheduler().deleteJob(jobKey);
			}
			return true;
		} catch (SchedulerException e) {
			LOGGER.error("", e);
			e.printStackTrace();
		}
		return false;
	}

}
