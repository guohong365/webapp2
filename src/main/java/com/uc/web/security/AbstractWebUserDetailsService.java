package com.uc.web.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.uc.utils.LoggerSupportor;
import com.uc.web.domain.security.UserProfile;
import com.uc.web.service.SecurityServiceBase;

public abstract class AbstractWebUserDetailsService<KeyType> 
	implements UserDetailsService, LoggerSupportor {

	private SecurityServiceBase securityService;
	
	public void setSecurityService(SecurityServiceBase securityService) {
		this.securityService = securityService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		getLogger().trace("loading user["+ username +"]。。。。。");
		try {
		  UserProfile userInfo=securityService.selectUserProfile(username);
		  if(userInfo!=null){
		    getLogger().trace("user info loaded。。。。。" + userInfo.getUsername() + " " + userInfo.isEnabled());
		    return userInfo;
		  }  else{
		    getLogger().error("user["+ username +"]not found");
			throw new UsernameNotFoundException("user:" + username);
		  }
		}
		catch(Exception e){
			getLogger().error("load user info error[[" +e.getClass() +":" + e.getMessage() +"]");
			throw new UsernameNotFoundException(username, e);
		}
	}
	
	

}
