/**
 * LineInfoRead.java
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
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LineInfoRead
 *
 * @author Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 */
public class LineInfoRead {
    private final static Logger logger = LoggerFactory.getLogger(LineInfoRead.class);

    public LineInfo load(CapInputStream in) throws UnableToReadCapFileException {

        LineInfo lineInfo = new LineInfo();

        logger.trace("Line Info");

        // start_pc reading
        short start_pc = in.readShort();
        logger.trace("start_pc: {}", start_pc);
        lineInfo.setStartPc(start_pc);

        // end_pc reading
        short end_pc = in.readShort();
        logger.trace("end_pc: {}", end_pc);
        lineInfo.setEndPc(end_pc);

        // source_line reading
        short source_line = in.readShort();
        logger.trace("source_line: {}", source_line);
        lineInfo.setSourceLine(source_line);

        return lineInfo;

    }
}
