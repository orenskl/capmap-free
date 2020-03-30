/**
 * InternalStaticMethodRef.java
 * <p>
 * Copyright (C) 2009 Guillaume Bouffard <guillaume.bouffard02@etu.unilim.fr>
 * Copyright (C) 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
 * Copyright (C) 2012 Julien Iguchi-Cartigny <julien.cartigny@xlim.fr>
 * <p>
 * Xlim - Universit de Limoges
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
 * InternalStaticMethodRef represents a reference to a static method defined in
 * this package
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class InternalStaticMethodRef extends StaticMethodRef {
    private byte padding = 0;

    // 16 bit offset into the item of the method componentTab
    private short offset;

    /**
     * Constructor
     *
     * @param padding padding
     * @param offset  offset
     */
    public InternalStaticMethodRef(byte padding, short offset) {
        this.padding = padding;
        this.offset = offset;
    }

    public InternalStaticMethodRef() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Get Padding
     *
     * @return padding value
     */
    public byte getPadding() {
        return padding;
    }

    /**
     * Set Padding
     *
     * @param padding
     */
    public void setPadding(byte padding) {
        this.padding = padding;
    }

    /**
     * Get Offset
     *
     * @return offset value
     */
    public short getOffset() {
        return offset;
    }

    /**
     * Set Offset
     *
     * @param offset new offset value
     */
    public void setOffset(short offset) {
        this.offset = offset;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String ret;

        ret = String.format("0x%04x", 0x00FFFF & offset);

        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InternalStaticMethodRef that = (InternalStaticMethodRef) o;

        if (offset != that.offset) return false;
        if (padding != that.padding) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        InternalStaticMethodRef out = new InternalStaticMethodRef();

        out.setOffset(this.getOffset());
        out.setPadding(this.getPadding());

        return out;
    }
}
