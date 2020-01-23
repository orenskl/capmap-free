package fr.xlim.ssd.expreader;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ExpConstantPackageTest {

    @Test
    public void testConstructor() throws IOException {
        ExpExportFileStream expoExportFileStream = Mockito.mock(ExpExportFileStream.class);
        when(expoExportFileStream.readByte()).thenReturn((byte)3);
        when(expoExportFileStream.readShort()).thenReturn((short) 5);
        ExpConstantPackage testPackage = new ExpConstantPackage(expoExportFileStream);
        assertEquals(5, testPackage.getName_index());
        assertEquals(3, testPackage.getMinor_version());
        assertEquals(3, testPackage.getMajor_version());
        assertEquals(3, testPackage.getAid_length());
        for(int i=0; i<testPackage.getAid_length(); i++) {
            assertEquals(3, testPackage.getAid()[i]);
        }
        assertEquals(13, testPackage.getTag());
    }


}
