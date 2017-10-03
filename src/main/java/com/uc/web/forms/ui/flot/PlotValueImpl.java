package com.uc.web.forms.ui.flot;

public class PlotValueImpl implements PlotValue {
	public PlotValueImpl(){
		
	}
	public PlotValueImpl(Object value){
		this.value=value;
	}
	private Object value;
	@Override
	public Object getValue() {
		return value;
	}
	public void setValue(Object value){
		this.value=value;
	}

	
}
