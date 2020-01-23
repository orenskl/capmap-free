package fr.xlim.ssd.capmanipulator.builder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CompilationHelperTest {

    private static Logger logger = LoggerFactory.getLogger(CompilationHelperTest.class);

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        List<Object[]> tab = new LinkedList<Object[]>();


        for (JavaCardVersion version : JavaCardVersion.values()) {

            logger.info("adding version {}", version);

            tab.add(new Object[]{
                    new File(FileManagement.getProjectRoot().getAbsolutePath() + File.separator
                            + "various/testbeds/testbed001/"),
                    new File(FileManagement.getModuleRoot().getAbsolutePath() + File.separator
                            + "target/testbed001/" + version.getVersion() + "/"),
                    version
            });
        }

        return tab;
    }

    private File projectDir;
    private File buildDir;
    private JavaCardVersion version;

    public CompilationHelperTest(File projectDir, File buildDir, JavaCardVersion version) {
        this.projectDir = projectDir;
        this.buildDir = buildDir;
        this.version = version;
    }


    @Test
    public void testBuild() {

        ProjectConfiguration configuration = new ProjectConfiguration(projectDir, buildDir);

        CompilationHelper helper = new CompilationHelper(configuration, version);
        helper.build();

        assertNotNull(configuration.getCapFile());
        assertNotNull(configuration.getJcaFile());
        assertNotNull(configuration.getExpFile());

        assertTrue(configuration.getCapFile().exists());
        assertTrue(configuration.getJcaFile().exists());
        assertTrue(configuration.getExpFile().exists());
    }
}