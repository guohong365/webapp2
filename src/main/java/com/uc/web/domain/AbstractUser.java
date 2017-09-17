package com.uc.web.domain;

public abstract class AbstractUser extends AbstractNamedObject implements User {
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password=password;
		
	}
	private String password;
	private String loginId;
	@Override
	public String getLoginId() {
		return loginId;
	}
	@Override
	public void setLoginId(String loginId) {
		this.loginId=loginId;
	}
}
