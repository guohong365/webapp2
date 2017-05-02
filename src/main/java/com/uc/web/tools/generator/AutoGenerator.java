package com.uc.web.tools.generator;

import java.io.IOException;
import java.util.List;

public interface AutoGenerator {


	void generate(Class<?>[] entities, String[] modelPagePath) throws IOException;

	GenerateOptions getOptions();

	void setOptions(GenerateOptions options);

	List<EntityGenerator> getGenerators();

	void setGenerators(List<EntityGenerator> generators);
}
