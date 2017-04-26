/**   
 *
 * @Title: QuartzJobFactoryDisallowConcurrentExecution.java 
 * @Package com.scc 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2017年4月17日 下午2:19:53   
 */
package com.scc;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @ClassName: QuartzJobFactoryDisallowConcurrentExecution
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2017年4月17日 下午2:19:53
 * 
 */
@DisallowConcurrentExecution
public class QuartzJobFactoryDisallowConcurrentExecution implements Job {

    /**
     *
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @author scc
     * @date 2017年4月17日 下午2:19:53
     */
    public QuartzJobFactoryDisallowConcurrentExecution() {
        // TODO Auto-generated constructor stub
    }

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        QuartzJobBean scheduleJob = (QuartzJobBean) context.getMergedJobDataMap().get("scheduleJob");
        this.logger.info("运行任务名称 = [" + scheduleJob.getJobName() + "]");
    }

}
