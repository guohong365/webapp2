package com.uc.web.service;

public interface AppServiceErrorHandler {
	public static final String ERROR_UNKNOWN="unknown";
	String getErrorMessage(int code);
}
