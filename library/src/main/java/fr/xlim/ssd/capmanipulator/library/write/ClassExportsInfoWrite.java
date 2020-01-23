package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ClassExportsInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class ClassExportsInfoWrite {

    /**
     * Write the Export Component in a cap file
     *
     * @param out Cap File to write
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException
     */
    public void write(CapOutputStream out, ClassExportsInfo classExportsInfo) throws UnableToWriteCapFileException {

        //Class offset writing
        out.writeShort(classExportsInfo.getClassOffset());

        //Static field count
        out.writeByte(classExportsInfo.getStaticFieldCount());

        //Static method count
        out.writeByte(classExportsInfo.getStaticMethodCount());

        //Static field offsets
        for (short f : classExportsInfo.getStaticFieldOffsets()) {
            out.writeShort(f);
        }

        //Static field offsets
        for (short m : classExportsInfo.getStaticMethodOffsets()) {
            out.writeShort(m);
        }
    }
}
