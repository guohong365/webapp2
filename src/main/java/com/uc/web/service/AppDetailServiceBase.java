package com.uc.web.service;

import com.uc.web.persistence.AppDeleteMapper;
import com.uc.web.persistence.AppInsertMapper;
import com.uc.web.persistence.AppSelectByKeyMapper;
import com.uc.web.persistence.AppUpdateMapper;
import com.uc.web.persistence.AppUuidMapper;

public class AppDetailServiceBase extends ServiceBase 
	implements AppDetailService {
	
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
	

	@Override
	public Object selectById(Object id) {
		Object detail= (Object) getSelectByKeyMapper().selectById(id);
		onAfterSelected(detail);
		return detail;
	}
	
	protected void onBeforeUpdate(Object detail){
	}
	protected void onAfterUpdate(Object detail){
	}

	@Override
	public int update(Object entity) {
		if(getUpdateMapper()==null) return 0;
		
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
	
	@Override
	public int updateSelective(Object entity) {
		if(getUpdateMapper()==null) return 0;
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

	@Override
	public int insert(Object entiry) {
		if(getInsertMapper()==null) return 0;
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

	@Override
	public int delete(Object detail) {
		if(getDeleteMapper()==null) return 0;
		onBeforeDelete(detail);
		int ret= getDeleteMapper().deleteDetail(detail);
		if(ret==1){
			onAfterDeleted(detail);
		} 
		return ret;
	}
}
