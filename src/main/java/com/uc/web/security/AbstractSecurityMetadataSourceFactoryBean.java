package com.uc.web.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.uc.utils.LoggerSupportor;
import com.uc.web.domain.security.RoleFunctionDefine;
import com.uc.web.service.SecurityServiceBase;

public class AbstractSecurityMetadataSourceFactoryBean<KeyType> 
	extends LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> implements LoggerSupportor  {

	private static final long serialVersionUID = 7114425880761707681L;
	
	private Logger logger;
	
	public AbstractSecurityMetadataSourceFactoryBean() {
		logger=LoggerFactory.getLogger(getClass());
	}

	private SecurityServiceBase securityService;
	
	public SecurityServiceBase getSecurityService() {
		return securityService;
	}

	public void setSecurityService(SecurityServiceBase securityService) {
		this.securityService = securityService;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@PostConstruct
	public void loadResourceDefine(){
		List<? extends RoleFunctionDefine> list = securityService.selectRoleFunctionDefines();
		RequestMatcher matcher=null;
		String pattern=null;
		Collection<ConfigAttribute> configAttributes=null;
		for (RoleFunctionDefine resource : list) {
			
			
			if(!resource.getFunction().getUriPattern().equals(pattern)){ //新的pattern				
				if(configAttributes!=null && !configAttributes.isEmpty()){					
					this.put(matcher, configAttributes); //保存之前的configAttributes
				}
				//新建 matcher和 configAttributes
				pattern=resource.getFunction().getUriPattern();
				matcher=new AntPathRequestMatcher(pattern);
				configAttributes = new HashSet<ConfigAttribute>();
			}
			ConfigAttribute configAttribute = new SecurityConfig("ROLE_" + resource.getRole().getId());
			logger.debug("add role to list ["+pattern+"]:" + "ROLE_" + resource.getRole().getId());
			configAttributes.add(configAttribute);
		}
		if(matcher!=null && configAttributes!=null && !configAttributes.isEmpty()){
			put(matcher, configAttributes);
		}
	}
}
