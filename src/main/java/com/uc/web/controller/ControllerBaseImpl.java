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
	private static final String PAGE_200 = "/error/200";
	private static final String PAGE_404 = "/error/404";
	private static final String PAGE_500 = "/error/500";
	private String page200=PAGE_200;
	private String page404=PAGE_404;
	private String page500=PAGE_500;
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

	public String getPage200() {
		return page200;
	}

	public void setPage200(String page200) {
		this.page200 = page200;
	}

	public String getPage404() {
		return page404;
	}

	public void setPage404(String page404) {
		this.page404 = page404;
	}

	public String getPage500() {
		return page500;
	}

	public void setPage500(String page500) {
		this.page500 = page500;
	}	
	
}

