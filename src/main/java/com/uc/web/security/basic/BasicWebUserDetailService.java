package com.uc.web.security.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uc.web.security.AbstractWebUserDetailsService;

public class BasicWebUserDetailService extends AbstractWebUserDetailsService<String>{

	private Logger logger;
	
	public BasicWebUserDetailService() {
		logger=LoggerFactory.getLogger(getClass());
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

}
