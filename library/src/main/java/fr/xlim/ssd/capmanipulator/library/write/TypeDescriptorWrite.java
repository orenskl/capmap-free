package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.TypeDescriptor;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class TypeDescriptorWrite {


    /**
     * Write the TypeDescriptor part of a cap file object into a cap file
     *
     * @param out Cap File stream
     * @throws java.io.IOException
     */
    public void write(CapOutputStream out, TypeDescriptor typeDescriptor) throws UnableToWriteCapFileException {

        out.writeByte(typeDescriptor.getNibbleCount());

        for (Byte t : typeDescriptor.getType()) {
            out.writeByte(t);
        }

    }

}
