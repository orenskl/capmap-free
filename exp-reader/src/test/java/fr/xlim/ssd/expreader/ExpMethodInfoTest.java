package fr.xlim.ssd.expreader;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ExpMethodInfoTest {

    @Test
    public void testConstructor() throws IOException {
        ExpExportFileStream expoExportFileStream = Mockito.mock(ExpExportFileStream.class);
        when(expoExportFileStream.readByte()).thenReturn((byte) 3);
        when(expoExportFileStream.readShort()).thenReturn((short) 5);
        ExpMethodInfo testMethodInfo = new ExpMethodInfo(expoExportFileStream);

        assertEquals(3, testMethodInfo.getToken());
        assertEquals(5, testMethodInfo.getAccess_flags());
        assertEquals(5, testMethodInfo.getName_index());
        assertEquals(5, testMethodInfo.getDescriptior_index());
    }


}
