package com.uc.web.forms.ui.componet;

import java.util.List;

import org.springframework.ui.Model;

import com.uc.web.forms.ui.IUIFormator;
import com.uc.web.service.Service;

public interface DashboardItem {
	public static final String DASHBOARDS="dashboards";
	public static final String VALUE_NAME="name";
	public static final String VALUE_TITLE="title";
	IUIFormator<? extends DashboardItem> getFormatter();
	void setFormatter(IUIFormator<? extends DashboardItem> formatter);
	DashboardItem getParent();
	Service getService();
	void setService(Service service);
	void setParent(DashboardItem parent);
	String getTitle();
	void setTitle(String title);
	String getName();
	void setName(String name);
	List<? extends DashboardItem> getSubItems();
	void setSubItems(List<? extends DashboardItem> items);
	String getUiTemplate();
	void setUiTemplate(String uiTemplate);
	String doGet(Model model);
	String doPost(String jsonParam, Model model);
		
}
