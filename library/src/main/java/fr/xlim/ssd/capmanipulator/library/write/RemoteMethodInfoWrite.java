package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.RemoteMethodInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class RemoteMethodInfoWrite {

    /**
     * Write the RemoteMethodInfo part of a cap file object into a cap file
     *
     * @param out Cap File Stream
     */
    public void write(CapOutputStream out, RemoteMethodInfo remoteMethodInfo) throws UnableToWriteCapFileException {

        out.writeShort(remoteMethodInfo.getRemoteMethodHash());
        out.writeShort(remoteMethodInfo.getSignatureOffset());
        out.writeShort(remoteMethodInfo.getVirtualMethodToken());
    }
}
