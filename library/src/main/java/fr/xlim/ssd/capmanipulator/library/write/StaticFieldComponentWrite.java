package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ArrayInitInfo;
import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.StaticFieldComponent;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticFieldComponentWrite extends ComponentWrite {

    private final static Logger logger = LoggerFactory.getLogger(StaticFieldComponentWrite.class);

    @Override
    public void write(CapOutputStream out, Component component) throws UnableToWriteCapFileException {

        assert component instanceof StaticFieldComponent;
        StaticFieldComponent staticFieldComponent = (StaticFieldComponent) component;

        // write tag and size
        super.write(out, staticFieldComponent);

        // image size writing
        out.writeShort(staticFieldComponent.getImageSize());

        // reference count writing
        out.writeShort(staticFieldComponent.getReferenceCount());

        // array init count writing
        out.writeShort(staticFieldComponent.getArrayInitCount());

        // Array init info writing
        for (ArrayInitInfo a : staticFieldComponent.getArrayInit()) {
            new ArrayInitInfoWrite().write(out, a);
        }

        // default value count writing
        out.writeShort(staticFieldComponent.getDefaultValueCount());

        // non default value count writing
        out.writeShort(staticFieldComponent.getNonDefaultValueCount());

        // non default values writing
        for (byte b : staticFieldComponent.getNonDefaultValues()) {
            out.writeByte(b);
        }
    }
}
