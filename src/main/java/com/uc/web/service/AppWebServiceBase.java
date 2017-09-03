package com.uc.web.service;

import java.util.List;

import com.uc.web.forms.QueryForm;
import com.uc.web.forms.WebListForm;
import com.uc.web.persistence.Example;

public class AppWebServiceBase<
	KeyType,QueryFormType extends QueryForm<KeyType>, DetailType> 
	extends ServiceBase	
	implements AppService<KeyType, QueryFormType, DetailType> {
	
	private AppWebListService<QueryFormType, DetailType> listService;
	private AppDetailService<KeyType, DetailType> detailService;

	public AppWebListService<QueryFormType, DetailType> getListService() {
		return listService;
	}
	public void setListService(	AppWebListService<QueryFormType, DetailType> listService) {
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
	public boolean prepareExample(QueryFormType queryForm, Example example) {
		return getListService().prepareExample(queryForm, example);
	}
	@Override
	public void select(WebListForm<QueryFormType, DetailType> webForm) {
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
	@Override
	public boolean prepareQueryForm(QueryFormType queryForm) {
		return true;
	}
	@Override
	public Long selectCount(QueryFormType queryForm) {
		return getListService().selectCount(queryForm);
	}
	@Override
	public List<DetailType> select(QueryFormType queryForm, long offset, long count) {
		return getListService().select(queryForm, offset, count);
	}

}
