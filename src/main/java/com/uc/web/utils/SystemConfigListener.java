package com.uc.web.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.util.StringUtils;

public class SystemConfigListener implements ServletContextListener {
	static final String SYSTEM_CONFIG_FILE_PARAM_NAME="SystemConfig";
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String configFileName=sce.getServletContext().getInitParameter(SYSTEM_CONFIG_FILE_PARAM_NAME);
		if(!StringUtils.isEmpty(configFileName)){
			SystemConfig.load(configFileName);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
