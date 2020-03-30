/**
 * VariableInfoRead.java
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

import fr.xlim.ssd.capmanipulator.library.VariableInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * VariableInfoRead
 *
 * @author Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 */
public class VariableInfoRead {

    private final static Logger logger = LoggerFactory.getLogger(VariableInfoRead.class);

    public VariableInfo load(CapInputStream in) throws UnableToReadCapFileException {

        VariableInfo variableInfo = new VariableInfo();

        logger.trace("Variable Info");

        // index reading
        byte index = in.readByte();
        logger.trace("index: {}", index);
        variableInfo.setIndex(index);

        // name_index reading
        short name_index = in.readShort();
        logger.trace("name_index: {}", name_index);
        variableInfo.setNameIndex(name_index);

        // description_index reading
        short description_index = in.readShort();
        logger.trace("description_index: {}", description_index);
        variableInfo.setNameIndex(description_index);

        // start_pc reading
        short start_pc = in.readShort();
        logger.trace("start_pc: {}", start_pc);
        variableInfo.setStartPc(start_pc);

        // length reading
        short length = in.readShort();
        logger.trace("length: {}", length);
        variableInfo.setLength(length);

        return variableInfo;
    }

}
