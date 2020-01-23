package fr.xlim.ssd.capmanipulator.library;

import fr.xlim.ssd.capmanipulator.library.read.ConstantPoolComponentRead;
import fr.xlim.ssd.capmanipulator.library.write.ConstantPoolComponentWrite;
import java.io.File;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ConstantPoolComponentTest extends AbstractComponentTest {

    public ConstantPoolComponentTest(File file) {
        super(file, ComponentEnum.CONSTANT_POOL_COMPONENT, new ConstantPoolComponentRead(), new ConstantPoolComponentWrite());
    }
}