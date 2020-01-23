package fr.xlim.ssd.capmanipulator.library;

import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;
import fr.xlim.ssd.capmanipulator.library.read.CapFileRead;
import fr.xlim.ssd.capmanipulator.library.read.CapInputStream;
import fr.xlim.ssd.capmanipulator.library.write.CapFileWrite;
import fr.xlim.ssd.capmanipulator.library.write.CapOutputStream;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LoadCapFileTest {

    private static final Logger logger = LoggerFactory.getLogger(LoadCapFileTest.class);

    @Parameterized.Parameters
    public static Collection<Object[]> data() throws URISyntaxException, IOException {

        List<Object[]> tab = new LinkedList<Object[]>();

        File f = new File(ClassLoader.getSystemResource(".").toURI());
        f = new File(f.getAbsolutePath() + "/../../../various/cap-files/fichiers_cap/");

        assertTrue(f.exists());

        logger.debug("cap directory: " + f.getAbsolutePath());

        for (File file : f.listFiles()) {
            if (file.getName().endsWith(".cap")) {
                logger.debug("loading " + file.getAbsolutePath());
                boolean textFound = false;
                for (File file2 : f.listFiles()) {
                    if (file2.getAbsolutePath().equals(file.getAbsolutePath() + ".txt")) {
                        logger.debug("loading text " + file2.getAbsolutePath());
                        textFound = true;
                        tab.add(new Object[]{file, file2});
                        break;
                    }
                }
                assertTrue(textFound);
            }
        }

        return tab;
    }

    private File capFile;

    private File textFile;

    public LoadCapFileTest(File capFile, File textFile) {
        this.capFile = capFile;
        this.textFile = textFile;
    }

    @Test
    public void testLoad() throws URISyntaxException, UnableToReadCapFileException {

        logger.debug("loading " + capFile.getAbsolutePath());
        CapInputStream cis = new CapInputStream(capFile);
        CapFileRead cfr = new CapFileRead(cis);
        CapFile cap = cfr.load();
        assertNotNull(cap);
    }

    @Test
    public void testLoadThenPrint() throws UnableToReadCapFileException {

        logger.debug("loading " + capFile.getAbsolutePath());
        CapInputStream cis = new CapInputStream(capFile);
        CapFileRead cfr = new CapFileRead(cis);
        CapFile cap = cfr.load();
        logger.trace("print: {}", cap.toString());
    }

    @Test
    public void testLoadThenWrite() throws UnableToReadCapFileException, UnableToWriteCapFileException {

        logger.debug("loading " + capFile.getAbsolutePath());
        CapInputStream cis = new CapInputStream(capFile);
        CapFileRead cfr = new CapFileRead(cis);
        CapFile cap = cfr.load();

        OutputStream bout = new ByteArrayOutputStream();
        CapOutputStream dout = new CapOutputStream(bout);
        CapFileWrite cfw = new CapFileWrite(dout);
        cfw.writeFileOrder(cap);
    }

    @Test
    public void testLoadThenComparePrint() throws UnableToReadCapFileException, IOException {

        logger.debug("loading " + capFile.getAbsolutePath());
        CapInputStream cis = new CapInputStream(capFile);
        CapFileRead cfr = new CapFileRead(cis);
        CapFile cap = cfr.load();

        // load file text in a String
        byte[] buffer = new byte[(int) textFile.length()];
        BufferedInputStream f = new BufferedInputStream(new FileInputStream(textFile));
        f.read(buffer);
        f.close();

        String textString = new String(buffer);

        assertTextEquals(textString, cap.toString());
    }

    private void assertTextEquals(String expected, String results) {

        // split expected array and remove 7 first lines
        String[] expectedArray = expected.split("\n");

        expectedArray = Arrays.copyOfRange(expectedArray, 7, expectedArray.length);

        for (int i = 0 ; i < expectedArray.length ; ++i) {
            expectedArray[i] = expectedArray[i].trim();
        }

        // split results array
        String[] resultsArray = results.split("\n");

        for (int i = 0 ; i < resultsArray.length ; ++i) {
            resultsArray[i] = resultsArray[i].trim();
        }

        for (int i = 0; i < Math.min(expectedArray.length, resultsArray.length); i++) {
            assertEquals("error in line " + i, resultsArray[i], expectedArray[i]);
        }

        assertEquals("not same length", expectedArray.length, resultsArray.length);
    }
}