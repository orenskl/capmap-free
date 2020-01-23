package fr.xlim.ssd.capmanipulator.library.testbeds;


import fr.xlim.ssd.capmanipulator.builder.CompilationHelper
import fr.xlim.ssd.capmanipulator.builder.FileManagement
import fr.xlim.ssd.capmanipulator.builder.JavaCardVersion
import fr.xlim.ssd.capmanipulator.builder.ProjectConfiguration
import fr.xlim.ssd.capmanipulator.library.CapFile
import fr.xlim.ssd.capmanipulator.library.DirectoryComponent
import fr.xlim.ssd.capmanipulator.library.read.CapFileRead
import fr.xlim.ssd.capmanipulator.library.read.CapInputStream
import groovy.util.logging.Slf4j
import org.junit.BeforeClass
import org.junit.Test
import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertTrue

@Slf4j("logger")
public class Testbed001Test {

    private static def data() {

        def tab = [];

        for (JavaCardVersion version: JavaCardVersion.values()) {

            logger.info("adding version {}", version);

            tab.add(
                    [
                            projectDir: new File(FileManagement.getProjectRoot().getAbsolutePath() + File.separator
                                    + "various/testbeds/testbed001/"),
                            buildDir: new File(FileManagement.getModuleRoot().getAbsolutePath() + File.separator
                                    + "target/testbed001/" + version.getVersion() + "/"),
                            version: version
                    ]
            );
        }

        return tab;
    }

    private static Map<JavaCardVersion, CapFile> capFileByVersion = [:]

    @BeforeClass
    public static void createCapFiles() {

        for (def val: data()) {

            assert val.projectDir != null
            assert val.buildDir != null

            ProjectConfiguration configuration = new ProjectConfiguration(val.projectDir, val.buildDir);

            assert configuration != null
            assert val.version != null

            CompilationHelper helper = new CompilationHelper(configuration, val.version);
            helper.build();

            assertNotNull(configuration.getCapFile());
            assertNotNull(configuration.getJcaFile());
            assertNotNull(configuration.
                    getExpFile());

            assertTrue(configuration.getCapFile().exists());
            assertTrue(configuration.getJcaFile().exists());
            assertTrue(configuration.getExpFile().exists());


            Map<JavaCardVersion, ProjectConfiguration> projectConfigurations = [:]

            projectConfigurations[val.version] = configuration

            CapInputStream is = new CapInputStream(configuration.getCapFile())
            capFileByVersion[val.version] = new CapFileRead(is).load()
        }
    }

    @Test
    public void compareHeaderComponent() {
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_1].headerComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_1_2].headerComponent)
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_2].headerComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_2_1].headerComponent)
        assert capFileByVersion[JavaCardVersion.VERSION_2_2_1].headerComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_2_2].headerComponent)
    }

    @Test
    public void compareAppletComponent() {
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_1].appletComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_1_2].appletComponent)
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_2].appletComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_2_1].appletComponent)
        assert capFileByVersion[JavaCardVersion.VERSION_2_2_1].appletComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_2_2].appletComponent)
    }

    @Test
    public void compareDirectoryComponent() {
        def directoryComponent211 = capFileByVersion[JavaCardVersion.VERSION_2_1_1].directoryComponent
        def directoryComponent212 = capFileByVersion[JavaCardVersion.VERSION_2_1_2].directoryComponent
        def directoryComponent221 = capFileByVersion[JavaCardVersion.VERSION_2_2_1].directoryComponent
        def directoryComponent222 = capFileByVersion[JavaCardVersion.VERSION_2_2_2].directoryComponent
        assert directoryComponent211.equals(directoryComponent212)
        assert directoryComponent212.equals(directoryComponent221)
        assert !directoryComponent221.equals(directoryComponent222)
    }

    @Test
    public void compareDirectoryComponentFrom221To222() {
        DirectoryComponent directoryComponent221 = capFileByVersion[JavaCardVersion.VERSION_2_2_1].directoryComponent
        DirectoryComponent directoryComponent222 = capFileByVersion[JavaCardVersion.VERSION_2_2_2].directoryComponent
        assert directoryComponent221.tag == directoryComponent222.tag
        assert directoryComponent221.size == directoryComponent222.size
        [0, 1, 2, 4, 5, 6, 7, 8, 9, 10].each {
            assert directoryComponent221.componentSize[it] == directoryComponent222.componentSize[it]
        }
        assert directoryComponent221.staticFieldComponentSize == directoryComponent222.staticFieldComponentSize
        assert directoryComponent221.staticFieldSize == directoryComponent222.staticFieldSize
        assert directoryComponent221.appletCount == directoryComponent222.appletCount
        assert directoryComponent221.customCount == directoryComponent222.customCount
        assert directoryComponent221.customComponent == directoryComponent222.customComponent

        // troublemakers
        assert directoryComponent221.componentSize[3] != directoryComponent222.componentSize[3]
        assert directoryComponent221.importCount != directoryComponent222.importCount

        logger.debug("directory component from 2.2.1:\n{}\ndirectory component from 2.2.2:\n{}",
                directoryComponent221.toString(), directoryComponent222.toString())
    }

    @Test
    public void compareImportComponent() {
        def importComponent211 = capFileByVersion[JavaCardVersion.VERSION_2_1_1].importComponent
        def importComponent212 = capFileByVersion[JavaCardVersion.VERSION_2_1_2].importComponent
        def importComponent221 = capFileByVersion[JavaCardVersion.VERSION_2_2_1].importComponent
        def importComponent222 = capFileByVersion[JavaCardVersion.VERSION_2_2_2].importComponent
        assert importComponent211.equals(importComponent212)
        assert !importComponent212.equals(importComponent221)
        assert !importComponent221.equals(importComponent222)
    }

    @Test
    public void compareImportComponentFrom212To221() {
        def importComponent212 = capFileByVersion[JavaCardVersion.VERSION_2_1_2].importComponent
        def importComponent221 = capFileByVersion[JavaCardVersion.VERSION_2_2_1].importComponent
        assert importComponent212.tag == importComponent221.tag
        assert importComponent212.size == importComponent221.size
        assert importComponent212.count == importComponent221.count
        assert importComponent212.packages.size() == importComponent221.packages.size()
        assert importComponent212.packages[0].AID == importComponent221.packages[0].AID
        assert importComponent212.packages[0].AIDLength == importComponent221.packages[0].AIDLength
        assert importComponent212.packages[0].majorVersion == importComponent221.packages[0].majorVersion

        // troublemakers
        assert importComponent212.packages[0].minorVersion != importComponent221.packages[0].minorVersion

        logger.debug("import component from 2.1.2:\n{}\nimport component from 2.2.1:\n{}",
                importComponent212.toString(), importComponent221.toString())
    }

    @Test
    public void compareImportComponentFrom221To222() {
        def importComponent221 = capFileByVersion[JavaCardVersion.VERSION_2_2_1].importComponent
        def importComponent222 = capFileByVersion[JavaCardVersion.VERSION_2_2_2].importComponent
        assert importComponent221.tag == importComponent222.tag

        // troublemakers

        assert importComponent221.size != importComponent222.size
        assert importComponent221.count != importComponent222.count
        assert importComponent221.packages.size() != importComponent222.packages.size()

        logger.debug("import component from 2.2.1:\n{}\nimport component from 2.2.2:\n{}",
                importComponent221.toString(), importComponent222.toString())
    }

    @Test
    public void compareExportComponent() {
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_1].exportComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_1_2].exportComponent)
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_2].exportComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_2_1].exportComponent)
        assert capFileByVersion[JavaCardVersion.VERSION_2_2_1].exportComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_2_2].exportComponent)
    }

    @Test
    public void compareClassComponent() {
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_1].classComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_1_2].classComponent)
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_2].classComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_2_1].classComponent)
        assert capFileByVersion[JavaCardVersion.VERSION_2_2_1].classComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_2_2].classComponent)
    }

    @Test
    public void compareConstantPoolComponent() {
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_1].constantPoolComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_1_2].constantPoolComponent)
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_2].constantPoolComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_2_1].constantPoolComponent)
        assert capFileByVersion[JavaCardVersion.VERSION_2_2_1].constantPoolComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_2_2].constantPoolComponent)
    }

    @Test
    public void compareMethodComponent() {
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_1].methodComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_1_2].methodComponent)
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_2].methodComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_2_1].methodComponent)
        assert capFileByVersion[JavaCardVersion.VERSION_2_2_1].methodComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_2_2].methodComponent)
    }

    @Test
    public void compareStaticFieldComponent() {
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_1].staticFieldComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_1_2].staticFieldComponent)
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_2].staticFieldComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_2_1].staticFieldComponent)
        assert capFileByVersion[JavaCardVersion.VERSION_2_2_1].staticFieldComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_2_2].staticFieldComponent)
    }

    @Test
    public void compareReferenceLocationComponent() {
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_1].referenceLocationComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_1_2].referenceLocationComponent)
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_2].referenceLocationComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_2_1].referenceLocationComponent)
        assert capFileByVersion[JavaCardVersion.VERSION_2_2_1].referenceLocationComponent
                .equals(capFileByVersion[JavaCardVersion.VERSION_2_2_2].referenceLocationComponent)
    }

    @Test
    public void compareDescriptorComponent() {
        def descriptorComponent211 = capFileByVersion[JavaCardVersion.VERSION_2_1_1].descriptorComponent
        def descriptorComponent212 = capFileByVersion[JavaCardVersion.VERSION_2_1_2].descriptorComponent
        def descriptorComponent221 = capFileByVersion[JavaCardVersion.VERSION_2_2_1].descriptorComponent
        def descriptorComponent222 = capFileByVersion[JavaCardVersion.VERSION_2_2_2].descriptorComponent
        assert descriptorComponent211.equals(descriptorComponent212)
        assert descriptorComponent212.equals(descriptorComponent221)
        assert descriptorComponent221.equals(descriptorComponent222)
    }

    @Test
    public void compareDebugComponent() {
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_1].debugComponent == null;
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_2].debugComponent == null;
        assert capFileByVersion[JavaCardVersion.VERSION_2_2_1].debugComponent == null;
        assert capFileByVersion[JavaCardVersion.VERSION_2_2_2].debugComponent == null;
    }

    @Test
    public void compareCustomComponent() {
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_1].customComponents.size == 0;
        assert capFileByVersion[JavaCardVersion.VERSION_2_1_2].customComponents.size == 0;
        assert capFileByVersion[JavaCardVersion.VERSION_2_2_1].customComponents.size == 0;
        assert capFileByVersion[JavaCardVersion.VERSION_2_2_2].customComponents.size == 0;
    }
}