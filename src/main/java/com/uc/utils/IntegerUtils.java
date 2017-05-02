package com.uc.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegerUtils {
	public static boolean isEmpty(Long integer){
		return integer==null || integer==0;
	}
	public static boolean isEmpty(Integer integer){
		return integer==null || integer==0;
	}
	 
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

}
