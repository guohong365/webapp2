package com.uc.web.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractUserRoles extends EntityBase implements UserRole {
	@Override
	public List<Role> getRoles() {		
		return roles;
	}
	@Override
	public void addRole(Role role) {
		roles.add(role);
	}
	@Override
	public void addRole(Collection<? extends Role> roles) {
		this.roles.addAll(roles);
		
	}
	@Override
	public void removeRole(Role role) {
		roles.remove(role);
	}
	@Override
	public void removeAllRole() {
		roles.clear();
	}
	@Override
	public Role findRole(Object roleId) {
		for (Role iRole : roles) {
			if(iRole.getId().equals(roleId)){
				return iRole;
			}
		}
		return null;
	}
	private User user;
	
	private List<Role> roles=new ArrayList<>();
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
