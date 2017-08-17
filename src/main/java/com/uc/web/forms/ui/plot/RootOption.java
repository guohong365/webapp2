package com.uc.web.forms.ui.plot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class RootOption implements PlotOption {
	private String name;
	private List<PlotOption> subOptions=new ArrayList<>();
	
	protected RootOption(String name) {
		this.name=name;
	}
	
	protected StringBuilder dataToJson(StringBuilder builder){
		for(int i=0; i<subOptions.size(); i++){
			if(i>0) builder.append(',');
			builder.append(subOptions.get(i));
		}
		return builder;
	}
	
	@Override
	public String toJson() {
		StringBuilder builder=new StringBuilder();
		builder.append('{');
		if(!StringUtils.isEmpty(getName())){
			builder.append('"').append(getName()).append('"').append(":{");
		}
		dataToJson(builder);
		if(!StringUtils.isEmpty(getName())){
			builder.append('}');
		}
		builder.append('}');
		return builder.toString();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<PlotOption> getSubOptions() {
		return subOptions;
	}
	
	@Override
	public List<PlotOption> add(PlotOption option) {
		getSubOptions().add(option);
		return getSubOptions();
	}
}
