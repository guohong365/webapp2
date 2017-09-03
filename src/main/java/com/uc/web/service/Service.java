package com.uc.web.service;

import com.uc.utils.LoggerSupportor;
import com.uc.web.persistence.Mapper;

public interface Service extends LoggerSupportor {	
	Service getParent();
	void setParent(Service parent);
	Mapper getMapper();
	void setMapper(Mapper mapper);
}
