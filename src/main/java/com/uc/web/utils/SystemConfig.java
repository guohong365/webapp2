package com.uc.web.utils;

import java.io.InputStreamReader;
import java.util.Properties;

public class SystemConfig {
		
	public static final String KEY_NOTICE_COUNT="notice.count";
	public static final String DEFAULT_NOTICE_COUNT = "5";
	
	public static final String KEY_PAGE_SIZE="pageCtrl.Size";
	private static final String DEFAULT_PAGE_SIZE = "25";
	
	public static final String KEY_DEBUG_FLAG="debug";
	public static final String DEFAULT_DEBUG_FLAG="false";
	private static final String KEY_NO_LOGIN = "noLogin";
	
	static Properties configs=new Properties();
	
	public static void load(String cfgFile){
		try{
			InputStreamReader stream=new InputStreamReader( SystemConfig.class.getResourceAsStream("/"+cfgFile), "UTF-8");

			configs.load(stream);
			stream.close();
		}
		catch (Exception e) {
		}
	}
	public static String getConfig(String name, String defaultValue){
		return configs.getProperty(name, defaultValue);
	}
	
	public static int getPageSize(){
		int size;
		try{
			size=Integer.parseInt(configs.getProperty(KEY_PAGE_SIZE, DEFAULT_PAGE_SIZE));		
		}catch (Exception e) {
			size=Integer.parseInt(DEFAULT_PAGE_SIZE);
		}
		return size;
	}
	
	public static int getNoticeCount(){
		int count;
		try{
			count= Integer.parseInt(configs.getProperty(KEY_NOTICE_COUNT, DEFAULT_NOTICE_COUNT));
		} catch(Exception e){
			count=Integer.parseInt(DEFAULT_NOTICE_COUNT);
		}
		return count;
	}
	
	public static boolean isDebug(){
		String flag=configs.getProperty(KEY_DEBUG_FLAG);
		return flag!=null && flag.equalsIgnoreCase("true");
	}
	public static boolean noLogin(){
		String flag=configs.getProperty(KEY_NO_LOGIN);
		return "true".equalsIgnoreCase(flag);
	}
}
