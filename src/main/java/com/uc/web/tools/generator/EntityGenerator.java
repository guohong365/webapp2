package com.uc.web.tools.generator;

import java.io.IOException;

public interface EntityGenerator{
	public static String getPathFromPacakge(String root, String packageName){
		String path=root +"/" + packageName.replace('.', '/');
		path=path.replace('\\','/');
		return path;
	}
	void generateString(EntityDescriptor descriptor, StringBuilder builder);
	void generateFile(EntityDescriptor descriptor) throws IOException;
	String getRootDir();
	void setRootDir(String rootDir);
}
