package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ExtendedMethodHeaderInfo;
import fr.xlim.ssd.capmanipulator.library.MethodHeaderInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class MethodHeaderInfoWrite {

    /**
     * Write the Method Header Info in a cap file
     *
     * @param out Cap File to write
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException
     */
    public void write(CapOutputStream out, MethodHeaderInfo methodHeaderInfo)
            throws UnableToWriteCapFileException {

        if (methodHeaderInfo instanceof ExtendedMethodHeaderInfo) {

            ExtendedMethodHeaderInfo extendedMethodHeaderInfo = (ExtendedMethodHeaderInfo) methodHeaderInfo;

            // write flags and max stack
            out.writeByte((byte) ((extendedMethodHeaderInfo.getFlags() << 4) | extendedMethodHeaderInfo.getPadding()));
            out.writeByte(extendedMethodHeaderInfo.getMaxStack());
            out.writeByte(extendedMethodHeaderInfo.getNargs());
            out.writeByte(extendedMethodHeaderInfo.getMaxLocals());
        } else {
            // write flags and max stack
            out.writeByte((byte) ((methodHeaderInfo.getFlags() << 4) | methodHeaderInfo.getMaxStack()));
            out.writeByte((byte) ((methodHeaderInfo.getNargs() << 4) | methodHeaderInfo.getMaxLocals()));
        }
    }

}
