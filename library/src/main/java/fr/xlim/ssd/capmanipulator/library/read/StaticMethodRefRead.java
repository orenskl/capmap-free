/**
 * StaticMethodRefRead.java
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

import fr.xlim.ssd.capmanipulator.library.ExternalStaticMethodRef;
import fr.xlim.ssd.capmanipulator.library.InternalStaticMethodRef;
import fr.xlim.ssd.capmanipulator.library.StaticMethodRef;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

public class StaticMethodRefRead {

    /**
     * read the values of the StaticMethodRef from a cap file
     * and set this values
     *
     * @param in Cap File Stream
     * @return a StaticMethodRef object (internal or external classref)
     * @throws java.io.IOException
     */
    public StaticMethodRef load(CapInputStream in) throws UnableToReadCapFileException {
        StaticMethodRef staticMethodRef;
        Byte buf = in.readByte();

        //if the most significant bit is 0 it's an internalStaticMethoddRef
        if ((buf % (Math.pow(2, 16) - 1)) == 0) {
            staticMethodRef = new InternalStaticMethodRef();
            ((InternalStaticMethodRef) staticMethodRef).setPadding(buf);
            ((InternalStaticMethodRef) staticMethodRef).setOffset(in.readShort());

        } else {
            //case of an externalStaticMethodRef
            staticMethodRef = new ExternalStaticMethodRef();
            ((ExternalStaticMethodRef) staticMethodRef).setPackageToken(buf);
            ((ExternalStaticMethodRef) staticMethodRef).setClassToken(in.readByte());
            ((ExternalStaticMethodRef) staticMethodRef).setToken(in.readByte());

        }

        return staticMethodRef;
    }
}
