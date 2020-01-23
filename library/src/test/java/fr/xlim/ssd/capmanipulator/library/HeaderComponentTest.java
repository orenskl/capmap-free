package fr.xlim.ssd.capmanipulator.library;

import fr.xlim.ssd.capmanipulator.library.read.HeaderComponentRead;
import fr.xlim.ssd.capmanipulator.library.write.HeaderComponentWrite;
import java.io.File;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class HeaderComponentTest extends AbstractComponentTest {

    public HeaderComponentTest(File file) {
        super(file, ComponentEnum.HEADER_COMPONENT, new HeaderComponentRead(), new HeaderComponentWrite());
    }
}