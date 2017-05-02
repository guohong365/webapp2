package com.uc.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import com.uc.web.domain.Code;
import com.uc.web.domain.security.UserProfile;
import com.uc.web.service.AppDetailService;

public abstract class AbstractDetailControllerBase<KeyType,	DetailType> 
	extends ControllerSupportImpl<KeyType> {

	protected static final String PAGE_VIEW = "/view";
	protected static final String PAGE_MODIFY = "/modify";
	protected static final String PAGE_DELETE = "/delete";
	protected static final String PAGE_NEW = "/new";
	protected static final String PAGE_CANCELATE = "/cancelate";
	protected static final String PAGE_DISABLE = "/disable";
	protected static final String PAGE_REACTIVE = "/reactive";
	private static final String PAGE_FAULT = "/500";
	
	protected String getErrorPageName(){
		return PAGE_FAULT;
	}
		
	protected String getViewPageName() {
		return getPageBasePath() + PAGE_VIEW;
	}

	protected String getModifyPageName() {
		return getPageBasePath() + PAGE_MODIFY;
	}

	protected String getDeletePageName() {
		return getPageBasePath() + PAGE_DELETE;
	}

	protected String getNewPageName() {
		return getPageBasePath() + PAGE_NEW;
	}

	private AppDetailService<KeyType, DetailType> appDetailService;
	
	public void setAppDetailService(AppDetailService<KeyType, DetailType> appDetailService) {
		this.appDetailService = appDetailService;
	}
	
	public AppDetailService<KeyType, DetailType> getAppDetailService() {
		return appDetailService;
	}

	private void logCodes(
			Map<String, List<? extends Code<KeyType>>> codes) {
		if(getLogger().isTraceEnabled() && codes!=null){
			getLogger().trace("--------加载查询条件代码:" + codes.size() + "个...");
			for(Entry<String, List<? extends Code<KeyType>>> entry: codes.entrySet()){
				if(entry!=null){
					getLogger().trace("\t 代码: ["+entry.getKey()+"] " + entry.getValue());
				}
			}
			getLogger().trace("--------代码加载完成-----------");			
		}
	}
	
	private String detailClassName;
	public void setDetailClassName(String detailClassName) {
		this.detailClassName = detailClassName;
	}
	public String getDetailClassName() {
		return detailClassName;
	}
	
	private DetailType defaultDetail;
	public DetailType getDefaultDetail() {
		return defaultDetail;
	}
	public void setDefaultDetail(DetailType defaultDetail) {
		this.defaultDetail = defaultDetail;
	}

	@SuppressWarnings("unchecked")
	protected DetailType onCreateNewDetail(){
		if(getDefaultDetail()!=null){
			return getDefaultDetail();
		}
		return StringUtils.isEmpty(getDetailClassName())? null:(DetailType) createInstanceByName(getDetailClassName());
	}

	protected Map<String, List<? extends Code<KeyType>>> onGetNewCodes(UserProfile<KeyType> user) {
		return new HashMap<>();
	}

	protected Map<String, List<? extends Code<KeyType>>> onGetModifyCodes(UserProfile<KeyType> user, DetailType detail) {
		return new HashMap<>();
	}

	protected void onAfterSelectDetail(UserProfile<KeyType> user, String action, DetailType detail) {		
	}

	protected String onGetDetailPage(String action, KeyType selectedId, Model model) {
		UserProfile<KeyType> user=getUserProfile();
		DetailType detail=null;
		Map<String, List<? extends Code<KeyType>>> codes;		
		String pageName="";		
		getLogger().trace("--------获取详细信息页，操作=["+ action	+ "] 记录ID=["+ selectedId + "]--------");
		
		switch(action){
		case WebAction.NEW:
			detail=onCreateNewDetail();
			getLogger().trace("-------record created ---------");
			getLogger().trace(detail.toString());
			addDetailToModel(action, detail, model);
			getLogger().trace("------ prepare new page codes -----");
			codes=onGetNewCodes(user);
			logCodes(codes);			
			model.addAllAttributes(codes);			
			pageName=getNewPageName();
			break;
		case WebAction.MODIFY:
			getLogger().trace("-------- modify action ---------------");
			detail=getAppDetailService().selectById(selectedId);
			getLogger().trace("-------- detail record selected by id=["+selectedId+"]-------");
			getLogger().trace(detail.toString());
			getLogger().trace("------ prepare new page codes -----");
			codes=onGetModifyCodes(user, detail);			
			logCodes(codes);			
			model.addAllAttributes(codes);			
			pageName=getModifyPageName();
			break;
		case WebAction.CANCELATE:
			detail=getAppDetailService().selectById(selectedId);
			pageName=getCancelatePageName();
			break;
		case WebAction.DELETE:
			detail=getAppDetailService().selectById(selectedId);
			pageName=getDeletePageName();
			break;
		case WebAction.DISABLE:
			detail=getAppDetailService().selectById(selectedId);
			pageName=getDisablePageName();
			break;
		case WebAction.REACTIVE:
			detail=getAppDetailService().selectById(selectedId);	
			pageName=getReactivePageName();
			break;			
		case WebAction.VIEW:
			detail=getAppDetailService().selectById(selectedId);			
			if(getLogger().isTraceEnabled() && detail!=null){
				getLogger().trace(detail.toString());
			}
			pageName=getViewPageName();
			break;
		default:
			getLogger().error("---- unknown action[" + action + "]-----");
			return getErrorPageName();
		}		
		getLogger().trace(detail.toString());
		onAfterSelectDetail(user, action, detail);
		
		addDetailToModel(action, detail, model);
		getLogger().trace("------返回页面模板["+pageName+"] --------");
		return pageName;
	}

	protected String getReactivePageName() {
		return PAGE_REACTIVE;
	}

	protected String getDisablePageName() {
		return PAGE_DISABLE;
	}

	protected String getCancelatePageName() {
		return PAGE_CANCELATE;
	}

	protected void onBeforSaveDetail(UserProfile<KeyType> user, String action, DetailType detail) throws Exception {
		
	}
	protected void saveNew(DetailType detail){
		getAppDetailService().insert(detail);
	}
	protected void saveModify(DetailType detail){
		getAppDetailService().update(detail);
	}
	protected void saveDelete(DetailType detail){
		getAppDetailService().delete(detail);
	}
	protected void saveCancelate(DetailType detail){		
	}
	protected void saveReactive(DetailType detail){		
	}
	protected void saveDisable(DetailType detail){		
	}
	

	protected String onPostDetailPage(String action, DetailType detail) {
		UserProfile<KeyType> user =getUserProfile();
		getLogger().trace("--------保存记录修改  操作["+action+"] -----");
		getLogger().trace("--------页面记录---------------");
		getLogger().trace(detail.toString());
		getLogger().trace("----------------------------");
		
		try {
			getLogger().trace("--------预处理输入数据--------");
			onBeforSaveDetail(user, action, detail);
			getLogger().trace("--------处理完成----------");
			getLogger().trace(detail.toString());
			getLogger().trace("------------------------");
	
			switch (action) {
			case WebAction.NEW:
				saveNew(detail);
				break;
			case WebAction.MODIFY:
				saveModify(detail);
				break;
			case WebAction.DELETE:
				saveDelete(detail);
				break;
			case WebAction.VIEW:
				break;
			case WebAction.CANCELATE:
				saveCancelate(detail);
				break;
			case WebAction.DISABLE:
				saveDisable(detail);
				break;
			case WebAction.REACTIVE:
				saveReactive(detail);
			default:
				getLogger().error("-----unknown action-----");
				assert false;
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			getLogger().error("-------保存失败-------");
			getLogger().error(e.toString());
			getLogger().error("-------------------");
			return "FAILED";
		}
		getLogger().debug("-----保存成功------");
		return "OK";
	}

	protected void addDetailToModel(String action, DetailType detail, Model model) {
		model.addAttribute(GeneralController.PARAM_NAME_ENTITY_NAME, getEntityName());
		model.addAttribute(GeneralController.PARAM_NAME_ACTION, action);
		model.addAttribute(GeneralController.PARAM_NAME_ACTION_NAME, WebAction.getActoinName(action)+getEntityName());
		model.addAttribute(GeneralController.PARAM_NAME_DETAIL, detail);
	}
}
