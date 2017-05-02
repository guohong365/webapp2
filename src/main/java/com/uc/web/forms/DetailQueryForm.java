package com.uc.web.forms;

public interface DetailQueryForm<KeyType> extends QueryForm<KeyType> {
	KeyType getParentKey();
	void setParentKey();
}
