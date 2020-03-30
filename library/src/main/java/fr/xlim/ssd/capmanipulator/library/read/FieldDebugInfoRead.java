/**
 * FieldDebugInfoRead.java
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

import fr.xlim.ssd.capmanipulator.library.FieldDebugInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FieldDebugInfo
 * <p/>
 * describes a field in a class. It can describe either an instance
 * field, a static field or a constant (primitive final static) field
 *
 * @author Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 */
public class FieldDebugInfoRead {
    private final static Logger logger = LoggerFactory.getLogger(ClassDebugInfoRead.class);

    public FieldDebugInfo load(CapInputStream in) throws UnableToReadCapFileException {

        FieldDebugInfo fieldDebugInfo = new FieldDebugInfo();

        logger.trace("Field Debug Info");

        // name_index reading
        short name_index = in.readShort();
        logger.trace("name_index: {}", name_index);
        fieldDebugInfo.setNameIndex(name_index);

        // descriptor_index reading
        short descriptor_index = in.readShort();
        logger.trace("descriptor_index: {}", descriptor_index);
        fieldDebugInfo.setDescriptorIndex(descriptor_index);

        // access_flag reading
        short access_flag = in.readShort();
        logger.trace("access_flag: {}", access_flag);
        fieldDebugInfo.setAccessFlags(access_flag);

        // contents reading
        int contents = in.readInt();
        logger.trace("contents: {}", contents);
        fieldDebugInfo.setContents(contents);

        /*

        // field_debug_info reading
        if (((access_flag & FieldDebugInfo.ACC_PUBLIC) > 0)
            || ((access_flag & FieldDebugInfo.ACC_PRIVATE) > 0)
            || ((access_flag & FieldDebugInfo.ACC_PROTECTED) > 0)) {
                logger.trace("The field is an instance");
                // pad1 reading
                byte pad1 = in.readByte();
                logger.trace("pad1: {}", pad1);

                // pad2 reading
                byte pad2 = in.readByte();
                logger.trace("pad2: {}", pad2);

                // pad3 reading
                byte pad3 = in.readByte();
                logger.trace("pad3: {}", pad3);

                // token reading
                byte token = in.readByte();
                logger.trace("token: {}", token);
                fieldDebugInfo.setToken_var(pad1, pad2, pad3, token);
        }
        if ((access_flag & !FieldDebugInfo.ACC_FINAL & FieldDebugInfo.ACC_STATIC) != 0) {
                logger.trace("The field is a non-final static");

                // pad reading
                short pad = in.readShort();
                logger.trace("pad: {}", pad);

                // location reading
                short location = in.readShort();
                logger.trace("location: {}", location);

                fieldDebugInfo.setLocation_var(pad, location);
        }

        if ((access_flag & FieldDebugInfo.ACC_FINAL & FieldDebugInfo.ACC_STATIC) != 0) {
                logger.trace("The field is static or a type byte, boolean, short or int");

                fieldDebugInfo.setConstValue(in.readInt());
        }*/


        return fieldDebugInfo;
    }
}
