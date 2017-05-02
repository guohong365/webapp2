package com.uc.web.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractUserRoles<KeyType> implements UserRole<KeyType> {
	@Override
	public List<Role<KeyType>> getRoles() {		
		return roles;
	}
	@Override
	public void addRole(Role<KeyType> role) {
		roles.add(role);
	}
	@Override
	public void addRole(Collection<? extends Role<KeyType>> roles) {
		this.roles.addAll(roles);
		
	}
	@Override
	public void removeRole(Role<KeyType> role) {
		roles.remove(role);
	}
	@Override
	public void removeAllRole() {
		roles.clear();
	}
	@Override
	public Role<KeyType> findRole(KeyType roleId) {
		for (Role<KeyType> iRole : roles) {
			if(iRole.getId().equals(roleId)){
				return iRole;
			}
		}
		return null;
	}
	private User<KeyType> user;
	
	private List<Role<KeyType>> roles=new ArrayList<>();
	
	public User<KeyType> getUser() {
		return user;
	}
	public void setUser(User<KeyType> user) {
		this.user = user;
	}
}
