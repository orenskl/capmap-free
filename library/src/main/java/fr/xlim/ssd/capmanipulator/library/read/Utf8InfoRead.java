/**
 * UTF8_info.java
 * <p>
 * Copyright (C) 2009 Guillaume Bouffard <guillaume.bouffard02@etu.unilim.fr>
 * Copyright (C) 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
 * Copyright (C) 2012 Julien Iguchi-Cartigny <julien.cartigny@xlim.fr>
 * <p>
 * Xlim - Université de Limoges
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

import fr.xlim.ssd.capmanipulator.library.Utf8Info;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import fr.xlim.ssd.capmanipulator.library.tool.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utf8InfoRead
 *
 * @author Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 */
public class Utf8InfoRead {

    private final static Logger logger = LoggerFactory.getLogger(DebugComponentRead.class);

    public Utf8Info load(CapInputStream in) throws UnableToReadCapFileException {
        Utf8Info utf8Info = new Utf8Info();

        //logger.debug(LogType.DEBUG_COMPONENT.getMarker(), "String length: " + (utf8Info.getLength() + 0x00FFFF));

        short length = in.readShort();
        logger.trace("UTF8 Length: {}", length);
        utf8Info.setLength(length);

        for (int i = 0; i < length; ++i) {
            utf8Info.getBytes().add(in.readByte());
        }
        logger.trace("UTF8 String: {}", Converter.StringRepresentation(utf8Info.getBytes()));

        return utf8Info;
    }
}
