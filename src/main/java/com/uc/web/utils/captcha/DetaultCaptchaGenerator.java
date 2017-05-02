package com.uc.web.utils.captcha;

import java.util.Calendar;
import java.util.Random;

import org.springframework.util.StringUtils;

public class DetaultCaptchaGenerator implements ICharCodeCaptchaGenerator {
	private static final String DEFAULT_CHAR_SET="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private String captchaCharSet;
	
	@Override
	public String generate(int count) {
		Random random=new Random(Calendar.getInstance().getTimeInMillis());
		StringBuilder builder=new StringBuilder();
		for(int i=0; i< count; i++){
			builder.append(getCaptchaCharSet().charAt(random.nextInt(getCaptchaCharSet().length()-1)));
		}
		return builder.toString();
	}

	public String getCaptchaCharSet() {
		if(StringUtils.isEmpty(captchaCharSet))
			return DEFAULT_CHAR_SET;
		return captchaCharSet;
	}

	public void setCaptchaCharSet(String captchaCharSet) {
		this.captchaCharSet = captchaCharSet;
	}

}
