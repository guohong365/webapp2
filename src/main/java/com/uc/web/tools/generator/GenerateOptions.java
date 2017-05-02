package com.uc.web.tools.generator;

public class GenerateOptions {
	private String rootPackage;
	private String javaSourceRootPath;
	private String pageRootPath;
	
	public GenerateOptions(String sourceRootPath, String pageRootPath, String rootPackage) {
		this.javaSourceRootPath=sourceRootPath;
		this.pageRootPath=pageRootPath;		
		this.rootPackage=rootPackage;
	}

	public String getRootPackage() {
		return rootPackage;
	}

	public void setRootPackage(String rootPackage) {
		this.rootPackage = rootPackage;
	}

	public String getJavaSourceRootPath() {
		return javaSourceRootPath;
	}

	public void setJavaSourceRootPath(String javaSourceRootPath) {
		this.javaSourceRootPath = javaSourceRootPath;
	}

	public String getPageRootPath() {
		return pageRootPath;
	}

	public void setPageRootPath(String pageRootPath) {
		this.pageRootPath = pageRootPath;
	}
}
