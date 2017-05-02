package com.uc.web.forms.ui;

public class AbstractUIFormatorBase {
	private ContainerProvider containerProvider;
	
	public void setContainerProvider(ContainerProvider provider) {
		this.containerProvider=provider;		
	}
	
	public ContainerProvider getContainerProvider() {
		return containerProvider;
	}

}
