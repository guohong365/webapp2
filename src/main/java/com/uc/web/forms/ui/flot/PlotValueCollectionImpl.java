package com.uc.web.forms.ui.flot;

import java.util.ArrayList;
import java.util.Collection;

public class PlotValueCollectionImpl extends ArrayList<PlotValue> implements PlotValueCollection {
	private static final long serialVersionUID = -6441638828542391222L;
	public PlotValueCollectionImpl(){
	}
	public PlotValueCollectionImpl(Collection<PlotValue> collection){
		super(collection);
	}
	@Override
	public String toJson() {
		String ret= "[";
		for(int i=0; i< size(); i++){			
			ret += get(i).toJson();
			if(i< size() -1) ret +=",";
		}
		ret += "]";
		return ret;
	}
}
