package com.uc.web.forms.app.system;

import com.uc.web.forms.AbstractQueryForm;

public abstract class AbstractRoleQueryForm<KeyType> 
	extends AbstractQueryForm<KeyType>{

	public String getQueryRoleName() {
		return queryRoleName;
	}
	public void setQueryRoleName(String queryRoleName) {
		this.queryRoleName = queryRoleName;
	}
	public boolean isQueryAll() {
		return queryAll;
	}
	public void setQueryAll(boolean _queryAll) {
		this.queryAll = _queryAll;
	}

	private String queryRoleName;
	private boolean queryAll;
}