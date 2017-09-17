package com.uc.web.domain;

public interface User extends NamedObjct {
	public String getLoginId();
	public void setLoginId(String loginId);
	public String getPassword();
	public void setPassword(String password);
}
