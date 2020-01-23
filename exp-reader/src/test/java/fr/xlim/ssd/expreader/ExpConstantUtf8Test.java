package fr.xlim.ssd.expreader;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ExpConstantUtf8Test {

    @Test
    public void testConstructor() throws IOException {
        ExpExportFileStream expoExportFileStream = Mockito.mock(ExpExportFileStream.class);
        when(expoExportFileStream.readByte()).thenReturn((byte)3);
        when(expoExportFileStream.readShort()).thenReturn((short) 5);
        ExpConstantUtf8 testUtf8 = new ExpConstantUtf8(expoExportFileStream);
        assertEquals(5, testUtf8.getLength());
        for(int i=0; i<testUtf8.getLength(); i++){
            assertEquals(3, testUtf8.getBytes()[i]);
        }


        assertEquals(1, testUtf8.getTag());
    }


}
