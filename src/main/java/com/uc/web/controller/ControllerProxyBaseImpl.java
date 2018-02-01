package com.uc.web.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.uc.web.forms.editor.BigDecimalEditor;
import com.uc.web.forms.editor.IntegerEditor;
import com.uc.web.forms.editor.LongEditor;

public abstract class ControllerProxyBaseImpl extends ControllerBaseImpl implements ControllerProxy {

	private String baseUri;

	
	private ControllerBase controller;
	
	public void setBaseUri(String baseUri) {
		this.baseUri = baseUri;
	}
	
	public ControllerBase getController() {
		return controller;
	}
	
	public void setController(ControllerBase controller) {
		this.controller = controller;
	}
		
	@Override
	@ModelAttribute(value=PARAM_NAME_BASE_URL)
	public String getBaseUri() {
		return StringUtils.isEmpty(baseUri) ? "": baseUri.substring(1);
	}	
	
	@Override
	@ModelAttribute(PARAM_NAME_MODULE_NAME)
	public String getModuleName() {
		return getController().getModuleName();
	}
	
	@Override
	@ModelAttribute(PARAM_NAME_MODULE_TITLE)
	public String getModuleTitle() {
		return getController().getModuleTitle();
	}
		
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
