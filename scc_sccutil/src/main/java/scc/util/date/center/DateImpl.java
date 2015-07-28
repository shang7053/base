package scc.util.date.center;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;

import scc.util.date.service.IDate;

/**
 * 
 * @ClassName: DateUtils
 * @Description: 日期工具类
 * @author scc
 * @date 2014年11月17日 下午1:50:42
 * 
 */
public final class DateImpl implements IDate {
	private Logger logger=Logger.getLogger(DateImpl.class);
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
	// 格式：年－月－日
	public static final String LONG_DATE_FORMAT = "yyyy-MM-dd";
	private static final SimpleDateFormat DefaultSDF = new SimpleDateFormat(defaultSDFStr);

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getMonthStartTime()
	 */
	@Override
	public long getMonthStartTime() {
		return getMonthStartTime(System.currentTimeMillis());
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getThreeMonthStartTime()
	 */
	@Override
	public long getThreeMonthStartTime() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -2);
		cal.set(Calendar.DATE, 1);
		return getDayStartTime(cal.getTimeInMillis());
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getWeekStartTime()
	 */
	@Override
	public long getWeekStartTime() {
		return getWeekStartTime(System.currentTimeMillis());
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getMonthStartTime(long)
	 */
	@Override
	public long getMonthStartTime(long l) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(l);
		cal.set(Calendar.DATE, 1);
		return getDayStartTime(cal.getTime().getTime());
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getWeekStartTime(long)
	 */
	@Override
	public long getWeekStartTime(long l) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(l);
		cal.set(Calendar.DAY_OF_WEEK, 2);
		if (7 == getWeek(l))
			return getDayStartTime(cal.getTime().getTime()) - ONE_WEEK_TIME;
		else
			return getDayStartTime(cal.getTime().getTime());
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getMonth()
	 */
	@Override
	public int getMonth() {
		return getMonth(System.currentTimeMillis());
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getYear()
	 */
	@Override
	public int getYear() {
		return getYear(System.currentTimeMillis());
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getWeek()
	 */
	@Override
	public int getWeek() {
		return getWeek(System.currentTimeMillis());
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getMonth(long)
	 */
	@Override
	public int getMonth(long l) {
		Calendar cal = Calendar.getInstance(Locale.CHINESE);
		cal.setTimeInMillis(l);
		return cal.get(Calendar.MONTH) + 1;
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getYear(long)
	 */
	@Override
	public int getYear(long l) {
		Calendar cal = Calendar.getInstance(Locale.CHINESE);
		cal.setTimeInMillis(l);
		return cal.get(Calendar.YEAR);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getDay(long)
	 */
	@Override
	public int getDay(long l) {
		Calendar cal = Calendar.getInstance(Locale.CHINESE);
		cal.setTimeInMillis(l);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getDayByYear(long)
	 */
	@Override
	public int getDayByYear(long l) {
		Calendar cal = Calendar.getInstance(Locale.CHINESE);
		cal.setTimeInMillis(l);
		return cal.get(Calendar.DAY_OF_YEAR);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#isMouthEnd(long)
	 */
	@Override
	public boolean isMouthEnd(long l) {
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

	private boolean isIntIn(int thisInt, int... is) {
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

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#isLeapYear(long)
	 */
	@Override
	public boolean isLeapYear(long l) {
		int year = getYear(l);
		return 0 == year % 4 || 0 == year % 100 || 0 == year % 400;
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#isYearEnd(long)
	 */
	@Override
	public boolean isYearEnd(long l) {
		Calendar cal = Calendar.getInstance(Locale.CHINESE);
		cal.setTimeInMillis(l);
		int day = cal.get(Calendar.DAY_OF_YEAR);
		if (isLeapYear(l)) {
			return 366 == day;
		} else {
			return 365 == day;
		}
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getWeek(long)
	 */
	@Override
	public int getWeek(long l) {
		Calendar cal = Calendar.getInstance(Locale.CHINESE);
		cal.setTimeInMillis(l);
		int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		return week == 0 ? 7 : week;
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getDayStartTime()
	 */
	@Override
	public long getDayStartTime() {
		return (System.currentTimeMillis() / ONE_DATE_TIME) * ONE_DATE_TIME - OneDateSub;
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getDayEndTime()
	 */
	@Override
	public long getDayEndTime() {
		return getDayStartTime() + ONE_DATE_TIME - 1l;
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getDayStartTime(long)
	 */
	@Override
	public long getDayStartTime(long l) {
		return (l / ONE_DATE_TIME) * ONE_DATE_TIME - OneDateSub;
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getDayEndTime(long)
	 */
	@Override
	public long getDayEndTime(long l) {
		return getDayStartTime(l) + ONE_DATE_TIME - 1l;
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getDateString(long)
	 */
	@Override
	public String getDateString(long l) {
		return DefaultSDF.format(new Date(l));
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getDateString(long, java.lang.String)
	 */
	@Override
	public String getDateString(long l, String dateFormat) {
		return new SimpleDateFormat(dateFormat == null ? defaultSDFStr : dateFormat).format(new Date(l));
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getDate(java.lang.String, java.lang.String)
	 */
	@Override
	public long getDate(String str, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			return sdf.parse(str).getTime();
		} catch (ParseException e) {
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#subDay(long, long)
	 */
	@Override
	public int subDay(long startTime, long endTime) {
		return subDay(startTime, endTime, false);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#subDay(long, long, boolean)
	 */
	@Override
	public int subDay(long startTime, long endTime, boolean haveHour) {
		long subTime;
		if (haveHour) {
			subTime = endTime - startTime;
		} else {
			subTime = getDayStartTime(endTime) - getDayStartTime(startTime);
		}
		return (int) (subTime / ONE_DATE_TIME);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#subDay(long, boolean)
	 */
	@Override
	public int subDay(long endTime, boolean haveHour) {
		return subDay(System.currentTimeMillis(), endTime, haveHour);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#convert2long(java.lang.String)
	 */
	@Override
	public long convert2long(String date) {
		if (date != null) {
			// 长日期格式
			String TIME_FORMAT = "yyyy-MM-dd";
			try {
				SimpleDateFormat sf = new SimpleDateFormat(TIME_FORMAT);
				return sf.parse(date).getTime();
			} catch (ParseException e) {
				logger.error(e);
			}
		}
		return 0l;
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#compareDate(java.util.Date, java.util.Date)
	 */
	@Override
	public boolean compareDate(Date startDate, Date returnDate) {
		return returnDate.after(startDate);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#subtractDate(java.util.Date, java.util.Date)
	 */
	@Override
	public long subtractDate(Date startDate, Date returnDate) {

		return (returnDate.getTime() - startDate.getTime()) / 86400000;
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#subtractDateReturnMin(java.util.Date, java.util.Date)
	 */
	@Override
	public long subtractDateReturnMin(Date startDate, Date returnDate) {

		return (returnDate.getTime() - startDate.getTime()) / 60000;
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#dayDiff(java.util.Date, java.util.Date)
	 */
	@Override
	public long dayDiff(Date date1, Date date2) {
		return (date2.getTime() - date1.getTime()) / 86400000;
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getDaysOfMonth(java.lang.String, java.lang.String)
	 */
	@Override
	public int getDaysOfMonth(String year, String month) {
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

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getDaysOfMonth(int, int)
	 */
	@Override
	public int getDaysOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getToday()
	 */
	@Override
	public int getToday() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DATE);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getToMonth()
	 */
	@Override
	public int getToMonth() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH) + 1;
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getToYear()
	 */
	@Override
	public int getToYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getDay(java.util.Date)
	 */
	@Override
	public int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DATE);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getYear(java.util.Date)
	 */
	@Override
	public int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getMonth(java.util.Date)
	 */
	@Override
	public int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#stringtoDate(java.lang.String, java.lang.String)
	 */
	@Override
	public Date stringtoDate(String dateStr, String format) {
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

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#stringtoDate(java.lang.String, java.lang.String, java.text.ParsePosition)
	 */
	@Override
	public Date stringtoDate(String dateStr, String format, ParsePosition pos) {
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

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#dateToString(java.util.Date, java.lang.String)
	 */
	@Override
	public String dateToString(Date date, String format) {
		String result = "";
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			result = formater.format(date);
		} catch (Exception e) {
			// log.error(e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getCurrDate(java.lang.String)
	 */
	@Override
	public String getCurrDate(String format) {
		return dateToString(new Date(), format);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#yearDiff(java.lang.String, java.lang.String)
	 */
	@Override
	public int yearDiff(String before, String after) {
		Date beforeDay = stringtoDate(before, LONG_DATE_FORMAT);
		Date afterDay = stringtoDate(after, LONG_DATE_FORMAT);
		return getYear(afterDay) - getYear(beforeDay);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#yearDiffCurr(java.lang.String)
	 */
	@Override
	public int yearDiffCurr(String after) {
		Date beforeDay = new Date();
		Date afterDay = stringtoDate(after, LONG_DATE_FORMAT);
		return getYear(beforeDay) - getYear(afterDay);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#dayDiffCurr(java.lang.String)
	 */
	@Override
	public long dayDiffCurr(String before) {
		Date currDate = stringtoDate(getCurrDate(LONG_DATE_FORMAT), LONG_DATE_FORMAT);
		Date beforeDate = stringtoDate(before, LONG_DATE_FORMAT);
		return (currDate.getTime() - beforeDate.getTime()) / 86400000;

	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getFirstWeekdayOfMonth(int, int)
	 */
	@Override
	public int getFirstWeekdayOfMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.SATURDAY); // 星期天为第一天
		c.set(year, month - 1, 1);
		return c.get(Calendar.DAY_OF_WEEK);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#getLastWeekdayOfMonth(int, int)
	 */
	@Override
	public int getLastWeekdayOfMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.SATURDAY); // 星期天为第一天
		c.set(year, month - 1, getDaysOfMonth(year, month));
		return c.get(Calendar.DAY_OF_WEEK);
	}

	/* (non-Javadoc)
	 * @see scc.util.date.center.Sss#addDateByField(java.util.Date, int, int)
	 */
	@Override
	public Date addDateByField(Date date, int field, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(field, amount);
		return c.getTime();
	}

	@Override
	public Date prevWeekStartTime(int week) {
		return prevWeekStartTime(new Date(),week);
	}

	@Override
	public Date prevWeekStartTime(Date dt, int week) {
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(getWeekStartTime(dt.getTime())));
        cal.add(Calendar.DAY_OF_MONTH, -week * 7);
        return cal.getTime();
	}
	@Override
	public long getWeekEndTime() {
		return getWeekEndTime(System.currentTimeMillis());
	}

	@Override
	public long getWeekEndTime(long l) {
		return getWeekStartTime(l)+ONE_WEEK_TIME-1l;
	}

	@Override
	public Date prevWeekEndTime(int week) {
		return prevWeekEndTime(new Date(), week);
	}

	@Override
	public Date prevWeekEndTime(Date dt, int week) {
		return new Date(prevWeekStartTime(dt, week).getTime()+ONE_WEEK_TIME-1l);
	}
	@Override
	public Date prevMonthStartTime(int month) {
		return prevMonthStartTime(new Date(), month);
	}
	@Override
	public Date prevMonthStartTime(Date dt, int month){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(getMonthStartTime(dt.getTime())));
		cal.add(Calendar.MONTH, -month*1);
		return cal.getTime();
	}

	@Override
	public List<Map<String, Date>> autoCutDateForYear(Date start, Date end) {
		List<Map<String, Date>> result=new ArrayList<>();
		Map<String,Date> temp=null;
		int startyear=getYear(start);
		int startMonth=getMonth(start);
		int endyear=getYear(end);
		int endMonth=getMonth(end);
		if(startyear<endyear){
			temp=new HashMap<>();
			temp.put("start", start);
			temp.put("end", getYearLast(getYear(start)));
			result.add(temp);
			temp=new HashMap<>();
			temp.put("start", getYearFirst(getYear(end)));
			temp.put("end", end);
			result.add(temp);
		}else if(startyear==endyear&&startMonth<=endMonth){
			temp=new HashMap<>();
			temp.put("start", start);
			temp.put("end", end);
			result.add(temp);
		}
		return result;
	}

	@Override
	public Date getCurrYearLast() {
		Calendar currCal=Calendar.getInstance();    
        int currentYear = currCal.get(Calendar.YEAR);  
        return getYearLast(currentYear);
	}

	@Override
	public Date getCurrYearFirst() {
		Calendar currCal=Calendar.getInstance();    
        int currentYear = currCal.get(Calendar.YEAR);  
        return getYearFirst(currentYear);  
	}

	@Override
	public Date getYearLast(int year) {
		Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);  
        Date currYearLast = calendar.getTime();  
        return currYearLast;  
	}

	@Override
	public Date getYearFirst(int year) {
		Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        Date currYearFirst = calendar.getTime();  
        return currYearFirst;  
	}

	@Override
	public Date getUTCDate(Date localDate) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(localDate);
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
        cal.add(java.util.Calendar.MILLISECOND, +(zoneOffset + dstOffset));
        return new Date(cal.getTimeInMillis());
	}

	@Override
	public Date preDate(Date sourceDate, Integer days) {
		Calendar rightNow=Calendar.getInstance(); 
		rightNow.setTime(sourceDate); 
		rightNow.add(Calendar.DATE,-days);//你要加减的日期   
		return rightNow.getTime();
	}

	@Override
	public Date nextDate(Date sourceDate, Integer days) {
		Calendar rightNow=Calendar.getInstance(); 
		rightNow.setTime(sourceDate); 
		rightNow.add(Calendar.DATE,days);//你要加减的日期   
		return rightNow.getTime();
	}

	@Override
	public Date preDate(Integer days) {
		return preDate(new Date(),days);
	}

	@Override
	public Date nextDate(Integer days) {
		return nextDate(new Date(), days);
	}

	@Override
	public Date MonthLastDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
	  int MaxDay=c.getActualMaximum(Calendar.DAY_OF_MONTH);
	  //按你的要求设置时间
	  c.set( c.get(Calendar.YEAR), c.get(Calendar.MONTH), MaxDay, 23, 59, 59);
		return c.getTime();
	}

	@Override
	public Date lastMonthLastDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.MONTH, Calendar.MONTH-1);
		return MonthLastDay(c.getTime());
	}
}
