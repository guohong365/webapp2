package com.uc.web.domain;

import java.util.Collection;
import java.util.List;

public interface UserRole {
	public User getUser();
	public List<Role> getRoles();
	
	public void addRole(Role role);
	public void addRole(Collection<? extends Role> roles);
	public void removeRole(Role role);
	public void removeAllRole();
	public Role findRole(Object roleId);
	
}
