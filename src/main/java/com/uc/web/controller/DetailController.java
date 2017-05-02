package com.uc.web.controller;

import org.springframework.ui.Model;

public interface DetailController<KeyType, DetailType> 
	extends	ControllerSupport<KeyType> {
	//----------- get detail ------------------------
	String getDetailPage(String action, KeyType recordId, Model model);

	//-------- post detail --------------------------------
	String postDetailPage(String action, DetailType detail);

	String getModelTitle();
	String getPageBasePath();

	String getEntityName();

}
