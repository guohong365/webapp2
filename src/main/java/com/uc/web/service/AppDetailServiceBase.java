package com.uc.web.service;

import com.uc.web.persistence.AppDeleteMapper;
import com.uc.web.persistence.AppInsertMapper;
import com.uc.web.persistence.AppSelectByKeyMapper;
import com.uc.web.persistence.AppUpdateMapper;
import com.uc.web.persistence.AppUuidMapper;

public class AppDetailServiceBase<DetailKeyType, DetailType extends Object> 
	extends ServiceBase 
	implements AppDetailService<DetailKeyType, DetailType> {
	
	@SuppressWarnings("unchecked")
	public AppInsertMapper<DetailType> getInsertMapper(){
		if(getMapper() instanceof AppInsertMapper){ 
			return (AppInsertMapper<DetailType>)getMapper();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public AppUpdateMapper<DetailType> getUpdateMapper(){
		if(getMapper() instanceof AppUpdateMapper){
			return (AppUpdateMapper<DetailType>)getMapper();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public AppDeleteMapper<DetailType> getDeleteMapper(){
		if(getMapper() instanceof AppDeleteMapper){
			return (AppDeleteMapper<DetailType>) getMapper();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public AppSelectByKeyMapper<DetailKeyType, DetailType> getSelectByKeyMapper(){
		if(getMapper() instanceof AppSelectByKeyMapper){
			return (AppSelectByKeyMapper<DetailKeyType, DetailType>) getMapper();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public AppUuidMapper<DetailKeyType, DetailType> getUuidMapper(){
		if(getMapper() instanceof AppUuidMapper){
			return (AppUuidMapper<DetailKeyType, DetailType>)getMapper();
		}
		return null;
	}
	
	protected void onAfterSelected(DetailType detail){
	}
	

	@Override
	public DetailType selectById(DetailKeyType id) {
		DetailType detail= getSelectByKeyMapper().selectById(id);
		onAfterSelected(detail);
		return detail;
	}
	
	protected void onBeforeUpdate(DetailType detail){
	}
	protected void onAfterUpdate(DetailType detail){
	}

	@Override
	public int update(DetailType entity) {
		if(getUpdateMapper()==null) return 0;
		
		onBeforeUpdate(entity);
		int ret= getUpdateMapper().updateDetail(entity);
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
		if(getUpdateMapper()==null) return 0;
		onBeforeUpdateSelective(entity);
		int ret= getUpdateMapper().updateDetailSelective(entity);
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
		if(getInsertMapper()==null) return 0;
		onBeforeInsert(entiry);
		int ret= getInsertMapper().insertDetail(entiry);
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
		if(getDeleteMapper()==null) return 0;
		onBeforeDelete(detail);
		int ret= getDeleteMapper().deleteDetail(detail);
		if(ret==1){
			onAfterDeleted(detail);
		} 
		return ret;
	}
}
