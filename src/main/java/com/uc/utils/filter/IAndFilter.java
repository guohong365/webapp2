package com.uc.utils.filter;

public interface IAndFilter<DataType> extends IFilter<DataType> {
	public IAndFilter<DataType> and(IFilter<DataType> filter);	
}
