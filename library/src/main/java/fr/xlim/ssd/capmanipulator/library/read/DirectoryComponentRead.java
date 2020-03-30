/**
 * DirectoryComponentRead.java
 * <p/>
 * Author: 2009 Guillaume Bouffard <guillaume.bouffard02@etu.unilim.fr>
 * Author: 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
 * Author: 2012 Julien Iguchi-Cartigny <julien.cartigny@xlim.fr>
 * <p/>
 * <p/>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */

package fr.xlim.ssd.capmanipulator.library.read;

import fr.xlim.ssd.capmanipulator.library.*;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class DirectoryComponentRead extends ComponentRead {

    private final static Logger logger = LoggerFactory.getLogger(DirectoryComponentRead.class);

    @Override
    public Component load(CapInputStream in) throws UnableToReadCapFileException {

        DirectoryComponent directoryComponent = new DirectoryComponent();

        // tag and size reading
        super.load((byte) ComponentEnum.DIRECTORY_COMPONENT.getValue(), in, directoryComponent);

        // we reset the count of byte read to zero
        in.resetCount();

        // number of bytes in each of the 12 components in the CAP file
        directoryComponent.setComponentSize(new ArrayList<Short>());
        directoryComponent.setStaticFieldSize(new StaticFieldSizeInfo());
        directoryComponent.setCustomComponent(new ArrayList<CustomComponentInfo>());

        // componentSizes reading
        int componentNumber = DirectoryComponent.COMPONENT_NUMBER_21;

        if (CapFileRead.getCapFile() != null) {
            int minorVersion = CapFileRead.getCapFile().getHeaderComponent().getMinorVersion();
            componentNumber = (minorVersion == 1 ? DirectoryComponent.COMPONENT_NUMBER_21 : DirectoryComponent.COMPONENT_NUMBER_22);
        }

        for (int i = 0; i < componentNumber; i++) {
            short size = in.readShort();
            logger.trace("component number {} has size {}", i, size);
            directoryComponent.getComponentSize().add(size);
        }

        // staticFieldSize reading
        directoryComponent.setStaticFieldSize(new StaticFieldSizeInfoRead().load(in));

        // importCount reading
        directoryComponent.setImportCount(in.readByte());
        logger.trace("import count: {}", directoryComponent.getImportCount());

        // appletCount reading
        directoryComponent.setAppletCount(in.readByte());
        logger.trace("applet count: {}", directoryComponent.getAppletCount());

        // customCount reading
        directoryComponent.setCustomCount(in.readByte());
        logger.trace("custom count: {}", directoryComponent.getCustomCount());

        // customComponents reading
        logger.debug("===>> " + directoryComponent.getCustomCount());
        for (byte i = 0; i < directoryComponent.getCustomCount(); i++) {
            CustomComponentInfo customComp = new CustomComponentInfoRead().load(in);
            directoryComponent.getCustomComponent().add(customComp);
        }

        checkSize(in, directoryComponent);

        return directoryComponent;
    }
}
