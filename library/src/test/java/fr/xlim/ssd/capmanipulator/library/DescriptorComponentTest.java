package fr.xlim.ssd.capmanipulator.library;

import fr.xlim.ssd.capmanipulator.library.read.DescriptorComponentRead;
import fr.xlim.ssd.capmanipulator.library.write.DescriptorComponentWrite;
import java.io.File;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DescriptorComponentTest extends AbstractComponentTest {

    public DescriptorComponentTest(File file) {
        super(file, ComponentEnum.DESCRIPTOR_COMPONENT, new DescriptorComponentRead(), new DescriptorComponentWrite());
    }
}