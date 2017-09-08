package com.uc.web.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AppOptimizedMapper<QueryFormType, EntityType> extends Mapper {
	Long selectCountOptimized(
			@Param("queryForm")
			QueryFormType qureForm
			);
	List<EntityType> selectOptimized(
			@Param("queryForm")
			QueryFormType queryForm,
			@Param("offset")
			long offset,
			@Param("count")
			long count);

}
