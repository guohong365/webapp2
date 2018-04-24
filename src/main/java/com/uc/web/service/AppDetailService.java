package com.uc.web.service;

public interface AppDetailService extends Service{
	Object selectById(Object id);	
	Object selectByUuid(String uuid);
	Object selectIdByUuid(String uuid);
	int update(Object entity);
	int updateSelective(Object entity);
	int insert(Object entiry);
	int delete(Object detail);
}
