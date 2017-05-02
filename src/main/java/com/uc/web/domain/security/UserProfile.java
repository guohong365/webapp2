package com.uc.web.domain.security;

import org.springframework.security.core.userdetails.UserDetails;

import com.uc.web.domain.Menu;
import com.uc.web.domain.IMenuTree;
import com.uc.web.domain.Settings;
import com.uc.web.domain.UserOrgnizaiton;
import com.uc.web.domain.UserRole;

public interface UserProfile<KeyType> 
	extends UserRole<KeyType>,
	UserOrgnizaiton<KeyType>,	
	UserDetails {
	
	public IMenuTree<KeyType, ? extends Menu<KeyType>> getMenu();
	public void setMenu(IMenuTree<KeyType, ? extends Menu<KeyType>> menu);
	
	public Settings getSettings();
	public void setSettings(Settings settings);
	
}
