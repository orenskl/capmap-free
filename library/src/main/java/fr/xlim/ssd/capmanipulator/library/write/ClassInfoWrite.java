package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ClassComponent;
import fr.xlim.ssd.capmanipulator.library.ClassInfo;
import fr.xlim.ssd.capmanipulator.library.ImplementedInterfaceInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class ClassInfoWrite {

    /**
     * Write the ClassInfo part of a cap file object into a cap file
     *
     * @param out Cap File stream
     * @throws java.io.IOException
     */
    public void write(CapOutputStream out, ClassInfo classInfo) throws UnableToWriteCapFileException {

        out.writeByte(classInfo.getFlags());
        new ClassRefWrite().write(out, classInfo.getSuperClassRef());
        out.writeByte(classInfo.getDeclaredInstanceSize());
        out.writeByte(classInfo.getFirstReferenceToken());
        out.writeByte(classInfo.getReferenceCount());
        out.writeByte(classInfo.getPublicMethodTableBase());
        out.writeByte(classInfo.getPublicMethodTableCount());
        out.writeByte(classInfo.getPackageMethodTableBase());
        out.writeByte(classInfo.getPackageMethodTableCount());

        for (Short virtTab : classInfo.getPublicVirtualMethodTable()) {
            out.writeShort(virtTab);
        }

        for (Short pckVirtTab : classInfo.getPackageVirtualMethodTable()) {
            out.writeShort(pckVirtTab);
        }

        for (ImplementedInterfaceInfo impInf : classInfo.getInterfaces()) {
            new ImplementedInterfaceInfoWrite().write(out, impInf);
        }

        // remoteInterfaces writing
        // only if the ACC_REMOTE flag has the value 0

        if ((classInfo.getFlags() & ClassComponent.ACC_REMOTE) == ClassComponent.ACC_REMOTE) {
            new RemoteInterfaceInfoWrite().write(out, classInfo.getRemoteInterfacesInfo());
        }
    }
}
