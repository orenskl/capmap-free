/**
 * StaticFieldSizeInfoRead.java
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

import fr.xlim.ssd.capmanipulator.library.StaticFieldSizeInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticFieldSizeInfoRead {

    private final static Logger logger = LoggerFactory.getLogger(StaticFieldSizeInfoRead.class);

    /**
     * read the StaticFieldSizeInfo part of a cap file to set the values of the
     * StaticFieldSizeInfo
     *
     * @throws java.io.IOException
     */
    public StaticFieldSizeInfo load(CapInputStream in) throws UnableToReadCapFileException {

        StaticFieldSizeInfo staticFieldSizeInfo = new StaticFieldSizeInfo();

        // image size reading
        staticFieldSizeInfo.setImageSize(in.readShort());
        logger.trace("image size: {}", staticFieldSizeInfo.getImageSize());

        // array_init_count reading
        staticFieldSizeInfo.setArrayInitCount(in.readShort());
        logger.trace("array init count: {}", staticFieldSizeInfo.getArrayInitCount());

        // array_init_size
        staticFieldSizeInfo.setArrayInitSize(in.readShort());
        logger.trace("array init size: {}", staticFieldSizeInfo.getArrayInitSize());

        return staticFieldSizeInfo;
    }
}
