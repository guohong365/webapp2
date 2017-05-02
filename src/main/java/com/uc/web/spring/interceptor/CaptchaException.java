package com.uc.web.spring.interceptor;

import org.springframework.security.core.AuthenticationException;

public class CaptchaException extends AuthenticationException {
	public CaptchaException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
