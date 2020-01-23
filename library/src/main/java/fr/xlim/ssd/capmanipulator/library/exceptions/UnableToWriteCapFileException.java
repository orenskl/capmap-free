/**
 * UnableToWriteCapFileException.java
 * <p>
 * Author: 2009 Guillaume Bouffard <guillaume.bouffard02@etu.unilim.fr>
 * Author: 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
 * <p>
 * <p>
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 3 of the License, or any later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p>
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package fr.xlim.ssd.capmanipulator.library.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exception raised when an error occured while writing a cap file
 *
 * @author BOUFFARD Guillaume/BOUTET Julien
 */
public class UnableToWriteCapFileException extends Exception {

    private final static Logger logger = LoggerFactory.getLogger(UnableToWriteCapFileException.class);

    public UnableToWriteCapFileException(String string) {
        super(string);
    }

    public UnableToWriteCapFileException(Throwable ex) {
        super(ex);
        logger.error("cannot write cap file", ex);
    }

    public UnableToWriteCapFileException(String element, Throwable ex) {
        super(ex);
        logger.error("cannot write {} in cap file", element, ex);
    }
}
