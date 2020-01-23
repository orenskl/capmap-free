package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.HeaderComponent;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeaderComponentWrite extends ComponentWrite {

    private final static Logger logger = LoggerFactory.getLogger(HeaderComponentWrite.class);

    /**
     * Write the header of a cap file object into a cap file
     *
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException
     */
    @Override
    public void write(CapOutputStream out, Component component) throws UnableToWriteCapFileException {

        assert component instanceof HeaderComponent;
        HeaderComponent headerComponent = (HeaderComponent) component;

        super.write(out, headerComponent);
        // magic writing

        logger.trace("writing magic: " + headerComponent.getMagic());
        out.writeInt(headerComponent.getMagic());

        // minor version writing
        logger.trace("write minor version: " + headerComponent.getMinorVersion());
        out.writeByte(headerComponent.getMinorVersion());

        // major version writing
        logger.trace("write minor version: " + headerComponent.getMajorVersion());
        out.writeByte(headerComponent.getMajorVersion());

        // flags writing
        logger.trace("write flags: " + headerComponent.getFlags());
        out.writeByte(headerComponent.getFlags());

        // describes the package defined in this CAP file
        new PackageInfoWrite().write(out, headerComponent.getThePackage());
    }
}
