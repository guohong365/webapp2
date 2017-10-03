package com.uc.web.forms.json;

import java.util.ArrayList;
import java.util.Collection;

public class PlotValueCollectionImpl extends ArrayList<JsonValue> implements JsonValueArray {
	private static final long serialVersionUID = -6441638828542391222L;
	public PlotValueCollectionImpl(){
	}
	public PlotValueCollectionImpl(Collection<JsonValue> collection){
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
