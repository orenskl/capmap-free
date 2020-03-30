/**
 * InternalClassRef.java
 * <p/>
 * Copyright (C) 2009 Guillaume Bouffard <guillaume.bouffard02@etu.unilim.fr>
 * Copyright (C) 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
 * Copyright (C) 2012 Julien Iguchi-Cartigny <julien.cartigny@xlim.fr>
 * <p/>
 * Xlim - Université de Limoges
 * <p/>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */

package fr.xlim.ssd.capmanipulator.library;

/**
 * InternalClassRef
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class InternalClassRef extends ClassRef {
    // 16 bit offset into the info item of the class componentTab to an
    // interface_info or class_info structure
    // value must be between 0 and 32767
    private short internalClassRef;

    /**
     * Constructor
     */
    public InternalClassRef() {
    }

    /**
     * Get Internal Class Ref
     *
     * @return Internal Class Ref
     */
    public short getInternalClassRef() {
        return internalClassRef;
    }

    /**
     * Set Internal Class Ref
     *
     * @param internalClassRef new Internal Class Ref
     */
    public void setInternalClassRef(short internalClassRef) {
        this.internalClassRef = internalClassRef;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String ret = String.format("0x%04x", 0x00FFFF & internalClassRef);


        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InternalClassRef that = (InternalClassRef) o;

        if (internalClassRef != that.internalClassRef) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        InternalClassRef out = new InternalClassRef();

        out.setInternalClassRef(this.getInternalClassRef());

        return out;
    }
}
