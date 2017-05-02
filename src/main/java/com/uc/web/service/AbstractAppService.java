package com.uc.web.service;

import java.util.List;

import com.uc.web.forms.QueryForm;
import com.uc.web.forms.WebListFormBase;
import com.uc.web.persistence.AppMapper;
import com.uc.web.persistence.Example;
import com.uc.web.persistence.Mapper;

public class AbstractAppService<
	KeyType,QueryFormType extends QueryForm<KeyType>, DetailType> 
	extends ServiceBase
	implements AppService<KeyType, QueryFormType, DetailType> {
	
	private AppListService<KeyType, QueryFormType, DetailType> listService;
	private AppDetailService<KeyType, DetailType> detailService;

	public AppListService<KeyType, QueryFormType, DetailType> getListService() {
		return listService;
	}
	public void setListService(	AppListService<KeyType, QueryFormType, DetailType> listService) {
		this.listService = listService;
		this.listService.setParent(this);
	}
	public AppDetailService<KeyType, DetailType> getDetailService() {
		return detailService;
	}
	public void setDetailService(AppDetailService<KeyType, DetailType> detailService) {
		this.detailService = detailService;
		this.detailService.setParent(this);
	}
	
	private AppMapper<KeyType, DetailType> appMapper;
	public void setAppMapper(AppMapper<KeyType, DetailType> appMapper) {
		this.appMapper = appMapper;
	}
	public AppMapper<KeyType, DetailType> getAppMapper() {
		return appMapper;
	}
	
	@Override
	public Mapper getMapper() {
		return getAppMapper();
	}
	
	@Override
	public DetailType selectById(KeyType id) {
		return getDetailService().selectById(id);
	}
	@Override
	public int update(DetailType entity) {
		return getDetailService().update(entity);
	}
	@Override
	public int updateSelective(DetailType entity) {
		return getDetailService().updateSelective(entity);
	}
	@Override
	public int insert(DetailType entiry) {
		return getDetailService().insert(entiry);
	}
	@Override
	public int delete(DetailType detail) {
		return getDetailService().delete(detail);
	}
	
	@Override
	public String getErrorMessage(int code) {
		String msg=getDetailService().getErrorMessage(code);
		if(ERROR_UNKNOWN.equals(msg)){
			msg=getListService().getErrorMessage(code);
		}
		return msg;
	}
	@Override
	public boolean prepareExample(QueryFormType queryForm, Example example) {
		return getListService().prepareExample(queryForm, example);
	}
	@Override
	public void select(WebListFormBase<KeyType, QueryFormType, DetailType> webForm) {
		getListService().select(webForm);
	}
	@Override
	public String getDefaultOrderByClause() {
		return getListService().getDefaultOrderByClause();
	}
	@Override
	public List<DetailType> selectForExport(QueryFormType queryForm) {
		return getListService().selectForExport(queryForm);
	}
	@Override
	public void setDefaultOrderByClause(String defaultOrderBy) {
		getListService().setDefaultOrderByClause(defaultOrderBy);
	}

}
