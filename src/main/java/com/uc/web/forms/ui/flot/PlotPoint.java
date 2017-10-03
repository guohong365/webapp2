package com.uc.web.forms.ui.flot;

public interface PlotPoint extends  PlotValue {
	public Object getX();
	public Object getY();
	
	default Object getValue() {
		return new Object[]{getX(), getY()};
	}	
}
