package com.uc.web.tools.generator;

public class ControllerProxyGenerator extends ClassGeneratorImpl {
	@Override
	protected void genImport(EntityDescriptor descriptor, StringBuilder builder){
		builder.append("import ").append(getBaseClass()).append(";").append(ENDL);
		if(isUseEntity()){
			builder.append("import ").append(getEntityFullName(descriptor)).append(";").append(ENDL)
			.append("import ").append(getQueryFullName(descriptor)).append(";").append(ENDL);
		} else {
			builder.append("import ").append(getEntityInterfaceFullName(descriptor)).append(";").append(ENDL)
			.append("import ").append(getQueryInterfaceFullName(descriptor)).append(";").append(ENDL);
		}
		builder.append(ENDL);
	}
	
	@Override
	protected void genSuperInterface(EntityDescriptor descriptor, StringBuilder builder) {
	}
	
	protected void genClassName(EntityDescriptor descriptor, StringBuilder builder){
		builder.append(ENDL)	
		.append("@Controller").append(ENDL)
		.append("@RequestMapping(").append("\"${controller.proxy.uri.").append(descriptor.getEntityClass().getSimpleName()).append("}\"").append(")").append(ENDL)
		.append("public ").append(isAsInterface()? "interface ":"class ")
		.append(getClassName(descriptor));
	}
}
