package com.uc.web.security.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uc.web.security.AbstractWebUserDetailsService;

public class IntegerWebUserDetailService extends AbstractWebUserDetailsService<Long>{

	private Logger logger;
	
	public IntegerWebUserDetailService() {
		logger=LoggerFactory.getLogger(getClass());
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

}
