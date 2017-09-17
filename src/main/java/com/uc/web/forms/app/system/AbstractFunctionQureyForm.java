package com.uc.web.forms.app.system;

import com.uc.web.forms.ListQueryFormImpl;

public abstract class AbstractFunctionQureyForm
	extends ListQueryFormImpl {
	
	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryFuncName) {
		this.queryName = queryFuncName;
	}
	public String getQueryUri() {
		return queryUri;
	}
	public void setQueryUri(String queryFuncUri) {
		this.queryUri = queryFuncUri;
	}
	public String getQueryPattern() {
		return queryPattern;
	}
	public void setQueryPattern(String queryPattern) {
		this.queryPattern = queryPattern;
	}
	private String queryName;
	private String queryUri;
	private String queryPattern;
}
