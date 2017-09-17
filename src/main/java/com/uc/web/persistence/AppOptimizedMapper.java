package com.uc.web.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AppOptimizedMapper extends Mapper {
	Long selectCountOptimized(
			@Param("queryForm")
			Object qureForm
			);
	List<?> selectOptimized(
			@Param("queryForm")
			Object queryForm,
			@Param("offset")
			long offset,
			@Param("count")
			long count);

}
