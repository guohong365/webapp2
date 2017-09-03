package com.uc.web.utils.captcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.uc.web.service.ServiceBase;

public abstract class AbstractCaptcha extends ServiceBase implements CaptchaService {
	public static final String DEFAULT_CAPTCHA_KEY="captcha_key";
	public static final String DEFAULT_CAPTCHA_VALUE_NAME="capthca";
	
	public static final String DEFAULT_VERIFY_SUCCESS_VALUE="OK";
	public static final String DEFAULT_VERIFY_FIALURE_VALUE="ERROR";
	
	private String captchaValueName;
	private String captchaKey;
	private String successValue;
	private String failureValue;
	
	@Override
	public boolean verifyCaptha(HttpServletRequest request, HttpServletResponse response) {
		String inputCode= request.getParameter(getCaptchaValueName());
		
		if(StringUtils.isEmpty(inputCode)) return false;
				
		String savedCode= (String) request.getSession().getAttribute(getCaptchaKey());
		
		if(StringUtils.isEmpty(savedCode)) return false;
		
		if(inputCode.equalsIgnoreCase(savedCode)) return true;
		
		return false;
	}
	@Override
	public String getCaptchaValueName() {
		if(StringUtils.isEmpty(captchaValueName)){
			return DEFAULT_CAPTCHA_VALUE_NAME;
		}
		return captchaValueName;
	}
	@Override
	public void setCaptchaValueName(String name) {
		captchaValueName=name;
		
	}
	@Override
	public String getSuccessValue() {
		if(StringUtils.isEmpty(successValue)){
			return DEFAULT_VERIFY_SUCCESS_VALUE;
		}
		return successValue;
	}
	@Override
	public void setSuccessValue(String value) {
		successValue=value;
	}
	@Override
	public String getFailureValue() {
		if(StringUtils.isEmpty(failureValue)){
			return DEFAULT_VERIFY_FIALURE_VALUE;
		}
		return failureValue;
	}
	@Override
	public void setFailureValue(String value) {
		failureValue=value;		
	}
	@Override
	public String getCaptchaKey() {
		if(StringUtils.isEmpty(captchaKey)){
			return DEFAULT_CAPTCHA_KEY;
		}
		return captchaKey;
	}
	@Override
	public void setCaptchaKey(String value) {
		captchaKey=value;		
	}


}
