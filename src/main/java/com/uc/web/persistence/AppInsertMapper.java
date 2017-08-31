package com.uc.web.persistence;

public interface AppInsertMapper<DetailType> extends Mapper {
	int insertDetail(DetailType detail);
}
