/**   
 *
 * @Title: QuartzJobFactory.java 
 * @Package com.scc 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2017年4月17日 下午2:19:33   
 */
package com.scc;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @ClassName: QuartzJobFactory
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2017年4月17日 下午2:19:33
 * 
 */
public class QuartzJobFactory implements Job {

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
     * @date 2017年4月17日 下午2:19:33
     */
    public QuartzJobFactory() {
        // TODO Auto-generated constructor stub
    }

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        QuartzJobBean scheduleJob = (QuartzJobBean) context.getMergedJobDataMap().get("scheduleJob");
        this.logger.info("运行任务名称 = [" + scheduleJob.getJobName() + "]");
    }
}
