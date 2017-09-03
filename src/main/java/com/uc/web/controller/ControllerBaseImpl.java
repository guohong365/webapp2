package com.uc.web.controller;


import org.springframework.security.core.context.SecurityContextHolder;

import com.uc.utils.LoggerSupportorImpl;
import com.uc.web.domain.security.UserProfile;
import com.uc.web.service.Service;

public abstract class ControllerBaseImpl extends LoggerSupportorImpl
	implements ControllerBase {
	
	private Service service;
	private String pageBasePath;
    private String moduleTitle;
    private String moduleName;
    private String entityName;
    
	@Override
	public Service getService() {
		return service;
	}
	
	public void setService(Service service) {
		this.service = service;
	}
	
	@Override
	public UserProfile getUser() {
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserProfile)
			return (UserProfile) principal;
		return null;
	}

	public void setPageBasePath(String pageBasePath) {
		this.pageBasePath = pageBasePath;
	}
	
	@Override
	public String getPageBasePath(){
		return pageBasePath;
	}

	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}
	@Override
	public String getModuleTitle() {
		return moduleTitle;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	public String getEntityName() {
		return entityName;
	}
	
	protected static Object createInstanceByName(String className){
		try {
			Class<?> clazz=Class.forName(className);
			return clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String modulelName) {
		this.moduleName = modulelName;
	}	
	
}

