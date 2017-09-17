package com.uc.web.service;

import java.util.List;

import com.uc.web.domain.security.RoleFunctionDefine;
import com.uc.web.domain.security.UserProfile;

public interface SecurityServiceBase{
	UserProfile selectUserProfile(String username);
	List<RoleFunctionDefine> selectRoleFunctionDefines();
}
