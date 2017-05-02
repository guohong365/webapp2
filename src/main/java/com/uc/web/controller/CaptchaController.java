package com.uc.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uc.utils.LoggerSupportorImpl;
import com.uc.web.utils.captcha.ICaptcha;

@Controller
public class CaptchaController extends LoggerSupportorImpl {
	
	@Resource(name="captchaService")
	ICaptcha captchaService;
	
	//登录获取验证码
    @RequestMapping(value="/captcha", method=RequestMethod.GET)
    @ResponseBody
    public void getCaptcha(HttpServletResponse response,
            HttpServletRequest request) {
    	if(captchaService==null){
    		getLogger().error("captchaService is not installed.");
    		return;
    	}
    	
        response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Set-Cookie", "name=value; HttpOnly");//设置HttpOnly属性,防止Xss攻击
        response.setDateHeader("Expire", 0);        
        try {
        	captchaService.requestCaptcha(response, request);
        	getLogger().info("captcha generated......");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //验证码验证
    @RequestMapping(value = "/captchaVerify")
    @ResponseBody
    public String verifyCaptcha(HttpServletRequest request,HttpServletResponse response) {
    	if(captchaService==null) return "not supported";
    	
    	if(captchaService.verifyCaptha(request,response)){
    		return captchaService.getSuccessValue();
    	}
    	return captchaService.getFailureValue();
    }

}
