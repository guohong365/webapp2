package webapp2;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.junit.Test;

import com.uc.web.tools.generator.EntityDescriptor;
import com.uc.web.tools.generator.EntityParser;

public class GenPage {
	@Test
	public void test(){
		EntityDescriptor descriptor=EntityParser.parse(TestEntity.class);
		VelocityEngine ve=new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		 ve.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
		 ve.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
		 ve.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
		 ve.init();
		 
		 Template t = ve.getTemplate("com/uc/web/tools/generator/ace/detailModifyPage.vm");
		 VelocityContext ctx = new VelocityContext();
		ctx.put("descriptor", descriptor);
		StringWriter writer=new StringWriter();
		t.merge(ctx, writer);
		
		System.out.println(writer.toString());
		
	}
}
