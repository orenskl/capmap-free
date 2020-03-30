/**
 * ClassRefRead.java
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

import fr.xlim.ssd.capmanipulator.library.ClassRef;
import fr.xlim.ssd.capmanipulator.library.ExternalClassRef;
import fr.xlim.ssd.capmanipulator.library.InternalClassRef;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

public class ClassRefRead {

    /**
     * read the values of the classRef from a cap file and set this values
     *
     * @param in Cap File Stream
     * @return a ClassRef object (internal or external classref)
     * @throws java.io.IOException
     */
    public ClassRef load(CapInputStream in) throws UnableToReadCapFileException {

        ClassRef classRef;
        Short buf = in.readShort();

        // if the most significant bit is 0 it's a internal class ref
        if ((buf & 0x8000) >>> 15 == 0) {
            classRef = new InternalClassRef();
            ((InternalClassRef) classRef).setInternalClassRef(buf);
        } else {
            // case of an external class ref
            classRef = new ExternalClassRef();
            ((ExternalClassRef) classRef).setClassToken(buf.byteValue());
            buf = Short.reverseBytes(buf);
            ((ExternalClassRef) classRef).setPackageToken(buf.byteValue());
        }

        return classRef;
    }
}
