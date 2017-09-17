package com.uc.web.controller.utils;

import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.uc.web.forms.ui.componet.DashboardItem;

public class DashboardManagerImpl implements DashboardManager {
	
	Map<String, DashboardItem> dashboardMap=new HashMap<>();
	
	public DashboardManagerImpl(Collection<DashboardItem> items) {
		for(DashboardItem item : items){			
			dashboardMap.put(item.getModuleName(), item);
		}
	}
	public DashboardManagerImpl(DashboardItem[] items) {
		for(DashboardItem item : items){			
			dashboardMap.put(item.getModuleName(), item);
		}
	}
	
	public void put(String name, DashboardItem item){
		dashboardMap.put(name, item);
	}

	@Override
	public DashboardItem find(String name) {		
		return dashboardMap.containsKey(name) ? dashboardMap.get(name) : null;
	}
	@Override
	public void dump(PrintStream err) {
		for(Entry<String, DashboardItem> entry: dashboardMap.entrySet()){
			err.println("key=["+ entry.getKey() + "] " + entry.getValue().getClass());
		}
	}
	
	
	
}
