package com.uc.web.domain;

public interface Code<KeyType>{
	public KeyType getCode();
	public void setCode(KeyType code);
	public String getValue();
	public void setValue(String value);
	public Boolean getValid();
	public void setValid(Boolean valid);
}
