/**
 * ConstantSuperMethodRef.java
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
 * ConstantSuperMethodref references super method
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class ConstantSuperMethodRef extends ConstantPoolInfo {

    // class associated with the referenced super method
    private ClassRef associatedClass;
    // virtual method token of the referenced method
    private byte token;

    /**
     * Default constructor
     */
    public ConstantSuperMethodRef() {
        super(ConstantPoolComponent.TAG_SUPER_METHOD_REF);
    }

    /**
     * Get Associated Class
     *
     * @return Associated Class ref
     */
    public ClassRef getAssociatedClass() {
        return associatedClass;
    }

    /**
     * Set Associated Class ref
     *
     * @param associatedClass new Associated Class ref
     */
    public void setAssociatedClass(ClassRef associatedClass) {
        this.associatedClass = associatedClass;
    }

    /**
     * Get Token
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        StringBuffer ret = new StringBuffer("CONSTANT_SuperMethodRef   :");

        ret.append(" method ").append(token);
        ret.append(" of class ").append(associatedClass.toString());

        return ret.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConstantSuperMethodRef that = (ConstantSuperMethodRef) o;

        if (token != that.token) return false;
        if (!associatedClass.equals(that.associatedClass)) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ConstantSuperMethodRef out = new ConstantSuperMethodRef();

        out.setTag(this.getTag());
        out.setAssociatedClass((ClassRef) this.getAssociatedClass().clone());
        out.setToken(this.getToken());

        return out;
    }
}
