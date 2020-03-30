/**
 * MethodDebugInfoRead.java
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

import fr.xlim.ssd.capmanipulator.library.LineInfo;
import fr.xlim.ssd.capmanipulator.library.MethodDebugInfo;
import fr.xlim.ssd.capmanipulator.library.VariableInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MethodDebugInfoRead
 *
 * @author Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 */
public class MethodDebugInfoRead {
    private final static Logger logger = LoggerFactory.getLogger(MethodDebugInfo.class);

    public MethodDebugInfo load(CapInputStream in) throws UnableToReadCapFileException {

        MethodDebugInfo methodDebugInfo = new MethodDebugInfo();

        logger.trace("Method Debug Info");

        // name_index reading
        short name_index = in.readShort();
        logger.trace("name_index: {}", name_index);
        methodDebugInfo.setNameIndex(name_index);

        // descriptor_index reading
        short descriptor_index = in.readShort();
        logger.trace("descriptor_index: {}", descriptor_index);
        methodDebugInfo.setDescriptorIndex(descriptor_index);

        // access_flag reading
        short access_flag = in.readShort();
        logger.trace("access_flag: {}", access_flag);
        methodDebugInfo.setAccessFlags(access_flag);

        // location reading
        short location = in.readShort();
        logger.trace("location: {}", location);
        methodDebugInfo.setLocation(location);

        // header_size reading
        byte header_size = in.readByte();
        logger.trace("header_size: {}", header_size);
        methodDebugInfo.setHeaderSize(header_size);

        // Body_size reading
        short body_size = in.readShort();
        logger.trace("body_size: {}", body_size);
        methodDebugInfo.setBodySize(body_size);

        // variable_count reading
        short variable_count = in.readShort();
        logger.trace("variable_count: {}", variable_count);
        methodDebugInfo.setVariableCount(variable_count);

        // line_count reading
        short line_count = in.readShort();
        logger.trace("line_count: {}", line_count);
        methodDebugInfo.setLineCount(line_count);

        // variable table reading
        for (int i = 0; i < variable_count; ++i) {
            VariableInfo variableInfo = new VariableInfoRead().load(in);
            methodDebugInfo.getVariableTable().add(variableInfo);
        }

        // line table reading
        for (int i = 0; i < line_count; ++i) {
            LineInfo lineInfo = new LineInfoRead().load(in);
            methodDebugInfo.getLineTable().add(lineInfo);
        }

        return methodDebugInfo;
    }
}
