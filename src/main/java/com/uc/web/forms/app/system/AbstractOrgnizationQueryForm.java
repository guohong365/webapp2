package com.uc.web.forms.app.system;

import com.uc.web.forms.QueryFormImpl;

public abstract class AbstractOrgnizationQueryForm<KeyType> 
	extends QueryFormImpl<KeyType> {

	private String queryName;
	private KeyType queryParent;
	
	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}
	public KeyType getQueryParent() {
		return queryParent;
	}
	public void setQueryParent(KeyType queryParent) {
		this.queryParent = queryParent;
	}
}
