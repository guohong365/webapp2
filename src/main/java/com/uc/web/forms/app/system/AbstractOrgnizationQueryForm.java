package com.uc.web.forms.app.system;

import com.uc.web.forms.AbstractQueryForm;

public abstract class AbstractOrgnizationQueryForm<KeyType> 
	extends AbstractQueryForm<KeyType> {

    
	private String queryOrgName;
	private boolean queryIsAll;
	
	public String getQueryOrgName() {
		return queryOrgName;
	}
	public void setQueryOrgName(String queryOrgName) {
		this.queryOrgName = queryOrgName;
	}
	public Boolean getQueryAll() {
		return queryIsAll;
	}
	public void setQueryAll(Boolean queryIsAll) {
		this.queryIsAll = queryIsAll;
	}

}
