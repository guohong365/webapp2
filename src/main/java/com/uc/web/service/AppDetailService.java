package com.uc.web.service;

public interface AppDetailService extends Service{
	Object selectById(Object id);	
	int update(Object entity);
	int updateSelective(Object entity);
	int insert(Object entiry);
	int delete(Object detail);
}
