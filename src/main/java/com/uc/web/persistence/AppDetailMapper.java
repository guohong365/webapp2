package com.uc.web.persistence;

public interface AppDetailMapper<DetailKeyType, DetailType extends Object> extends 
		AppInsertMapper<DetailType>, 
		AppUpdateMapper<DetailType>, 
		AppDeleteMapper<DetailType>,
		AppSelectByKeyMapper<DetailKeyType, DetailType>
{
}
