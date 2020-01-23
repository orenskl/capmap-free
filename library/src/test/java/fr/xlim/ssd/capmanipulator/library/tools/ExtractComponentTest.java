package fr.xlim.ssd.capmanipulator.library.tools;

import fr.xlim.ssd.capmanipulator.library.ComponentEnum;
import fr.xlim.ssd.capmanipulator.library.tool.ExtractComponent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExtractComponentTest {

    private static final Logger logger = LoggerFactory.getLogger(ExtractComponentTest.class);

    @Test
    public void testExtractComponent() throws URISyntaxException, IOException {

        File f = new File(ClassLoader.getSystemResource(".").toURI());
        f = new File(f.getAbsolutePath() + "/../../../various/cap-files/fichiers_cap/");

        ExtractComponent ec = new ExtractComponent();
        assertTrue(f.exists());

        logger.debug("cap directory: " + f.getAbsolutePath());

        for (File file : f.listFiles()) {
            if (file.getName().endsWith(".cap")) {
                logger.debug("loading " + file.getAbsolutePath());
                for (ComponentEnum ce : ComponentEnum.values()) {
                    byte[] tab = ec.extractComponent(file, ce);
                    if (tab != null) {
                        ByteBuffer bb = ByteBuffer.wrap(tab);
                        short size = bb.getShort();
                        assertEquals(size + 2, tab.length);
                    }
                }
            }
        }
    }
}
