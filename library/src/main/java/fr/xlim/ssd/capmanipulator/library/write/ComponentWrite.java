package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public abstract class ComponentWrite implements WritableComponent {

    /**
     * write the value of tag and file in a cap file
     *
     * @param out Cap File Stream
     * @throws java.io.IOException
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException
     */
    @Override
    public void write(CapOutputStream out, Component component) throws UnableToWriteCapFileException {

        out.writeByte(component.getTag());
        out.writeShort(component.getSize());
    }

}
