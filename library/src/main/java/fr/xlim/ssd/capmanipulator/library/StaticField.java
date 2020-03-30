/**
 * StaticField.java
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

// field ref (union type):
// if the ACC_STATIC (0x08) is equal to 1 in the acess flags->
// StaticFieldRef
public class StaticField extends FieldRef {

    private StaticFieldRef staticFieldRef;

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
    public void setStaticField(StaticFieldRef staticFieldRef) {
        this.staticFieldRef = staticFieldRef;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        StaticField out = new StaticField();

        out.setStaticField((StaticFieldRef) this.getStaticFieldRef().clone());

        return out;
    }
}

