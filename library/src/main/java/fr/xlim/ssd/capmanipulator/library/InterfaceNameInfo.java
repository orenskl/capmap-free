/**
 * InterfaceNameInfo.java
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

import java.util.ArrayList;

/**
 * Interface_name_info
 *
 *represents interface name informations (required if interface is
 * remote)
 */

/**
 * @author guillaume
 */
public class InterfaceNameInfo implements Cloneable {
    byte interfaceNameLength = 0; // number of byte in interface_name item
    // representation of the name of this interface in UTF-8
    ArrayList<Byte> interfaceName = new ArrayList<Byte>();


    /**
     * Get Interface name length
     *
     * @return Interface name length value
     */
    public byte getInterfaceNameLength() {
        return interfaceNameLength;
    }

    /**
     * Set Interface name length
     *
     * @param interfaceNameLength new Interface name length value
     */
    public void setInterfaceNameLength(byte interfaceNameLength) {
        this.interfaceNameLength = interfaceNameLength;
    }

    /**
     * Get Interface name
     *
     * @return Interface name array
     */
    public ArrayList<Byte> getInterfaceName() {
        return interfaceName;
    }

    /**
     * Set Interface name
     *
     * @param interfaceName new Interface name array
     */
    public void setInterfaceName(ArrayList<Byte> interfaceName) {
        this.interfaceName = interfaceName;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {

        String rl = "\n\t";
        String res = "\tinterface_name_length: " + interfaceNameLength
                + rl;
        res += "\tinterface_name : [ ";

        for (int i = 0; i < interfaceNameLength; i++) {

            res += interfaceName.get(i) + " ";
        }

        res += "]" + rl;

        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterfaceNameInfo that = (InterfaceNameInfo) o;

        if (interfaceNameLength != that.interfaceNameLength) return false;
        if (!interfaceName.equals(that.interfaceName)) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        InterfaceNameInfo out = new InterfaceNameInfo();

        out.setInterfaceNameLength(this.getInterfaceNameLength());

        ArrayList<Byte> name = new ArrayList<>();
        for(Byte b : this.getInterfaceName()) {
            name.add(b.byteValue());
        }
        out.setInterfaceName(name);

        return out;
    }
}