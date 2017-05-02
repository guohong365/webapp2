package com.uc.web.forms.controller.factory;

public abstract class ColumnsControllerFactoryBase implements ColumnsControllerFactory {
	
	private String name;

	public ColumnsControllerFactoryBase(String name) {
		this.name=name;
	}
	

	@Override
	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

}
