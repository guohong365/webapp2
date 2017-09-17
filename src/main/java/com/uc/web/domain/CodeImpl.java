package com.uc.web.domain;

public class CodeImpl extends EntityBase implements Code{
	
	public CodeImpl() {
		this(null, null, null);
	}
	
	public CodeImpl(Object key, String value) {
		this(key, value, true);
	}

	public CodeImpl(Object key, String value, Boolean valid) {
		this.code=key;
		this.value=value;
		this.valid=valid;
	}

	public Object getCode() {
		return code;
	}
	public void setCode(Object code) {
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
	private Object code;
	private String value;
	private Boolean valid;
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(obj instanceof Code){
			return getCode().equals(((Code) obj).getCode()); 
		}
		return false;
	}
}
