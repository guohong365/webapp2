package com.uc.web.domain;

public interface UserOrgnizaiton<KeyType> {
	public User<KeyType> getUser();
	public void setUser(User<KeyType> user);
	
	public Orgnization<KeyType> getOrgnization();
	public void setOrgnization(Orgnization<KeyType> org);
	
}
