package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ExternalStaticFieldRef;
import fr.xlim.ssd.capmanipulator.library.InternalStaticFieldRef;
import fr.xlim.ssd.capmanipulator.library.StaticFieldRef;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class StaticFieldRefWrite {

    public void write(CapOutputStream out, StaticFieldRef staticFieldRef) throws UnableToWriteCapFileException {
        if (staticFieldRef instanceof ExternalStaticFieldRef) {
            ExternalStaticFieldRef externalStaticFieldRef = (ExternalStaticFieldRef) staticFieldRef;
            out.writeByte(externalStaticFieldRef.getPackageToken());
            out.writeByte(externalStaticFieldRef.getClassToken());
            out.writeByte(externalStaticFieldRef.getToken());
        } else if (staticFieldRef instanceof InternalStaticFieldRef) {
            InternalStaticFieldRef internalStaticFieldRef = (InternalStaticFieldRef) staticFieldRef;
            out.writeByte(internalStaticFieldRef.getPadding());
            out.writeShort(internalStaticFieldRef.getOffset());
        } else {
            throw new IllegalArgumentException("expecting internal or external static field ref");
        }
    }
}
