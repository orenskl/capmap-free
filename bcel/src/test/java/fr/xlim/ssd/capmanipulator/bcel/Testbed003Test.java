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

public class Testbed003Test {

    private CompilationHelper helper;

    @Before
    public void buildTestbed() {
        ProjectConfiguration configuration = new ProjectConfiguration(
                new File(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/testbeds/testbed003/"),
                new File(FileManagement.getModuleRoot().getAbsolutePath() + File.separator + "target/testbed003/")
        );

        helper = new CompilationHelper(configuration, JavaCardVersion.VERSION_2_2_2);
        helper.build();
    }


    @Test
    public void testApplet002() throws Exception, CapFieldException {
        Map map1 = (Map) helper.getConfiguration().get("results");
        Map map2 = (Map) map1.get("cap");
        File file = (File)map2.get("file");

		CapFileFactory.loadCapFile(map2.get("file").toString());

		CapParser capParser = new CapParser();

        Assert.assertEquals(5, capParser.getCapClasses().size());
        Assert.assertEquals(1, capParser.getCapInterfaces().size());

        int fieldCount = 0;

        for (CapClass capClass : capParser.getCapClasses()) {

            fieldCount += capClass.getCapFields().size();
        }

        Assert.assertEquals(7, fieldCount);
    }
}

