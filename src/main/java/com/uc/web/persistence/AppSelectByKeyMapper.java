package com.uc.web.persistence;

import org.apache.ibatis.annotations.Param;

public interface AppSelectByKeyMapper extends Mapper{
	Object selectById(@Param("id")Object id);
}
