/**
 * ConstantClassRef.java
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
 * ConstantClassref this class is used to represent a reference to a class or an
 * interface the class or interface may be defined in this package or in an
 * imported package
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class ConstantClassRef extends ConstantPoolInfo {

    private ClassRef classRef;
    // used to make size of CONSTANT_Classref_info structure
    // same as all other constants in the constant_pool[]
    // array
    private byte padding;

    public ConstantClassRef() {
        super(ConstantPoolComponent.TAG_CLASS_REF);
    }

    /**
     * Get Class Ref
     *
     * @return class ref
     */
    public ClassRef getClassRef() {
        return classRef;
    }

    /**
     * Set Class Ref
     *
     * @param classRef new class ref
     */
    public void setClassRef(ClassRef classRef) {
        this.classRef = classRef;
    }

    /**
     * Get padding
     *
     * @return padding value
     */
    public byte getPadding() {
        return padding;
    }

    /**
     * Set padding
     *
     * @param padding new padding value
     */
    public void setPadding(byte padding) {
        this.padding = padding;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {

        StringBuffer ret = new StringBuffer();

        ret.append("CONSTANT_ClassRef         : ");

        ret.append(classRef.toString());
        // ret += "padding : "+padding;

        return ret.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConstantClassRef that = (ConstantClassRef) o;

        if (padding != that.padding) return false;
        if (!classRef.equals(that.classRef)) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ConstantClassRef out = new ConstantClassRef();

        out.setTag(this.getTag());
        out.setClassRef((ClassRef) this.getClassRef().clone());
        out.setPadding(this.getPadding());

        return out;
    }
}
