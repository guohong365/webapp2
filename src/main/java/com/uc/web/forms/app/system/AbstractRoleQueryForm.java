package com.uc.web.forms.app.system;

import com.uc.web.forms.QueryFormImpl;

public abstract class AbstractRoleQueryForm<KeyType> 
	extends QueryFormImpl<KeyType>{

	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryRoleName) {
		this.queryName = queryRoleName;
	}
	private String queryName;
}