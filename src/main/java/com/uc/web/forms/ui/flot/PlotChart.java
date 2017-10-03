package com.uc.web.forms.ui.flot;

import com.uc.web.forms.JsonString;

public interface PlotChart extends JsonString{	
	PlotValue getDataSet();
	PlotItem getOptions();
	@Override
	default String toJson() {
		StringBuilder builder=new StringBuilder();
		builder.append('{').append("\"dataSet\":").append(getDataSet().toJson()) ;		
		if(getOptions()!=null){
			builder.append(',')
			.append("\"options\":").append(getOptions().toJson());			
		}
		builder.append('}');		
		return builder.toString();
	}

}
