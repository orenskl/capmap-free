package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ClassRef;
import fr.xlim.ssd.capmanipulator.library.InterfaceInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class InterfaceInfoWrite {


    /**
     * Write the IntefaceInfo part of a cap file object into a cap file
     *
     * @param out Cap File Stream
     * @throws java.io.IOException
     */
    public void write(CapOutputStream out, InterfaceInfo interfaceInfo) throws UnableToWriteCapFileException {

        out.writeByte(interfaceInfo.getBitfield());

        for (ClassRef c : interfaceInfo.getSuperInterfaces()) {
            new ClassRefWrite().write(out, c);
        }

        // TODO: Only in 22 Cap File Format
        // new InterfaceNameInfoWrite().write(out, interfaceInfo.getInterfaceNameInfo());
    }
}
