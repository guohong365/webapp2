package com.uc.web.tools.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ClassGeneratorImpl implements ClassGenerator {
	protected static final char ENDL ='\n';
	private String rootPacakge;
	private String baseClass;	
	private String packageName;
	private String rootDir;
	private String prefix;
	private String suffix;
	private boolean asInterface;
	private boolean useEntity;
	private boolean packageRelatedEntity;
	
	private String interfacePrefix;
	private String interfaceSuffix;
	private String interfacePackage;
	private String entityInterfacePackage;
	private String entityInterfacePrefix;
	private String entityInterfaceSuffix;
	private String queryInterfacePackage;
	private String queryInterfacePrefix;
	private String queryInterfaceSuffix;
	private String queryPackage;
	private String queryPrefix;
	private String querySuffix;
	private TypeParameter[] baseClassParameters;
	
	public ClassGeneratorImpl() {
		setAsInterface(false);
		setUseEntity(false);
		setBaseClass("");
		setEntityInterfacePackage("domain");
		setEntityInterfacePrefix("I");
		setEntityInterfaceSuffix("");
		setInterfacePackage("");
		setInterfacePrefix("");
		setInterfaceSuffix("");
		setPackageName("");
		setPrefix("");
		setQueryInterfacePackage("forms");
		setQueryInterfacePrefix("I");
		setQueryInterfaceSuffix("QueryForm");
		setQueryPackage("forms.entity");
		setQueryPrefix("");
		setQuerySuffix("QueryForm");
		setRootDir("");
		setRootPacakge("");
		setSuffix("");
		setBaseClassParameters(new TypeParameter[]{});
	}
	
	protected void genPackage(EntityDescriptor descriptor, StringBuilder builder){
		builder.append("package ").append(getPackageName()).append(";").append(ENDL);
		builder.append(ENDL);
	}
	protected void genImport(EntityDescriptor descriptor, StringBuilder builder){
		builder.append("import ").append(getBaseClass()).append(";").append(ENDL);
		if(isUseEntity()){
			builder.append("import ").append(getEntityFullName(descriptor)).append(";").append(ENDL)
			.append("import ").append(getQueryFullName(descriptor)).append(";").append(ENDL);
		} else {
			builder.append("import ").append(getEntityInterfaceFullName(descriptor)).append(";").append(ENDL)
			.append("import ").append(getQueryInterfaceFullName(descriptor)).append(";").append(ENDL);
		}
		if(!isAsInterface())
			builder.append("import ").append(getInterfaceFullName(descriptor)).append(';').append(ENDL);
		builder.append(ENDL);
	}
	
	protected String getInterfaceFullName(EntityDescriptor descriptor) {
		return getInterfacePackage() + "." + getInterface(descriptor);
	}

	protected String getQueryInterfaceFullName(EntityDescriptor descriptor) {
		return getQueryInterfacePackage() + "." + getQueryInterface(descriptor);
	}

	protected String getEntityInterfaceFullName(EntityDescriptor descriptor) {
		return getEntityInterfacePackage() + "." + getEntiryInterface(descriptor);
	}

	protected String getQueryFullName(EntityDescriptor descriptor) {
		return getQueryPackage() + "." + getQuery(descriptor);
	}
	

	protected String getEntityFullName(EntityDescriptor descriptor) {
		return descriptor.getEntityClass().getName();
	}

	protected void genClassName(EntityDescriptor descriptor, StringBuilder builder){
		builder.append(ENDL)		
		.append("public ").append(isAsInterface()? "interface ":"class ")
		.append(getClassName(descriptor));
	}
	protected void genSuperClass(EntityDescriptor descriptor, StringBuilder builder){	
		builder.append(" extends ").append(getRowBaseClass()).append("<");
	for(int i=0; i<getBaseClassParameters().length; i++){
		switch(getBaseClassParameters()[i]){
		case ENTITY:
			builder.append(descriptor.getEntityClass().getSimpleName());
			break;
		case ENTITY_INTERFACE:
			builder.append(getEntiryInterface(descriptor));
			break;
		case QUERY:
			builder.append(getQuery(descriptor));
			break;
		case QUERY_INTERFACE:
			builder.append(getQueryInterface(descriptor));
			break;
		default:
			break;
		}
		if(i< getBaseClassParameters().length -1){
			builder.append(",");
		}
	}
	builder.append(">");
	}
	protected void genSuperInterface(EntityDescriptor descriptor, StringBuilder builder){
		if(!isAsInterface()){
			builder.append(" implements ").append(getInterface(descriptor));
		}
	}
	protected void genBody(EntityDescriptor descriptor, StringBuilder builder){
		builder.append("{").append(ENDL)
		.append("}").append(ENDL);		
	}
	@Override
	public void generateString(EntityDescriptor descriptor, StringBuilder builder) {
		genPackage(descriptor,builder);
		genImport(descriptor, builder);
		genClassName(descriptor, builder);	
		genSuperClass(descriptor, builder);
		genSuperInterface(descriptor, builder);
		genBody(descriptor, builder);
	}

	@Override
	public void generateFile(EntityDescriptor descriptor) throws IOException {
		StringBuilder builder=new StringBuilder();
		generateString(descriptor, builder);
		String dir=EntityGenerator.getPathFromPacakge(getRootDir(), getPackageName());
		File file=new File(dir);
		if((file.exists() && !file.isDirectory())||(!file.exists() && !file.mkdirs()))
			throw new FileNotFoundException(getClass() + ":" + dir);
		String fullName=dir + "/" + getFileName(descriptor);				
		OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream(fullName), "UTF-8");
		writer.write(builder.toString());
		writer.flush();
		writer.close();
	}

	protected String getClassName(EntityDescriptor descriptor){
		return getPrefix() + descriptor.getEntityClass().getSimpleName() + getSuffix();
	};

	protected String getFileName(EntityDescriptor descriptor) {		
		return getClassName(descriptor) + ".java";
	}
	
	protected String getInterface(EntityDescriptor descriptor) {
		return getInterfacePrefix() + descriptor.getEntityClass().getSimpleName() + getInterfaceSuffix();
	}

	protected String getEntiryInterface(EntityDescriptor descriptor) {
		return getEntityInterfacePrefix() + descriptor.getEntityClass().getSimpleName() + getEntityInterfaceSuffix();
	}

	protected String getQueryInterface(EntityDescriptor descriptor) {
		return getQueryInterfacePrefix() + descriptor.getEntityClass().getSimpleName() + getQueryInterfaceSuffix();
	}
	
	protected String getQuery(EntityDescriptor descriptor){
		return getQueryPrefix() + descriptor.getEntityClass().getSimpleName() + getQuerySuffix();
	}
	
	protected String getEntityPackage(EntityDescriptor descriptor){
		String name=descriptor.getEntityClass().getName();
		return name.substring(0, name.lastIndexOf('.') -1);
	}
	
	protected String getRowBaseClass() {
		int index=getBaseClass().lastIndexOf('.');
		return getBaseClass().substring(index+1);
	}
	
	public String getBaseClass() {
		return baseClass;
	}

	public void setBaseClass(String baseClass) {
		this.baseClass = baseClass;
	}

	public String getPackageName() {
		return getRootPacakge() + "." + packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	@Override
	public String getRootDir() {
		return rootDir;
	}
	@Override
	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getInterfacePrefix() {
		return interfacePrefix;
	}

	public void setInterfacePrefix(String interfacePrefix) {
		this.interfacePrefix = interfacePrefix;
	}

	public String getInterfaceSuffix() {
		return interfaceSuffix;
	}

	public void setInterfaceSuffix(String interfaceSuffix) {
		this.interfaceSuffix = interfaceSuffix;
	}

	public String getInterfacePackage() {
		return getRootPacakge() + "." + interfacePackage;
	}

	public void setInterfacePackage(String interfacePackage) {
		this.interfacePackage = interfacePackage;
	}

	public String getEntityInterfacePackage() {
		return getRootPacakge() + "." + entityInterfacePackage;
	}

	public void setEntityInterfacePackage(String entityInterfacePackage) {
		this.entityInterfacePackage = entityInterfacePackage;
	}

	public String getEntityInterfacePrefix() {
		return entityInterfacePrefix;
	}

	public void setEntityInterfacePrefix(String entityInterfacePrefix) {
		this.entityInterfacePrefix = entityInterfacePrefix;
	}

	public String getEntityInterfaceSuffix() {
		return entityInterfaceSuffix;
	}

	public void setEntityInterfaceSuffix(String entityInterfaceSuffix) {
		this.entityInterfaceSuffix = entityInterfaceSuffix;
	}

	public String getQueryInterfacePrefix() {
		return queryInterfacePrefix;
	}

	public void setQueryInterfacePrefix(String queryInterfacePrefix) {
		this.queryInterfacePrefix = queryInterfacePrefix;
	}

	public String getQueryInterfaceSuffix() {
		return queryInterfaceSuffix;
	}

	public void setQueryInterfaceSuffix(String queryInterfaceSuffix) {
		this.queryInterfaceSuffix = queryInterfaceSuffix;
	}

	public String getQueryPrefix() {
		return queryPrefix;
	}

	public void setQueryPrefix(String queryPrefix) {
		this.queryPrefix = queryPrefix;
	}

	public String getQuerySuffix() {
		return querySuffix;
	}

	public void setQuerySuffix(String querySuffix) {
		this.querySuffix = querySuffix;
	}
	@Override
	public String getRootPacakge() {
		return rootPacakge;
	}
	@Override
	public void setRootPacakge(String rootPacakge) {
		this.rootPacakge = rootPacakge;
	}

	public String getQueryInterfacePackage() {
		return getRootPacakge() + "." + queryInterfacePackage;
	}

	public void setQueryInterfacePackage(String queryInterfacePackage) {
		this.queryInterfacePackage = queryInterfacePackage;
	}

	public boolean isAsInterface() {
		return asInterface;
	}

	public void setAsInterface(boolean asInterface) {
		this.asInterface = asInterface;
	}

	public String getQueryPackage() {
		return getRootPacakge() + "." + queryPackage;
	}

	public void setQueryPackage(String queryPackage) {
		this.queryPackage = queryPackage;
	}

	public boolean isUseEntity() {
		return useEntity;
	}

	public void setUseEntity(boolean useEntity) {
		this.useEntity = useEntity;
	}


	public boolean isPackageRelatedEntity() {
		return packageRelatedEntity;
	}

	public void setPackageRelatedEntity(boolean packageRelatedEntity) {
		this.packageRelatedEntity = packageRelatedEntity;
	}

	public TypeParameter[] getBaseClassParameters() {
		return baseClassParameters;
	}

	public void setBaseClassParameters(TypeParameter[] baseClassParameters) {
		this.baseClassParameters = baseClassParameters;
	}



}
