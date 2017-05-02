package com.uc.web.tools.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class PageGeneratorImpl extends PageGeneratorBase {
	
	
	
	@Override
	public void generateString(EntityDescriptor descriptor, StringBuilder builder) {
		getPageFormator().formatHTML(descriptor, builder);		
	}

	@Override
	public void generateFile(EntityDescriptor descriptor) throws IOException {
		StringBuilder builder=new StringBuilder();
		generateString(descriptor, builder);
		String dir=getRootDir() + "/" + getModelPath();
		File file=new File(dir);
		if((file.exists() && !file.isDirectory())|| (!file.exists() && !file.mkdirs())) throw new FileNotFoundException(dir);
		String fileName=getRootDir() + "/" + getModelPath() +"/" + getPageName();
		FileOutputStream stream=new FileOutputStream(fileName);
		OutputStreamWriter writer=new OutputStreamWriter(stream, "UTF-8");
		writer.write(builder.toString());	
		writer.flush();
		writer.close();
	}
}
