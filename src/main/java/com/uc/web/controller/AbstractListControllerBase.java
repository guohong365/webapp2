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

import com.uc.utils.export.Exportor;
import com.uc.utils.export.ExportorFactory;
import com.uc.web.domain.Code;
import com.uc.web.domain.security.UserProfile;
import com.uc.web.forms.QueryForm;
import com.uc.web.forms.WebListFormBase;
import com.uc.web.forms.ui.componet.IPageCtrl;
import com.uc.web.forms.ui.componet.PageCtrl;
import com.uc.web.service.AppListService;

public abstract class AbstractListControllerBase<KeyType,QueryFormType extends QueryForm<KeyType>,DetailType> 
	extends ControllerSupportImpl<KeyType> {

	protected static final String PAGE_LIST = "/list";
	protected static final String PAGE_TABLE = "/table";
	

	protected String getListPageName() {
		return getPageBasePath() + PAGE_LIST;
	}

	protected String getTablePageName() {
		return getPageBasePath() + PAGE_TABLE;
	}
	
	AppListService<KeyType, QueryFormType, DetailType> appListService;
	
	public void setAppListService(AppListService<KeyType, QueryFormType, DetailType> appListService) {
		this.appListService = appListService;
	}
	
	public AppListService<KeyType, QueryFormType, DetailType> getAppListService() {
		return appListService;
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
	
	private String queryFormClassName;
	
	public String getQueryFormClassName() {
		return queryFormClassName;
	}
	public void setQueryFormClassName(String queryFormClassName) {
		this.queryFormClassName = queryFormClassName;
	}
	
	private QueryFormType defaultQueryForm;
	public QueryFormType getDefaultQueryForm() {
		return defaultQueryForm;
	}
	public void setDefaultQueryForm(QueryFormType defaultQueryForm) {
		this.defaultQueryForm = defaultQueryForm;
	}

	@SuppressWarnings("unchecked")
	protected QueryFormType onCreateNewQueryForm(){
		if(getDefaultQueryForm()!=null){
			return getDefaultQueryForm();
		}
		return StringUtils.isEmpty(getQueryFormClassName())?null: (QueryFormType)createInstanceByName(getQueryFormClassName());
	}
	
	

	protected void onSetUserQueryLimits(QueryFormType queryForm) {
	}

	protected QueryFormType onPrepareInitQueryForm(UserProfile<KeyType> user) {
		QueryFormType queryForm=onCreateNewQueryForm();
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
		getAppListService().select(webForm);
		getLogger().trace("------获得数据["+webForm.getData().size()+"]------" );
		addWebListFormToModel(webForm, model);
		
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
		getLogger().trace(pageCtrl.toString());
		getLogger().trace("----------------------");
		webForm.setQuery(queryForm);
		webForm.setPageCtrl(pageCtrl);
		getLogger().trace("------查询数据----------");
		getAppListService().select(webForm);
		getLogger().trace("------获得数据["+webForm.getData().size()+"]----");
		getLogger().trace("------ 加工修改列表结果--------");
		afterListSelected(webForm);
		getLogger().trace("-------加工修改列表结果完成---- ");		
		addWebListFormToModel(webForm, model);		
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
		getAppListService().select(webForm);
		getLogger().trace("------获得数据[%d]----", webForm.getData().size());
		
		getLogger().trace("------ 加工修改列表结果--------");
		afterListSelected(webForm);
		getLogger().trace("-------加工修改列表结果完成---- ");	
		
		
		addWebListFormToModel(webForm, model);
		
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
	
	protected Map<String, Object> prepareExportOptions(QueryFormType queryForm, List<DetailType> data){
		Map<String,Object> options=new HashMap<>();
		options.put(EXPORTOR_OPTION_QUERY_FORM, queryForm);
		options.put(EXPORTOR_OPTION_DATA, data);
		options.put(EXPORTOR_OPTION_EXTERNAL, getExportorOptions());
		return options;
	}
	
	protected Exportor onGetExportor(QueryFormType queryForm, List<DetailType> data, String type) {
		if(getExportorFactory()!=null){			
			return getExportorFactory().create(prepareExportOptions(queryForm, data));
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
		List<DetailType> data=getAppListService().selectForExport(queryForm);
		
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

	protected void addWebListFormToModel(WebListFormBase<KeyType, QueryFormType, DetailType> webListFormBase, Model model) {
		model.addAttribute(PARAM_NAME_QUERY_INPUT, webListFormBase.getQuery());
		model.addAttribute(PARAM_NAME_RECORDS, webListFormBase.getData());
		model.addAttribute(PARAM_NAME_PAGE_CTRL,webListFormBase.getPageCtrl());
	}
}
