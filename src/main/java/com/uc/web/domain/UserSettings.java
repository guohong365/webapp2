package com.uc.web.domain;

import com.uc.web.domain.security.UserProfile;

public interface UserSettings<KeyType> extends Settings {
	UserProfile<KeyType> getOwner();
}
