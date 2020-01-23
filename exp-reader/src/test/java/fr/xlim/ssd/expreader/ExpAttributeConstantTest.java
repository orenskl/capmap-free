package fr.xlim.ssd.expreader;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ExpAttributeConstantTest {

    @Test
    public void testConstructor() throws IOException {
        ExpExportFileStream expoExportFileStream = Mockito.mock(ExpExportFileStream.class);
        when(expoExportFileStream.readInt()).thenReturn(3);
        when(expoExportFileStream.readShort()).thenReturn((short) 5);
        ExpAttributeConstant testAttributeConstant = new ExpAttributeConstant(expoExportFileStream);
        assertEquals(5, testAttributeConstant.getAttribute_name_index());
        assertEquals(3, testAttributeConstant.getAttribute_length());
        assertEquals(5, testAttributeConstant.getConstantValue());
    }


}
