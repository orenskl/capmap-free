package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.CapApplet;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class CapAppletWrite {

    /**
     * Write the applet part of a cap file object into a cap file
     *
     * @param out stream to writing cap file
     * @throws java.io.IOException
     */
    public void write(CapOutputStream out, CapApplet capApplet) throws UnableToWriteCapFileException {
        out.writeByte(capApplet.getAidLength());

        for (Byte anAid : capApplet.getAid()) {
            out.writeByte(anAid);
        }

        out.writeShort(capApplet.getInstallMethodOffset());
    }

}
