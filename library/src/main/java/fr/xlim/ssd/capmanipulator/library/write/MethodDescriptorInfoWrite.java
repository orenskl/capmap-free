package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.MethodDescriptorInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class MethodDescriptorInfoWrite {


    /**
     * Write the Method Descriptor Info in a cap file
     *
     * @param out Cap File to write
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException
     */
    public void write(CapOutputStream out, MethodDescriptorInfo methodDescriptorInfo)
            throws UnableToWriteCapFileException {
        // token writing
        out.writeByte(methodDescriptorInfo.getToken());

        // access_flag
        out.writeByte(methodDescriptorInfo.getAccessFlags());

        // method offset
        out.writeShort(methodDescriptorInfo.getMethodOffset());

        // type offset writing
        out.writeShort(methodDescriptorInfo.getTypeOffset());

        // bytecode count
        out.writeShort(methodDescriptorInfo.getBytecodeCount());

        // exception handler count
        out.writeShort(methodDescriptorInfo.getExceptionHandlerCount());

        // exception handler index
        out.writeShort(methodDescriptorInfo.getExceptionHandlerIndex());
    }

}
