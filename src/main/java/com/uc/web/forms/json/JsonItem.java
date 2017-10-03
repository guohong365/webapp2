package com.uc.web.forms.json;

public interface JsonItem extends JsonValue {
	String getName();
	@Override
	default String toJson() {
		if(getValue()==null) return "";
		StringBuilder builder=new StringBuilder();
		if(getName()!=null){
			builder.append('"').append(getName()).append('"').append(':');
		}
		builder.append(JsonValue.super.toJson());
		return builder.toString();
	}
}
