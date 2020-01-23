package fr.xlim.ssd.capmanipulator.library;

import fr.xlim.ssd.capmanipulator.library.read.ClassComponentRead;
import fr.xlim.ssd.capmanipulator.library.write.ClassComponentWrite;
import java.io.File;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ClassComponentTest extends AbstractComponentTest {

    public ClassComponentTest(File file) {
        super(file, ComponentEnum.CLASS_COMPONENT, new ClassComponentRead(), new ClassComponentWrite());
    }
}