package com.uc.web.forms.app.system;

import com.uc.web.forms.AbstractQueryForm;

public abstract class AbstractOrgnizationQueryForm<KeyType> 
	extends AbstractQueryForm<KeyType> {

    
	private String queryName;
	private boolean queryAll;
	
	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryOrgName) {
		this.queryName = queryOrgName;
	}
	public Boolean getQueryAll() {
		return queryAll;
	}
	public void setQueryAll(Boolean queryIsAll) {
		this.queryAll = queryIsAll;
	}

}
