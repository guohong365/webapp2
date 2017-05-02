package com.uc.utils;

public interface ObjectCache {
	
	public void put(String name, Object object);

	public <T> T get(String name);

	public boolean has(String name);
}
