package com.uc.web.utils;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Properties;

import com.uc.web.domain.EntityBase;

public class SystemConfig {
	
	protected static final String KEY_NOTICE_COUNT="notice.count";
	protected static final int DEFAULT_NOTICE_COUNT = 5;
	
	protected static final String KEY_PAGE_SIZE="pageCtrl.Size";
	protected static final int DEFAULT_PAGE_SIZE = 25;
	
	protected static final String KEY_DEBUG_FLAG="debug";
	protected static final boolean DEFAULT_DEBUG_FLAG=false;
	protected static final String KEY_NO_LOGIN = "noLogin";
	
	protected static final String KEY_ENTITY_TO_STRING = "platform.tostring";
	protected static final int DEFAULT_OUTPUT_LEVEL = 0;
	
	protected Properties configs=new Properties();
	
	static SystemConfig instance= new SystemConfig();
	
	public static SystemConfig getInstance(){
		return instance;
	}
	
	public void load(String cfgFile){
		try{
			InputStreamReader stream=new InputStreamReader( SystemConfig.class.getResourceAsStream("/"+cfgFile), "UTF-8");
			configs.load(stream);
			stream.close();
			setup();
		}
		catch (Exception e) {
		}
	}
	
	protected void setup(){
		EntityBase.OUTPUT_DETAIL = getConfigInt(KEY_ENTITY_TO_STRING, DEFAULT_OUTPUT_LEVEL);
	}
	public boolean getConfigBool(String name, boolean defaultValue){
		String val= configs.getProperty(name, "" + defaultValue);
		return val.equalsIgnoreCase("true");
	}
	public int getConfigInt(String name, int defaultValue){
		String value=configs.getProperty(name, "" + defaultValue);
		try{
			int val = Integer.parseInt(value);
			return val;
		} catch(Exception e){
			return defaultValue;
		}
	}
	public BigDecimal getConfigDecimal(String name, BigDecimal defaultValue){
		String val=configs.getProperty(name, defaultValue.toString());
		try{
			BigDecimal ret=new BigDecimal(val);
			return ret;
		} catch(Exception e){
			return defaultValue;
		}
	}
	public double getConfigDouble(String name, double defaultValue){
		String val=configs.getProperty(name, ""+defaultValue);
		try{
			double ret = Double.parseDouble(val);
			return ret;
		}catch(Exception e){
			return defaultValue;
		}
	}
	public String getConfigString(String name, String defaultValue){
		return configs.getProperty(name, defaultValue);
	}
	
	public static int getPageSize(){
		return getInstance().getConfigInt(KEY_PAGE_SIZE, DEFAULT_PAGE_SIZE);		
	}
	
	public static int getNoticeCount(){
		return getInstance().getConfigInt(KEY_NOTICE_COUNT, DEFAULT_NOTICE_COUNT);
	}
	
	public static boolean isDebug(){
		return getInstance().getConfigBool(KEY_DEBUG_FLAG, DEFAULT_DEBUG_FLAG);
	}
	public static boolean noLogin(){
		return getInstance().getConfigBool(KEY_NO_LOGIN, false);
	}
}
