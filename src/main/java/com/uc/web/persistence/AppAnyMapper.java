package com.uc.web.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AppAnyMapper extends Mapper{
	List<?> selectAny(@Param("sql")String sql);
	long selectAnyCount(@Param("sql")String sql);
	Object selectAnyOne(@Param("sql")String sql);
	int updateAny(@Param("sql")String sql);
	int deleteAny(@Param("sql")String sql);
}
