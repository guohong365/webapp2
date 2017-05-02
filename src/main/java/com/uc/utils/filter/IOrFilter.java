package com.uc.utils.filter;

public interface IOrFilter<DataType> extends IFilter<DataType> {
	IOrFilter<DataType> or(IFilter<DataType> filter);
}
