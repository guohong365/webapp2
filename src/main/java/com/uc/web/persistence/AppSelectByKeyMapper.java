package com.uc.web.persistence;

import org.apache.ibatis.annotations.Param;

public interface AppSelectByKeyMapper<DetailKeyType, DetailType> extends Mapper{
	DetailType selectById(@Param("id")DetailKeyType id);
}
