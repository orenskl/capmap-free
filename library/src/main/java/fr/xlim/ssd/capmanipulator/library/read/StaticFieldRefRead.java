/**
 * StaticFieldRefRead.java
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

import fr.xlim.ssd.capmanipulator.library.ExternalStaticFieldRef;
import fr.xlim.ssd.capmanipulator.library.InternalStaticFieldRef;
import fr.xlim.ssd.capmanipulator.library.StaticFieldRef;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

public class StaticFieldRefRead {

    /**
     * read the values of the StaticFieldRef from a cap file
     * and set this values
     *
     * @param in Cap File Stream
     * @return a StaticFieldRef object (internal or external classref)
     * @throws java.io.IOException
     */
    public StaticFieldRef load(CapInputStream in)
            throws UnableToReadCapFileException {
        StaticFieldRef staticFieldRef;
        Byte buf = in.readByte();

        //if the most significant bit is 0 it's an internalStaticFieldRef
        if ((buf & 0x80) == 0) {
            short offset = in.readShort();
            staticFieldRef = new InternalStaticFieldRef();
            ((InternalStaticFieldRef) staticFieldRef).setPadding(buf);
            ((InternalStaticFieldRef) staticFieldRef).setOffset(offset);

        } else {
            //case of an externalStaticFieldRef
            staticFieldRef = new ExternalStaticFieldRef();

            ((ExternalStaticFieldRef) staticFieldRef).setPackageToken(buf);
            ((ExternalStaticFieldRef) staticFieldRef).setClassToken(in.readByte());
            ((ExternalStaticFieldRef) staticFieldRef).setToken(in.readByte());

        }

        return staticFieldRef;
    }

}
