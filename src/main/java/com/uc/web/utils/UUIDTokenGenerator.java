package com.uc.web.utils;

import java.util.UUID;

public class UUIDTokenGenerator implements TokenGenerator {

	@Override
	public Object generateToken() {
		return UUID.randomUUID().toString();
	}

}
