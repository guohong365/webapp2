package com.uc.web.domain.basic;

import com.uc.web.domain.AbstractCode;

public class BasicCode extends AbstractCode<String> {
	public BasicCode() {		
	}
	
	public BasicCode(String code, String value){
		this(code, value, Boolean.TRUE);
	}
	
	public BasicCode(String code, String value, Boolean valid){
		setCode(code);
		setValue(value);
		setValid(valid);
	}
}
