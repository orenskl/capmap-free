package fr.xlim.ssd.capmanipulator.library;

import fr.xlim.ssd.capmanipulator.library.read.StaticFieldComponentRead;
import fr.xlim.ssd.capmanipulator.library.write.StaticFieldComponentWrite;
import java.io.File;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class StaticFieldComponentTest extends AbstractComponentTest {

    public StaticFieldComponentTest(File file) {
        super(file, ComponentEnum.STATIC_FIELD_COMPONENT, new StaticFieldComponentRead(), new StaticFieldComponentWrite());
    }
}