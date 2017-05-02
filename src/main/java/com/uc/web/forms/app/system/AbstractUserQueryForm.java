package com.uc.web.forms.app.system;

import com.uc.web.forms.AbstractQueryForm;

public abstract class AbstractUserQueryForm<KeyType>
	extends AbstractQueryForm<KeyType>  {
	
	private String queryUserId;
	private String queryUserName;
	private KeyType queryUserOrgId;
	
	private Boolean queryAll;

	public String getQueryUserId() {
		return queryUserId;
	}

	public void setQueryUserId(String queryUserId) {
		this.queryUserId = queryUserId;
	}

	public String getQueryUserName() {
		return queryUserName;
	}

	public void setQueryUserName(String queryUserName) {
		this.queryUserName = queryUserName;
	}

	public KeyType getQueryUserOrgId() {
		return queryUserOrgId;
	}

	public void setQueryUserOrgId(KeyType queryUserOrgId) {
		this.queryUserOrgId = queryUserOrgId;
	}

	public Boolean getQueryAll() {
		return queryAll;
	}

	public void setQueryAll(Boolean queryAll) {
		this.queryAll = queryAll;
	}

}
