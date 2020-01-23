package fr.xlim.ssd.capmanipulator.bcel;

import fr.xlim.ssd.capmanipulator.bcel.exceptions.CapFieldException;
import fr.xlim.ssd.capmanipulator.builder.CompilationHelper;
import fr.xlim.ssd.capmanipulator.builder.FileManagement;
import fr.xlim.ssd.capmanipulator.builder.JavaCardVersion;
import fr.xlim.ssd.capmanipulator.builder.ProjectConfiguration;
import fr.xlim.ssd.capmanipulator.library.CapFile;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import fr.xlim.ssd.capmanipulator.library.read.CapFileRead;
import fr.xlim.ssd.capmanipulator.library.read.CapInputStream;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Map;

public class Testbed004Test {

    private CompilationHelper helper;

    @Before
    public void buildTestbed() {
        ProjectConfiguration configuration = new ProjectConfiguration(
        //        new File(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/testbeds/fuzzingApplet/"),
        //        new File(FileManagement.getModuleRoot().getAbsolutePath() + File.separator + "target/fuzzingApplet/")
				new File(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/testbeds/testbed004/"),
				new File(FileManagement.getModuleRoot().getAbsolutePath() + File.separator + "target/testbed004/")
        );

        helper = new CompilationHelper(configuration, JavaCardVersion.VERSION_2_1_2, true);
        helper.build();
    }


    @Test
    public void testApplet004() throws UnableToReadCapFileException, CapFieldException {
        Map map1 = (Map) helper.getConfiguration().get("results");
        Map map2 = (Map) map1.get("cap");
        File file = (File)map2.get("file");

	    CapInputStream capInputStream = new CapInputStream(file);
        CapFileRead capFileRead = new CapFileRead(capInputStream);
        CapFile capFile = capFileRead.load();

		System.out.println(capFile.toString());


    }
}

