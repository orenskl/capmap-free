package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.InterfaceNameInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class InterfaceNameInfoWrite {


    /**
     * Write the IntefaceNameInfo part of a cap file object into a cap
     * file
     *
     * @param out Cap File Stream
     * @throws java.io.IOException
     */
    protected void write(CapOutputStream out, InterfaceNameInfo interfaceNameInfo) throws UnableToWriteCapFileException {

        out.writeByte(interfaceNameInfo.getInterfaceNameLength());

        for (Byte intName : interfaceNameInfo.getInterfaceName()) {
            out.writeByte(intName);
        }

    }
}
