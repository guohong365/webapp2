package com.uc.utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.UUID;

public class Utilities {
	static final int MOD=9999999;
	static int SEQUENCE=0;
	
	public static synchronized String generateId(String prefix, int length)
	{	
		SEQUENCE=SEQUENCE%MOD;
		java.util.Calendar c=Calendar.getInstance();
		String id=prefix + String.format(prefix + "%4d%02d%02d%02d%02d%02d%03d" ,
				c.get(Calendar.YEAR),
				c.get(Calendar.MONTH) + 1,
				c.get(Calendar.DAY_OF_MONTH), 
				c.get(Calendar.HOUR_OF_DAY),
				c.get(Calendar.MINUTE),
				c.get(Calendar.SECOND),
				c.get(Calendar.MILLISECOND));
		String pad="";
		if(length > id.length() + 7)
		{
			pad=String.format("%%0%dd",  length- id.length() -7);
			id += String.format(pad, SEQUENCE);
		}
		else{
			pad=String.format("%07d", SEQUENCE);
			id=id.substring(id.length() + pad.length() - length) + pad;
		}
		SEQUENCE++;
		return id;
	}
	public static String generateRandomId()
	{
		return UUID.randomUUID().toString();
	}
	public static String getDateString(String format)
	{
		java.util.Calendar c=Calendar.getInstance();
		return String.format(format, 
				c.get(Calendar.YEAR),
				c.get(Calendar.MONTH) + 1,
				c.get(Calendar.DAY_OF_MONTH)); 
	}
	public static String getDateTimeString(String format)
	{
		java.util.Calendar c=Calendar.getInstance();
		return String.format(format, 
				c.get(Calendar.YEAR),
				c.get(Calendar.MONTH) + 1,
				c.get(Calendar.DAY_OF_MONTH),
				c.get(Calendar.HOUR_OF_DAY),
				c.get(Calendar.MINUTE),
				c.get(Calendar.SECOND),
				c.get(Calendar.MILLISECOND));
	}
	public static String getTimeString(String format) {
		java.util.Calendar c=Calendar.getInstance();
		return String.format(format, 
				c.get(Calendar.HOUR_OF_DAY),
				c.get(Calendar.MINUTE),
				c.get(Calendar.SECOND),
				c.get(Calendar.MILLISECOND));
	}
	public static String getTomorrowDateString(String dateFormat) {
		java.util.Calendar c=Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 1);
		return String.format(dateFormat, 
				c.get(Calendar.YEAR),
				c.get(Calendar.MONTH) + 1,
				c.get(Calendar.DAY_OF_MONTH));
	}
	
	public static Calendar getDateFromString(String date) throws Exception{
		if(date.length() != 8 ) throw new Exception();
		Calendar calendar=Calendar.getInstance();
		String yearString=date.substring(0, 4);
		String monthString=date.substring(4, 6);
		String dayString=date.substring(6); 
		
		calendar.set(Calendar.YEAR, Integer.parseInt(yearString));
		calendar.set(Calendar.MONTH, Integer.parseInt(monthString) - 1 );
		calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dayString));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}
	public static String DataTimeStringToDate(String dataTime) {
		String date="";
		if(dataTime==null || dataTime.isEmpty())
			return date;
		if(dataTime.length() >=8 && dataTime.length() < 14){
			date= dataTime.substring(0, 4)+"��" + dataTime.substring(4,6) + "��" + dataTime.substring(6,8) +"��";
		}
		if(dataTime.length() >=14){
			date= dataTime.substring(0, 4)+"��" + dataTime.substring(4,6) + "��" + dataTime.substring(6,8) +"��" +" " +
					dataTime.substring(8,10)+"ʱ"+dataTime.substring(10, 12) + "��"+ dataTime.substring(12, 14) +"��";
		}
		return date;
	}

	public static String getMD5(String msg) {
		MessageDigest digest=null;
		try {
			digest=MessageDigest.getInstance("MD5");
			byte[] digestBytes=digest.digest(msg.getBytes());
			StringBuilder retBuilder=new StringBuilder();
			int val;
			for(byte b:digestBytes){
				val=b;
				if(val<0) val+=256;
				if(val<16) retBuilder.append('0');
				retBuilder.append(Integer.toHexString(val));
			}
			return retBuilder.toString().toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
		
	}
}
