package fr.xlim.ssd.capmanipulator.library;

import fr.xlim.ssd.capmanipulator.library.read.ExportComponentRead;
import fr.xlim.ssd.capmanipulator.library.write.ExportComponentWrite;
import java.io.File;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ExportComponentTest extends AbstractComponentTest {

    public ExportComponentTest(File file) {
        super(file, ComponentEnum.EXPORT_COMPONENT, new ExportComponentRead(), new ExportComponentWrite());
    }
}