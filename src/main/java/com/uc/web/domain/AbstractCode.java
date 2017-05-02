package com.uc.web.domain;

public abstract class AbstractCode<KeyType> extends EntityBase implements Code<KeyType>{
	
	public AbstractCode() {
		this(null, null, null);
	}
	
	public AbstractCode(KeyType key, String value) {
		this(key, value, true);
	}

	public AbstractCode(KeyType key, String value, Boolean valid) {
		this.code=key;
		this.value=value;
		this.valid=valid;
	}

	public KeyType getCode() {
		return code;
	}
	public void setCode(KeyType code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	private KeyType code;
	private String value;
	private Boolean valid;
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(obj instanceof Code){
			return getCode().equals(((Code<?>) obj).getCode()); 
		}
		return false;
	}
}
