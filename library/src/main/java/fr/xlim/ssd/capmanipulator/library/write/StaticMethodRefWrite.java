package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ExternalStaticMethodRef;
import fr.xlim.ssd.capmanipulator.library.InternalStaticMethodRef;
import fr.xlim.ssd.capmanipulator.library.StaticMethodRef;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class StaticMethodRefWrite {

    public void write(CapOutputStream out, StaticMethodRef staticMethodRef) throws UnableToWriteCapFileException {
        if (staticMethodRef instanceof InternalStaticMethodRef) {
            InternalStaticMethodRef internalStaticMethodRef = (InternalStaticMethodRef) staticMethodRef;
            out.writeByte(internalStaticMethodRef.getPadding());
            out.writeShort(internalStaticMethodRef.getOffset());
        } else if (staticMethodRef instanceof ExternalStaticMethodRef) {
            ExternalStaticMethodRef externalStaticMethodRef = (ExternalStaticMethodRef) staticMethodRef;
            out.writeByte(externalStaticMethodRef.getPackageToken());
            out.writeByte(externalStaticMethodRef.getClassToken());
            out.writeByte(externalStaticMethodRef.getToken());
        } else {
            throw new IllegalArgumentException("expecting internal or external method static ref");
        }
    }
}
