package fr.xlim.ssd.expreader;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ExpFieldInfoTest {

    @Test
    public void testConstructor() throws IOException {
        ExpExportFileStream expoExportFileStream = Mockito.mock(ExpExportFileStream.class);
        when(expoExportFileStream.readByte()).thenReturn((byte) 3);
        when(expoExportFileStream.readShort()).thenReturn((short) 5);
        ExpFieldInfo testFieldInfo = new ExpFieldInfo(expoExportFileStream);

        assertEquals(3, testFieldInfo.getToken());
        assertEquals(5, testFieldInfo.getAccess_flags());
        assertEquals(5, testFieldInfo.getName_index());
        assertEquals(5, testFieldInfo.getDescriptior_index());
        assertEquals(5, testFieldInfo.getAttributes_count());
        assertEquals(5, testFieldInfo.getAttributes().size());
    }


}
