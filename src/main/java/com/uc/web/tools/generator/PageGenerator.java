package com.uc.web.tools.generator;

public interface PageGenerator extends EntityGenerator {

	EntityFormator getPageFormator();

	void setPageFormator(EntityFormator pageFormator);

	String getModelPath();

	void setModelPath(String modelPath);

	String getPageName();

	void setPageName(String pageName);

}