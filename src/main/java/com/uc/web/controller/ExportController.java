package com.uc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uc.web.forms.ListQueryForm;

public interface ExportController<QueryFormType extends ListQueryForm>
	extends ControllerBase{
	
	void exportFile(QueryFormType queryForm, HttpServletRequest request, HttpServletResponse response);

}