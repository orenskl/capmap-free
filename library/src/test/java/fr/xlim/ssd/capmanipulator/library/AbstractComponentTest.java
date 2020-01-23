package fr.xlim.ssd.capmanipulator.library;

import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;
import fr.xlim.ssd.capmanipulator.library.read.CapInputStream;
import fr.xlim.ssd.capmanipulator.library.read.ComponentRead;
import fr.xlim.ssd.capmanipulator.library.tool.ExtractComponent;
import fr.xlim.ssd.capmanipulator.library.write.CapOutputStream;
import fr.xlim.ssd.capmanipulator.library.write.ComponentWrite;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public abstract class AbstractComponentTest {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractComponentTest.class);

    @Parameterized.Parameters
    public static Collection<Object[]> data() throws URISyntaxException, IOException {

        List<Object[]> tab = new LinkedList<Object[]>();

        File f = new File(ClassLoader.getSystemResource(".").toURI());
        f = new File(f.getAbsolutePath() + "/../../../various/cap-files/fichiers_cap/");

        ExtractComponent ec = new ExtractComponent();
        assertTrue(f.exists());

        logger.debug("cap directory: " + f.getAbsolutePath());

        for (File file : f.listFiles()) {
            if (file.getName().endsWith(".cap")) {
                logger.debug("loading " + file.getAbsolutePath());
                tab.add(new Object[]{file});
            }
        }

        return tab;
    }

    private File file;

    private byte[] componentTab;

    private ComponentEnum componentEnum;

    private ComponentRead componentRead;

    private ComponentWrite componentWrite;

    public AbstractComponentTest(File file, ComponentEnum componentEnum, ComponentRead componentRead, ComponentWrite componentWrite) {
        this.file = file;
        this.componentEnum = componentEnum;
        this.componentRead = componentRead;
        this.componentWrite = componentWrite;
    }

    @Before
    public void extractComponent() throws IOException {
        ExtractComponent ec = new ExtractComponent();
        componentTab = ec.extractComponent(file, componentEnum);
    }

    @Test
    public void testLoad() throws UnableToReadCapFileException, IOException {
        if (componentTab == null) {
            logger.warn("component is not present");
            return;
        }

        logger.debug("testing {} of file {}", componentEnum, file);

        logger.trace("loaded component size is {}", componentTab.length);

        CapInputStream cas = new CapInputStream(componentTab);
        cas.load();
        Component component = componentRead.load(cas);
        cas.close();

        logger.trace("string representation\n{}", component);
    }

    /**
     * test which will load an Applet componentTab, save it and check that they are
     * identical (by using their md5 signature and that no exception is raised
     * when we write the file
     */
    @Test
    public void testLoadAndWrite() throws UnableToReadCapFileException, UnableToWriteCapFileException, IOException {
        if (componentTab == null) {
            logger.warn("component is not present");
            return;
        }

        CapInputStream cas = new CapInputStream(componentTab);
        cas.load();
        Component component = componentRead.load(cas);
        cas.close();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        CapOutputStream cos = new CapOutputStream(os);
        componentWrite.write(cos, component);
        cos.close();
        os.close();

        assertArrayEquals(componentTab,
                Arrays.copyOfRange(os.toByteArray(), 1, os.toByteArray().length));
    }
}