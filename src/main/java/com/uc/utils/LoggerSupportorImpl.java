package com.uc.utils;

import org.slf4j.Logger;

public class LoggerSupportorImpl implements LoggerSupportor {
	private Logger logger;
	public LoggerSupportorImpl() {
		logger=org.slf4j.LoggerFactory.getLogger(this.getClass());
	}
	@Override
	public Logger getLogger() {
		return logger;
	}
}
