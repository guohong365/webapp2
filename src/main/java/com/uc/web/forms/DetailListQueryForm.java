package com.uc.web.forms;

public interface DetailListQueryForm<KeyType> extends QueryForm<KeyType> {
	KeyType getQuerySelectedId();
	void setQuerySelectedId(KeyType selectId);
}
