package com.uc.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
	public static List<?> subList(List<?> list, long fromIndex, long toIndex){
		if(list==null || list.size()==0){
			return new ArrayList<>();
		}
		int from=(int) fromIndex;
		int to=(int) toIndex;
		if(fromIndex < 0){
			from=0;
		}
		if(fromIndex > list.size()) {
			from= list.size() -1;
		}
		if(toIndex > list.size()) {
			to=list.size();
		}		
		return list.subList(from, to);
	}
}
