package com.uc.web.forms.ui.flot;

import java.util.List;

public interface PlotItemCollection extends List<PlotItem>, PlotValue{
	@Override
	default Object getValue() {
		return this;
	}
	default PlotItemCollection addValue(PlotItem item){
		add(item);
		return this;
	}
	@Override
	default String toJson() {
		String ret="";		
		ret += "{";
		for(int i=0; i<size(); i++){			
			ret += get(i).toJson();
			if(i< size() -1) ret +=",";
		}
		ret +="}";
		return ret;
	}
}
