package fr.xlim.ssd.capmanipulator.builder;

import org.junit.Test;

public class FileManagementTest {

    @Test
    public void testGetModuleRoot() {
        File pom = new File(FileManagement.moduleRoot.absolutePath + File.separator + "pom.xml")
        assert pom.exists()
        def xml = new XmlParser().parse(pom)
        assert xml.artifactId.text() == "builder"

    }

    @Test
    public void testGetProjectRoot() {
        File pom = new File(FileManagement.projectRoot.absolutePath + File.separator + "pom.xml")
        assert pom.exists()
        def xml = new XmlParser().parse(pom)
        assert xml.artifactId.text() == "capmap"
    }
}