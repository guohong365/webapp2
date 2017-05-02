package com.uc.web.utils;

public class TokenProcessor implements TokenGenerator {
	static TokenGenerator generatorImpl;

	static {
		generatorImpl=new UUIDTokenGenerator();
	}
	
	protected static TokenProcessor tokenProcessor;
	
	protected TokenProcessor(){};
	public static synchronized TokenProcessor getInstance() {
		if(tokenProcessor==null){
			tokenProcessor=new TokenProcessor();
		}
		return tokenProcessor;
	}
	public Object generateToken() {
		return generatorImpl.generateToken();
	}
}
