package fr.xlim.ssd.expreader;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ExpConstantIntegerTest {

    @Test
    public void testConstructor() throws IOException {
        ExpExportFileStream expoExportFileStream = Mockito.mock(ExpExportFileStream.class);
        when(expoExportFileStream.readInt()).thenReturn(3);
        ExpConstantInteger integer = new ExpConstantInteger(expoExportFileStream);
        assertEquals(3, integer.getBytes());
        assertEquals(3, integer.getTag());
    }


}
