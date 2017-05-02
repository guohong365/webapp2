package com.uc.web.persistence;

import org.apache.ibatis.annotations.Param;

public interface AppDetailMapper<DetailKeyType, DetailType extends Object> extends Mapper {
	int insertDetail(DetailType detail);
	int updateDetail(DetailType detail);
	int updateDetailSelective(DetailType detal);
	int deleteDetail(DetailType detail);
	DetailType selectById(@Param("id")DetailKeyType id);
}
