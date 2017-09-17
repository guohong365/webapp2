package com.uc.web.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class AbstractSettings implements Settings {
	
	Map<String, Object> map=new HashMap<>();
	
	protected Map<String, Object> getMap() {
		return map;
	}

	@Override
	public <T> T get(String key) {
		try{
			@SuppressWarnings("unchecked")
			T item=(T)map.get(key);
			return item;
		} catch (Exception e) {
			return null;
		}		
	}

	@Override
	public void put(String key, Object item) {
		map.put(key, item);		
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public Set<String> keys() {
		return map.keySet();
	}

	@Override
	public Collection<Object> Values() {
		return map.values();
	}

	@Override
	public boolean cotainsKey(String key) {
		return map.containsKey(key);
	}
}
