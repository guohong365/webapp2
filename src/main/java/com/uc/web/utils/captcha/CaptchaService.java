package com.uc.web.utils.captcha;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uc.web.service.Service;

public interface CaptchaService extends Service{
	
	void requestCaptcha(HttpServletResponse response, HttpServletRequest request) throws IOException;

	boolean verifyCaptha(HttpServletRequest request, HttpServletResponse response);
	
	String getCaptchaKey();
	void setCaptchaKey(String value);
	
	String getCaptchaValueName();
	void setCaptchaValueName(String name);

	String getSuccessValue();
	void setSuccessValue(String value);

	String getFailureValue();
	void setFailureValue(String value);
	
}
