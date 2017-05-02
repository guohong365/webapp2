package com.uc.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ServiceBase implements Service {
	
	private Service parent;		
	private Logger logger;
	
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
		
}
