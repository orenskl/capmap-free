/**
 * ComponentRead.java
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

import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ComponentRead implements ReadableComponent {

    private final static Logger logger = LoggerFactory.getLogger(ComponentRead.class);

    /**
     * read the tag and the size of a cap file componentTab set the values of tag
     * and size
     *
     * @param tag tag componentTab
     * @param in  cap file stream
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException
     *
     */
    protected void load(byte tag, CapInputStream in, Component component) throws UnableToReadCapFileException {
        component.setTag(tag);
        logger.trace("component tag: {}", tag);
        short size = in.readShort();
        logger.trace("component size: {}", size);
        component.setSize(size);
    }

    protected void checkSize(CapInputStream stream, Component component) throws UnableToReadCapFileException {
        // we check that the number of byte Read is the same that size
        if (stream.getByteRead() != component.getSize()) {
            logger.error("element size ({}) different from size read ({})", component.getSize(), stream.getByteRead());
            throw new UnableToReadCapFileException("element size different from size read");
        }
    }
}
