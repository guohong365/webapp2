package com.uc.web.utils;

import java.util.Date;

public class TimeStampTokenGenerator implements TokenGenerator {

	@Override
	public Object generateToken() {
		return new Date().getTime();
	}

}
