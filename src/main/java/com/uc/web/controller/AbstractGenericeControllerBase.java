package com.uc.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.uc.utils.export.Exportor;
import com.uc.utils.export.ExportorFactory;
import com.uc.web.domain.Code;
import com.uc.web.domain.security.UserProfile;
import com.uc.web.forms.QueryForm;
import com.uc.web.forms.WebListFormBase;
import com.uc.web.forms.ui.componet.IPageCtrl;
import com.uc.web.forms.ui.componet.PageCtrl;
import com.uc.web.service.AppService;

public abstract class AbstractGenericeControllerBase<KeyType,	QueryFormType extends QueryForm<KeyType>,	DetailType> 
	extends ControllerSupportImpl<KeyType> {

	protected static final String PAGE_LIST = "/list";
	protected static final String PAGE_TABLE = "/table";
	protected static final String PAGE_VIEW = "/view";
	protected static final String PAGE_MODIFY = "/modify";
	protected static final String PAGE_DELETE = "/delete";
	protected static final String PAGE_NEW = "/new";
	protected static final String PAGE_CANCELATE = "/cancelate";
	protected static final String PAGE_DISABLE = "/disable";
	protected static final String PAGE_REACTIVE = "/reactive";
	
	protected abstract String onGetPageBasePath();

	protected String getListPageName() {
		return onGetPageBasePath() + PAGE_LIST;
	}

	protected String getTablePageName() {
		return onGetPageBasePath() + PAGE_TABLE;
	}

	protected String getViewPageName() {
		return onGetPageBasePath() + PAGE_VIEW;
	}

	protected String getModifyPageName() {
		return onGetPageBasePath() + PAGE_MODIFY;
	}

	protected String getDeletePageName() {
		return onGetPageBasePath() + PAGE_DELETE;
	}

	protected String getNewPageName() {
		return onGetPageBasePath() + PAGE_NEW;
	}

	protected abstract String onGetModelTitle();

	public String getEntityName(){
		return onGetEntityName();
	}

	protected abstract String onGetEntityName();
	
	private AppService<KeyType,	QueryFormType,	DetailType> appService;
	
	protected AppService<KeyType,		QueryFormType,	DetailType> getAppService(){
		return appService;
	};
	
	public void setAppService(AppService<KeyType,	QueryFormType,	DetailType> appService){
		this.appService=appService;
	}
	
	private ExportorFactory exportorFactory;
		
	public void setExportorFactory(ExportorFactory exportorFactory) {
		this.exportorFactory = exportorFactory;
	}
	
	public ExportorFactory getExportorFactory() {
		return exportorFactory;
	}
	
	private Object exportorOptions;
	
	public void setExportorOptions(Object exportorOptions) {
		this.exportorOptions = exportorOptions;
	}
	
	public Object getExportorOptions() {
		return exportorOptions;
	}
	
	private void commonSetQueryForm(UserProfile<KeyType> user, QueryFormType queryForm) {
		queryForm.setQueryUser(user);
		onSetUserQueryLimits(queryForm);
	}

	private void logCodes(Map<String, List<? extends Code<KeyType>>> codes) {
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

	protected abstract QueryFormType onCreateNewQueryForm();

	protected void onSetUserQueryLimits(QueryFormType queryForm) {
	}

	protected QueryFormType onPrepareInitQueryForm(UserProfile<KeyType> user) {
		QueryFormType queryForm= onCreateNewQueryForm();
		commonSetQueryForm(user, queryForm);
		return queryForm;
	}

	protected Map<String, List<? extends Code<KeyType>>> onGetListPageCodes(UserProfile<KeyType> user) {
		return new HashMap<>();
	}

	protected void afterListSelected(WebListFormBase<KeyType, QueryFormType, DetailType> webForm) {
	}

	protected void onSetListModel(UserProfile<KeyType> user, Model model) {
	}

	protected String onGetListPage(Model model) {		
		UserProfile<KeyType> user=getUserProfile();
		
		WebListFormBase<KeyType, QueryFormType, DetailType> webForm=new WebListFormBase<>();
		//准备无条件queryFrom		
		getLogger().trace("---- 准备列表查询默认条件 --------");		
		QueryFormType queryForm=onPrepareInitQueryForm(user);
		getLogger().trace("---- 默认条件  -------");		
		getLogger().trace(queryForm.toString());
		getLogger().trace("------------------");
		
		webForm.setQuery(queryForm);
		
		getLogger().trace("-------查询数据-------");
		getAppService().select(webForm);
		getLogger().trace("------获得数据["+webForm.getData().size()+"]------" );
		addWebListFromToModel(webForm, model);
		
		getLogger().trace("------ 加工修改列表结果--------");
		afterListSelected(webForm);
		getLogger().trace("-------加工修改列表结果完成---- ");
		
		getLogger().trace("-------准备列表页查询代码--------");
		Map<String, List<? extends Code<KeyType>>> codes=onGetListPageCodes(user);
		logCodes(codes);
		
		if(codes!=null && !codes.isEmpty()){
			model.addAllAttributes(codes);
		}		
		
		getLogger().trace("------向model添加附加信息--------");
		onSetListModel(user, model);
		getLogger().trace("------附加信息添加完成--------");
		
		String pageName=getListPageName();
		getLogger().trace("------返回页面模板["+pageName+"]------"  );
		return pageName;
	}

	protected void onBeforeSelectPagationList(UserProfile<KeyType> user, QueryFormType queryForm, IPageCtrl pageCtrl) {
		commonSetQueryForm(user, queryForm);
	}

	protected String onPostTablePage(QueryFormType queryForm, PageCtrl pageCtrl, Model model) {
		UserProfile<KeyType> user=getUserProfile();
		getLogger().trace("-----输入条件-----");
		getLogger().trace(queryForm.toString());
		getLogger().trace("---------------");
		WebListFormBase<KeyType, QueryFormType, DetailType> webForm=new WebListFormBase<>();
		getLogger().trace("-----准备列表数据查询条件----");
		onBeforeSelectPagationList(user, queryForm, pageCtrl);
		getLogger().trace(queryForm.toString());
		getLogger().trace("----------------------");
		webForm.setQuery(queryForm);
		webForm.setPageCtrl(pageCtrl);
		getLogger().trace("------查询数据----------");
		getAppService().select(webForm);
		getLogger().trace("------获得数据["+webForm.getData().size()+"]----");
		getLogger().trace("------ 加工修改列表结果--------");
		afterListSelected(webForm);
		getLogger().trace("-------加工修改列表结果完成---- ");		
		addWebListFromToModel(webForm, model);		
		getLogger().trace("------添加类表附加信息--------");
		onSetListModel(user, model);
		getLogger().trace("------附加信息添加完成--------");
		String pageName=getTablePageName();
		getLogger().trace("------返回页面模板["+pageName+"]------");
		return pageName;
	}

	protected void onBeforeSelectPostList(UserProfile<KeyType> user, QueryFormType queryForm) {
		commonSetQueryForm(user, queryForm);
	}

	protected String onPostListPage(QueryFormType queryForm, Model model) {
		UserProfile<KeyType> user=getUserProfile();
		getLogger().trace("-----输入条件-----");
		getLogger().trace(queryForm.toString());
		getLogger().trace("---------------");
				
		WebListFormBase<KeyType, QueryFormType, DetailType> webForm=new WebListFormBase<>();
		getLogger().trace("-----准备查询条件-----");
		onBeforeSelectPostList(user, queryForm);
		getLogger().trace(queryForm.toString());
		getLogger().trace("------------------");
		webForm.setQuery(queryForm);		
		getLogger().trace("------查询数据----------");
		getAppService().select(webForm);
		getLogger().trace("------获得数据[%d]----", webForm.getData().size());
		
		getLogger().trace("------ 加工修改列表结果--------");
		afterListSelected(webForm);
		getLogger().trace("-------加工修改列表结果完成---- ");	
		
		
		addWebListFromToModel(webForm, model);
		
		getLogger().trace("------添加类表附加信息--------");
		onSetListModel(user, model);
		getLogger().trace("------附加信息添加完成--------");
		
		String pageName=getTablePageName();
		getLogger().trace("------返回页面模板["+pageName+"]------");
		return pageName;
	}

	protected String getDetaultExportFileName() {
		return "";
	}

	protected Exportor onGetExportor(QueryFormType queryForm, List<DetailType> data, String type) {
		if(getExportorFactory()!=null){
			Map<String,Object> options=new HashMap<>();
			options.put(GeneralController.EXPORTOR_OPTION_QUERY_FORM, queryForm);
			options.put(GeneralController.EXPORTOR_OPTION_DATA, data);
			options.put(GeneralController.EXPORTOR_OPTION_EXTERNAL, getExportorOptions());
			return getExportorFactory().create(options);
		}
		return null;
	}

	protected void onBeforeSelectExportList(UserProfile<KeyType> user, QueryFormType queryForm) {
		commonSetQueryForm(user, queryForm);
	}

	protected void onAferExportListSelected(QueryFormType queryForm, List<DetailType> details) {		
	}

	protected void onExport(QueryFormType queryForm, HttpServletRequest request, HttpServletResponse response, String type) {
		UserProfile<KeyType> user=getUserProfile();		
		
		onBeforeSelectExportList(user, queryForm);		
		List<DetailType> data=getAppService().selectForExport(queryForm);
		
		onAferExportListSelected(queryForm, data);
		
		Exportor exportor=onGetExportor(queryForm, data, type);
				
		if(exportor!=null){
			try {
				exportor.Export(request, response);
				getLogger().debug("---- export successfuly-------");
			} catch (IOException e) {
				e.printStackTrace();
				getLogger().error("-----export failed----------");
				getLogger().error(e.toString());
				getLogger().error("---------------------------");
			}
		} else {
			getLogger().error("---- no export found-----");
		}
		
	}

	protected abstract DetailType onCreateNewDetail();

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
		getLogger().debug("--------获取详细信息页，操作=["+ action	+ "] 记录ID=["+ selectedId + "]--------");
		
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
			detail=getAppService().selectById(selectedId);
			getLogger().trace("-------- detail record selected by id=["+selectedId+"]-------");
			getLogger().trace(detail.toString());
			getLogger().trace("------ prepare new page codes -----");
			codes=onGetModifyCodes(user, detail);			
			logCodes(codes);			
			model.addAllAttributes(codes);			
			pageName=getModifyPageName();
			break;
		case WebAction.CANCELATE:
			detail=getAppService().selectById(selectedId);
			pageName=getCancelatePageName();
			break;
		case WebAction.DELETE:
			detail=getAppService().selectById(selectedId);
			pageName=getDeletePageName();
			break;
		case WebAction.DISABLE:
			detail=getAppService().selectById(selectedId);
			pageName=getDisablePageName();
			break;
		case WebAction.REACTIVE:
			detail=getAppService().selectById(selectedId);	
			codes=onGetReactiveCodes(user, detail);
			model.addAllAttributes(codes);
			pageName=getReactivePageName();
			break;			
		case WebAction.VIEW:
			detail=getAppService().selectById(selectedId);			
			if(getLogger().isTraceEnabled() && detail!=null){
				getLogger().trace(detail.toString());
			}
			pageName=getViewPageName();
			break;
		default:
			getLogger().error("---- unknown action[" + action + "]-----");
			assert false;
			break;
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
		getAppService().insert(detail);
	}
	protected void saveModify(DetailType detail){
		getAppService().update(detail);
	}
	protected void saveDelete(DetailType detail){
		getAppService().delete(detail);
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
		setAction(action, model);
		setDetail(detail, model);		
	}

	protected void addWebListFromToModel(WebListFormBase<KeyType, QueryFormType, DetailType> webListFormBase, Model model) {
		
		model.addAttribute(GeneralController.PARAM_NAME_QUERY_INPUT, webListFormBase.getQuery());
		model.addAttribute(GeneralController.PARAM_NAME_RECORDS, webListFormBase.getData());
		model.addAttribute(GeneralController.PARAM_NAME_PAGE_CTRL,webListFormBase.getPageCtrl());
	}

	protected void setAction(String action, Model model) {
		model.addAttribute(GeneralController.PARAM_NAME_ACTION, action);
		model.addAttribute(GeneralController.PARAM_NAME_ACTION_NAME, WebAction.getActoinName(action)+getEntityName());
	}

	protected void setDetail(Object detail, Model model) {
		model.addAttribute(GeneralController.PARAM_NAME_DETAIL, detail);
	}

	protected Map<String, List<? extends Code<KeyType>>> onGetReactiveCodes(UserProfile<KeyType> user, DetailType detail) {
		return new HashMap<>();
	}


}
