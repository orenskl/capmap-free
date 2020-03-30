/**
 * ComponentEnum.java
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

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ComponentEnum {

    HEADER_COMPONENT(1),
    DIRECTORY_COMPONENT(2),
    APPLET_COMPONENT(3),
    IMPORT_COMPONENT(4),
    CONSTANT_POOL_COMPONENT(5),
    CLASS_COMPONENT(6),
    METHOD_COMPONENT(7),
    STATIC_FIELD_COMPONENT(8),
    REFERENCE_LOCATION_COMPONENT(9),
    EXPORT_COMPONENT(10),
    DESCRIPTOR_COMPONENT(11),
    DEBUG_COMPONENT(12),
    // TODO: this value is not defined in the Java Card 2.1.* Specification
    DEBUG_COMPONENT_2_1(0xDB);

    private static final Map<Integer, ComponentEnum> lookup = new HashMap<Integer, ComponentEnum>();

    static {
        for (ComponentEnum s : EnumSet.allOf(ComponentEnum.class))
            lookup.put(s.getValue(), s);
    }

    private int value;

    private ComponentEnum(int value) {
        this.value = (byte) value;
    }

    public static ComponentEnum get(int value) {

        return lookup.get(value);
    }

    public int getValue() {
        return value;
    }
}
