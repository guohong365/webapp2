package com.uc.web.controller;

import com.uc.web.forms.WebForm;

public class WebAction {
	public static final String NEW="new";
	public static final String MODIFY="modify";
	public static final String VIEW="view";
	public static final String DELETE="delete";
	public static final String CANCELATE="cancel";
	public static final String REACTIVE="reactive";
	public static final String DISABLE="disable";
	public static final String EXPORT="export";
	
	public static final String getActoinName(String action){		
		switch (action) {
		case NEW:
			return "新增";
		case MODIFY:
			return "修改";
		case VIEW:
			return "查看";
		case DELETE:
			return "删除";
		case CANCELATE:
			return "注销";
		case REACTIVE:
			return "激活";
		case DISABLE:
			return "禁用";
		case EXPORT:
			return "导出";
		default:
			return "UNKNOWN";
		}
	}
	public static final String getActionName(WebForm<?,?> action){
		return getActoinName(action.getAction());
	}

}
