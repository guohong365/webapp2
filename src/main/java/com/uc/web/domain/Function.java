package com.uc.web.domain;

public interface Function<KeyType> extends NamedObjct<KeyType> {
	public String getUri();
	public void setUri(String funcUri);
	public String getUriPattern();
	public void setUriPattern(String funcUriPattern);
}
