package fr.xlim.ssd.expreader;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ExpExportFileTest {

    @Test
    public void testConstructor() throws IOException {
        ExpExportFileStream expoExportFileStream = Mockito.mock(ExpExportFileStream.class);
        when(expoExportFileStream.readByte()).thenReturn((byte)3);
        when(expoExportFileStream.readShort()).thenReturn((short) 5);
        when(expoExportFileStream.readInt()).thenReturn(1);
        ExpExportFile testExportFile = new ExpExportFile(expoExportFileStream);

        assertEquals(1, testExportFile.getMagic());
        assertEquals(3, testExportFile.getMinor_version());
        assertEquals(3, testExportFile.getMajor_version());
        assertEquals(5, testExportFile.getConstant_pool_count());
        
        assertEquals(5, testExportFile.getConstant_pool().size());

        assertEquals(5, testExportFile.getThis_package());
        assertEquals(3, testExportFile.getExport_class_count());

        assertEquals(3, testExportFile.getClasses().size());

    }



}
