package com.uc.web.forms;

public interface DetailListQueryForm<KeyType> extends ListQueryForm {
	KeyType getQuerySelectedId();
	void setQuerySelectedId(KeyType selectId);
}
