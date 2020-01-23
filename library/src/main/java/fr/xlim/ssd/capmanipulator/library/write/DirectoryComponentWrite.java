package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.CustomComponentInfo;
import fr.xlim.ssd.capmanipulator.library.DirectoryComponent;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class DirectoryComponentWrite extends ComponentWrite {

    @Override
    public void write(CapOutputStream out, Component component) throws UnableToWriteCapFileException {

        assert component instanceof DirectoryComponent;
        DirectoryComponent directoryComponent = (DirectoryComponent) component;

        super.write(out, directoryComponent);

        for (Short size : directoryComponent.getComponentSize()) {
            out.writeShort(size);
        }

        new StaticFieldSizeInfoWrite().write(out, directoryComponent.getStaticFieldSize());

        out.writeByte(directoryComponent.getImportCount());
        out.writeByte(directoryComponent.getAppletCount());
        out.writeByte(directoryComponent.getCustomCount());

        for (CustomComponentInfo cu : directoryComponent.getCustomComponent()) {
            new CustomComponentInfoWrite().write(out, cu);
        }
    }
}
