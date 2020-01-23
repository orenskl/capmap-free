/**
 * ConstantVirtualMethodRef.java
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
 * ConstantVirtualMethodref references virtual method
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class ConstantVirtualMethodRef extends ConstantPoolInfo {

    // class associated with the referenced virtual method
    private ClassRef associatedClass;
    // virtual method token of the referenced method
    private byte token;

    /**
     * Default constructor
     */
    public ConstantVirtualMethodRef() {
        super(ConstantPoolComponent.TAG_VIRTUAL_METHOD_REF);
    }

    /**
     * Get Associated Class
     *
     * @return Associated Class Ref
     */
    public ClassRef getAssociatedClass() {
        return associatedClass;
    }

    /**
     * Set Associated Class
     *
     * @param associatedClass new Associated Class ref
     */
    public void setAssociatedClass(ClassRef associatedClass) {
        this.associatedClass = associatedClass;
    }

    /**
     * Get token
     *
     * @return token value
     */
    public byte getToken() {
        return token;
    }

    /**
     * Set token
     *
     * @param token new token value
     */
    public void setToken(byte token) {
        this.token = token;
    }

    @Override
    public String toString() {

        StringBuffer ret = new StringBuffer("CONSTANT_VirtualMethodRef :");

        ret.append(" method ").append(token & 0x00FF);
        ret.append(" of class ").append(associatedClass.toString());

        return ret.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConstantVirtualMethodRef that = (ConstantVirtualMethodRef) o;

        if (token != that.token) return false;
        return associatedClass.equals(that.associatedClass);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ConstantVirtualMethodRef out = new ConstantVirtualMethodRef();

        out.setTag(this.getTag());
        out.setAssociatedClass((ClassRef) this.getAssociatedClass().clone());
        out.setToken(this.getToken());

        return out;
    }
}