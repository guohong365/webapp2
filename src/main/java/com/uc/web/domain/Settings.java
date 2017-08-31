package com.uc.web.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface Settings{
	public Map<String, ? extends Serializable> getMap();
	public <T extends Serializable> T get(String key);
	public <T extends Serializable>  void put(String key,T item);
	public int size();
	public Set<String> keys();
	public Collection<? extends Serializable> Values();
	public boolean cotainsKey(String key);
}
