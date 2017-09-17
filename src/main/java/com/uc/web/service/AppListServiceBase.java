package com.uc.web.service;

import java.util.List;

import org.springframework.util.StringUtils;

import com.uc.web.forms.ListQueryForm;
import com.uc.web.persistence.AppListMapper;
import com.uc.web.persistence.AppOptimizedMapper;
import com.uc.web.persistence.Example;
import com.uc.web.persistence.ExampleImpl;

public class AppListServiceBase	extends ServiceBase	implements AppListService {
	
	private String defaultOrderByClause;
	
	@Override
	public String getDefaultOrderByClause() {
		return defaultOrderByClause;
	}
	@Override
	public void setDefaultOrderByClause(String defaultOrderByClause) {
		this.defaultOrderByClause = defaultOrderByClause;
	}
	
	public AppListMapper getListMapper(){
		if(getMapper() instanceof AppListMapper)
			return (AppListMapper) getMapper();
		return null;
	}
	
	public AppOptimizedMapper getOptimiedMapper(){
		if(getMapper() instanceof AppOptimizedMapper)
			return (AppOptimizedMapper) getMapper();
		return null;
	}	
	@Override
	public boolean prepareExample(ListQueryForm queryFormType, Example example) {		
		return true;
	}
	@Override
	public boolean prepareQueryForm(ListQueryForm queryForm) {
		return true;
	}
	@Override
	public List<?> select(ListQueryForm queryForm, long offset, long count) {
		if(queryForm!=null && !isOrderBy(queryForm)){
			queryForm.setQueryOrderByClause(getDefaultOrderByClause());
		}		
		if(getOptimiedMapper()!=null){
			if(prepareQueryForm(queryForm)){
				return getOptimiedMapper().selectOptimized(queryForm, offset, count);
			}
		}
		if(getListMapper()!=null){
			Example example=new ExampleImpl();
			if(prepareExample(queryForm, example)){				
				return getListMapper().selectByExample(example, offset,  count);
			}
		}
		return null;
	}
	@Override
	public Long selectCount(ListQueryForm queryForm) {
		Long count = null;
		if(getOptimiedMapper()!=null){
			if(prepareQueryForm(queryForm)){
				count = getOptimiedMapper().selectCountOptimized(queryForm);			
			}
		}
		if(getListMapper()!=null){
			Example example=new ExampleImpl();
			if(prepareExample(queryForm, example)){
				count= getListMapper().selectCountByExample(example);
			}
		}
		return count;
	}
	
	protected void onAfterListSelected(List<?> list){
		
	}
	
	protected boolean isOrderBy(ListQueryForm queryForm) {
		return !StringUtils.isEmpty(queryForm.getQueryOrderByClause());
	}
}
