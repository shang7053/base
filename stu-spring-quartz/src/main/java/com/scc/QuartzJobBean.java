/**   
 *
 * @Title: QuartzJobBean.java 
 * @Package com.scc 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2017年4月17日 下午2:20:18   
 */
package com.scc;

import java.util.Date;

/**
 *
 * @ClassName: QuartzJobBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2017年4月17日 下午2:20:18
 * 
 */
public class QuartzJobBean {

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
     * @date 2017年4月17日 下午2:20:19
     */
    public QuartzJobBean() {
        // TODO Auto-generated constructor stub
    }

    public static final String STATUS_RUNNING = "1";
    public static final String STATUS_NOT_RUNNING = "0";
    public static final String CONCURRENT_IS = "1";
    public static final String CONCURRENT_NOT = "0";

    /** 任务id */
    private String jobId;

    /** 任务名称 */
    private String jobName;

    /** 任务分组，任务名称+组名称应该是唯一的 */
    private String jobGroup;

    /** 任务初始状态 0禁用 1启用 2删除 */
    private String jobStatus;

    /** 任务是否有状态（并发） */
    private String isConcurrent = "1";

    /** 任务运行时间表达式 */
    private String cronExpression;

    /** 任务描述 */
    private String description;

    /** 任务调用类在spring中注册的bean id，如果spingId不为空，则按springId查找 */
    private String springId;

    /** 任务调用类名，包名+类名，通过类反射调用 ，如果spingId为空，则按jobClass查找 */
    private String jobClass;

    /** 启动时间 */
    private Date startTime;

    /** 前一次运行时间 */
    private Date previousTime;

    /** 下次运行时间 */
    private Date nextTime;

    /**
     * @return the jobId
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     */
    public String getJobId() {
        return this.jobId;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     * @param jobId the jobId to set
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    /**
     * @return the jobName
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     */
    public String getJobName() {
        return this.jobName;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     * @param jobName the jobName to set
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * @return the jobGroup
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     */
    public String getJobGroup() {
        return this.jobGroup;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     * @param jobGroup the jobGroup to set
     */
    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    /**
     * @return the jobStatus
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     */
    public String getJobStatus() {
        return this.jobStatus;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     * @param jobStatus the jobStatus to set
     */
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    /**
     * @return the isConcurrent
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     */
    public String getIsConcurrent() {
        return this.isConcurrent;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     * @param isConcurrent the isConcurrent to set
     */
    public void setIsConcurrent(String isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    /**
     * @return the cronExpression
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     */
    public String getCronExpression() {
        return this.cronExpression;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     * @param cronExpression the cronExpression to set
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    /**
     * @return the description
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the springId
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     */
    public String getSpringId() {
        return this.springId;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     * @param springId the springId to set
     */
    public void setSpringId(String springId) {
        this.springId = springId;
    }

    /**
     * @return the jobClass
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     */
    public String getJobClass() {
        return this.jobClass;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     * @param jobClass the jobClass to set
     */
    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    /**
     * @return the startTime
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     */
    public Date getStartTime() {
        return this.startTime;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     * @param startTime the startTime to set
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the previousTime
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     */
    public Date getPreviousTime() {
        return this.previousTime;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     * @param previousTime the previousTime to set
     */
    public void setPreviousTime(Date previousTime) {
        this.previousTime = previousTime;
    }

    /**
     * @return the nextTime
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     */
    public Date getNextTime() {
        return this.nextTime;
    }

    /**
     * @author A18ccms a18ccms_gmail_com
     * @date 2017年4月17日 下午2:35:27
     * @param nextTime the nextTime to set
     */
    public void setNextTime(Date nextTime) {
        this.nextTime = nextTime;
    }

    /**
     *
     * @Title: isConcurrent
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2017年4月17日 下午2:46:29
     * @return
     */
    public Object isConcurrent() {
        // TODO Auto-generated method stub
        return this.isConcurrent;
    }
}
