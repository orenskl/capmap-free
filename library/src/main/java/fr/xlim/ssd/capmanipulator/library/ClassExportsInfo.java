/**
 * ClassExportsInfo.java
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

import java.util.ArrayList;

/**
 * ClassExportsInfo
 */
public class ClassExportsInfo implements Cloneable {
    private short classOffset;
    private byte staticFieldCount;
    private byte staticMethodCount;
    private ArrayList<Short> staticFieldOffsets;
    private ArrayList<Short> staticMethodOffsets;

    @Override
    public String toString() {
        String rl = "\n\t\t";
        StringBuffer ret = new StringBuffer();

        ret.append("\tclass_offset          : ").append(this.getClassOffset()).append(rl);
        ret.append("static_field_count    : ").append(this.getStaticFieldCount()).append(rl);
        ret.append("static_method_count   : ").append(this.getStaticMethodCount()).append(rl);

        ret.append("static_field_offsets  : ");

        for (short s : this.getStaticFieldOffsets()) {
            ret.append(" ").append(Integer.toHexString(s));
        }

        ret.append(rl);

        ret.append("static_method_offsets : ");

        for (short s : this.getStaticMethodOffsets()) {
            ret.append(" ").append(Integer.toHexString(s));
        }

        //ret.append(rl);

        return ret.toString();
    }

    /**
     * Get class Offset
     *
     * @return the classOffset
     */
    public short getClassOffset() {
        return classOffset;
    }

    /**
     * Set class Offset
     *
     * @param classOffset the classOffset to set
     */
    public void setClassOffset(short classOffset) {
        this.classOffset = classOffset;
    }

    /**
     * Get static Field Count
     *
     * @return the staticFieldCount
     */
    public byte getStaticFieldCount() {
        return staticFieldCount;
    }

    /**
     * Set static Field Count
     *
     * @param staticFieldCount the staticFieldCount to set
     */
    public void setStaticFieldCount(byte staticFieldCount) {
        this.staticFieldCount = staticFieldCount;
    }

    /**
     * Get static Method Count
     *
     * @return the staticMethodCount
     */
    public byte getStaticMethodCount() {
        return staticMethodCount;
    }

    /**
     * Set static Method Count
     *
     * @param staticMethodCount the staticMethodCount to set
     */
    public void setStaticMethodCount(byte staticMethodCount) {
        this.staticMethodCount = staticMethodCount;
    }

    /**
     * Set static Method Offsets
     *
     * @return the staticFieldOffsets
     */
    public ArrayList<Short> getStaticFieldOffsets() {
        return staticFieldOffsets;
    }

    /**
     * Set static Method Offsets
     *
     * @param staticFieldOffsets the staticFieldOffsets to set
     */
    public void setStaticFieldOffsets(ArrayList<Short> staticFieldOffsets) {
        this.staticFieldOffsets = staticFieldOffsets;
    }

    /**
     * Get static Method Offsets
     *
     * @return the staticMethodOffsets
     */
    public ArrayList<Short> getStaticMethodOffsets() {
        return staticMethodOffsets;
    }

    /**
     * Set static Method Offsets
     *
     * @param staticMethodOffsets the staticMethodOffsets to set
     */
    public void setStaticMethodOffsets(ArrayList<Short> staticMethodOffsets) {
        this.staticMethodOffsets = staticMethodOffsets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassExportsInfo that = (ClassExportsInfo) o;

        if (classOffset != that.classOffset) return false;
        if (staticFieldCount != that.staticFieldCount) return false;
        if (staticMethodCount != that.staticMethodCount) return false;
        if (!staticFieldOffsets.equals(that.staticFieldOffsets)) return false;
        if (!staticMethodOffsets.equals(that.staticMethodOffsets)) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ClassExportsInfo out = new ClassExportsInfo();

        out.setClassOffset(this.getClassOffset());
        out.setStaticFieldCount(this.getStaticFieldCount());
        out.setStaticMethodCount(this.getStaticMethodCount());

        ArrayList<Short> staticFieldOffsets = new ArrayList<>();
        for(Short s : this.getStaticFieldOffsets()) {
            staticFieldOffsets.add(s.shortValue());
        }
        out.setStaticFieldOffsets(staticFieldOffsets);

        ArrayList<Short> staticMethodOffsets = new ArrayList<>();
        for(Short s : this.getStaticMethodOffsets()) {
            staticMethodOffsets.add(s.shortValue());
        }
        out.setStaticFieldOffsets(staticMethodOffsets);

        return out;
    }
}