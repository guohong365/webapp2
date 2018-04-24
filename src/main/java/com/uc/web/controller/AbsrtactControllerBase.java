package com.uc.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import com.uc.utils.export.ExportOptions;
import com.uc.utils.export.Exportor;
import com.uc.utils.export.ExportorFactory;
import com.uc.web.domain.Code;
import com.uc.web.domain.security.UserProfile;
import com.uc.web.forms.ListQueryForm;
import com.uc.web.forms.ui.componet.PageCtrl;
import com.uc.web.forms.ui.componet.PageCtrlImpl;
import com.uc.web.service.AppService;

public class AbsrtactControllerBase extends ControllerBaseImpl {

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

	public AppService getService(){
		if(super.getService() instanceof AppService)
			return (AppService) super.getService();
		return null;
	}	
	
	private String entityClassName;
	
	public void setEntityClassName(String entityClassName) {
		this.entityClassName = entityClassName;
	}
	public String getEntityClassName() {
		return entityClassName;
	}
	
	private Object defaultDetail;
	public Object getDefaultDetail() {
		return defaultDetail;
	}
	public void setDefaultDetail(Object defaultDetail) {
		this.defaultDetail = defaultDetail;
	}

	protected Object createEntity(){
		if(!StringUtils.isEmpty(getEntityClassName())) return createInstanceByName(getEntityClassName());
		if(getDefaultDetail()!=null){
			return getDefaultDetail();
		}
		return onCreateEntity();
	}

	protected Object onCreateEntity() {
		return null;
	}

	protected Map<String, List<Code>> onGetNewCodes(UserProfile user) {
		return new HashMap<>();
	}

	protected Map<String, List<Code>> onGetModifyCodes(UserProfile user, Object detail) {
		return new HashMap<>();
	}

	protected void onAfterSelectDetail(UserProfile user, String action, Object detail) {		
	}

	protected String onGetDetailPage(String action, Object selectedId, Model model) {
		UserProfile user=getUser();
		Object detail=null;
		Map<String, List<Code>> codes;		
		String pageName="";		
		getLogger().trace("--------获取详细信息页，操作=["+ action	+ "] 记录ID=["+ selectedId + "]--------");
		
		switch(action){
		case WebAction.NEW:
			detail=createEntity();
			getLogger().trace("-------record created ---------");
			getLogger().trace(detail.toString());
			//addDetailToModel(action, detail, model);
			getLogger().trace("------ prepare new page codes -----");
			codes=onGetNewCodes(user);
			model.addAllAttributes(codes);			
			pageName=getNewPageName();
			break;
		case WebAction.MODIFY:
			getLogger().trace("-------- modify action ---------------");
			detail=getService().selectById(selectedId);
			getLogger().trace("-------- detail record selected by id=["+selectedId+"]-------");
			getLogger().trace(detail.toString());
			getLogger().trace("------ prepare new page codes -----");
			codes=onGetModifyCodes(user, detail);			
			model.addAllAttributes(codes);			
			pageName=getModifyPageName();
			break;
		case WebAction.CANCELATE:
			detail=getService().selectById(selectedId);
			pageName=getCancelatePageName();
			break;
		case WebAction.DELETE:
			detail=getService().selectById(selectedId);
			pageName=getDeletePageName();
			break;
		case WebAction.DISABLE:
			detail=getService().selectById(selectedId);
			pageName=getDisablePageName();
			break;
		case WebAction.REACTIVE:
			detail=getService().selectById(selectedId);	
			pageName=getReactivePageName();
			break;			
		case WebAction.VIEW:
			detail=getService().selectById(selectedId);			
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
		
		addEntityToModel(action, detail, model);
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

	protected void onBeforSaveDetail(UserProfile user, String action, Object detail) throws Exception {
		
	}
	protected void saveNew(Object detail){
		getLogger().trace("insert record [" + detail.toString() +"]");
		getService().insert(detail);
	}
	protected void saveModify(Object detail){
		getLogger().trace("modify record [" + detail.toString() + "]");
		getService().update(detail);
	}
	protected void saveDelete(Object detail){
		getLogger().trace("delete record [" + detail.toString() +"]");
		getService().delete(detail);
	}
	protected void saveCancelate(Object detail){
		getLogger().trace("cancelate record [" + detail.toString() + "]");
		getService().updateSelective(detail);
	}
	protected void saveReactive(Object detail){		
		getLogger().trace("reactive record ["+ detail.toString()+"]");
		getService().updateSelective(detail);
	}
	protected void saveDisable(Object detail){		
		getLogger().trace("disable record [" + detail.toString() +"]");
		getService().updateSelective(detail);
	}
	

	protected String onPostDetailPage(String action, Object detail) {
		UserProfile user =getUser();
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

	protected void addEntityToModel(String action, Object detail, Model model) {
		model.addAttribute(ControllerBase.PARAM_NAME_ENTITY_NAME, getEntityName());
		model.addAttribute(ControllerBase.PARAM_NAME_ACTION, action);
		model.addAttribute(ControllerBase.PARAM_NAME_ACTION_NAME, WebAction.getActoinName(action)+getEntityName());
		model.addAttribute(ControllerBase.PARAM_NAME_DETAIL, detail);
	}

	protected static final String PAGE_LIST = "/list";
	protected static final String PAGE_TABLE = "/table";
	
	protected String getListPageName() {
		return getPageBasePath() + PAGE_LIST;
	}

	protected String getTablePageName() {
		return getPageBasePath() + PAGE_TABLE;
	}
			
	private ExportorFactory exportorFactory;
		
	public void setExportorFactory(ExportorFactory exportorFactory) {
		this.exportorFactory = exportorFactory;
	}
	
	public ExportorFactory getExportorFactory() {
		return exportorFactory;
	}
	
	private ExportOptions exportorOptions;
	
	public void setExportorOptions(ExportOptions exportorOptions) {
		this.exportorOptions = exportorOptions;
	}
	
	public ExportOptions getExportorOptions() {
		return exportorOptions;
	}
	
	private void commonSetQueryForm(UserProfile user, ListQueryForm queryForm) {
		queryForm.setUser(user);
		onSetUserQueryLimits(queryForm);
	}

	protected void logCodes(Map<String, List<? extends Code>> codes) {
		if(getLogger().isTraceEnabled() && codes!=null){
			getLogger().trace("--------加载查询条件代码:" + codes.size() + "个...");
			for(Entry<String, List<? extends Code>> entry: codes.entrySet()){
				if(entry!=null){
					getLogger().trace("\t 代码: ["+entry.getKey()+"] " + entry.getValue());
				}
			}
			getLogger().trace("--------代码加载完成-----------");			
		}
	}
	
	private String queryFormClassName;	
	public String getQueryFormClassName() {
		return queryFormClassName;
	}
	public void setQueryFormClassName(String queryFormClassName) {
		this.queryFormClassName = queryFormClassName;
	}
	
	private ListQueryForm defaultQueryForm;
	public ListQueryForm getDefaultQueryForm() {
		return defaultQueryForm;
	}
	public void setDefaultQueryForm(ListQueryForm defaultQueryForm) {
		this.defaultQueryForm = defaultQueryForm;
	}

	protected ListQueryForm onCreateQueryForm(){
		return null;
	}
	
	public ListQueryForm createQueryForm(){
		if(!StringUtils.isEmpty(queryFormClassName)) return (ListQueryForm) createInstanceByName(queryFormClassName);		
		if(getDefaultQueryForm()!=null){
			return getDefaultQueryForm();
		}
		return onCreateQueryForm();
	}

	protected void onSetUserQueryLimits(ListQueryForm queryForm) {
	}

	protected ListQueryForm onPrepareInitQueryForm(UserProfile user) {
		ListQueryForm queryForm=createQueryForm();
		commonSetQueryForm(user, queryForm);
		return queryForm;
	}

	protected Map<String, List<Code>> onGetListPageCodes(UserProfile user) {
		return new HashMap<>();
	}

	protected void afterListSelected(List<?> list) {
	}

	protected void onSetListModel(UserProfile user, Model model) {
	}

	protected String onGetListPage(Model model) {		
		UserProfile user=getUser();		
		//准备无条件queryFrom		
		getLogger().trace("---- 准备列表查询默认条件 --------");		
		ListQueryForm queryForm=onPrepareInitQueryForm(user);
		PageCtrl pageCtrl=new PageCtrlImpl();
		
		getLogger().trace("---- 默认条件  -------");		
		getLogger().trace(queryForm.toString());
		
		getLogger().trace("-------查询数据-------");		
		onBeforeSelect(user, queryForm);
		List<?> list=getService().select(queryForm, pageCtrl);
		
		getLogger().trace("------ 加工修改列表结果--------");
		afterListSelected(list);
		
		getLogger().trace("-------添加结果-----");
		addFormToModel(queryForm, list, pageCtrl, model);
		
		getLogger().trace("-------准备列表页查询代码--------");
		Map<String, List<Code>> codes=onGetListPageCodes(user);
		if(codes!=null && !codes.isEmpty()){
			model.addAllAttributes(codes);
		}		
		getLogger().trace("------向model添加附加信息--------");
		onSetListModel(user, model);
		
		String pageName=getListPageName();
		getLogger().trace("------返回页面模板["+pageName+"]------"  );
		return pageName;
	}

	protected void onBeforeSelect(UserProfile user, ListQueryForm queryForm) {
	}

	protected void onBeforeSelectPagationList(UserProfile user, ListQueryForm queryForm, PageCtrl pageCtrl) {
		commonSetQueryForm(user, queryForm);
	}

	protected String onPostTablePage(ListQueryForm queryForm, PageCtrlImpl pageCtrl, Model model) {
		UserProfile user=getUser();
		getLogger().trace("-----输入条件-----");
				
		getLogger().trace("-----准备列表数据查询条件----");		
		onBeforeSelectPagationList(user, queryForm, pageCtrl);
		getLogger().trace("----------------------");

		getLogger().trace("------查询数据----------");
		onBeforeSelect(user, queryForm);
		List<?> list=getService().select(queryForm, pageCtrl);
		getLogger().trace("------获得数据["+ list.size()+"]----");
		
		getLogger().trace("------ 加工修改列表结果--------");
		afterListSelected(list);
		
		getLogger().trace("-------加工修改列表结果完成---- ");		
		addFormToModel(queryForm, list, pageCtrl, model);
		
		getLogger().trace("------添加类表附加信息--------");
		onSetListModel(user, model);
		
		getLogger().trace("------附加信息添加完成--------");
		String pageName=getTablePageName();
		getLogger().trace("------返回页面模板["+pageName+"]------");
		return pageName;
	}

	protected void onBeforeSelectPostList(UserProfile user, ListQueryForm queryForm) {
		commonSetQueryForm(user, queryForm);
	}

	protected String onPostListPage(ListQueryForm queryForm, Model model) {
		UserProfile user=getUser();
		PageCtrl pageCtrl=new PageCtrlImpl();
		
		getLogger().trace("-----输入条件-----");
		getLogger().trace(queryForm.toString());
		getLogger().trace("---------------");
				
		getLogger().trace("-----准备查询条件-----");
		onBeforeSelectPostList(user, queryForm);
		getLogger().trace(queryForm.toString());
		getLogger().trace("------------------");		
		onBeforeSelect(user, queryForm);
		getLogger().trace("------查询数据----------");
		List<?> list=getService().select(queryForm, pageCtrl);		
		getLogger().trace("------获得数据[%d]----", list.size());
		
		getLogger().trace("------ 加工修改列表结果--------");
		afterListSelected(list);
		
		getLogger().trace("-------加工修改列表结果完成---- ");
		addFormToModel(queryForm, list, pageCtrl, model);
		
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
	
	protected Map<String, Object> prepareExportOptions(ListQueryForm queryForm, List<?> data){
		Map<String,Object> options=new HashMap<>();
		options.put(EXPORTOR_OPTION_QUERY_FORM, queryForm);
		options.put(EXPORTOR_OPTION_DATA, data);
		options.put(EXPORTOR_OPTION_EXTERNAL, getExportorOptions());
		return options;
	}
	
	protected Exportor getExportor(ListQueryForm queryForm, List<?> data) {
		if(getExportorFactory()!=null){			
			return getExportorFactory().create(prepareExportOptions(queryForm, data));
		}
		return null;
	}

	protected void onBeforeSelectExportList(UserProfile user, ListQueryForm queryForm) {
		commonSetQueryForm(user, queryForm);
	}

	protected void onAferExportListSelected(ListQueryForm queryForm, List<?> details) {		
	}

	protected void onExport(ListQueryForm queryForm, HttpServletRequest request, HttpServletResponse response) {
		UserProfile user=getUser();		
		onBeforeSelect(user, queryForm);
		onBeforeSelectExportList(user, queryForm);		
		List<?> data=getService().selectForExport(queryForm);		
		onAferExportListSelected(queryForm, data);		
		Exportor exportor=getExportor(queryForm, data);				
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

	protected void addFormToModel(ListQueryForm queryForm, List<?> list, PageCtrl pageCtrl, Model model) {
		model.addAttribute(PARAM_NAME_QUERY_INPUT, queryForm);
		getLogger().trace("queryForm push back:");
		getLogger().trace(queryForm.toString());
		model.addAttribute(PARAM_NAME_PAGE_CTRL, pageCtrl);
		getLogger().trace("pageCtrl :");
		getLogger().trace(pageCtrl.toString());
		model.addAttribute(PARAM_NAME_RECORDS, list);
		getLogger().trace("Data count:" + list.size());
	}
}
