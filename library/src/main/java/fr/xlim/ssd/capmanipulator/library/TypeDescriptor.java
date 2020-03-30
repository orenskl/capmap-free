/**
 * TypeDescriptor.java
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

package fr.xlim.ssd.capmanipulator.library;

import java.util.ArrayList;

/**
 * Type_descriptor
 * <p/>
 * this class represents the type of a field or the signature of a method
 */
public class TypeDescriptor implements Cloneable {

    // attributes
    // number of nibbles required to describe the
    // type encoded in the type array
    private byte nibbleCount;
    // encoded description of the type - size : (nibble_count+1)/2
    private ArrayList<Byte> type = new ArrayList<Byte>();

    /**
     * Get nibble count
     *
     * @return the value of nibble
     */
    public byte getNibbleCount() {
        return nibbleCount;
    }

    /**
     * Set nibble count
     *
     * @param nibbleCount new value of nibble count
     */
    public void setNibbleCount(byte nibbleCount) {
        this.nibbleCount = nibbleCount;
    }

    /**
     * Get type
     *
     * @return array type
     */
    public ArrayList<Byte> getType() {
        return type;
    }

    /**
     * Set array type
     *
     * @param type new array type
     */
    public void setType(ArrayList<Byte> type) {
        this.type = type;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        StringBuffer ret = new StringBuffer();

        ret.append("nibbleCount : ").append(nibbleCount).append(" ");

        ret.append("type : [ ");

        for (int i = 0; i < (nibbleCount + 1) / 2; i++) {
            ret.append(Integer.toHexString(0xff & type.get(i))).append(" ");
        }
        ret.append("]");

        return ret.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeDescriptor that = (TypeDescriptor) o;

        if (nibbleCount != that.nibbleCount) return false;
        return type.equals(that.type);

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TypeDescriptor out = new TypeDescriptor();

        out.setNibbleCount(this.getNibbleCount());

        ArrayList<Byte> type = new ArrayList<>();
        for(Byte b : this.getType()) {
            type.add(b.byteValue());
        }
        out.setType(type);

        return out;
    }
}
