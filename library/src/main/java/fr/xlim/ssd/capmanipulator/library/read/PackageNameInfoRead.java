/**
 * PackageNameInfoRead.java
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

import fr.xlim.ssd.capmanipulator.library.PackageNameInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

public class PackageNameInfoRead {

    /**
     * read the PackageNameInfo part of a cap file set the values of
     * PackageNameInfo
     *
     * @throws java.io.IOException
     */
    public PackageNameInfo load(CapInputStream in) throws UnableToReadCapFileException {

        PackageNameInfo packageNameInfo = new PackageNameInfo();

        // nameLength reading
        packageNameInfo.setNameLength(in.readByte());

        // name reading
        packageNameInfo.getName().clear();

        for (byte i = 0; i < packageNameInfo.getNameLength(); i++) {
            packageNameInfo.getName().add(in.readByte());
        }

        return packageNameInfo;
    }
}
