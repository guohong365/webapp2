package com.uc.utils.filter;

import java.util.ArrayList;
import java.util.List;

abstract class ChainFilter<DataType> implements IFilter<DataType> {
	
	protected List<IFilter<DataType>> filters=new ArrayList<>();
	
	protected void add(IFilter<DataType> filter){
		if(filter==null) return;
		filters.add(filter);
	}
	
	public void clear(){
		filters.clear();
	}
	
}
