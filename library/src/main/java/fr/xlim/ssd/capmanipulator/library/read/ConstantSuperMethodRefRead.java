/**
 * ConstantSuperMethodRefRead.java
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

import fr.xlim.ssd.capmanipulator.library.ConstantSuperMethodRef;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

public class ConstantSuperMethodRefRead implements ConstantPoolInfoRead {


    /**
     * read the values of the ConstantSuperMethod from a cap file and set this
     * values
     *
     * @param in Cap File Stream
     * @throws java.io.IOException
     */
    public ConstantSuperMethodRef load(CapInputStream in) throws UnableToReadCapFileException {
        ConstantSuperMethodRef constantSuperMethodRef = new ConstantSuperMethodRef();
        constantSuperMethodRef.setAssociatedClass(new ClassRefRead().load(in));
        constantSuperMethodRef.setToken(in.readByte());
        return constantSuperMethodRef;
    }
}
