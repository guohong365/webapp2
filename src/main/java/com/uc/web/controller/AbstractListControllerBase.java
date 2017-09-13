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
import com.uc.web.service.AppWebListService;

public abstract class AbstractListControllerBase<QueryFormType extends ListQueryForm, EntityType> 
	extends ControllerBaseImpl {

	protected static final String PAGE_LIST = "/list";
	protected static final String PAGE_TABLE = "/table";
	
	protected String getListPageName() {
		return getPageBasePath() + PAGE_LIST;
	}

	protected String getTablePageName() {
		return getPageBasePath() + PAGE_TABLE;
	}
			
	@SuppressWarnings("unchecked")
	public AppWebListService<QueryFormType, EntityType> getService() {
		if(super.getService() instanceof AppWebListService)
			return (AppWebListService<QueryFormType, EntityType>) super.getService();
		return null;
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
	
	private void commonSetQueryForm(UserProfile user, QueryFormType queryForm) {
		queryForm.setUser(user);
		onSetUserQueryLimits(queryForm);
	}

	protected void logCodes(Map<String, List<? extends Code<?>>> codes) {
		if(getLogger().isTraceEnabled() && codes!=null){
			getLogger().trace("--------加载查询条件代码:" + codes.size() + "个...");
			for(Entry<String, List<? extends Code<?>>> entry: codes.entrySet()){
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

	protected QueryFormType onCreateQueryForm(){
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public QueryFormType createQueryForm(){
		if(!StringUtils.isEmpty(queryFormClassName)) return (QueryFormType) createInstanceByName(queryFormClassName);		
		if(getDefaultQueryForm()!=null){
			return getDefaultQueryForm();
		}
		return onCreateQueryForm();
	}

	protected void onSetUserQueryLimits(QueryFormType queryForm) {
	}

	protected QueryFormType onPrepareInitQueryForm(UserProfile user) {
		QueryFormType queryForm=createQueryForm();
		commonSetQueryForm(user, queryForm);
		return queryForm;
	}

	protected Map<String, List<? extends Code<?>>> onGetListPageCodes(UserProfile user) {
		return new HashMap<>();
	}

	protected void afterListSelected(List<EntityType> list) {
	}

	protected void onSetListModel(UserProfile user, Model model) {
	}

	protected String onGetListPage(Model model) {		
		UserProfile user=getUser();		
		//准备无条件queryFrom		
		getLogger().trace("---- 准备列表查询默认条件 --------");		
		QueryFormType queryForm=onPrepareInitQueryForm(user);
		PageCtrl pageCtrl=new PageCtrlImpl();
		
		getLogger().trace("---- 默认条件  -------");		
		getLogger().trace(queryForm.toString());
		
		getLogger().trace("-------查询数据-------");		
		onBeforeSelect(user, queryForm);
		List<EntityType> list=getService().select(queryForm, pageCtrl);
		
		getLogger().trace("------ 加工修改列表结果--------");
		afterListSelected(list);
		
		getLogger().trace("-------添加结果-----");
		addFormToModel(queryForm, list, pageCtrl, model);
		
		getLogger().trace("-------准备列表页查询代码--------");
		Map<String, List<? extends Code<?>>> codes=onGetListPageCodes(user);
		if(codes!=null && !codes.isEmpty()){
			model.addAllAttributes(codes);
		}		
		getLogger().trace("------向model添加附加信息--------");
		onSetListModel(user, model);
		
		String pageName=getListPageName();
		getLogger().trace("------返回页面模板["+pageName+"]------"  );
		return pageName;
	}

	protected void onBeforeSelect(UserProfile user, QueryFormType queryForm) {
	}

	protected void onBeforeSelectPagationList(UserProfile user, QueryFormType queryForm, PageCtrl pageCtrl) {
		commonSetQueryForm(user, queryForm);
	}

	protected String onPostTablePage(QueryFormType queryForm, PageCtrlImpl pageCtrl, Model model) {
		UserProfile user=getUser();
		getLogger().trace("-----输入条件-----");
		System.err.println(queryForm.toString());
				
		getLogger().trace("-----准备列表数据查询条件----");		
		onBeforeSelectPagationList(user, queryForm, pageCtrl);
		System.err.println(queryForm.toString());
		getLogger().trace("----------------------");

		getLogger().trace("------查询数据----------");
		onBeforeSelect(user, queryForm);
		List<EntityType> list=getService().select(queryForm, pageCtrl);
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

	protected void onBeforeSelectPostList(UserProfile user, QueryFormType queryForm) {
		commonSetQueryForm(user, queryForm);
	}

	protected String onPostListPage(QueryFormType queryForm, Model model) {
		UserProfile user=getUser();
		PageCtrl pageCtrl=new PageCtrlImpl();
		
		getLogger().trace("-----输入条件-----");
		getLogger().trace(queryForm.toString());
		getLogger().trace("---------------");
				
		getLogger().trace("-----准备查询条件-----");
		onBeforeSelectPostList(user, queryForm);
		getLogger().trace(queryForm.toString());
		getLogger().trace("------------------");		
		
		getLogger().trace("------查询数据----------");
		List<EntityType> list=getService().select(queryForm, pageCtrl);		
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
	
	protected Map<String, Object> prepareExportOptions(QueryFormType queryForm, List<EntityType> data){
		Map<String,Object> options=new HashMap<>();
		options.put(EXPORTOR_OPTION_QUERY_FORM, queryForm);
		options.put(EXPORTOR_OPTION_DATA, data);
		options.put(EXPORTOR_OPTION_EXTERNAL, getExportorOptions());
		return options;
	}
	
	protected Exportor getExportor(QueryFormType queryForm, List<EntityType> data) {
		if(getExportorFactory()!=null){			
			return getExportorFactory().create(prepareExportOptions(queryForm, data));
		}
		return null;
	}

	protected void onBeforeSelectExportList(UserProfile user, QueryFormType queryForm) {
		commonSetQueryForm(user, queryForm);
	}

	protected void onAferExportListSelected(QueryFormType queryForm, List<EntityType> details) {		
	}

	protected void onExport(QueryFormType queryForm, HttpServletRequest request, HttpServletResponse response) {
		UserProfile user=getUser();		
		onBeforeSelect(user, queryForm);
		onBeforeSelectExportList(user, queryForm);		
		List<EntityType> data=getService().selectForExport(queryForm);		
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

	protected void addFormToModel(QueryFormType queryForm, List<EntityType> list, PageCtrl pageCtrl, Model model) {
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
