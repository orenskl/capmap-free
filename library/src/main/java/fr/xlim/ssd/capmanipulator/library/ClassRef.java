/**
 * ClassRef.java
 * <p>
 * Copyright (C) 2009 Guillaume Bouffard <guillaume.bouffard@xlim.fr>
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
 * Class_ref the class_ref item represents a reference to a class or interface
 * if the class or interface is defined in this package the structure represents
 * an internal_class_ref if the class or interface is defined in another package
 * the structure represents an external_class_ref
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public abstract class ClassRef implements Cloneable {

    @Override
    abstract public Object clone() throws CloneNotSupportedException;
}
