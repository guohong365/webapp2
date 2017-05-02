package com.uc.web.domain;

public abstract class AbstractUserOrgnization<KeyType> implements UserOrgnizaiton<KeyType> {
	private User<KeyType> user;
	private Orgnization<KeyType> orgnization;
	
	@Override
	public User<KeyType> getUser() {
		return user;
	}

	@Override
	public void setUser(User<KeyType> user) {
		this.user=user;
		
	}

	@Override
	public Orgnization<KeyType> getOrgnization() {
		return orgnization;
	}

	@Override
	public void setOrgnization(Orgnization<KeyType> org) {
		this.orgnization=org;
		
	}

}
