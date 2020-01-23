package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.TypeDescriptor;
import fr.xlim.ssd.capmanipulator.library.TypeDescriptorInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

import java.util.Map;

public class TypeDescriptorInfoWrite {

    /**
     * Write the Type Descriptor Info in a cap file
     *
     * @param out Cap File to write
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException
     */
    public void write(CapOutputStream out, TypeDescriptorInfo typeDescriptorInfo)
            throws UnableToWriteCapFileException {
        // constant pool count
        out.writeShort(typeDescriptorInfo.getConstantPoolCount());

        // constant pool types
        for (short s : typeDescriptorInfo.getConstantPoolTypes()) {
            out.writeShort(s);
        }

        // type desc
        for (Map.Entry<Short, TypeDescriptor> entry : typeDescriptorInfo.getTypeDesc().entrySet()) {
            new TypeDescriptorWrite().write(out, entry.getValue());
        }

        /*
        // Writing the last element
        for (Map.Entry<Short, TypeDescriptor> e : typeDescriptorInfo.getTypeDesc().entrySet()) {
            new TypeDescriptorWrite().write(out, typeDescriptorInfo.getTypeDesc().get(e.getKey()));
        } */
    }

}
