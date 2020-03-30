/**
 * DebugComponentRead.java
 * <p>
 * Author: 2009 Guillaume Bouffard <guillaume.bouffard02@etu.unilim.fr>
 * Author: 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
 * Author: 2012 Julien Iguchi-Cartigny <julien.cartigny@xlim.fr>
 * <p>
 * <p>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */

package fr.xlim.ssd.capmanipulator.library.read;

import fr.xlim.ssd.capmanipulator.library.*;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import fr.xlim.ssd.capmanipulator.library.logging.LogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DebugComponentRead extends ComponentRead {

    private final static Logger logger = LoggerFactory.getLogger(DebugComponentRead.class);

    /**
     * read the debug part of a cap file to set the values of the DebugComponent
     *
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException
     *
     */
    @Override
    public Component load(CapInputStream in) throws UnableToReadCapFileException {

        DebugComponent debugComponent = new DebugComponent();

        // we first read tag and size
        super.load((byte) ComponentEnum.DEBUG_COMPONENT.getValue(), in, debugComponent);

        logger.debug(LogType.DEBUG_COMPONENT.getMarker(), "Component size: " + (debugComponent.getSize() + 0x00FFFF));

        logger.info(LogType.DEBUG_COMPONENT.getMarker(), "WARNING: The Debug Component is not still implemened!");

        // we reset the count of byte read to zero
        in.resetCount();

        byte size2jump = in.readByte();

        logger.trace("size2jump: {}", size2jump);

        for (int i = 0; i < (size2jump + 2); ++i) {
            logger.trace("Byte Jumped: 0x" + Integer.toHexString(in.readByte() & 0x0FF));
        }

        // string_count reading
        short string_count = in.readShort();
        logger.trace("string_count: {}", string_count);
        debugComponent.setStringCount(string_count);

        // strings_table reading
        for (int i = 0; i < string_count; ++i) {
            Utf8Info utf8Info = new Utf8InfoRead().load(in);
            debugComponent.getStringsTable().add(utf8Info);
        }

        // package_name_index reading
        short package_name_index = in.readShort();
        logger.trace("package_name_index: {}", package_name_index);
        debugComponent.setPackageNameIndex(package_name_index);

        // class_count reading
        short class_count = in.readShort();
        logger.trace("class_count: {}", class_count);
        debugComponent.setPackageNameIndex(class_count);

        // classes reading
        for (int i = 0; i < class_count; ++i) {
            ClassDebugInfo classDebugInfo = new ClassDebugInfoRead().load(in);
            debugComponent.getClasses().add(classDebugInfo);
        }

        checkSize(in, debugComponent);

        return debugComponent;
    }

}
