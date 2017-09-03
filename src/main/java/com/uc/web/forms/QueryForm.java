package com.uc.web.forms;

import java.util.Map;

import com.uc.web.domain.security.UserProfileBase;

public interface QueryForm<KeyType> extends ListQueryForm {
	void addLimits(String name, Object item);
	void addLimits(Map<String, ? extends Object> map);
	Object getLimits(String name);
	void clearLimits();
	UserProfileBase<KeyType> getQueryUser();

}
