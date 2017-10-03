package com.uc.web.forms.ui.flot;

public interface PlotItem extends PlotValue {
	String getName();
	@Override
	default String toJson() {
		if(getValue()==null) return "";
		StringBuilder builder=new StringBuilder();
		if(getName()!=null){
			builder.append('"').append(getName()).append('"').append(':');
		}
		builder.append(PlotValue.super.toJson());
		return builder.toString();
	}
}
