package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.CustomComponentInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class CustomComponentInfoWrite {


    /**
     * Write the packageNameInfo part of a cap file object into a cap file
     *
     * @param out Cap File Stream
     * @throws java.io.IOException
     */
    public void write(CapOutputStream out, CustomComponentInfo customComponentInfo) throws UnableToWriteCapFileException {
        out.writeByte(customComponentInfo.getComponentTag());
        out.writeShort(customComponentInfo.getSize());
        out.writeByte(customComponentInfo.getAidLength());

        for (int i = 0; i < customComponentInfo.getAidLength(); i++) {
            out.writeByte(customComponentInfo.getAid().get(i));
        }
    }
}
