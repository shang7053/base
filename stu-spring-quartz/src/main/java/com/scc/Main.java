/**   
 *
 * @Title: Main.java 
 * @Package com.scc 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2017年4月17日 下午3:09:59   
 */
package com.scc;

import org.apache.log4j.Logger;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @ClassName: Main
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2017年4月17日 下午3:09:59
 * 
 */
public class Main {
    private final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:spring-core.xml");
        TaskService taskService = (TaskService) factory.getBean("taskService");
        logger.info("初始化加载定时任务......");
        // 可执行的任务列表
        QuartzJobBean quartzJobBean = new QuartzJobBean();
        quartzJobBean.setJobClass("com.scc.QuartzJobFactory");
        quartzJobBean.setJobName("生生世世");
        quartzJobBean.setJobGroup("闪电似的");
        quartzJobBean.setCronExpression("0/10 * * * * ?");
        quartzJobBean.setJobStatus("1");
        taskService.addJob(quartzJobBean);
        QuartzJobBean quartzJobBean2 = new QuartzJobBean();
        quartzJobBean2.setJobClass("com.scc.QuartzJobFactory");
        quartzJobBean2.setJobName("四十多");
        quartzJobBean2.setJobGroup("阿萨德岁的");
        quartzJobBean2.setCronExpression("0/10 * * * * ?");
        quartzJobBean2.setJobStatus("1");
        taskService.addJob(quartzJobBean2);
        taskService.pauseJob(quartzJobBean2);
        taskService.resumeJob(quartzJobBean2);
    }

}
