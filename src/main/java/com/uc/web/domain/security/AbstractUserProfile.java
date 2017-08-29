package com.uc.web.domain.security;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.uc.web.domain.AbstractUserRoles;
import com.uc.web.domain.Menu;
import com.uc.web.domain.IMenuTree;
import com.uc.web.domain.Orgnization;
import com.uc.web.domain.Role;

public abstract class AbstractUserProfile<KeyType>
	extends AbstractUserRoles<KeyType>
	implements UserProfile<KeyType> {
	
	private Orgnization<KeyType> orgnization;
	
	@Override
	public String getPassword() {
		return getUser()==null?null:getUser().getPassword();
	}
	@Override
	public String getUsername() {
		return getUser()==null?null: (getUser()).getLoginId();
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return getUser()==null?false:getUser().getValid();
	}
	@Override
	public Orgnization<KeyType> getOrgnization() {
		return orgnization;
	}
	@Override
	public void setOrgnization(Orgnization<KeyType> org) {
		orgnization=org;
		
	}

	private static final long serialVersionUID = 3129210443720184408L;

	public IMenuTree<KeyType,? extends Menu<KeyType>> getMenu(){
		return menuTree;
	}
	public void setMenu(IMenuTree<KeyType,? extends Menu<KeyType>> menu){
		menuTree=menu;
	}

	private IMenuTree<KeyType, ? extends Menu<KeyType>> menuTree;

	Collection<GrantedAuthority> authoryties;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		synchronized (AbstractUserProfile.class) {
			if(authoryties==null){
				authoryties=new ArrayList<>();
			}
			for(Role<KeyType> role : getRoles()){
				GrantedAuthority authority=new SimpleGrantedAuthority("ROLE_" + role.getId());
				authoryties.add(authority);
			}
		}
		return authoryties;
	}
	
	@Override
	public String toString() {
		StringBuilder builder=new StringBuilder();
		builder
		.append("USER:").append(getUser().toString())
		.append("ORG:").append(getOrgnization().toString())
		.append("ROLES:").append(getRoles())
		.append("MENU").append(getMenu());		
		return super.toString();
	}

}
