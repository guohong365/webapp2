package com.uc.web.controller;


import org.springframework.security.core.context.SecurityContextHolder;

import com.uc.utils.LoggerSupportorImpl;
import com.uc.web.domain.security.UserProfile;
import com.uc.web.utils.SystemConfig;

public class ControllerSupportImpl<KeyType> extends LoggerSupportorImpl
	implements ControllerSupport<KeyType> {
	
	private ControllerSupport<KeyType> parent;
	@Override
	public ControllerSupport<KeyType> getParent() {
		return parent;
	}
	@Override
	public void setParent(ControllerSupport<KeyType> parent) {
		this.parent = parent;
	}

	@SuppressWarnings("unchecked")
	public UserProfile<KeyType> getUserProfile(){
		if(SystemConfig.noLogin()){
			return null;
		}
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserProfile<KeyType> userInfo;
		try	{
			userInfo=(UserProfile<KeyType>) principal;
		}catch(Exception e){
			userInfo=null;
		}
		return userInfo;
	}
	
	private String pageBasePath;
	
	public void setPageBasePath(String pageBasePath) {
		this.pageBasePath = pageBasePath;
	}
	
	protected String onGetPageBasePath(){
		return pageBasePath==null ? (getParent()!=null ? getParent().getPageBasePath(): "/error/404") : pageBasePath;
	}
	@Override
	public String getPageBasePath(){
		return onGetPageBasePath();
	}
	@Override
	public String getModelTitle(){
		return onGetModelTitle();
	}
    private String modelTitle;
    
    public void setModelTitle(String modelTitle) {
		this.modelTitle = modelTitle;
	}
	protected String onGetModelTitle(){
		return modelTitle==null ? (getParent()!=null? getParent().getModelTitle():""): modelTitle;
	}
	
	private String entityName;
	
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}	
	
	protected String onGetEntityName() {
		return entityName==null ? (getParent()!=null? getParent().getEntityName():""): entityName;
	}
	@Override
	public String getEntityName() {
		return onGetEntityName();
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
}

