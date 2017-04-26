/**   
 *
 * @Title: TaskService.java 
 * @Package com.scc 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2017年4月17日 下午2:16:39   
 */
package com.scc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

/**
 *
 * @ClassName: TaskService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2017年4月17日 下午2:16:39
 * 
 */
@Service(value = "taskService")
public class TaskService {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    /**
     * 获取单个任务
     * 
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     */
    public QuartzJobBean getJob(String jobName, String jobGroup) throws SchedulerException {
        QuartzJobBean job = null;
        Scheduler scheduler = this.schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        if (null != trigger) {
            job = new QuartzJobBean();
            job.setJobName(jobName);
            job.setJobGroup(jobGroup);
            job.setDescription("触发器:" + trigger.getKey());
            job.setNextTime(trigger.getNextFireTime()); // 下次触发时间
            job.setPreviousTime(trigger.getPreviousFireTime());// 上次触发时间
            Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
            job.setJobStatus(triggerState.name());
            CronTrigger cronTrigger = trigger;
            String cronExpression = cronTrigger.getCronExpression();
            job.setCronExpression(cronExpression);
        }
        return job;
    }

    /**
     * 获取所有任务
     * 
     * @return
     * @throws SchedulerException
     */
    public List<QuartzJobBean> getAllJobs() throws SchedulerException {
        Scheduler scheduler = this.schedulerFactoryBean.getScheduler();
        GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
        Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
        List<QuartzJobBean> jobList = new ArrayList<QuartzJobBean>();
        for (JobKey jobKey : jobKeys) {
            List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
            for (Trigger trigger : triggers) {
                QuartzJobBean job = new QuartzJobBean();
                job.setJobName(jobKey.getName());
                job.setJobGroup(jobKey.getGroup());
                job.setDescription("触发器:" + trigger.getKey());

                job.setNextTime(trigger.getNextFireTime()); // 下次触发时间
                // trigger.getFinalFireTime();//最后一次执行时间
                job.setPreviousTime(trigger.getPreviousFireTime());// 上次触发时间
                // trigger.getStartTime();//开始时间
                // trigger.getEndTime();//结束时间
                // 触发器当前状态
                Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                job.setJobStatus(triggerState.name());
                //
                if (trigger instanceof CronTrigger) {
                    CronTrigger cronTrigger = (CronTrigger) trigger;
                    String cronExpression = cronTrigger.getCronExpression();
                    job.setCronExpression(cronExpression);
                }
                jobList.add(job);
            }
        }
        return jobList;
    }

    /**
     * 所有正在运行的job
     * 
     * @return
     * @throws SchedulerException
     */
    public List<QuartzJobBean> getRunningJob() throws SchedulerException {
        Scheduler scheduler = this.schedulerFactoryBean.getScheduler();
        List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
        List<QuartzJobBean> jobList = new ArrayList<QuartzJobBean>(executingJobs.size());
        for (JobExecutionContext executingJob : executingJobs) {
            QuartzJobBean job = new QuartzJobBean();
            JobDetail jobDetail = executingJob.getJobDetail();
            JobKey jobKey = jobDetail.getKey();
            Trigger trigger = executingJob.getTrigger();
            job.setJobName(jobKey.getName());
            job.setJobGroup(jobKey.getGroup());
            job.setDescription("触发器:" + trigger.getKey());
            Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
            job.setJobStatus(triggerState.name());
            if (trigger instanceof CronTrigger) {
                CronTrigger cronTrigger = (CronTrigger) trigger;
                String cronExpression = cronTrigger.getCronExpression();
                job.setCronExpression(cronExpression);
            }
            jobList.add(job);
        }
        return jobList;
    }

    /**
     * 添加任务
     * 
     * @param scheduleJob
     * @throws SchedulerException
     */
    public boolean addJob(QuartzJobBean job) throws SchedulerException {
        if (job == null || !QuartzJobBean.STATUS_RUNNING.equals(job.getJobStatus())) {
            return false;
        }
        if (!TaskUtils.isValidExpression(job.getCronExpression())) {
            this.logger.error("时间表达式错误（" + job.getJobName() + "," + job.getJobGroup() + "）," + job.getCronExpression());
            return false;
        } else {
            Scheduler scheduler = this.schedulerFactoryBean.getScheduler();
            // 任务名称和任务组设置规则： // 名称：task_1 .. // 组 ：group_1 ..
            TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            // 不存在，创建一个
            if (null == trigger) {
                // 是否允许并发执行
                Class<? extends Job> clazz = QuartzJobBean.CONCURRENT_IS.equals(job.isConcurrent())
                        ? QuartzJobFactory.class : QuartzJobFactoryDisallowConcurrentExecution.class;
                JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getJobName(), job.getJobGroup())
                        .build();
                jobDetail.getJobDataMap().put("scheduleJob", job);
                // 表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
                // 按新的表达式构建一个新的trigger
                trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail, trigger);
            } else { // trigger已存在，则更新相应的定时设置
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
                // 按新的cronExpression表达式重新构建trigger
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
                // 按新的trigger重新设置job执行
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        }
        return true;
    }

    /**
     * 暂停任务
     * 
     * @param scheduleJob
     * @return
     */
    public boolean pauseJob(QuartzJobBean scheduleJob) {
        Scheduler scheduler = this.schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        try {
            scheduler.pauseJob(jobKey);
            return true;
        } catch (SchedulerException e) {}
        return false;
    }

    /**
     * 恢复任务
     * 
     * @param scheduleJob
     * @return
     */
    public boolean resumeJob(QuartzJobBean scheduleJob) {
        Scheduler scheduler = this.schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        try {
            scheduler.resumeJob(jobKey);
            return true;
        } catch (SchedulerException e) {}
        return false;
    }

    /**
     * 删除任务
     */
    public boolean deleteJob(QuartzJobBean scheduleJob) {
        Scheduler scheduler = this.schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        try {
            scheduler.deleteJob(jobKey);
            return true;
        } catch (SchedulerException e) {}
        return false;
    }

    /**
     * 立即执行一个任务
     * 
     * @param scheduleJob
     * @throws SchedulerException
     */
    public void testJob(QuartzJobBean scheduleJob) throws SchedulerException {
        Scheduler scheduler = this.schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        scheduler.triggerJob(jobKey);
    }

    /**
     * 更新任务时间表达式
     * 
     * @param scheduleJob
     * @throws SchedulerException
     */
    public void updateCronExpression(QuartzJobBean scheduleJob) throws SchedulerException {
        Scheduler scheduler = this.schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        // 获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        // 表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
        // 按新的cronExpression表达式重新构建trigger
        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
        // 按新的trigger重新设置job执行
        scheduler.rescheduleJob(triggerKey, trigger);
    }
}
