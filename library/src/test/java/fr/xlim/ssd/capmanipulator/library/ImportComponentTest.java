package fr.xlim.ssd.capmanipulator.library;

import fr.xlim.ssd.capmanipulator.library.read.ImportComponentRead;
import fr.xlim.ssd.capmanipulator.library.write.ImportComponentWrite;
import java.io.File;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ImportComponentTest extends AbstractComponentTest {

    public ImportComponentTest(File file) {
        super(file, ComponentEnum.IMPORT_COMPONENT, new ImportComponentRead(), new ImportComponentWrite());
    }
}