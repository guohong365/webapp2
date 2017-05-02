package com.uc.web.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringConfigTool implements ApplicationContextAware {

	private static ApplicationContext appContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appContext=applicationContext;
	}
	
	public static ApplicationContext getApplicationContext(){
		return appContext;
	}

	public static Object getBean(String beanName) {
		return appContext.getBean(beanName);
	}
	
	public static Object getBean(Class<?> c){
		return appContext.getBean(c);
	}

}
