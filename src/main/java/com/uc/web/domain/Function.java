package com.uc.web.domain;

public interface Function extends NamedObjct {
	public String getUri();
	public void setUri(String funcUri);
	public String getUriPattern();
	public void setUriPattern(String funcUriPattern);
}
