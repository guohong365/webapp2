package com.uc.web.controller;

import com.uc.utils.LoggerSupportor;
import com.uc.web.domain.security.UserProfile;
import com.uc.web.service.Service;

public interface ControllerBase extends LoggerSupportor {	
	public static final String PARAM_NAME_ACTION = "action";
	public static final String PARAM_NAME_DETAIL = "detailInput";
	public static final String PARAM_NAME_RECORDS = "records";
	public static final String PARAM_NAME_QUERY_INPUT = "queryInput";
	public static final String PARAM_NAME_PAGE_CTRL = "pageCtrl";
	public static final String PARAM_NAME_ACTION_NAME = "actionName";
	public static final String PARAM_NAME_MODULE_TITLE = "moduleTitle";
	public static final String PARAM_NAME_MODULE_NAME = "moduleName";
	public static final String PARAM_NAME_SELECTED_ID = "selectedId";
	public static final String PARAM_NAME_EXPORT_TYPE = "exportType";
	public static final String PARAM_NAME_BASE_URL="baseUrl";
	public static final String PARAM_NAME_DLG_TITLE = "dlgTitle";
	public static final String PARAM_NAME_DLG_MESSAGE = "dlgMessage";

	
	public static final String URI_PATH_LIST = "/list";
	public static final String URI_PATH_TABLE = "/table";
	public static final String URI_PATH_DETAIL = "/detail";
	public static final String URI_PATH_EXPORT = "/export";
	
	public static final String EXPORTOR_OPTION_QUERY_FORM="QUERY_FORM";
	public static final String EXPORTOR_OPTION_DATA="DATA";
	public static final String EXPORTOR_OPTION_EXTERNAL = "EXTERNAL";
	public static final String PARAM_NAME_ENTITY_NAME = "entiryName";
	
	public static final String DETAIL_POST_RESULT_OK="OK";
	public static final String DETAIL_POST_RESULT_FAILED="FAILED";
	
	UserProfile getUser();
	Service getService();
	String getPageBasePath();
	String getModuleName();
	String getModuleTitle();
	
	String getPage404();
	String getPage200();
	String getPage500();
}