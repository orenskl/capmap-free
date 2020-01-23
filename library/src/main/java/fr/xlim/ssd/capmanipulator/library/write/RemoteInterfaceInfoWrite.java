package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ClassRef;
import fr.xlim.ssd.capmanipulator.library.RemoteInterfaceInfo;
import fr.xlim.ssd.capmanipulator.library.RemoteMethodInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class RemoteInterfaceInfoWrite {

    /**
     * Write the RemoteInterfaceInfo part of a cap file object into a cap file
     *
     * @param out Cap File Stream
     * @throws java.io.IOException
     */
    public void write(CapOutputStream out, RemoteInterfaceInfo remoteInterfaceInfo) throws UnableToWriteCapFileException {

        out.writeByte(remoteInterfaceInfo.getRemoteMethodsCount());

        for (RemoteMethodInfo remoteMeth : remoteInterfaceInfo.getRemoteMethods()) {
            new RemoteMethodInfoWrite().write(out, remoteMeth);
        }

        out.writeByte(remoteInterfaceInfo.getHashModifierLength());

        for (Byte hashM : remoteInterfaceInfo.getHashModifier()) {
            out.writeByte(hashM);
        }

        out.writeByte(remoteInterfaceInfo.getClassNameLength());

        for (Byte classN : remoteInterfaceInfo.getClassName()) {
            out.writeByte(classN);
        }

        out.writeByte(remoteInterfaceInfo.getRemoteInterfacesCount());

        for (ClassRef cRef : remoteInterfaceInfo.getRemoteInterfaces()) {
            new ClassRefWrite().write(out, cRef);
        }

    }
}
