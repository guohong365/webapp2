package com.uc.web.tools.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AutoGenerateEntity {
	public static final String DEFAULT_ROW_BUTTON_VIEW="查看|view|btn-info|fa fa-search|icon";
	public static final String DEFAULT_ROW_BUTTON_MODIFY="修改|modify|btn-warning|fa fa-edit|icon";
	public static final String DEFAULT_ROW_BUTTON_DELETE="删除|delete|btn-danger|fa fa-trash-o|icon";
	public static final String DEFAULT_BUTTON_NEW="新建|new|btn-success|fa fa-pencil|both";
	//entity name
	String value() default "";
	String[] rowButtons() default {DEFAULT_ROW_BUTTON_VIEW, DEFAULT_ROW_BUTTON_MODIFY, DEFAULT_ROW_BUTTON_DELETE};
	//define list function buttons, format as : "buttonName[|action][|css_btnClass][|iconClass][|icon]"
	//buttonName: 按钮显示名称
	//action:动作(new,view,modify,delete,cancel,reactive,...)
	//btnClass:按钮样式
	//iconClass:图标样式
	//icon:是否显示图标(icon, text, both), default: both
	String[] buttons() default {DEFAULT_BUTTON_NEW};
}
