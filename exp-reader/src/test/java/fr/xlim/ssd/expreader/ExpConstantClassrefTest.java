package fr.xlim.ssd.expreader;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.shortThat;
import static org.mockito.Mockito.when;

public class ExpConstantClassrefTest {

    @Test
    public void testConstructor() throws IOException {
        ExpExportFileStream expoExportFileStream = Mockito.mock(ExpExportFileStream.class);
        when(expoExportFileStream.readShort()).thenReturn((short) 5);
        ExpConstantClassref classref = new ExpConstantClassref(expoExportFileStream);
        assertEquals(5, classref.getName_index());
        assertEquals(7, classref.getTag());
    }


}
