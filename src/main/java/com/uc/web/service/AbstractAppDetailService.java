package com.uc.web.service;

import com.uc.web.persistence.AppDetailMapper;
import com.uc.web.persistence.Mapper;

public abstract class AbstractAppDetailService<DetailKeyType, DetailType extends Object> 
	extends ServiceBase 
	implements AppDetailService<DetailKeyType, DetailType> {
	
	private AppDetailMapper<DetailKeyType, DetailType> appDetailMapper;
	
	public void setAppDetailMapper(AppDetailMapper<DetailKeyType, DetailType> appDetailMapper) {
		this.appDetailMapper = appDetailMapper;
	}
	
	@SuppressWarnings("unchecked")
	public AppDetailMapper<DetailKeyType, DetailType> getAppDetailMapper() {
		if(appDetailMapper==null && getParent()!=null){
			if(getParent().getMapper() instanceof AppDetailMapper)
				return (AppDetailMapper<DetailKeyType, DetailType>) getParent().getMapper();
		}
		return appDetailMapper;
	}
	
	@Override
	public Mapper getMapper() {
		return getAppDetailMapper();
	}
	
	protected void onAfterSelected(DetailType detail){
	}
	

	@Override
	public DetailType selectById(DetailKeyType id) {
		DetailType detail= getAppDetailMapper().selectById(id);
		onAfterSelected(detail);
		return detail;
	}
	
	protected void onBeforeUpdate(DetailType detail){
	}
	protected void onAfterUpdate(DetailType detail){
	}

	@Override
	public int update(DetailType entity) {
		onBeforeUpdate(entity);
		int ret= getAppDetailMapper().updateDetail(entity);
		if(ret==1){
			onAfterUpdate(entity);
		}
		return ret;
	}
	
	protected void onBeforeUpdateSelective(DetailType detail){
	}
	protected void onAfterUpdateSelective(DetailType detail){
	}
	
	@Override
	public int updateSelective(DetailType entity) {
		onBeforeUpdateSelective(entity);
		int ret= getAppDetailMapper().updateDetailSelective(entity);
		if(ret==1){
			onAfterUpdateSelective(entity);
		}
		return ret;
	};
	
	
	protected void onBeforeInsert(DetailType detail){
	}
	protected void onAfterInsert(DetailType detail){
	}

	@Override
	public int insert(DetailType entiry) {
		onBeforeInsert(entiry);
		int ret= getAppDetailMapper().insertDetail(entiry);
		if(ret==1){
			onAfterInsert(entiry);
		} 
		return ret;
	}
	protected void onBeforeDelete(DetailType detail){
	}
	protected void onAfterDeleted(DetailType detail){
	}

	@Override
	public int delete(DetailType detail) {
		onBeforeDelete(detail);
		int ret= getAppDetailMapper().deleteDetail(detail);
		if(ret==1){
			onAfterDeleted(detail);
		} 
		return ret;
	}

	@Override
	public String getErrorMessage(int code) {
		return ERROR_UNKNOWN;
	}
}
