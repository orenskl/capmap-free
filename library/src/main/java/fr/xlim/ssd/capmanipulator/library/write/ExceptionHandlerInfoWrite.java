package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ExceptionHandlerInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class ExceptionHandlerInfoWrite {


    /**
     * Write the Exception Handler Info in a cap file
     *
     * @param out Cap File to write
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException
     */
    public void write(CapOutputStream out, ExceptionHandlerInfo exceptionHandlerInfo)
            throws UnableToWriteCapFileException {
        // start offset writing
        out.writeShort(exceptionHandlerInfo.getStartOffset());

        // bitfield writing
        out.writeShort(exceptionHandlerInfo.getBitfield());

        // handler offset
        out.writeShort(exceptionHandlerInfo.getHandlerOffset());

        // catch type index
        out.writeShort(exceptionHandlerInfo.getCatchTypeIndex());
    }
}
