package com.uc.web.forms.ui.flot;

public class PlotItemImpl extends PlotValueImpl implements PlotItem {
	private String name;
	public PlotItemImpl(String name, Object value){
		this.name=name;
		setValue(value);
	}
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
