package com.uc.web.forms.json;

import java.util.List;

public interface JsonValueArray extends List<JsonValue>, JsonValue {
	default JsonValueArray addValue(Object value){
		add(value instanceof JsonValue ? (JsonValue)value : new JsonValueImpl(value));
		return this;
	}
	@Override
	default Object getValue() {
		return toArray(new Object[size()]);
	}
}
