package com.uc.web.persistence;

import org.apache.ibatis.annotations.Param;

public interface AppSelectByKeyMapper<KeyType, EntityType> extends Mapper{
	EntityType selectById(@Param("id")KeyType id);
}
