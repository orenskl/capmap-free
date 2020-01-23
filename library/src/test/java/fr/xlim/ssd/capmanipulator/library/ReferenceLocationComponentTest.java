package fr.xlim.ssd.capmanipulator.library;

import fr.xlim.ssd.capmanipulator.library.read.ReferenceLocationComponentRead;
import fr.xlim.ssd.capmanipulator.library.write.ReferenceLocationComponentWrite;
import java.io.File;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ReferenceLocationComponentTest extends AbstractComponentTest {

    public ReferenceLocationComponentTest(File file) {
        super(file, ComponentEnum.REFERENCE_LOCATION_COMPONENT, new ReferenceLocationComponentRead(),
                new ReferenceLocationComponentWrite());
    }
}