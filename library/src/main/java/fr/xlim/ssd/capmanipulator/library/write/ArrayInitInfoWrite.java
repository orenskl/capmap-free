package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ArrayInitInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class ArrayInitInfoWrite {

    /**
     * Write the Array Init Info in a cap file
     *
     * @param out Cap File to write
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException
     */
    public void write(CapOutputStream out, ArrayInitInfo arrayInitInfo) throws UnableToWriteCapFileException {
        // type writing
        out.writeByte(arrayInitInfo.getType());

        // count writing
        out.writeShort(arrayInitInfo.getCount());

        // values writing
        for (byte v : arrayInitInfo.getValues()) {
            out.writeByte(v);
        }
    }
}
