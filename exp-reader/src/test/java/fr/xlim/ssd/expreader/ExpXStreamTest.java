package fr.xlim.ssd.expreader;

public class ExpXStreamTest {

    // TODO: Unable to execute it ! No file found!
    /*
    @Test
    public void testConstructor() throws IOException {
        ExpExportFileStream expoExportFileStream = Mockito.mock(ExpExportFileStream.class);
        when(expoExportFileStream.readInt()).thenReturn(3);
        when(expoExportFileStream.readShort()).thenReturn((short) 5);
        when(expoExportFileStream.readByte()).thenReturn((byte) 7);

        ExpExportFile export1 = new ExpExportFile(expoExportFileStream);

        ExpXStream stream1 = new ExpXStream();

        File testFile = new File("target/test1.xml");
        if (testFile.exists()) {
            assertTrue(testFile.delete());
        }

        stream1.toXML(export1);
        stream1.saveIntoFile(testFile.getAbsolutePath());

        ExpXStream stream2 = new ExpXStream();
        stream2.loadFromFile(testFile.getAbsolutePath());

        ExpExportFile export2 = (ExpExportFile) stream2.fromXML();

        assertEquals(stream1.xml, stream2.xml);


    }*/


}
