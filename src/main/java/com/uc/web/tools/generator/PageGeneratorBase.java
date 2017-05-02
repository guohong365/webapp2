package com.uc.web.tools.generator;

public abstract class PageGeneratorBase implements PageGenerator{
	private String modelPath;
	private String pageName;
	private EntityFormator pageFormator;

	@Override
	public EntityFormator getPageFormator() {
		return pageFormator;
	}

	@Override
	public void setPageFormator(EntityFormator pageFormator) {
		this.pageFormator = pageFormator;
	}
	@Override
	public String getModelPath() {
		return modelPath;
	}
	@Override
	public void setModelPath(String modelPath) {
		this.modelPath = modelPath;
	}
	private String rootDir;
	@Override
	public String getRootDir() {
		return rootDir;
	}
	@Override
	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}
	@Override
	public String getPageName() {
		return pageName;
	}
	@Override
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
}
