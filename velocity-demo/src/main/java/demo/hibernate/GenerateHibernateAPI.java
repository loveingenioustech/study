package demo.hibernate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import util.DBUtil;
import db.Schema;
import db.Table;

public class GenerateHibernateAPI {

	public static void main(String[] args) {
		GenerateHibernateAPI gha = new GenerateHibernateAPI();

		try {

			gha.createDTO();

			// gha.createHbm();

			// gha.updateCfg();

			// gha.createRequestWrapper();

			// gha.createResponseWrapper();

			// gha.createDAO();

			// gha.createDAOImpl();

			// gha.updateDbConfig();

			// gha.createTest();

			// gha.updateTestConfig();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void createDTO() throws Exception {
		// Velocity.init();
		// Velocity.setProperty("resource.loader", "class");
		// Velocity.setProperty("class.resource.loader.class",
		// "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

		Properties properties = new Properties();
		String basePath = "C:/Dev/GitRepos/Study/velocity-demo/src/main/resources/templates";
		properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, basePath);
		Velocity.init(properties);

		VelocityContext context = new VelocityContext();

		context.put("package", "demo.test");
		context.put("dtoClassName", "Event");

		Table eventTable = DBUtil.reverseTable("EVENT", new Schema("study",
				"study", "jdbc:oracle:thin:@localhost:1521:XE",
				"oracle.jdbc.OracleDriver"));
		context.put("table", eventTable);

		Template template = null;

		try {
			template = Velocity.getTemplate("java/dto.java.vm");
		} catch (ResourceNotFoundException rnfe) {
			// couldn't find the template
			rnfe.printStackTrace();
			System.out.println("couldn't find the template");
		} catch (ParseErrorException pee) {
			// syntax error : problem parsing the template
			System.out.println("syntax error : problem parsing the template");
		} catch (MethodInvocationException mie) {
			// something invoked in the template
			// threw an exception
			System.out.println("something invoked in the template");
		}

		Writer writer = null;
		// -- create a file for the path
		File file = new File(
				"C:/Dev/GitRepos/Study/velocity-demo/src/main/java/demo/test/Event.java");

		// -- create all the directories
		System.out.println("getParent: " + file.getParent());
		if (!file.getParentFile().exists()) {
			boolean succes = (new File(file.getParent())).mkdirs();

			// -- check if the creation of the directories worked
			if (!succes)
				throw new Exception(
						"Unable to create the directory to write the file to");

		}

		// -- wrap the file into a writer so we can put data in it
		writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(
				file)));

		template.merge(context, writer);

		// -- write our content to the file
		writer.flush();
		writer.close();
	}

}
