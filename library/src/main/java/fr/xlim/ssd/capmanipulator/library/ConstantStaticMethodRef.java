/**
 * ConstantStaticMethodRef.java
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
 * ConstantStaticMethodref
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class ConstantStaticMethodRef extends ConstantPoolInfo {

    private StaticMethodRef staticMethodRef;

    /**
     * Default Constructor
     */
    public ConstantStaticMethodRef() {
        super(ConstantPoolComponent.TAG_STATIC_METHOD_REF);
    }

    /**
     * Get Method Ref
     *
     * @return Method Ref
     */
    public StaticMethodRef getStaticMethodRef() {
        return staticMethodRef;
    }

    /**
     * Set Method Ref
     *
     * @param staticMethodRef new Method Ref
     */
    public void setStaticMethodRef(StaticMethodRef staticMethodRef) {
        this.staticMethodRef = staticMethodRef;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {

        StringBuffer ret = new StringBuffer("CONSTANT_StaticMethodRef  : ");

        ret.append(staticMethodRef.toString());

        return ret.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConstantStaticMethodRef that = (ConstantStaticMethodRef) o;

        return staticMethodRef.equals(that.staticMethodRef);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ConstantStaticMethodRef out = new ConstantStaticMethodRef();

        out.setTag(this.getTag());
        out.setStaticMethodRef((StaticMethodRef) this.getStaticMethodRef().clone());

        return out;
    }
}
