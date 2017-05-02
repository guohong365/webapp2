package com.uc.web.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class AbstractSettings implements Settings {
	
	Map<String, Serializable> settingsMap=new HashMap<>();
	@Override
	public Map<String, ? extends Serializable> getMap() {
		return (Map<String, ? extends Serializable>) settingsMap;
	}

	@Override
	public <T extends Serializable> T get(String key) {
		try{
			@SuppressWarnings("unchecked")
			T item=(T)settingsMap.get(key);
			return item;
		} catch (Exception e) {
			return null;
		}		
	}

	@Override
	public <T extends Serializable> void put(String key, T item) {
		settingsMap.put(key, item);		
	}

	@Override
	public int size() {
		return settingsMap.size();
	}

	@Override
	public Set<String> keys() {
		return settingsMap.keySet();
	}

	@Override
	public Collection<? extends Serializable> Values() {
		return (Collection<? extends Serializable>) settingsMap.values();
	}

	@Override
	public boolean cotainsKey(String key) {
		return settingsMap.containsKey(key);
	}
}
