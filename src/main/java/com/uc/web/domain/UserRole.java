package com.uc.web.domain;

import java.util.Collection;
import java.util.List;

public interface UserRole<KeyType> {
	public User<KeyType> getUser();
	public List<Role<KeyType>> getRoles();
	
	public void addRole(Role<KeyType> role);
	public void addRole(Collection<? extends Role<KeyType>> roles);
	public void removeRole(Role<KeyType> role);
	public void removeAllRole();
	public Role<KeyType> findRole(KeyType roleId);
	
}
