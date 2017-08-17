package com.uc.web.forms.ui.plot;

import java.util.ArrayList;
import java.util.List;

public class SeriesBase<XType, YType> implements Series<XType, YType> {
	private List<PlotPoint<XType, YType>> data=new ArrayList<>();
	private String label;
	private PlotOption option;
	public List<PlotPoint<XType, YType>> getData(){
		return data;
	}	
	public void add(PlotPoint<XType, YType> point){
		getData().add(point);
	}
	@Override
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@Override
	public PlotOption getOption() {
		return option;
	}
	@Override
	public void setOption(PlotOption option) {
		this.option = option;
	}
	
	protected void toJsonOther(StringBuilder builder){
		
	}

	@Override
	public String toJson() {
		StringBuilder builder=new StringBuilder();
		builder.append('{')
			.append("\"label\":").append('"').append(getLabel()).append('"');
		if(getData().size()>0){
			builder.append(',').append("\"data\":").append('[');
			for(int i=0; i< getData().size(); i++){
				if(i!=0) builder.append(',');
				builder.append(getData().get(i).toJson());				
			}
			builder.append(']');
		}
		if(getOption()!=null){
			builder.append(',').append(getOption().toJson());
		}
		toJsonOther(builder);		
		builder.append('}');
		return builder.toString();
	}
}
