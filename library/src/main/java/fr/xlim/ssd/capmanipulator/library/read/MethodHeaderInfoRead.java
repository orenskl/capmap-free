/**
 * MethodHeaderInfoRead.java
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

import fr.xlim.ssd.capmanipulator.library.MethodHeaderInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

public class MethodHeaderInfoRead {

    /**
     * read the MethodHeaderInfo a cap file to set the values of the
     * Method Header Info
     *
     * @param in Cap File to read
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException
     *
     */
    public MethodHeaderInfo load(CapInputStream in, byte bitfield) throws UnableToReadCapFileException {
        MethodHeaderInfo methodHeaderInfo = new MethodHeaderInfo();
        methodHeaderInfo.setFlags((byte) ((bitfield & 0xF0) >>> 4));
        methodHeaderInfo.setMaxStack((byte) ((bitfield & 0x0F)));

        bitfield = in.readByte();
        methodHeaderInfo.setNargs((byte) ((bitfield & 0xF0) >>> 4));
        methodHeaderInfo.setMaxLocals((byte) ((bitfield & 0x0F)));

        return methodHeaderInfo;
    }
}
