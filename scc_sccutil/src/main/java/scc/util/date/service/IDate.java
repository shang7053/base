package scc.util.date.service;

import java.text.ParsePosition;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IDate {
	/** 
     * 获取某年最后一天日期 
     * @param year 年份 
     * @return Date 
     */  
   Date getYearLast(int year);
	/** 
     * 获取某年第一天日期 
     * @param year 年份 
     * @return Date 
     */  
    Date getYearFirst(int year);
	 /** 
     * 获取当年的最后一天 
     * @param year 
     * @return 
     */  
    Date getCurrYearLast();
	 /** 
     * 获取当年的第一天 
     * @param year 
     * @return 
     */  
	Date getCurrYearFirst();
	/**
	 * 
	 * @Title: autoCutDateForYear 
	 * @Description: 自动切割跨年时间段为两个
	 * @param start 开始日期
	 * @param end 结束日期
	 * @return 时间段,start获取开始，end获取结束
	 */
	List<Map<String, Date>> autoCutDateForYear(Date start,Date end);
	/**
	 * 
	 * @Title: getMonthStartTime 
	 * @Description: 本月开始时间 
	 * @return 时间 
	 */
	long getMonthStartTime();

	/**
	 * 
	 * @Title: getThreeMonthStartTime 
	 * @Description: 获得前3个月第一天的开始时间  例： 当前是10月，那么返回的是7月1号0点的时间
	 * @return 时间
	 */
	long getThreeMonthStartTime();

	/**
	 * 
	 * @Title: getWeekStartTime 
	 * @Description: 本周开始时间
	 * @return 时间
	 */
	long getWeekStartTime();
	/**
	 * 
	 * @Title: getWeekEndtTime 
	 * @Description: 本周结束始时间
	 * @return 时间
	 */
	long getWeekEndTime();
	/**
	 * 
	 * @Title: getWeekEndtTime 
	 * @Description: 以传入时间为准，获取周结束始时间
	 * @param l 当前时间
	 * @return 时间
	 */
	long getWeekEndTime(long l);
	
	/**
	 * 
	 * @Title: getMonthStartTime 
	 * @Description: 月开始时间
	 * @param l 当前时间
	 * @return 时间
	 */
	long getMonthStartTime(long l);

	/**
	 * 
	 * @Title: getWeekStartTime 
	 * @Description: 周开始时间
	 * @param l 当前时间
	 * @return 时间
	 */
	long getWeekStartTime(long l);

	/**
	 * 
	 * @Title: getMonth 
	 * @Description: 当前月份 
	 * @return 月份
	 */
	int getMonth();

	/**
	 * 
	 * @Title: getYear 
	 * @Description: 当前年份 
	 * @return 年份
	 */
	int getYear();

	/**
	 * 
	 * @Title: getWeek 
	 * @Description: 当前星期数
	 * @return 星期数
	 */
	int getWeek();

	/**
	 * 
	 * @Title: getMonth 
	 * @Description: 月份
	 * @param l 输入时间
	 * @return 月份
	 */
	int getMonth(long l);

	/**
	 * 
	 * @Title: getYear 
	 * @Description: 年份
	 * @param l 输入时间
	 * @return 年份
	 */
	int getYear(long l);

	/**
	 * 
	 * @Title: getDay 
	 * @Description: 日期
	 * @param l 输入时间
	 * @return 时间
	 */
	int getDay(long l);

	/**
	 * 
	 * @Title: getDayByYear 
	 * @Description: 天（年）
	 * @param l 天的毫秒值
	 * @return 时间
	 */
	int getDayByYear(long l);

	/**
	 * 
	 * @Title: isMouthEnd 
	 * @Description: 是否月末（比较到日期） 
	 * @param l 时间
	 * @return 时间
	 */
	boolean isMouthEnd(long l);

	/**
	 * 
	 * @Title: isLeapYear 
	 * @Description: 是否是闰年
	 * @param l 时间
	 * @return 时间
	 */
	boolean isLeapYear(long l);

	/**
	 * 
	 * @Title: isYearEnd 
	 * @Description: 是否年末
	 * @param l 时间
	 * @return 时间
	 */
	boolean isYearEnd(long l);

	/**
	 * 
	 * @Title: getWeek 
	 * @Description: 星期数
	 * @param l 时间
	 * @return 时间
	 */
	int getWeek(long l);
	/**
	 * 
	 * @Title: prevWeek 
	 * @Description: 以当前日期为标准，如何取n周前的日期
	 * @param week n周
	 * @return n周前的日期
	 */
	Date prevWeekStartTime(int week);
	/**
	 * 
	 * @Title: prevWeek 
	 * @Description: 以传入日期为标准，如何取n周前的日期
	 * @param dt 传入的日期
	 * @param week n周
	 * @return n周前的日期
	 */
	Date prevWeekStartTime(Date dt, int week);
	/**
	 * 
	 * @Title: prevWeek 
	 * @Description: 以当前日期为标准，如何取n周前的日期周结束日期
	 * @param week n周
	 * @return n周前的日期
	 */
	Date prevWeekEndTime(int week);
	/**
	 * 
	 * @Title: prevWeek 
	 * @Description: 以传入日期为标准，如何取n周前的日期周结束日期
	 * @param dt 传入的日期
	 * @param week n周
	 * @return n周前的日期
	 */
	Date prevWeekEndTime(Date dt, int week);

	/**
	 * 
	 * @Title: getDayStartTime 
	 * @Description: 当天开始时间0:00:00:000
	 * @return 时间
	 */
	long getDayStartTime();

	/**
	 * 
	 * @Title: getDayEndTime 
	 * @Description: 当天结束时间23:59:59:999
	 * @return 时间
	 */
	long getDayEndTime();

	/**
	 * 
	 * @Title: getDayStartTime 
	 * @Description: 当天开始时间0:00:00:000
	 * @param l 时间
	 * @return 时间
	 */
	long getDayStartTime(long l);

	/**
	 * 
	 * @Title: getDayEndTime 
	 * @Description: 当天结束时间23:59:59:999
	 * @param l 时间
	 * @return 时间
	 */
	long getDayEndTime(long l);

	/**
	 * 
	 * @Title: getDateString 
	 * @Description: 获得时间字符串。默认"yyyy-MM-dd"
	 * @param l 时间
	 * @return 时间
	 */
	String getDateString(long l);

	/**
	 * 
	 * @Title: getDateString 
	 * @Description: 获得时间字符串。默认"yyyy-MM-dd"
	 * @param l 时间
	 * @param dateFormat 格式
	 * @return 时间
	 */
	String getDateString(long l, String dateFormat);
	/**
	 * 
	 * @Title: getDate 
	 * @Description: 获得时间毫秒值
	 * @param str 时间
	 * @param dateFormat 格式
	 * @return 毫秒值
	 */
	long getDate(String str, String dateFormat);

	/**
	 * 
	 * @Title: subDay 
	 * @Description: 天数差
	 * @param startTime 初始时间
	 * @param endTime 结束时间
	 * @return 时间
	 */
	int subDay(long startTime, long endTime);

	/**
	 * 
	 * @Title: subDay 
	 * @Description: 天数差
	 * @param startTime 初始时间
	 * @param endTime 结束时间
	 * @param haveHour 是否有让时间参与计算。默认false。只记天数差。
	 * @return 天数差
	 */
	int subDay(long startTime, long endTime, boolean haveHour);

	/**
	 * 
	 * @Title: subDay 
	 * @Description: 与当前日期天数差 endTime-this
	 * @param endTime 结束时间
	 * @param haveHour 是否有让时间参与计算。false,只记天数差。
	 * @return 时间
	 */
	int subDay(long endTime, boolean haveHour);
	/**
	 * 字符串转换为long
	 * 
	 * @param date
	 * @return
	 */
	long convert2long(String date);

	/**
	 * 比较出发日期与到达日期，如果返回日期小于出发日期时，返回false
	 */
	boolean compareDate(Date startDate, Date returnDate);

	/**
	 * 两日期做减法，返回天数
	 * 
	 * @param startDate
	 * @param returnDate
	 * @return
	 */
	long subtractDate(Date startDate, Date returnDate);

	/**
	 * 两日期做减法，返回分钟
	 * 
	 * @param startDate
	 * @param returnDate
	 * @return
	 */
	long subtractDateReturnMin(Date startDate, Date returnDate);

	/**
	 * 计算两个日期相差的天数，如果date2 > date1 返回正数，否则返回负数
	 */
	long dayDiff(Date date1, Date date2);

	/**
	 * 获得某月的天数
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	int getDaysOfMonth(String year, String month);

	/**
	 * 获取某年某月的天数
	 */
	int getDaysOfMonth(int year, int month);

	/**
	 * 获得当前日期
	 */
	int getToday();

	/**
	 * 获得当前月份
	 */
	int getToMonth();

	/**
	 * 获得当前年份
	 */
	int getToYear();

	/**
	 * 返回日期的天
	 */
	int getDay(Date date);

	/**
	 * 返回日期的年
	 */
	int getYear(Date date);

	/**
	 * 返回日期的月份，1-12
	 */
	int getMonth(Date date);

	/**
	 * 把符合日期格式的字符串转换为日期类型
	 */
	Date stringtoDate(String dateStr, String format);

	/**
	 * 把符合日期格式的字符串转换为日期类型
	 */
	Date stringtoDate(String dateStr, String format, ParsePosition pos);

	/**
	 * 把日期转换为字符串
	 */
	String dateToString(Date date, String format);

	/**
	 * 获取当前时间的指定格式
	 */
	String getCurrDate(String format);

	/**
	 * 比较两个日期的年差
	 */
	int yearDiff(String before, String after);

	/**
	 * 比较指定日期与当前日期的差
	 */
	int yearDiffCurr(String after);

	/**
	 * 比较指定日期与当前日期的差
	 */
	long dayDiffCurr(String before);

	/**
	 * 获取每月的第一周
	 */
	int getFirstWeekdayOfMonth(int year, int month);

	/**
	 * 获取每月的最后一周
	 */
	int getLastWeekdayOfMonth(int year, int month);

	/**
	 * 日期按字加减
	 * 
	 * @param date
	 * @param field
	 * @param amount
	 * @return
	 */
	Date addDateByField(Date date, int field, int amount);
	/**
	 * 获取几个月的第一天
	 * @Title: prevMonthStartTime 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param month
	 * @return
	 */
	public Date prevMonthStartTime(int month);
	/**
	 * 
	 * @Title: prevMonthStartTime 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param dt
	 * @param month
	 * @return
	 */
	public Date prevMonthStartTime(Date dt, int month);
	/**
	 * 
	 * @Title: getUTCDate 
	 * @Description: 根据传入时间（北京）获取UTC时间
	 * @param localDate
	 * @return
	 */
	Date getUTCDate(Date localDate);
	/**
	 * 
	 * @Title: preDate 
	 * @Description: 传入日期获取days前的日期
	 * @param sourceDate
	 * @param days
	 * @return
	 */
	Date preDate(Date sourceDate,Integer days); 
	/**
	 * 
	 * @Title: preDate 
	 * @Description: 传入日期获取days后的日期
	 * @param sourceDate
	 * @param days
	 * @return
	 */
	Date nextDate(Date sourceDate,Integer days); 
	/**
	 * 
	 * @Title: preDate 
	 * @Description: 传入当前日期获取days前的日期
	 * @param sourceDate
	 * @param days
	 * @return
	 */
	Date preDate(Integer days); 
	/**
	 * 
	 * @Title: preDate 
	 * @Description: 传入当前日期获取days后的日期
	 * @param sourceDate
	 * @param days
	 * @return
	 */
	Date nextDate(Integer days); 
	/**
	 * 
	 * @Title: lastMonthLastDay 
	 * @Description: 传入当前日期获取上月的最后一天的日期
	 * @param date
	 * @return
	 */
	Date lastMonthLastDay(Date date);
	/**
	 * 
	 * @Title: lastMonthLastDay 
	 * @Description: 传入当前日期获取当月的最后一天的日期
	 * @param date
	 * @return
	 */
	Date MonthLastDay(Date date);
}