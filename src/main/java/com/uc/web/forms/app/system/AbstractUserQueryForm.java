package com.uc.web.forms.app.system;

import com.uc.web.forms.ListQueryFormImpl;

public abstract class AbstractUserQueryForm<KeyType>
	extends ListQueryFormImpl  {
	
	private String queryLoginId;
	private String queryName;
	private KeyType queryOrg;
	public String getQueryLoginId() {
		return queryLoginId;
	}
	public void setQueryLoginId(String queryLoginId) {
		this.queryLoginId = queryLoginId;
	}
	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}
	public KeyType getQueryOrg() {
		return queryOrg;
	}
	public void setQueryOrg(KeyType queryOrg) {
		this.queryOrg = queryOrg;
	}
}
