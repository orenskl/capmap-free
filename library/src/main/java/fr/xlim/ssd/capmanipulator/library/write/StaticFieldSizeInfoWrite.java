package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.StaticFieldSizeInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class StaticFieldSizeInfoWrite {

    /**
     * Write the packageNameInfo part of a cap file object into a cap file
     *
     * @param out Cap File Stream
     * @throws java.io.IOException
     */
    public void write(CapOutputStream out, StaticFieldSizeInfo staticFieldSizeInfo) throws UnableToWriteCapFileException {
        out.writeShort(staticFieldSizeInfo.getImageSize());
        out.writeShort(staticFieldSizeInfo.getArrayInitCount());
        out.writeShort(staticFieldSizeInfo.getArrayInitSize());
    }
}
