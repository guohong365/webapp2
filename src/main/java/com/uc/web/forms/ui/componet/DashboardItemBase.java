package com.uc.web.forms.ui.componet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.uc.web.forms.ui.IUIFormator;
import com.uc.web.service.Service;

public abstract class DashboardItemBase implements DashboardItem {
	private DashboardItem parent;
	private Service service;
	private IUIFormator<? extends DashboardItem> formatter;
	private String title;
	private String name;
	private String uiTemplate;
	private List<? extends DashboardItem> subItems;
	@Override
	public DashboardItem getParent() {
		return parent;
	}
	@Override
	public void setParent(DashboardItem parent) {
		this.parent = parent;
	}
	@Override
	public Service getService() {
		return service;
	}
	@Override
	public void setService(Service service) {
		this.service = service;
	}
	
	@Override
	public IUIFormator<? extends DashboardItem> getFormatter() {
		return formatter;
	}

	@Override
	public void setFormatter(IUIFormator<? extends DashboardItem> formatter) {
		this.formatter=formatter;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title=title;
	}

	@Override
	public List<? extends DashboardItem> getSubItems() {
		return subItems;
	}

	@Override
	public void setSubItems(List<? extends DashboardItem> items) {
		subItems=items;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}
	
	@Override
	public String getUiTemplate() {
		return uiTemplate;
	}
	public void setUiTemplate(String uiTemplate) {
		this.uiTemplate = uiTemplate;
	}
	protected void setupOutputDataMap(Map<String, Object> data){
		data.put(VALUE_NAME, getName());
		data.put(VALUE_TITLE, getTitle());
	}
	protected void setModelData(Model model){
		Map<String, Map<String, Map<String, Object>>> values=new HashMap<>();
		Map<String, Map<String, Object>> thisMap=new HashMap<>();
		Map<String, Object> data=new HashMap<>();
		setupOutputDataMap(data);		
		thisMap.put(name, data);
		values.put(DASHBOARDS, thisMap);
		model.mergeAttributes(thisMap);
	}
	
	protected void doProcessGet(Model model){}
	protected void doProcessPost(String jsonString, Model model){}

	@Override
	public String doGet(Model model) {
		doProcessGet(model);
		setModelData(model);
		return getUiTemplate();
	}
		

	@Override
	public String doPost(String jsonString, Model model) {
		doProcessPost(jsonString, model);
		setModelData(model);		
		return getUiTemplate();
	}

}
