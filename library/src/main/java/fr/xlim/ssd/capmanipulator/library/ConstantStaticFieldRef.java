/**
 * ConstantStaticFieldRef.java
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

/**
 * ConstantStaticFieldref
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class ConstantStaticFieldRef extends ConstantPoolInfo {

    private StaticFieldRef staticFieldRef;

    /**
     * Default Constructor
     */
    public ConstantStaticFieldRef() {
        super(ConstantPoolComponent.TAG_STATIC_FIELD_REF);
    }

    /**
     * Get Static Field Ref
     *
     * @return Static Field Ref value
     */
    public StaticFieldRef getStaticFieldRef() {
        return staticFieldRef;
    }

    /**
     * Set Static Field Ref
     *
     * @param staticFieldRef new Static Field Ref value
     */
    public void setStaticFieldRef(StaticFieldRef staticFieldRef) {
        this.staticFieldRef = staticFieldRef;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        StringBuffer ret = new StringBuffer("CONSTANT_StaticFieldRef   : ");

        ret.append(staticFieldRef.toString());

        return ret.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConstantStaticFieldRef that = (ConstantStaticFieldRef) o;

        return staticFieldRef != null ? staticFieldRef.equals(that.staticFieldRef) : that.staticFieldRef == null;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ConstantStaticFieldRef out = new ConstantStaticFieldRef();

        out.setTag(this.getTag());
        out.setStaticFieldRef((StaticFieldRef) this.getStaticFieldRef().clone());

        return out;
    }
}
