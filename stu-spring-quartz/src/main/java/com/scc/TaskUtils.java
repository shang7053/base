/**   
 *
 * @Title: TaskUtils.java 
 * @Package com.scc 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2017年4月17日 下午2:19:12   
 */
package com.scc;

import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.impl.triggers.CronTriggerImpl;

/**
 *
 * @ClassName: TaskUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2017年4月17日 下午2:19:12
 * 
 */
public class TaskUtils {

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
     * @date 2017年4月17日 下午2:19:12
     */
    public TaskUtils() {
        // TODO Auto-generated constructor stub
    }

    private final static Logger logger = Logger.getLogger(TaskUtils.class);

    /**
     * 判断cron时间表达式正确性
     * 
     * @param cronExpression
     * @return
     */
    public static boolean isValidExpression(final String cronExpression) {
        // CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        CronTriggerImpl trigger = new CronTriggerImpl();
        try {
            trigger.setCronExpression(cronExpression);
            Date date = trigger.computeFirstFireTime(null);
            return date != null && date.after(new Date());
        } catch (ParseException e) {}
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValidExpression("0/10 * * * * ?"));
    }

    /*
     * 任务运行状态
     */
    public enum TASK_STATE {
        NONE("NONE", "未知"), NORMAL("NORMAL", "正常运行"), PAUSED("PAUSED", "暂停状态"), COMPLETE("COMPLETE", ""), ERROR("ERROR",
                "错误状态"), BLOCKED("BLOCKED", "锁定状态");

        private TASK_STATE(String index, String name) {
            this.name = name;
            this.index = index;
        }

        private String index;
        private String name;

        public String getName() {
            return this.name;
        }

        public String getIndex() {
            return this.index;
        }
    }
}
