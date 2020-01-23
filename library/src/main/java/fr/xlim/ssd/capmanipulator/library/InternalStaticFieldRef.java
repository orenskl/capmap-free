/**
 * InternalStaticFieldRef.java
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
 * InternalStaticFieldRef represents a reference to a static field defined in
 * this package
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class InternalStaticFieldRef extends StaticFieldRef {
    private byte padding = 0;

    // 16 bit offset into the item of the method componentTab
    private short offset;

    /**
     * Constructor
     */
    public InternalStaticFieldRef() {
    }

    /**
     * Get Padding
     *
     * @return Padding value
     */
    public byte getPadding() {
        return padding;
    }

    /**
     * Set Padding
     *
     * @param padding new Padding value
     */
    public void setPadding(byte padding) {
        this.padding = padding;
    }

    /**
     * Get offset
     *
     * @return offset value
     */
    public short getOffset() {
        return offset;
    }

    /**
     * Set offset
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
        String ret = "";

        ret += String.format("0x%04x", offset & 0x00FFFF);

        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InternalStaticFieldRef that = (InternalStaticFieldRef) o;

        if (offset != that.offset) return false;
        if (padding != that.padding) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        InternalStaticFieldRef out = new InternalStaticFieldRef();

        out.setOffset(this.getOffset());
        out.setPadding(this.getPadding());

        return out;
    }
}
