/**
 * UnableToReadCapFileException.java
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

package fr.xlim.ssd.capmanipulator.library.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exception raised when an error occured while reading a cap file
 *
 * @author BOUFFARD Guillaume/BOUTET Julien
 */
public class UnableToReadCapFileException extends Exception {

    private final static Logger logger = LoggerFactory.getLogger(UnableToReadCapFileException.class);

    public UnableToReadCapFileException(String string) {
        super(string);
    }

    public UnableToReadCapFileException(Throwable ex) {
        super(ex);
        logger.error("cannot read cap file", ex);
    }

    public UnableToReadCapFileException(String element, Throwable ex) {
        super(ex);
        logger.error("cannot read {} in cap file", element, ex);
    }
}
