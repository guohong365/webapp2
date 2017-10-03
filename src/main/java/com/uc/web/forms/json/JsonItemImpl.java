package com.uc.web.forms.json;

public class JsonItemImpl extends JsonValueImpl implements JsonItem {
	private String name;
	public JsonItemImpl(String name, Object value){
		this.name=name;
		setValue(value);
	}
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
