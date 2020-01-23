package fr.xlim.ssd.expreader;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ExpClassinfoTest {

    @Test
    public void testConstructor() throws IOException {
        ExpExportFileStream expoExportFileStream = Mockito.mock(ExpExportFileStream.class);
        when(expoExportFileStream.readByte()).thenReturn((byte) 3);
        when(expoExportFileStream.readShort()).thenReturn((short) 5);
        when(expoExportFileStream.readInt()).thenReturn(2);

        ExpClassInfo testClassinfo = new ExpClassInfo(expoExportFileStream);

        assertEquals(3, testClassinfo.getToken());
        assertEquals(5, testClassinfo.getAccess_flags());
        assertEquals(5, testClassinfo.getName_index());
        assertEquals(5, testClassinfo.getExport_supers_count());

        for(int i=0; i<testClassinfo.export_supers_count;i++) {
            assertEquals(5, testClassinfo.getSupers()[i]);
        }

        assertEquals(3, testClassinfo.getExport_interfaces_count());
        for(int i=0; i<testClassinfo.export_interfaces_count;i++) {
            assertEquals(5, testClassinfo.getInterfaces()[i]);
        }

        assertEquals(5, testClassinfo.getExport_fields_count());
        assertEquals(5, testClassinfo.getFields().size());

        assertEquals(5, testClassinfo.getExport_methods_count());
        assertEquals(5, testClassinfo.getMethods().size());

    }


}
