package com.uc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uc.web.forms.QueryForm;

public interface ExportController<KeyType, QueryFormType extends QueryForm<KeyType>, DetailType>
	extends ControllerSupport<KeyType>{

String getModelTitle();

//----------------- export -----------------------------
void exportFile(QueryFormType queryForm, HttpServletRequest request, HttpServletResponse response, String type);

}