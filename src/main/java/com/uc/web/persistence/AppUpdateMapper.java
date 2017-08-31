package com.uc.web.persistence;

public interface AppUpdateMapper<DetailType> extends Mapper{
	int updateDetail(DetailType detail);
	int updateDetailSelective(DetailType detal);
}
