package com.uc.web.persistence;

public interface AppUuidMapper extends Mapper {
	Object selectIdByUuid(String uuid);	
	Object selectByUuid(String uuid);

}
