package com.uc.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegerUtils {
	public static Set<Long> getIntSet(String[] strs){
		Set<Long> set=new HashSet<>();
		for(String id : strs){
			try{
			Long l=Long.parseLong(id);
			set.add(l);
			}catch (Exception e){				
			}
		}
		return set;
	}
	public static List<Long> getIntList(String[] strs){
		List<Long> set=new ArrayList<>();
		for(String id : strs){
			try{
			Long l=Long.parseLong(id);
			set.add(l);
			}catch (Exception e){				
			}
		}
		return set;
	}
	
	public static boolean isEmpty(Object value){
		return !(value!=null && (value instanceof Number) && ((Number)value).intValue()>0);
	}

}
