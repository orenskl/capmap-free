package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ImplementedInterfaceInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class ImplementedInterfaceInfoWrite {


    /**
     * Write the ImplementedInterfaceInfo part of a cap file object into a cap
     * file
     *
     * @param out Cap File Stream
     * @throws java.io.IOException
     */
    public void write(CapOutputStream out, ImplementedInterfaceInfo implementedInterfaceInfo)
            throws UnableToWriteCapFileException {

        new ClassRefWrite().write(out, implementedInterfaceInfo.getTheInterface());
        out.writeByte(implementedInterfaceInfo.getCount());

        for (Byte ind : implementedInterfaceInfo.getIndex()) {
            out.writeByte(ind);
        }

    }
}
