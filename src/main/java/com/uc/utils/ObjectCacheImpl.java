package com.uc.utils;

import java.util.HashMap;
import java.util.Map;

import com.uc.utils.ObjectCache;

public class ObjectCacheImpl implements ObjectCache {
	private Map<String,Object> objects=new HashMap<>();
	
	@Override
	public synchronized void put(String name, Object object){
		objects.put(name, object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public synchronized <T> T get(String name) {
		try{
			return (T)objects.get(name);
		}
		catch (Exception e) {
			return null;
		}
    }
	@Override
	public synchronized boolean has(String name){
		return objects.containsKey(name);
	}
	
	private static ObjectCacheImpl instance=new ObjectCacheImpl();
	
	public static ObjectCacheImpl getInstance(){
		return instance;
	}
}
