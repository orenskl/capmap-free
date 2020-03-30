/**
 * TypeDescriptorReadRead.java
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

import fr.xlim.ssd.capmanipulator.library.TypeDescriptor;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

public class TypeDescriptorRead {

    /**
     * read the values of the TypeDescriptor from a cap file and set this
     * values
     *
     * @param in Cap file stream
     * @throws java.io.IOException
     */
    public TypeDescriptor load(CapInputStream in) throws UnableToReadCapFileException {

        TypeDescriptor typeDescriptor = new TypeDescriptor();

        // nibbleCount reading
        typeDescriptor.setNibbleCount(in.readByte());

        // type array reading
        typeDescriptor.getType().clear();
        // there is (nibbleCount +1)/2 elements in type array
        for (int i = 0; i < (typeDescriptor.getNibbleCount() + 1) / 2; i++) {
            typeDescriptor.getType().add(in.readByte());
        }

        return typeDescriptor;
    }
}
