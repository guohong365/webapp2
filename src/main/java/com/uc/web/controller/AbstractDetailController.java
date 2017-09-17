package com.uc.web.controller;

import org.springframework.ui.Model;

public abstract class AbstractDetailController<KeyType, EntityType>
	extends AbstractDetailControllerBase
	implements DetailController<KeyType, EntityType> {
		
	@Override
	public String getDetailPage(String action, KeyType recordId, Model model) {
		return onGetDetailPage(action, recordId, model);
	}
	@Override
	public String postDetailPage(String action, EntityType detail) {
		return onPostDetailPage(action, detail);
	}

}
