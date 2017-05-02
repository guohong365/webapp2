package com.uc.web.service;

import java.util.List;

import com.uc.web.domain.security.IRoleFunctionDefine;
import com.uc.web.domain.security.UserProfile;

public interface SecurityService<KeyType>{
	UserProfile<KeyType> selectUserProfile(String username);
	List<? extends IRoleFunctionDefine<KeyType>> selectRoleFunctionDefines();
}
