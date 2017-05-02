package com.uc.web.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.uc.web.forms.editor.BigDecimalEditor;
import com.uc.web.forms.editor.IntegerEditor;
import com.uc.web.forms.editor.LongEditor;

public abstract class ControllerProxySupportImpl<KeyType> extends ControllerSupportImpl<KeyType> {
	@InitBinder(PARAM_NAME_DETAIL)
	protected void InitBinderDetailInput(WebDataBinder binder){
		binder.setFieldDefaultPrefix(PARAM_NAME_DETAIL+".");
	}
	
	@InitBinder(PARAM_NAME_QUERY_INPUT)
	protected void initBinderQueryForm(WebDataBinder binder) {
		binder.setFieldDefaultPrefix(PARAM_NAME_QUERY_INPUT + ".");
	}

	@InitBinder(PARAM_NAME_PAGE_CTRL)
	protected void iniBinderPageCtrl(WebDataBinder binder) {
		binder.setFieldDefaultPrefix(PARAM_NAME_PAGE_CTRL + ".");
	}

	@InitBinder
	protected void initBinderDateType(WebDataBinder binder) {
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true) );
		binder.registerCustomEditor(Integer.class, new IntegerEditor());
		binder.registerCustomEditor(Long.class, new LongEditor());
		binder.registerCustomEditor(BigDecimal.class, new BigDecimalEditor());		
	}
}
