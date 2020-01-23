/**
 * LogType.java
 * <p>
 * Author: 2009 Guillaume Bouffard <guillaume.bouffard02@etu.unilim.fr>
 * Author: 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
 * Author: 2012 Julien Iguchi-Cartigny <julien.cartigny@xlim.fr>
 * Author: 2012 David Pequegnot <david.pequegnot@xlim.fr>
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
package fr.xlim.ssd.capmanipulator.library.logging;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Log types
 * <p/>
 * A log type is a <i>marker</i> which indicates the type of log. It can be used
 * to differentiate logs and allow filtering.
 *
 * @author Guillaume Bouffard
 * @author David Pequegnot
 */
public enum LogType {
    // Global Component Log

    COMPONENT,
    // Header Component Log
    HEADER_COMPONENT,
    // Directory Component Log
    DIRECTORY_COMPONENT,
    // Applet Component Log
    APPLET_COMPONENT,
    // Import Component Log
    IMPORT_COMPONENT,
    // Constant Pool Component Log
    CONSTANT_POOL_COMPONENT,
    // Class Component Log
    CLASS_COMPONENT,
    // Method Component Log
    METHOD_COMPONENT,
    // Static Field Component Log
    STATIC_FIELD_COMPONENT,
    // Reference Location Component Log
    REFERENCE_LOCATION_COMPONENT,
    // Export Component Log
    EXPORT_COMPONENT,
    // Descriptor Component Log
    DESCRIPTOR_COMPONENT,
    // Debug Component Log
    DEBUG_COMPONENT,
    // Custom Component Log
    CUSTOM_COMPONENT,

    // BCV Tag Log
    BCV_VERIFIER;

    // Establish relationships between <code>Marker</code> instances.
    static {
        HEADER_COMPONENT.getMarker().add(COMPONENT.getMarker());
        DIRECTORY_COMPONENT.getMarker().add(COMPONENT.getMarker());
        APPLET_COMPONENT.getMarker().add(COMPONENT.getMarker());
        APPLET_COMPONENT.getMarker().add(COMPONENT.getMarker());
        IMPORT_COMPONENT.getMarker().add(COMPONENT.getMarker());
        CONSTANT_POOL_COMPONENT.getMarker().add(COMPONENT.getMarker());
        CLASS_COMPONENT.getMarker().add(COMPONENT.getMarker());
        METHOD_COMPONENT.getMarker().add(COMPONENT.getMarker());
        STATIC_FIELD_COMPONENT.getMarker().add(COMPONENT.getMarker());
        REFERENCE_LOCATION_COMPONENT.getMarker().add(COMPONENT.getMarker());
        EXPORT_COMPONENT.getMarker().add(COMPONENT.getMarker());
        DESCRIPTOR_COMPONENT.getMarker().add(COMPONENT.getMarker());
        DEBUG_COMPONENT.getMarker().add(COMPONENT.getMarker());
        CUSTOM_COMPONENT.getMarker().add(COMPONENT.getMarker());


        BCV_VERIFIER.getMarker().add(BCV_VERIFIER.getMarker());
    }

    // The <code>Marker</code> instance corresponding to the log type.
    private Marker marker;

    /**
     * Link a
     * <code>Marker</code> name to an enumerate value
     * <p/>
     * The
     * <code>Marker</code> will be the
     * <code>java.lang.String</code> representation of the enumerate value.
     */
    private LogType() {
        this.marker = MarkerFactory.getIMarkerFactory().getMarker(this.name());
    }

    /**
     * Get the
     * <code>Marker</code> instance corresponding to the enumerate value.
     *
     * @return the
     *         <code>Marker</code> instance corresponding to the enumerate value
     */
    public Marker getMarker() {
        return this.marker;
    }
}
