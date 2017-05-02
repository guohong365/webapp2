package com.uc.web.service;

public interface AppDetailService<DetailKeyType, DetailType extends Object> extends Service, AppServiceErrorHandler {
	DetailType selectById(DetailKeyType id);	
	int update(DetailType entity);
	int updateSelective(DetailType entity);
	int insert(DetailType entiry);
	int delete(DetailType detail);
}
