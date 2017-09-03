package com.uc.web.domain;

import com.uc.web.domain.security.UserProfileBase;

public interface UserSettings<KeyType> extends Settings {
	UserProfileBase<KeyType> getOwner();
}
