package com.uc.utils;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {
	public static final String ORG_TREE = "orgTree";
	public static final String AREA_TREE="areaTree";
	public static final String MENU_TREE = "menuTree";
	
	public static final String CODE_AGE_GROUP="ageGroup";
	public static final String CODE_DUTY="duty";
	
	public static final String AREA_CODES = "areaCodes";
	public static final String AREA_CODES_WITH_ROOT = "areaCodesWithRoot";
	
	private Map<String, Object> map;
	
	private static CacheManager instance;
	
	private CacheManager(){
		map=new HashMap<String, Object>();
	}
	
	public Object getItem(String key){
		synchronized (CacheManager.class) {
			return map.get(key);
		}
	}
	public void setItem(String key,Object item){
		synchronized (CacheManager.class) {
			map.put(key, item);
		}
	}
	
	public static CacheManager GetInstance(){
		synchronized (CacheManager.class) {
			if(instance==null){
				instance=new CacheManager();
			}
			return instance;
		}
	}

	public void invalidate(String cacheKey) {
		synchronized (CacheManager.class) {
			map.remove(cacheKey);
		}	
	}
}
