/**
 * ClassDebugInfoRead.java
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

import fr.xlim.ssd.capmanipulator.library.ClassDebugInfo;
import fr.xlim.ssd.capmanipulator.library.FieldDebugInfo;
import fr.xlim.ssd.capmanipulator.library.MethodDebugInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassDebugInfoRead
 *
 * @author Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 */
public class ClassDebugInfoRead {
    private final static Logger logger = LoggerFactory.getLogger(ClassDebugInfoRead.class);

    public ClassDebugInfo load(CapInputStream in) throws UnableToReadCapFileException {

        ClassDebugInfo classDebugInfo = new ClassDebugInfo();

        logger.trace("Class Debug Info");

        // name_index reading
        short name_index = in.readShort();
        logger.trace("name_index: {}", name_index);
        classDebugInfo.setNameIndex(name_index);

        // access_flag reading
        short access_flag = in.readShort();
        logger.trace("access_flag: {}", access_flag);
        classDebugInfo.setAccessFlags(access_flag);

        // location reading
        short location = in.readShort();
        logger.trace("location: {}", location);
        classDebugInfo.setLocation(location);

        // superclass_name_index reading
        short superclass_name_index = in.readShort();
        logger.trace("superclass_name_index: {}", superclass_name_index);
        classDebugInfo.setSuperNameIndex(superclass_name_index);

        // source_file_index reading
        short source_file_index = in.readShort();
        logger.trace("source_file_index: {}", source_file_index);
        classDebugInfo.setSourceFileIndex(source_file_index);

        // interface_count reading
        byte interface_count = in.readByte();
        logger.trace("interface_count: {}", interface_count);
        classDebugInfo.setInterfaceCount(interface_count);

        // field_count reading
        short field_count = in.readShort();
        logger.trace("field_count: {}", field_count);
        classDebugInfo.setFieldCount(field_count);

        // method_count reading
        short method_count = in.readShort();
        logger.trace("method_count: {}", method_count);
        classDebugInfo.setMethodCount(method_count);

        // interface_name_info reading
        for (int i = 0; i < interface_count; ++i) {
            classDebugInfo.getInterfaceNamesIndexes().add(in.readShort());
        }

        logger.trace("Interface Names Indexes", classDebugInfo.getInterfaceNamesIndexes());

        // fields reading
        for (int i = 0; i < field_count; ++i) {
            FieldDebugInfo fieldDebugInfo = new FieldDebugInfoRead().load(in);
            classDebugInfo.getFields().add(fieldDebugInfo);
        }

        // methods reading
        for (int i = 0; i < method_count; ++i) {
            MethodDebugInfo methodDebugInfo = new MethodDebugInfoRead().load(in);
            classDebugInfo.getMethods().add(methodDebugInfo);
        }

        return classDebugInfo;
    }
}
