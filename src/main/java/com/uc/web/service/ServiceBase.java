package com.uc.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uc.web.persistence.Mapper;

public abstract class ServiceBase implements Service {
	
	private Service parent;		
	private Logger logger;
	private Mapper mapper;
	
	public void setParent(Service parent) {
		this.parent = parent;
	}
	@Override
	public Service getParent() {
		return parent;
	}
	
	public ServiceBase() {
		logger=LoggerFactory.getLogger(getClass());
	}
	@Override
	public Logger getLogger() {
		return logger;
	}	
	
	@Override
	public void setMapper(Mapper mapper) {
		this.mapper=mapper;
	}
	@Override
	public Mapper getMapper() {
		return mapper;
	}
		
}
