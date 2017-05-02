package com.uc.web.domain.security.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uc.web.domain.security.AbstractUserProfile;

public abstract class IntegerUserProfile extends AbstractUserProfile<Long> {

	private static final long serialVersionUID = 5015917088320021836L;
	private Logger logger;
	
	public IntegerUserProfile() {
		logger=LoggerFactory.getLogger(getClass());
	}

	@Override
	public Logger getLogger() {
		return logger;
	}

}
