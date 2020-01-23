/**
 * ImplementedInterfaceInfo.java
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

import java.util.ArrayList;

/**
 * ImplementedInterfaceInto
 */
public class ImplementedInterfaceInfo implements Cloneable {

    // fields
    private ClassRef theInterface; // reference interface implemented by
    // this class
    private byte count; // number of entries in the index array
    // maps declaration of interface methods to implementations of those
    // methods in this class
    private ArrayList<Byte> index = new ArrayList<Byte>();

    /**
     * Assessor
     */
    /**
     * Get interface
     *
     * @return interface value
     */
    public ClassRef getTheInterface() {
        return theInterface;
    }

    /**
     * Set Interface
     *
     * @param theInterface new interface value
     */
    public void setTheInterface(ClassRef theInterface) {
        this.theInterface = theInterface;
    }

    /**
     * Get count
     *
     * @return count value
     */
    public byte getCount() {
        return count;
    }

    /**
     * Set count
     *
     * @param count new count value
     */
    public void setCount(byte count) {
        this.count = count;
    }

    /**
     * Get index
     *
     * @return index values
     */
    public ArrayList<Byte> getIndex() {
        return index;
    }

    /**
     * Set index
     *
     * @param index new index values
     */
    public void setIndex(ArrayList<Byte> index) {
        this.index = index;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        StringBuffer res = new StringBuffer();
        res.append("\t\tinterface : ").append(theInterface.toString());
        res.append(" index : [ ");

        for (int i = 0; i < count; i++) {
            res.append(Integer.toHexString(0xff & index.get(i))).append(" ");
        }

        res.append("]");

        return res.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImplementedInterfaceInfo that = (ImplementedInterfaceInfo) o;

        if (count != that.count) return false;
        if (!index.equals(that.index)) return false;
        return theInterface.equals(that.theInterface);

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ImplementedInterfaceInfo out = new ImplementedInterfaceInfo();

        out.setTheInterface((ClassRef) this.getTheInterface().clone());
        out.setCount(this.getCount());

        ArrayList<Byte> index = new ArrayList<>();
        for (Byte b : this.getIndex()) {
            index.add(b.byteValue());
        }
        out.setIndex(index);

        return out;
    }
}