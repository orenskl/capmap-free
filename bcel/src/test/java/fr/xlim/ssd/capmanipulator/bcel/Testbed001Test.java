package fr.xlim.ssd.capmanipulator.bcel;

import fr.xlim.ssd.capmanipulator.bcel.exceptions.CapFieldException;
import fr.xlim.ssd.capmanipulator.builder.CompilationHelper;
import fr.xlim.ssd.capmanipulator.builder.FileManagement;
import fr.xlim.ssd.capmanipulator.builder.JavaCardVersion;
import fr.xlim.ssd.capmanipulator.builder.ProjectConfiguration;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Map;

public class Testbed001Test {

    private CompilationHelper helper;

    @Before
    public void buildTestbed() {
        ProjectConfiguration configuration = new ProjectConfiguration(
                new File(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/testbeds/testbed001/"),
                new File(FileManagement.getModuleRoot().getAbsolutePath() + File.separator + "target/testbed001/")
        );

        helper = new CompilationHelper(configuration, JavaCardVersion.VERSION_2_2_2);
        helper.build();
    }

    @Test
    public void testApplet001() throws Exception, CapFieldException {
        Map map1 = (Map) helper.getConfiguration().get("results");
        Map map2 = (Map) map1.get("cap");
        File file = (File)map2.get("file");

		CapFileFactory.loadCapFile(map2.get("file").toString());

        CapParser capParser = new CapParser();


        System.out.println(capParser.getCapClasses().get(0).getCapFields().size());

        for (CapField capField : capParser.getCapClasses().get(0).getCapFields()) {

            System.out.println(capField.getTypeToString());
        }

        Assert.assertEquals(1, capParser.getCapClasses().size());
        Assert.assertEquals(7, capParser.getCapClasses().get(0).getMethods().size());
    }
}

