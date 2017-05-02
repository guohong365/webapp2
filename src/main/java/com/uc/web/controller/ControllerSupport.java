package com.uc.web.controller;

import com.uc.utils.LoggerSupportor;
import com.uc.web.domain.security.UserProfile;

public interface ControllerSupport<KeyType> extends LoggerSupportor {
	public UserProfile<KeyType> getUserProfile();
	public static final String PARAM_NAME_ACTION = "action";
	public static final String PARAM_NAME_DETAIL = "detailInput";
	public static final String PARAM_NAME_RECORDS = "records";
	public static final String PARAM_NAME_QUERY_INPUT = "queryInput";
	public static final String PARAM_NAME_PAGE_CTRL = "pageCtrl";
	public static final String PARAM_NAME_ACTION_NAME = "actionName";
	public static final String PARAM_NAME_MODEL_TITLE = "modelTitle";
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
	
	ControllerSupport<KeyType> getParent();
	void setParent(ControllerSupport<KeyType> parent);
	public String getPageBasePath();
	public String getModelTitle();
	public String getEntityName();

}