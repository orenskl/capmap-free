package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ExtendedMethodHeaderInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class ExtendedMethodHeaderInfoWrite {

    protected void write(CapOutputStream out, ExtendedMethodHeaderInfo extendedMethodHeaderInfo) throws UnableToWriteCapFileException {
        // write flags and max stack
        out.writeByte((byte) ((extendedMethodHeaderInfo.getFlags() << 4) | extendedMethodHeaderInfo.getMaxStack()));

        // max_locals writing
        out.writeByte(extendedMethodHeaderInfo.getMaxStack());

        // nargs writing
        out.writeByte(extendedMethodHeaderInfo.getNargs());

        // max_local writing
        out.writeByte(extendedMethodHeaderInfo.getMaxLocals());
    }
}
