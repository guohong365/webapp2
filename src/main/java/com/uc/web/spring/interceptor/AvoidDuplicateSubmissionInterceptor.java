package com.uc.web.spring.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.uc.web.spring.annotation.AvoidDuplicateSubmissionToken;
import com.uc.web.utils.TokenProcessor;

/**
 * <p>
 * 防止重复提交过滤器
 * </p>
 *
 * @author: chuanli
 * @date: 2013-6-27上午11:19:05
 */
public class AvoidDuplicateSubmissionInterceptor extends HandlerInterceptorAdapter {
    private static final String TOKEN_NAME="token";
 
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
    	if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
       		HandlerMethod handlerMethod = (HandlerMethod) handler;       		
       		Method method = handlerMethod.getMethod(); 
       		AvoidDuplicateSubmissionToken annotation = method.getAnnotation(AvoidDuplicateSubmissionToken.class);
       		if (annotation != null) {
       			boolean needSaveSession = annotation.save();
       			if (needSaveSession) {
       				request.getSession(false).setAttribute(TOKEN_NAME, TokenProcessor.getInstance().generateToken());
       			} 
       			boolean needCheckSession = annotation.check();
        		if (needCheckSession) {        			
        			if (isRepeatSubmit(request)) {
        				return false;
        			}
        		}
        	}
        	return true;
        } else {
        	return super.preHandle(request, response, handler);
        }
    }
    
    private boolean isRepeatSubmit(HttpServletRequest request) {
    	String action=request.getParameter("action");
    	if(action==null || action.equals("view")){
    		return false;
    	}
        String serverToken = (String) request.getSession(false).getAttribute(TOKEN_NAME);
        if (serverToken == null) {
            return true;
        }
        String clinetToken = request.getParameter(TOKEN_NAME);
        if (clinetToken == null) {
            return true;
        }
        if (!serverToken.equals(clinetToken)) {
            return true;
        }
        return false;
    }
 
}