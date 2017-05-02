package com.uc.web.persistence;

public interface AppUuidMapper<DetailKeyType, DetailType> extends Mapper {
	
	DetailKeyType selectIdByUuid(String uuid);	
	DetailType selectByUuid(String uuid);

}
