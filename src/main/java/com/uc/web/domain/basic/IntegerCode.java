package com.uc.web.domain.basic;

import com.uc.web.domain.AbstractCode;

public class IntegerCode extends AbstractCode<Long> {
	public IntegerCode(Long code, String value, boolean valid) {
		super(code, value, valid);
	}
	
	public IntegerCode(Long code, String value) {
		this(code, value, true);
	}
	
	public IntegerCode(){
		
	}
	
}
