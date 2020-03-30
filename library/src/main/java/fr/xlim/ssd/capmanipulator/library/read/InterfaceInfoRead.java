/**
 * InterfaceInfoRead.java
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

import fr.xlim.ssd.capmanipulator.library.ClassRef;
import fr.xlim.ssd.capmanipulator.library.InterfaceInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

public class InterfaceInfoRead {


    /**
     * read the values of an IntefaceInfo from a cap file and set this
     * values
     *
     * @param in Cap File stream
     * @throws java.io.IOException
     */
    public InterfaceInfo load(byte bitfield, int offset, CapInputStream in) throws UnableToReadCapFileException {

        InterfaceInfo interfaceInfo = new InterfaceInfo();

        interfaceInfo.setOffset(offset);

        interfaceInfo.setBitfield(bitfield);
        // the number of entries entries in the SuperInterfaces array
        // is in the second nibble of the bitField
        byte interfaceCount = (byte) (bitfield & 0x0F);

        // superInterfaces loading
        interfaceInfo.getSuperInterfaces().clear();

        for (int i = 0; i < interfaceCount; i++) {
            ClassRef c = new ClassRefRead().load(in);

            interfaceInfo.getSuperInterfaces().add(c);
        }

        // intefaceNameInfo loading (only if the bit remote is set in the flag)
        // Not in 2.1 file
        /*
        if ((bitfield & ClassComponent.ACC_REMOTE) >>> 5 == ClassComponent.ACC_REMOTE) {
            interfaceInfo.setInterfaceNameInfo(new InterfaceNameInfoRead().load(in));
        }
        {
            interfaceInfo.setInterfaceNameInfo(new InterfaceNameInfo());
        } */

        return interfaceInfo;
    }
}
