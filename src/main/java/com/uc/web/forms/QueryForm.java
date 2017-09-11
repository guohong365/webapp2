package com.uc.web.forms;

import com.uc.web.domain.security.UserProfileBase;

public interface QueryForm<KeyType> extends ListQueryForm {
	UserProfileBase<KeyType> getUser();

}
