package com.uc.web.controller;

import org.springframework.ui.Model;

public interface DetailController<KeyType, EntityType> 
	extends	ControllerBase {	
	String getDetailPage(String action, KeyType recordId, Model model);
	String postDetailPage(String action, EntityType detail);	
	String getEntityName();
}
