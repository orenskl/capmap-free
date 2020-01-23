/**
 * ConstantInstanceFieldRef.java
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
 * ConstantInstanceFieldref references instance field
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class ConstantInstanceFieldRef extends ConstantPoolInfo {

    // class associated with the referenced instance field
    private ClassRef associatedClass;
    private byte token; // instance field token of the referenced field

    /**
     * Constructor
     */
    public ConstantInstanceFieldRef() {
        super(ConstantPoolComponent.TAG_INSTANCE_FIELD_REF);
    }

    /**
     * Get Associated Class
     *
     * @return associated class value
     */
    public ClassRef getAssociatedClass() {
        return associatedClass;
    }

    /**
     * Set associated Class
     *
     * @param associatedClass new associated class
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {

        StringBuffer ret = new StringBuffer();

        ret.append("CONSTANT_InstanceFieldRef :");

        ret.append(" field ").append(token & 0x00FF);
        ret.append(" of class ").append(associatedClass.toString());

        return ret.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConstantInstanceFieldRef that = (ConstantInstanceFieldRef) o;

        if (token != that.token) return false;
        if (!associatedClass.equals(that.associatedClass)) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ConstantInstanceFieldRef out = new ConstantInstanceFieldRef();

        out.setTag(this.getTag());
        out.setAssociatedClass((ClassRef) this.getAssociatedClass().clone());
        out.setToken(this.getToken());

        return out;
    }
}
