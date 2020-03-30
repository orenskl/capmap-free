/**
 * InstantField.java
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

// else ->InstanceFieldRef
public class InstanceField extends FieldRef {
    ClassRef class_;
    byte token;

    /**
     * Constructor
     *
     * @param class_ class
     * @param token
     */
    protected InstanceField(ClassRef class_, byte token) {
        this.class_ = class_;
        this.token = token;
    }

    public InstanceField() { }

    /**
     * Get Class Ref
     *
     * @return Class Ref Value
     */
    public ClassRef getClass_() {
        return class_;
    }

    /**
     * Set Class ref
     *
     * @param class_ new class ref value
     */
    public void setClass_(ClassRef class_) {
        this.class_ = class_;
    }

    /**
     * Get Token
     *
     * @return Token value
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
    public Object clone() throws CloneNotSupportedException {
        return new InstanceField((ClassRef) this.getClass_().clone(), this.getToken());
    }
}