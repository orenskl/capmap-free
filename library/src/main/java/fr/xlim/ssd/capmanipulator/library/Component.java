/**
 * Component.java
 * <p>
 * Author: 2009 Guillaume Bouffard <guillaume.bouffard@xlim.fr>
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generic Component
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public abstract class Component implements Cloneable {

    private final static Logger logger = LoggerFactory.getLogger(Component.class);

    private byte tag; // tag of the Component
    // number of bytes in the Component, excluding tag and size
    private short size;

    /**
     * Assessor methods
     */

    /**
     * Get the value of tag
     *
     * @return the value of tag
     */
    public byte getTag() {
        return tag;
    }

    /**
     * Set the value of tag
     *
     * @param newVar the new value of tag
     */
    public void setTag(byte newVar) {
        tag = newVar;
    }

    /**
     * Get the value of size
     *
     * @return the value of size
     */
    public short getSize() {
        return size;
    }

    /**
     * Set the value of size
     *
     * @param newVar the new value of size
     */
    public void setSize(short newVar) {
        size = newVar;
    }

    @Override
    public String toString() {

        StringBuffer res = new StringBuffer();

        res.append("tag :").append(tag);
        res.append(" size : ").append(Integer.toHexString(size));

        return res.toString();
    }

    @Override
    abstract public Object clone() throws CloneNotSupportedException;
}