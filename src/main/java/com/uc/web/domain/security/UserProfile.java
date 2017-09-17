package com.uc.web.domain.security;

import org.springframework.security.core.userdetails.UserDetails;

import com.uc.web.domain.MenuTree;
import com.uc.web.domain.UserOrgnizaiton;
import com.uc.web.domain.UserRole;

public interface UserProfile extends UserRole, UserOrgnizaiton, UserDetails {
  MenuTree getMenu();
  void setMenu(MenuTree menu);
  UserSettings getSettings();
  void setSettings(UserSettings settings);

}
