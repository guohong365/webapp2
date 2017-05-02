package com.uc.utils.filter;

public class AndFilter<DataType> extends ChainFilter<DataType> implements IAndFilter<DataType>{

	@Override
	public boolean filter(DataType object) {
		for(IFilter<DataType> filter:filters){
			if(!filter.filter(object))
				return false;
		}
		return true;
	}

	@Override
	public IAndFilter<DataType> and(IFilter<DataType> filter) {
		add(filter);
		return this;
	}
	
}
