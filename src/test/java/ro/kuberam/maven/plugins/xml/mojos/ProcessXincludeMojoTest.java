package ro.kuberam.maven.plugins.xml.mojos;

import java.io.File;

import org.apache.maven.project.MavenProject;

import ro.kuberam.maven.plugins.utils.KuberamAbstractMojoTestBase;

public class ProcessXincludeMojoTest extends KuberamAbstractMojoTestBase {

	public void testNormalProcessing() throws Exception {
		final ProcessXincludeMojo mojo = this.mojo();

		setVariableValueToObject(mojo, "inputFile", new File(baseDir + File.separator + "src/test/resources/ro/kuberam/maven/plugins/xml/mojos/process-xinclude/document-01.xml"));
		setVariableValueToObject(mojo, "outputDir", new File(projectBuildDirectory + "/process-xinclude"));
		mojo.execute();
	}
	
	public void testOmitXmlDeclaration() throws Exception {
		final ProcessXincludeMojo mojo = this.mojo();
		
		setVariableValueToObject(mojo, "inputFile", new File(baseDir + File.separator + "src/test/resources/ro/kuberam/maven/plugins/xml/mojos/process-xinclude/document-01.xml"));
		setVariableValueToObject(mojo, "omitXmlDeclaration", "yes");
		setVariableValueToObject(mojo, "outputDir", new File(projectBuildDirectory + "/process-xinclude"));
		mojo.execute();
	}
	
	public void testValidate() throws Exception {
		final ProcessXincludeMojo mojo = this.mojo();
		
		setVariableValueToObject(mojo, "inputFile", new File(baseDir + File.separator + "src/test/resources/ro/kuberam/maven/plugins/xml/mojos/process-xinclude/document-02.xml"));
		setVariableValueToObject(mojo, "omitXmlDeclaration", "yes");
		setVariableValueToObject(mojo, "validate", "true");
		setVariableValueToObject(mojo, "outputDir", new File(projectBuildDirectory + "/process-xinclude"));
		mojo.execute();
	}

	private ProcessXincludeMojo mojo() throws Exception {
		final ProcessXincludeMojo mojo = new ProcessXincludeMojo();
		
		setVariableValueToObject(mojo, "outputDir", new File(projectBuildDirectory));
		mojo.setProject(new MavenProject());
		mojo.setRepoSession(newSession(newRepositorySystem()));

		return mojo;
	}
}
