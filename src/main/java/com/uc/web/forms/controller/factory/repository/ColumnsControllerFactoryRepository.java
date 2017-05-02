package com.uc.web.forms.controller.factory.repository;

import java.util.HashMap;
import java.util.Map;

import com.uc.web.forms.controller.factory.ColumnsControllerFactory;

public class ColumnsControllerFactoryRepository{
    private static Map<String, ColumnsControllerFactory> facrotyMap;
    
	public static ColumnsControllerFactory getFactory(String mode) {
		synchronized (ColumnsControllerFactoryRepository.class) {
			if(facrotyMap==null){
				facrotyMap=new HashMap<>();
				return null;
			}
			return facrotyMap.get(mode);
		}
	}
	
	public static void register(ColumnsControllerFactory factory){
		synchronized (ColumnsControllerFactoryRepository.class) {
			if(facrotyMap==null){
				facrotyMap=new HashMap<>();				
			}
			facrotyMap.put(factory.getName(), factory);
		}
	}
}
