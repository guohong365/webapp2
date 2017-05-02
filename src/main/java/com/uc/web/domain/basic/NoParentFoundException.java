package com.uc.web.domain.basic;

public class NoParentFoundException extends Exception {
	private static final long serialVersionUID = 7460138227519750834L;
	
	public NoParentFoundException() {
		super();
	}
	
	public NoParentFoundException(String msg){
		super(msg);
	}
	
	public NoParentFoundException(Throwable exp){
		super(exp);
	}
	
	public NoParentFoundException(String msg, Throwable exp){
		super(msg, exp);
	}

}
