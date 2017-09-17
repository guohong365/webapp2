package com.uc.web.domain.security;

import com.uc.web.domain.Settings;

public interface UserSettings extends Settings {
	UserProfile getOwner();
}
