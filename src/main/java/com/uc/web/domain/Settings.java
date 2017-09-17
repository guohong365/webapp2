package com.uc.web.domain;

import java.util.Collection;
import java.util.Set;

public interface Settings{
	public <T> T get(String key);
	public void put(String key,Object value);
	public int size();
	public Set<String> keys();
	public Collection<Object> Values();
	public boolean cotainsKey(String key);
}
