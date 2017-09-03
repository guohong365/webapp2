package com.uc.web.forms;

import com.uc.web.domain.security.UserProfile;

public interface QueryFormBase {
	UserProfile getUser();
	void setUser(UserProfile user);
}
