package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.AppletComponent;
import fr.xlim.ssd.capmanipulator.library.CapApplet;
import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppletComponentWrite extends ComponentWrite {

    private final static Logger logger = LoggerFactory.getLogger(AppletComponentWrite.class);

    @Override
    public void write(CapOutputStream out, Component component) throws UnableToWriteCapFileException {

        assert out != null;
        assert component != null;
        assert component instanceof AppletComponent;
        AppletComponent appletComponent = (AppletComponent) component;

        super.write(out, appletComponent);

        out.writeByte(appletComponent.getCount());

        for (CapApplet ap : appletComponent.getApplets()) {
            new CapAppletWrite().write(out, ap);
        }
    }
}
