package com.uc.web.forms.ui.flot;

public interface PlotSeries extends PlotItem {	
	PlotValueCollection getValue();
	PlotItem getOptions();
	default PlotSeries addValue(PlotValue value){
		getValue().add(value);
		return this;
	}
		
	@Override
	default String toJson() {		
		return  PlotItem.super.toJson() + 
				getOptions()==null ? "" : "," + getOptions().toJson();
	}
	
	
}
