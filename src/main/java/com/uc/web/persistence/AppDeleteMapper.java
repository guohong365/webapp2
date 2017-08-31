package com.uc.web.persistence;

public interface AppDeleteMapper<DetailType> extends Mapper{
	int deleteDetail(DetailType detail);
}
