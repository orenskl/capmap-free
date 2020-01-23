package fr.xlim.ssd.capmanipulator.library;

import fr.xlim.ssd.capmanipulator.library.read.AppletComponentRead;
import fr.xlim.ssd.capmanipulator.library.write.AppletComponentWrite;
import java.io.File;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AppletComponentTest extends AbstractComponentTest {

    public AppletComponentTest(File file) {
        super(file, ComponentEnum.APPLET_COMPONENT, new AppletComponentRead(), new AppletComponentWrite());
    }
}