package fr.xlim.ssd.capmanipulator.library;

import fr.xlim.ssd.capmanipulator.library.read.CapFileRead;
import fr.xlim.ssd.capmanipulator.library.read.DirectoryComponentRead;
import fr.xlim.ssd.capmanipulator.library.write.DirectoryComponentWrite;
import java.io.File;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DirectoryComponentTest extends AbstractComponentTest {

    public DirectoryComponentTest(File file) {
        super(file, ComponentEnum.DIRECTORY_COMPONENT, new DirectoryComponentRead(), new DirectoryComponentWrite());
    }
}