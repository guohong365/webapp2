package com.uc.web.forms.controller.factory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ColumnsManagerFactoryRepository {
	private Map<String, ColumnsManagerFactory> map=new HashMap<>();

	public ColumnsManagerFactoryRepository(Collection<ColumnsManagerFactory> factories) {
		if (factories != null) {
			for (ColumnsManagerFactory factory : factories) {
				map.put(factory.getName(), factory);
			}
		}
	}

	public ColumnsManagerFactory get(String name) {
		return map.get(name);
	}
	
	private static ColumnsManagerFactoryRepository _instance;
	
	public static void setInstance(ColumnsManagerFactoryRepository instance){
		_instance=instance;
	}
	
	public static ColumnsManagerFactoryRepository getInstance(){
		return _instance;
	}

}
