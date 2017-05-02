package com.uc.web.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AppListMapper<DetailType extends Object> extends Mapper {
	long selectCountByExample(
			@Param("example")
			Example example);	
	List<DetailType> selectByExample(
			@Param("example")
			Example example,
			@Param("offset")
			long offset,
			@Param("count")
			long count);
}
