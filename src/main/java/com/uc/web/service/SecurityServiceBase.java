package com.uc.web.service;

import java.util.List;

import com.uc.web.domain.security.IRoleFunctionDefine;
import com.uc.web.domain.security.UserProfileBase;

public interface SecurityServiceBase<KeyType>{
	UserProfileBase<KeyType> selectUserProfile(String username);
	List<? extends IRoleFunctionDefine<KeyType>> selectRoleFunctionDefines();
}
