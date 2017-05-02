package com.uc.web.forms.app.system;

import com.uc.web.forms.AbstractQueryForm;

public abstract class AbstractFunctionQureyForm<KeyType> 
	extends AbstractQueryForm<KeyType> {

	
	public String getQueryFuncName() {
		return queryFuncName;
	}
	public void setQueryFuncName(String queryFuncName) {
		this.queryFuncName = queryFuncName;
	}
	public String getQueryFuncUri() {
		return queryFuncUri;
	}
	public void setQueryFuncUri(String queryFuncUri) {
		this.queryFuncUri = queryFuncUri;
	}
	public boolean isQueryIsAll() {
		return queryIsAll;
	}
	public void setQueryIsAll(boolean queryIsAll) {
		this.queryIsAll = queryIsAll;
	}
	private String queryFuncName;
	private String queryFuncUri;
	private boolean queryIsAll;

}
