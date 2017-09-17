package com.uc.web.forms.app.system;

import com.uc.web.forms.ListQueryFormImpl;

public abstract class AbstractRoleQueryForm<KeyType> 
	extends ListQueryFormImpl {

	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryRoleName) {
		this.queryName = queryRoleName;
	}
	private String queryName;
}