package com.uc.utils.filter;

public class NotFilter<DataType> implements IFilter<DataType> {
	IFilter<DataType> filter;
	
	public NotFilter(IFilter<DataType> filter) {
		this.filter=filter;
	}
	
	@Override
	public boolean filter(DataType object) {
		return !filter.filter(object);
	}
}
