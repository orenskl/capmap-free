package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ClassRef;
import fr.xlim.ssd.capmanipulator.library.ExternalClassRef;
import fr.xlim.ssd.capmanipulator.library.InternalClassRef;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class ClassRefWrite {

    public void write(CapOutputStream out, ClassRef classRef) throws UnableToWriteCapFileException {
        if (classRef instanceof InternalClassRef) {
            out.writeShort(((InternalClassRef) classRef).getInternalClassRef());
        } else if (classRef instanceof ExternalClassRef) {
            out.writeByte(((ExternalClassRef) classRef).getPackageToken());
            out.writeByte(((ExternalClassRef) classRef).getClassToken());
        } else {
            throw new IllegalArgumentException("expecting internal or external class ref");
        }
    }
}
