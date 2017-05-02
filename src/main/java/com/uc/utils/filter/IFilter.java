package com.uc.utils.filter;

public interface IFilter<DataType> {
	boolean filter(DataType object);
}
