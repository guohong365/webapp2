package com.uc.web.service;

public interface ActivableObjectService<DetailFormType> extends Service {
	public int updateActive(DetailFormType detailForm, boolean active);
}
