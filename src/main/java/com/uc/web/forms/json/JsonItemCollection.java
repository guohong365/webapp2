package com.uc.web.forms.json;

import java.util.List;

public interface JsonItemCollection extends List<JsonItem>, JsonValue{
	@Override
	default JsonValue getValue() {
		return this;
	}
	default JsonItemCollection addItem(JsonItem item){
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
