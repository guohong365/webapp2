package com.uc.web.tools.generator;

import java.io.IOException;
import java.util.List;

public class AutoGeneratorImpl implements AutoGenerator {
	private GenerateOptions options;
	@Override
	public GenerateOptions getOptions() {
		return options;
	}
	@Override
	public void setOptions(GenerateOptions options) {
		this.options = options;
	}
	
	private List<EntityGenerator> generators;
	@Override
	public List<EntityGenerator> getGenerators() {
		return generators;
	}
	@Override
	public void setGenerators(List<EntityGenerator> generators) {
		this.generators = generators;
	}
	
	@Override
	public void generate(Class<?>[] entities, String[] modelPagePaths) throws IOException {
		for(int i=0; i< Math.min(entities.length, modelPagePaths.length); i++){
			EntityDescriptor descriptor= EntityParser.parse(entities[i]);
			for(EntityGenerator generator:getGenerators()){
				if(generator instanceof PageGenerator){
					((PageGenerator)generator).setModelPath(modelPagePaths[i]);
					generator.setRootDir(options.getPageRootPath());
				}
				if(generator instanceof ClassGenerator){
					generator.setRootDir(options.getJavaSourceRootPath());
					((ClassGenerator)generator).setRootPacakge(options.getRootPackage());
				}
				generator.generateFile(descriptor);
			}			
		}
		
	}  

}
