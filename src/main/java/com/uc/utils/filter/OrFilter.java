package com.uc.utils.filter;

public class OrFilter<DataType> extends ChainFilter<DataType> implements IOrFilter<DataType> {

	@Override
	public boolean filter(DataType object) {
		if(filters.size()==0) return true;
		for(IFilter<DataType> filter:filters){
			if(filter.filter(object))
				return true;
		}
		return false;
	}

	@Override
	public IOrFilter<DataType> or(IFilter<DataType> filter) {
		add(filter);
		return this;
	}

}
