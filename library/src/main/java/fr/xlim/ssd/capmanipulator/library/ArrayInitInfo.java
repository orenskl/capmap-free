/**
 * ArrayInfo.java
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

import java.util.ArrayList;

/**
 * ArrayInitInfo
 */
public class ArrayInitInfo implements Cloneable {

    // type of the primitive array
    private byte type;

    // number of bytes in the value array
    private short count;

    // byte array containing the initial values of the static field array
    private ArrayList<Byte> values;


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t";
        StringBuffer ret = new StringBuffer();

        ret.append("\ttype   : ");
        switch (this.getType() & 0xFF) {
            case 2:
                ret.append("boolean");
                break;
            case 3:
                ret.append("byte   ");
                break;
            case 4:
                ret.append("short  ");
                break;
            case 5:
                ret.append("int    ");
                break;
        }
        ret.append(rl).append("\tcount  : ").append(this.getCount() & 0xFF).append(rl);
        ret.append("\tvalues = {").append(rl).append("\t\t");

        for (int i = 0, j = 0; i < values.size(); i++, j++) {
            String hex = Integer.toHexString(values.get(i) & 0xFF);
            ret.append(hex.length() == 1 ? "0" : "").append(hex).append(" ");
            if (j == 15 && i + 1 < values.size()) {
                j = -1;
                ret.append(rl).append("\t\t");
            }
        }

        ret.append(rl).append("\t}").append(rl);

        return ret.toString();
    }

    /**
     * Get type
     *
     * @return the type
     */
    public byte getType() {
        return type;
    }

    /**
     * Set type
     *
     * @param type the type to set
     */
    public void setType(byte type) {
        this.type = type;
    }

    /**
     * Get count
     *
     * @return the count
     */
    public short getCount() {
        return count;
    }

    /**
     * Set count
     *
     * @param count the count to set
     */
    public void setCount(short count) {
        this.count = count;
    }

    /**
     * Get values
     *
     * @return the values
     */
    public ArrayList<Byte> getValues() {
        return values;
    }

    /**
     * Set values
     *
     * @param values the values to set
     */
    public void setValues(ArrayList<Byte> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArrayInitInfo that = (ArrayInitInfo) o;

        if (count != that.count) return false;
        if (type != that.type) return false;
        if (!values.equals(that.values)) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ArrayInitInfo out = new ArrayInitInfo();

        out.setCount(this.getCount());
        out.setType(this.getType());

        ArrayList<Byte> values = new ArrayList<>();
        for (Byte b : this.getValues()) {
            values.add(b.byteValue());
        }
        out.setValues(values);

        return out;
    }
}