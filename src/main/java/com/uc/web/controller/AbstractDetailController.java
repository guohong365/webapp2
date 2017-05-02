package com.uc.web.controller;

import org.springframework.ui.Model;

public abstract class AbstractDetailController<KeyType, DetailType>
	extends AbstractDetailControllerBase<KeyType, DetailType>
	implements DetailController<KeyType, DetailType> {
	
	@Override
	public String getDetailPage(String action, KeyType recordId, Model model) {
		return onGetDetailPage(action, recordId, model);
	}
	@Override
	public String postDetailPage(String action, DetailType detail) {
		return onPostDetailPage(action, detail);
	}

}
