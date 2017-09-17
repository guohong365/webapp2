package com.uc.web.persistence;

public interface AppUpdateMapper extends Mapper{
	int updateDetail(Object detail);
	int updateDetailSelective(Object detal);
}
