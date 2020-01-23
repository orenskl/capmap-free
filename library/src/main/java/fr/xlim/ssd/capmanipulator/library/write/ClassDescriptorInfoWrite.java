package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ClassDescriptorInfo;
import fr.xlim.ssd.capmanipulator.library.ClassRef;
import fr.xlim.ssd.capmanipulator.library.FieldDescriptorInfo;
import fr.xlim.ssd.capmanipulator.library.MethodDescriptorInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class ClassDescriptorInfoWrite {

    /**
     * Write the Class Descriptor Info in a cap file
     *
     * @param out Cap File to write
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException
     */
    public void write(CapOutputStream out, ClassDescriptorInfo classDescriptorInfo) throws UnableToWriteCapFileException {

        // token writing
        out.writeByte(classDescriptorInfo.getToken());

        // access flags writing
        out.writeByte(classDescriptorInfo.getAccesFlags());

        // this class ref writing
        new ClassRefWrite().write(out, classDescriptorInfo.getThisClassRef());

        // interface count writing
        out.writeByte(classDescriptorInfo.getInterfaceCount());

        // field count writing
        out.writeShort(classDescriptorInfo.getFieldCount());

        // method count writing
        out.writeShort(classDescriptorInfo.getMethodCount());

        // interfaces writing
        for (ClassRef c : classDescriptorInfo.getInterfaces()) {
            new ClassRefWrite().write(out, c);
        }

        // fields writing
        for (FieldDescriptorInfo f : classDescriptorInfo.getFields()) {
            new FieldDescriptorInfoWrite().write(out, f);
        }

        // methods writing
        for (MethodDescriptorInfo m : classDescriptorInfo.getMethods()) {
            new MethodDescriptorInfoWrite().write(out, m);
        }
    }
}
