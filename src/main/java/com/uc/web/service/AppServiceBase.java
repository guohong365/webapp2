package com.uc.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.uc.utils.export.Exportor;
import com.uc.web.forms.ListQueryForm;
import com.uc.web.forms.ui.componet.PageCtrl;
import com.uc.web.persistence.AppDeleteMapper;
import com.uc.web.persistence.AppInsertMapper;
import com.uc.web.persistence.AppListMapper;
import com.uc.web.persistence.AppOptimizedMapper;
import com.uc.web.persistence.AppSelectByKeyMapper;
import com.uc.web.persistence.AppUpdateMapper;
import com.uc.web.persistence.AppUuidMapper;
import com.uc.web.persistence.Example;
import com.uc.web.persistence.ExampleImpl;

public class AppServiceBase extends ServiceBase {
	public AppInsertMapper getInsertMapper(){
		if(getMapper() instanceof AppInsertMapper){ 
			return (AppInsertMapper)getMapper();
		}
		return null;
	}
	public AppUpdateMapper getUpdateMapper(){
		if(getMapper() instanceof AppUpdateMapper){
			return (AppUpdateMapper)getMapper();
		}
		return null;
	}
	public AppDeleteMapper getDeleteMapper(){
		if(getMapper() instanceof AppDeleteMapper){
			return (AppDeleteMapper) getMapper();
		}
		return null;
	}
	public AppSelectByKeyMapper getSelectByKeyMapper(){
		if(getMapper() instanceof AppSelectByKeyMapper){
			return (AppSelectByKeyMapper) getMapper();
		}
		return null;
	}
	public AppUuidMapper getUuidMapper(){
		if(getMapper() instanceof AppUuidMapper){
			return (AppUuidMapper)getMapper();
		}
		return null;
	}
	
	protected void onAfterSelected(Object detail){
	}
	

	public Object selectById(Object id) {
		Object detail= (Object) getSelectByKeyMapper().selectById(id);
		onAfterSelected(detail);
		return detail;
	}
	
	protected void onBeforeUpdate(Object detail){
	}
	protected void onAfterUpdate(Object detail){
	}
	
	public int update(Object entity) {		
		onBeforeUpdate(entity);
		int ret= getUpdateMapper().updateDetail(entity);
		if(ret==1){
			onAfterUpdate(entity);
		}
		return ret;
	}
	
	protected void onBeforeUpdateSelective(Object detail){
	}
	protected void onAfterUpdateSelective(Object detail){
	}
	
	public int updateSelective(Object entity) {
		onBeforeUpdateSelective(entity);
		int ret= getUpdateMapper().updateDetailSelective(entity);
		if(ret==1){
			onAfterUpdateSelective(entity);
		}
		return ret;
	};
	
	
	protected void onBeforeInsert(Object detail){
	}
	protected void onAfterInsert(Object detail){
	}


	public int insert(Object entiry) {
		onBeforeInsert(entiry);
		int ret= getInsertMapper().insertDetail(entiry);
		if(ret==1){
			onAfterInsert(entiry);
		} 
		return ret;
	}
	protected void onBeforeDelete(Object detail){
	}
	protected void onAfterDeleted(Object detail){
	}

	public int delete(Object detail) {
		onBeforeDelete(detail);
		int ret= getDeleteMapper().deleteDetail(detail);
		if(ret==1){
			onAfterDeleted(detail);
		} 
		return ret;
	}
	
	
	private String defaultOrderByClause;
	
	public String getDefaultOrderByClause() {
		return defaultOrderByClause;
	}
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
	public boolean prepareExample(ListQueryForm queryFormType, Example example) {		
		return true;
	}
	public boolean prepareQueryForm(ListQueryForm queryForm) {
		return true;
	}
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
	

	public List<?> select(ListQueryForm queryForm, PageCtrl pageCtrl) {		
		Long count=null;
		List<?> list;
		
		count=selectCount(queryForm);		
		if(count==null || count == 0){
			PageCtrl.initPageCtrl(pageCtrl, 0);
			return new ArrayList<>();
		}
		if(pageCtrl.getOffset() < 0){
			PageCtrl.initPageCtrl(pageCtrl, count);			
		} else {  //update total of pageCtrl
			pageCtrl.setTotal(count);
		}		
		list=select(queryForm, pageCtrl.getOffset(), pageCtrl.getPageSize());
		onAfterListSelected(list);
		return list;
	}

	public List<?> selectForExport(ListQueryForm queryForm) {
		Long count= selectCount(queryForm);
		if(count==null){
			return new ArrayList<>();
		}				
		return select(queryForm, 0, Exportor.MAX_ROW);
	}
	
	public Object selectByUuid(String uuid) {
		if(getUuidMapper()!=null)
			return getUuidMapper().selectByUuid(uuid);
		return null;
	}
	public Object selectIdByUuid(String uuid) {
		if(getUuidMapper()!=null) {
			return getUuidMapper().selectIdByUuid(uuid);
		}
		return null;
	}
}
