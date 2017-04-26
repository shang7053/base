/**   
 *
 * @Title: AbstractDataCheck.java 
 * @Package com.scc 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2017年4月17日 下午4:15:18   
 */
package com.scc;

import java.util.Map;

import javax.sql.DataSource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @ClassName: AbstractDataCheck
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2017年4月17日 下午4:15:18
 * 
 */
public abstract class AbstractDataCheck implements Job {
    public abstract void checkdata(DataSource dataSource, Map<String, Object> args);

    /*
     * (非 Javadoc)
     * <p>Title: execute</p>
     * <p>Description: </p>
     * 
     * @param context
     * 
     * @throws JobExecutionException
     * 
     * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        this.checkdata((DataSource) context.get("ds"), (Map<String, Object>) context.get("args"));
    }

}
