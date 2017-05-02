package com.uc.web.persistence;

public interface AppMapper<DetailKeyType,	DetailType extends Object> 
	extends AppDetailMapper<DetailKeyType, DetailType>,
	        AppListMapper<DetailType>, Mapper{
		
}
