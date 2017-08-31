package com.uc.utils.calendar;

import java.util.Calendar;

public class CalendarUtils {
	
	/**
	 * @return 小时、分钟、秒、毫秒都置零的当前日期。
	 */
	public static Calendar getDate(){
		Calendar calendar=Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}
	/** 指定年、月、日生成小时、分钟、秒、毫秒都置零的当前日期。
	 * @param year，年份，
	 * @param month，月份，1-12
	 * @param date 日期，1-31
	 * @return 小时、分钟、秒、毫秒都置零的日期。
	 */
	public static Calendar getDate(int year, int month, int date){
		Calendar calendar=Calendar.getInstance();
		calendar.set(year, month - 1, date, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}
	/** 依据输入calendar的日期生成小时、分钟、秒、毫秒都置零的日期。
	 * @param calendar 
	 * @return 小时、分钟、秒、毫秒都置零的日期。
	 */
	public static Calendar getDate(Calendar calendar){
		Calendar c=Calendar.getInstance();
		c.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c;
	}
	/**依据输入calendar的日期生成该日期指定月份1号的小时、分钟、秒、毫秒都置零的日期
	 * @param calendar
	 * @return 小时、分钟、秒、毫秒都置零的日期。
	 */
	public static Calendar getFirstDayOfMonth(Calendar calendar){
		Calendar c=getDate(calendar);
		c.set(Calendar.DATE, 1);
		return c;
	}
	public static Calendar getLastDayOfMonth(Calendar calendar){
		Calendar c=getFirstDayOfMonth(calendar);
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DATE, -1);
		return c;
	}
	/**返回当前日期之前years年的日期
	 * @param years 
	 * @return 小时、分钟、秒、毫秒都置零的日期。
	 */
	public static Calendar getDateYearsAgo(int years){
		Calendar calendar=getDate();
		calendar.add(Calendar.YEAR, -years);
		return calendar;
	}
	public static Calendar getDateYearsAgo(Calendar calendar, int years){
		Calendar c=getDate(calendar);
		c.add(Calendar.YEAR, -years);
		return c;
	}	
	public static Calendar getFirstDayOfLastMonth(){
		Calendar calendar=getFirstDayOfMonth(Calendar.getInstance());
		calendar.add(Calendar.MONTH, -1);
		return calendar;
	}
	public static Calendar getDateMonthsAgo(int months)	{
		Calendar calendar=getDate();
		calendar.add(Calendar.MONTH, -months);
		return calendar;
	}
	public static Calendar getDateMonthsAgo(Calendar calendar, int months){
		Calendar c=getDate(calendar);
		c.add(Calendar.MONTH, -months);
		return c;
	}
	public static Calendar getDateAfterMonths(int months){
		Calendar calendar=getDate();
		calendar.add(Calendar.MONTH, months);
		return calendar;
	}	
	public static Calendar getDateAfterMonths(Calendar calendar,int months){
		Calendar c=getDate();
		c.add(Calendar.MONTH, months);
		return c;
	}
	public static Calendar getDateAfterDays(int days){
		Calendar calendar=getDate();
		calendar.add(Calendar.DATE, days);
		return calendar;
	}
	public static Calendar getDateAfterDays(Calendar calendar, int days){
		Calendar c=getDate(calendar);
		c.add(Calendar.DATE, days);
		return c;
	}
	
	public static String FormatMillisecond(long millisecond){
		long ms = millisecond % 1000;
		long s = millisecond / 1000;
		long m = s/60;
		long h = m/60;
		return String.format("%d:%d:%d %d", h,m,s,ms);
	}
	
	public static float getHours(long millisecond){
		return ((float)millisecond)/1000/60/60;
	}
	
	public static float getMinutes(long millisecond){
		return ((float)millisecond)/1000/60;
	}
	public static float getSecond(long millisecond){
		return ((float)millisecond)/1000;
	}
}
