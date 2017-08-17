package com.uc.web.forms.ui.plot;

import java.util.ArrayList;
import java.util.List;

public class PlotChartBase implements PlotChart {
	private List<Series<?,?>> data=new ArrayList<>();
	private PlotOption option;
	
	@Override
	public List<Series<?, ?>> getData() {
		return data;
	}
	
	void toJsonOther(StringBuilder builder){
		
	}
	
	@Override
	public String toJson() {
		StringBuilder builder=new StringBuilder();
		builder.append('{').append("\"data\":").append('[') ;
		for(int i=0; i<data.size(); i++){
			if(i>0) builder.append(',');
			builder.append(data.get(i).toJson());
		}
		builder.append("]");
		
		if(getOption()!=null){
			builder.append(',')
			.append("\"options\":").append('{').append(option.toJson()).append('}');			
		}
		toJsonOther(builder);		
		builder.append('}');		
		return builder.toString();
	}

	@Override
	public List<Series<?, ?>> add(Series<?, ?> serie) {
		data.add(serie);
		return data;
	}

	@Override
	public PlotOption getOption() {
		return option;
	}
}
