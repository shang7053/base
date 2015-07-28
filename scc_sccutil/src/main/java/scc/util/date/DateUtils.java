package scc.util.date;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @author scc
 *
 */
public final class DateUtils {
	/**
	 * 一天的毫秒数
	 */
	public static final long ONE_HOUR_TIME = 60 * 60 * 1000l;
	public static final long ONE_DATE_TIME = 24 * ONE_HOUR_TIME;
	private static final long OneDateSub = 8 * 60 * 60 * 1000l;
	/**
	 * 一周的毫秒数
	 */
	public static final long ONE_WEEK_TIME = 7 * ONE_DATE_TIME;
	public static final long OneMonthEmpty30 = 30 * ONE_DATE_TIME;
	public static final long OneMonthEmpty31 = 31 * ONE_DATE_TIME;
	public static final long OneMonthEmpty29 = 29 * ONE_DATE_TIME;
	public static final long OneMonthEmpty28 = 28 * ONE_DATE_TIME;
	private static final String defaultSDFStr = "yyyy-MM-dd HH:mm:ss.SSS";
	private static final SimpleDateFormat DefaultSDF = new SimpleDateFormat(defaultSDFStr);
	// 格式：年－月－日
	public static final String LONG_DATE_FORMAT = "yyyy-MM-dd";

	// private static final Calendar defaultCal =
	// Calendar.getInstance(Locale.CHINESE);
	public static void main(String[] args) {
		System.out.println("day start:" + getDateString(getDayStartTime()));
		System.out.println("day end:" + getDateString(getDayEndTime()));
		System.out.println("week start:" + getDateString(getWeekStartTime()));
		System.out.println("Month start:" + getDateString(getMonthStartTime()));
		System.out.println("month:" + getMonth());
		System.out.println("week:" + getWeek(System.currentTimeMillis()));
		System.out.println("year:" + getYear(System.currentTimeMillis()));
		System.out.println("lunar:" + getDateString(getLunarCalendar(System.currentTimeMillis())));
		System.out.println("lunar:" + dayDiffCurr("2014-12-19"));
	}

	/**
	 * 本月开始时间
	 * 
	 * @return
	 */
	public static long getMonthStartTime() {
		return getMonthStartTime(System.currentTimeMillis());
	}

	/**
	 * 获得前3个月第一天的开始时间 例： 当前是10月，那么返回的是8月1号0点的时间
	 * 
	 * @return
	 */
	public static long getThreeMonthStartTime() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -2);
		cal.set(Calendar.DATE, 1);
		return getDayStartTime(cal.getTimeInMillis());
	}

	/**
	 * 本周开始时间
	 * 
	 * @return
	 */
	public static long getWeekStartTime() {
		return getWeekStartTime(System.currentTimeMillis());
	}

	/**
	 * 月开始时间
	 * 
	 * @return
	 */
	public static long getMonthStartTime(long l) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(l);
		cal.set(Calendar.DATE, 1);
		return getDayStartTime(cal.getTime().getTime());
	}

	/**
	 * 周开始时间
	 * 
	 * @return
	 */
	public static long getWeekStartTime(long l) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(l);
		cal.set(Calendar.DAY_OF_WEEK, 2);
		if (7 == getWeek(l))
			return getDayStartTime(cal.getTime().getTime()) - ONE_WEEK_TIME;
		else
			return getDayStartTime(cal.getTime().getTime());
	}

	/**
	 * 当前月份
	 * 
	 * @return
	 */
	public static int getMonth() {
		return getMonth(System.currentTimeMillis());
	}

	/**
	 * 当前年份
	 * 
	 * @param l
	 * @return
	 */
	public static int getYear() {
		return getYear(System.currentTimeMillis());
	}

	/**
	 * 当前星期数
	 * 
	 * @return
	 */
	public static int getWeek() {
		return getWeek(System.currentTimeMillis());
	}

	/**
	 * 月份
	 * 
	 * @param l
	 * @return
	 */
	public static int getMonth(long l) {
		Calendar cal = Calendar.getInstance(Locale.CHINESE);
		cal.setTimeInMillis(l);
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * 年份
	 * 
	 * @param l
	 * @return
	 */
	public static int getYear(long l) {
		Calendar cal = Calendar.getInstance(Locale.CHINESE);
		cal.setTimeInMillis(l);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 日期
	 * 
	 * @param l
	 * @return
	 */
	public static int getDay(long l) {
		Calendar cal = Calendar.getInstance(Locale.CHINESE);
		cal.setTimeInMillis(l);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 天（年）
	 * 
	 * @param l
	 * @return
	 */
	public static int getDayByYear(long l) {
		Calendar cal = Calendar.getInstance(Locale.CHINESE);
		cal.setTimeInMillis(l);
		return cal.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 是否月末（比较到日期）
	 * 
	 * @param l
	 * @return
	 */
	public static boolean isMouthEnd(long l) {
		int month = getMonth(l);
		int day = getDay(l);
		if (isIntIn(month, 1, 3, 5, 7, 8, 10, 12)) {
			if (31 == day) {
				return true;
			}
		} else if (isIntIn(month, 4, 6, 9, 11)) {
			if (30 == day) {
				return true;
			}
		} else if (isLeapYear(l)) {
			return 29 == day;
		} else {
			return 28 == day;
		}
		return false;
	}

	private static boolean isIntIn(int thisInt, int... is) {
		if (null == is) {
			return false;
		}
		for (int i : is) {
			if (thisInt == i) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否是闰年
	 * 
	 * @return
	 */
	public static boolean isLeapYear(long l) {
		int year = getYear(l);
		return 0 == year % 4 || 0 == year % 100 || 0 == year % 400;
	}

	/**
	 * 是否年末
	 * 
	 * @param l
	 * @return
	 */
	public static boolean isYearEnd(long l) {
		Calendar cal = Calendar.getInstance(Locale.CHINESE);
		cal.setTimeInMillis(l);
		int day = cal.get(Calendar.DAY_OF_YEAR);
		if (isLeapYear(l)) {
			return 366 == day;
		} else {
			return 365 == day;
		}
	}

	/**
	 * 星期数
	 * 
	 * @param l
	 * @return
	 */
	public static int getWeek(long l) {
		Calendar cal = Calendar.getInstance(Locale.CHINESE);
		cal.setTimeInMillis(l);
		int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		return week == 0 ? 7 : week;
	}

	/**
	 * 当天开始时间0:00:00:000
	 * 
	 * @return
	 */
	public static long getDayStartTime() {
		return (System.currentTimeMillis() / ONE_DATE_TIME) * ONE_DATE_TIME - OneDateSub;
	}

	/**
	 * 当天结束时间23:59:59:999
	 * 
	 * @return
	 */
	public static long getDayEndTime() {
		return getDayStartTime() + ONE_DATE_TIME - 1l;
	}

	/**
	 * 当天开始时间0:00:00:000
	 * 
	 * @return
	 */
	public static long getDayStartTime(long l) {
		return (l / ONE_DATE_TIME) * ONE_DATE_TIME - OneDateSub;
	}

	/**
	 * 当天结束时间23:59:59:999
	 * 
	 * @return
	 */
	public static long getDayEndTime(long l) {
		return getDayStartTime(l) + ONE_DATE_TIME - 1l;
	}

	/**
	 * 获得时间字符串。默认"yyyy-MM-dd"
	 * 
	 * @param l
	 * @return
	 */
	public static String getDateString(long l) {
		return DefaultSDF.format(new Date(l));
	}

	/**
	 * 获得时间字符串。默认"yyyy-MM-dd"
	 * 
	 * @param l
	 * @param dateFormat
	 * @return
	 */
	public static String getDateString(long l, String dateFormat) {
		return new SimpleDateFormat(dateFormat == null ? defaultSDFStr : dateFormat).format(new Date(l));
	}

	public static long getDate(String str, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			return sdf.parse(str).getTime();
		} catch (ParseException e) {
			return 0;
		}
	}

	/**
	 * 天数差
	 * 
	 * @param startTime
	 *            初始时间
	 * @param endTime
	 *            结束时间
	 * @param haveHour
	 *            是否有让时间参与计算。默认false。只记天数差。
	 * @return
	 */
	public static int subDay(long startTime, long endTime) {
		return subDay(startTime, endTime, false);
	}

	/**
	 * 天数差
	 * 
	 * @param startTime
	 *            初始时间
	 * @param endTime
	 *            结束时间
	 * @param haveHour
	 *            是否有让时间参与计算。默认false。只记天数差。
	 * @return
	 */
	public static int subDay(long startTime, long endTime, boolean haveHour) {
		long subTime;
		if (haveHour) {
			subTime = endTime - startTime;
		} else {
			subTime = getDayStartTime(endTime) - getDayStartTime(startTime);
		}
		return (int) (subTime / ONE_DATE_TIME);
	}

	/**
	 * 与当前日期天数差 endTime-this
	 * 
	 * @param endTime
	 *            结束时间
	 * @param haveHour
	 *            是否有让时间参与计算。false,只记天数差。
	 * @return
	 */
	public static int subDay(long endTime, boolean haveHour) {
		return subDay(System.currentTimeMillis(), endTime, haveHour);
	}

	/**
	 * 获得中国阴历时间(此方法当前错误，待修改)
	 * 
	 * @param solar
	 * @return
	 */
	@Deprecated
	public static long getLunarCalendar(long solar) {
		return solar;
	}

	/**
	 * 字符串转换为long
	 * 
	 * @param date
	 * @return
	 */
	public static long convert2long(String date) {
		if (date != null) {
			// 长日期格式
			String TIME_FORMAT = "yyyy-MM-dd";
			try {
				SimpleDateFormat sf = new SimpleDateFormat(TIME_FORMAT);
				return sf.parse(date).getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return 0l;
	}

	/**
	 * 比较出发日期与到达日期，如果返回日期小于出发日期时，返回false
	 */
	public static boolean compareDate(Date startDate, Date returnDate) {
		return returnDate.after(startDate);
	}

	/**
	 * 两日期做减法，返回天数
	 * 
	 * @param startDate
	 * @param returnDate
	 * @return
	 */
	public static long subtractDate(Date startDate, Date returnDate) {

		return (returnDate.getTime() - startDate.getTime()) / 86400000;
	}

	/**
	 * 两日期做减法，返回分钟
	 * 
	 * @param startDate
	 * @param returnDate
	 * @return
	 */
	public static long subtractDateReturnMin(Date startDate, Date returnDate) {

		return (returnDate.getTime() - startDate.getTime()) / 60000;
	}

	/**
	 * 计算两个日期相差的天数，如果date2 > date1 返回正数，否则返回负数
	 */
	public static long dayDiff(Date date1, Date date2) {
		return (date2.getTime() - date1.getTime()) / 86400000;
	}

	/**
	 * 获得某月的天数
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDaysOfMonth(String year, String month) {
		int days = 0;
		if (month.equals("1") || month.equals("3") || month.equals("5") || month.equals("7") || month.equals("8") || month.equals("10") || month.equals("12")) {
			days = 31;
		} else if (month.equals("4") || month.equals("6") || month.equals("9") || month.equals("11")) {
			days = 30;
		} else {
			if ((Integer.parseInt(year) % 4 == 0 && Integer.parseInt(year) % 100 != 0) || Integer.parseInt(year) % 400 == 0) {
				days = 29;
			} else {
				days = 28;
			}
		}

		return days;
	}

	/**
	 * 获取某年某月的天数
	 */
	public static int getDaysOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获得当前日期
	 */
	public static int getToday() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 获得当前月份
	 */
	public static int getToMonth() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获得当前年份
	 */
	public static int getToYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 返回日期的天
	 */
	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 返回日期的年
	 */
	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 返回日期的月份，1-12
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 把符合日期格式的字符串转换为日期类型
	 */
	public static Date stringtoDate(String dateStr, String format) {
		Date d = null;
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			formater.setLenient(false);
			d = formater.parse(dateStr);
		} catch (Exception e) {
			// log.error(e);
			d = null;
		}
		return d;
	}

	/**
	 * 把符合日期格式的字符串转换为日期类型
	 */
	public static Date stringtoDate(String dateStr, String format, ParsePosition pos) {
		Date d = null;
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			formater.setLenient(false);
			d = formater.parse(dateStr, pos);
		} catch (Exception e) {
			d = null;
		}
		return d;
	}

	/**
	 * 把日期转换为字符串
	 */
	public static String dateToString(Date date, String format) {
		String result = "";
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			result = formater.format(date);
		} catch (Exception e) {
			// log.error(e);
		}
		return result;
	}

	/**
	 * 获取当前时间的指定格式
	 */
	public static String getCurrDate(String format) {
		return dateToString(new Date(), format);
	}

	/**
	 * 比较两个日期的年差
	 */
	public static int yearDiff(String before, String after) {
		Date beforeDay = stringtoDate(before, LONG_DATE_FORMAT);
		Date afterDay = stringtoDate(after, LONG_DATE_FORMAT);
		return getYear(afterDay) - getYear(beforeDay);
	}

	/**
	 * 比较指定日期与当前日期的差
	 */
	public static int yearDiffCurr(String after) {
		Date beforeDay = new Date();
		Date afterDay = stringtoDate(after, LONG_DATE_FORMAT);
		return getYear(beforeDay) - getYear(afterDay);
	}

	/**
	 * 比较指定日期与当前日期的差
	 */
	public static long dayDiffCurr(String before) {
		Date currDate = stringtoDate(getCurrDate(LONG_DATE_FORMAT), LONG_DATE_FORMAT);
		Date beforeDate = stringtoDate(before, LONG_DATE_FORMAT);
		return (currDate.getTime() - beforeDate.getTime()) / 86400000;

	}

	/**
	 * 获取每月的第一周
	 */
	public static int getFirstWeekdayOfMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.SATURDAY); // 星期天为第一天
		c.set(year, month - 1, 1);
		return c.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 获取每月的最后一周
	 */
	public static int getLastWeekdayOfMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.SATURDAY); // 星期天为第一天
		c.set(year, month - 1, getDaysOfMonth(year, month));
		return c.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 日期按字加减
	 * 
	 * @param date
	 * @param field
	 * @param amount
	 * @return
	 */
	public static Date addDateByField(Date date, int field, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(field, amount);
		return c.getTime();
	}
}
