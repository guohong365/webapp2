package com.uc.web.forms.json;

import java.lang.reflect.Array;

import com.uc.web.forms.JsonString;

public interface JsonValue extends JsonString {	
	Object getValue();
	@Override
	default String toJson() {
		if(getValue()==null) return "null";
		if(getValue().getClass().equals(String.class)){
			return "\"" + getValue() + "\"";
		} else if(getValue().getClass().isPrimitive()) {
			return getValue().toString();			
		} else if(getValue().getClass().isArray()){
			int length=Array.getLength(getValue());
			String ret="[";
			for(int i=0; i< length; i++){
				Object item = Array.get(getValue(), i);				
				if(item instanceof JsonString){
					ret += ((JsonString)Array.get(getValue(), i)).toJson();
				} else {
					JsonString json=new JsonValueImpl(item);
					ret += json.toJson();
				}
				if(i< length -1) ret+=",";
			}
			ret +="]";
			return ret;
		} else if(getValue() instanceof JsonString){
			return ((JsonString)getValue()).toJson();
		}		 
		return getValue().toString();
	}
}
