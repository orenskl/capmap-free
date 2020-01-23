package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.MethodInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class MethodInfoWrite {


    /**
     * Write the Method Info in a cap file
     *
     * @param out Cap File to write
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException
     */
    public void write(CapOutputStream out, MethodInfo methodInfo)
            throws UnableToWriteCapFileException {
        // method header
        new MethodHeaderInfoWrite().write(out, methodInfo.getMethodHeader());

        // Bytecode writing
        for (byte b : methodInfo.getBytecodes()) {
            out.writeByte(b);
        }
    }
}
