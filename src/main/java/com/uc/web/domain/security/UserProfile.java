package com.uc.web.domain.security;

import org.springframework.security.core.userdetails.UserDetails;

import com.uc.web.domain.Settings;

public interface UserProfile extends UserDetails {
	Settings getSettings();
}
