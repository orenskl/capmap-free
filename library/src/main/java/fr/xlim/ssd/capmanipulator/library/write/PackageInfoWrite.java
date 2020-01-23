package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.PackageInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PackageInfoWrite {

    private final static Logger logger = LoggerFactory.getLogger(PackageInfoWrite.class);

    /**
     * Write the packageInfo part of a cap file object into a cap file
     *
     * @param out Cap File Stream
     * @throws java.io.IOException
     */
    public void write(CapOutputStream out, PackageInfo packageInfo) throws UnableToWriteCapFileException {

        logger.trace("write minor version: " + packageInfo.getMinorVersion());
        out.writeByte(packageInfo.getMinorVersion());
        logger.trace("write major version: " + packageInfo.getMajorVersion());
        out.writeByte(packageInfo.getMajorVersion());

        // AID length reading
        logger.trace("write AID length: " + packageInfo.getAIDLength());
        out.writeByte(packageInfo.getAIDLength());

        // AID reading
        for (int i = 0; i < packageInfo.getAID().size(); i++) {
            out.writeByte(packageInfo.getAID().get(i));
        }
    }
}
