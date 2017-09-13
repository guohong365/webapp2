package com.uc.web.service;

import com.uc.utils.LoggerSupportorImpl;
import com.uc.web.persistence.Mapper;

public abstract class ServiceBase extends LoggerSupportorImpl implements Service {
	private Mapper mapper;
		
	@Override
	public void setMapper(Mapper mapper) {
		this.mapper=mapper;
	}
	@Override
	public Mapper getMapper() {
		return mapper;
	}
		
}
