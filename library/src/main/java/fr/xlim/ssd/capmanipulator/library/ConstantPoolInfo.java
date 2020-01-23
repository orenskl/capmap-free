/**
 * ConstantPoolInfo.java
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

package fr.xlim.ssd.capmanipulator.library;

/**
 * abstract class inherited by class which are stocked in the constant pool
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public abstract class ConstantPoolInfo implements Cloneable {

    // king of cp_info entry
    private byte tag;

    protected ConstantPoolInfo(byte tag) {
        this.tag = tag;
    }

    /**
     * Get tag
     *
     * @return tag value
     */
    public byte getTag() {
        return tag;
    }

    /**
     * Set tag
     *
     * @param tag new tag value
     */
    public void setTag(byte tag) {
        this.tag = tag;
    }

    @Override
    abstract public Object clone() throws CloneNotSupportedException;
}
