package com.uc.web.forms.json;

public class JsonValueImpl implements JsonValue {
	public JsonValueImpl(){
		
	}
	public JsonValueImpl(Object value){
		this.value=value;
	}
	private Object value;
	@Override
	public Object getValue() {
		return value;
	}
	public void setValue(Object value){
		this.value=value;
	}

	
}
