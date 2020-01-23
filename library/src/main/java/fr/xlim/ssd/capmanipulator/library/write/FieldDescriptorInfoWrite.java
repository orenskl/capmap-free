package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.FieldDescriptorInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class FieldDescriptorInfoWrite {


    /**
     * Write the Field Descriptor Info in a cap file
     *
     * @param out Cap File to write
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException
     */
    public void write(CapOutputStream out, FieldDescriptorInfo fieldDescriptorInfo) throws UnableToWriteCapFileException {
        // token writing
        out.writeByte(fieldDescriptorInfo.getToken());

        // access flags
        out.writeByte(fieldDescriptorInfo.getAccessFlags());

        // field ref writinf
        new FieldRefWrite().write(out, fieldDescriptorInfo.getFieldRef());

        // type writing
        out.writeShort(fieldDescriptorInfo.getType());
    }
}
