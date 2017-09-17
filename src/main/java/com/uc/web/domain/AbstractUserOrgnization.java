package com.uc.web.domain;

public abstract class AbstractUserOrgnization implements UserOrgnizaiton {
	private User user;
	private Orgnization orgnization;
	
	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void setUser(User user) {
		this.user=user;
		
	}

	@Override
	public Orgnization getOrgnization() {
		return orgnization;
	}

	@Override
	public void setOrgnization(Orgnization org) {
		this.orgnization=org;
		
	}

}
