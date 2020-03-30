/**
 * PackageNameInfo.java
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

public class PackageNameInfo implements Cloneable {
    // number of bytes in the name item (0 if the packages does not define
    // any remote interfaces or remote classes)
    private byte nameLength;

    // variable length representation of the fully qualified name of this
    // package in UTF-8 format
    private ArrayList<Byte> name = new ArrayList<Byte>();

    /**
     * get the value of nameLength
     *
     * @return value of nameLength
     */
    public byte getNameLength() {
        return nameLength;
    }

    /**
     * set the value of nameLength
     *
     * @param newVal value of nameLength
     */
    public void setNameLength(byte newVal) {
        nameLength = newVal;
    }

    /**
     * get the value of name
     *
     * @return value of name
     */
    public ArrayList<Byte> getName() {
        return name;
    }

    /**
     * set the value of name
     *
     * @param newVal value of name
     */
    public void setName(ArrayList<Byte> newVal) {
        name = newVal;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t";
        StringBuffer str = new StringBuffer();

        if (nameLength == 0)
            return "";

        str.append("\tnameLength : ").append(nameLength).append(rl).append("name : ");

        for (byte i = 0; i < this.getNameLength(); i++) {
            str.append(name.get(i)).append(".");
        }

        str.append("\n");

        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackageNameInfo that = (PackageNameInfo) o;

        if (nameLength != that.nameLength) return false;
        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        PackageNameInfo out = new PackageNameInfo();

        out.setNameLength(this.getNameLength());
        ArrayList<Byte> name = new ArrayList<Byte>();
        for(Byte b : this.getName()) {
            name.add(b.byteValue());
        }
        out.setName(name);

        return out;
    }
}
