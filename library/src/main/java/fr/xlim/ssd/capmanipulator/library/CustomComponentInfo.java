/**
 * CustomComponentInfo.java
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

public class CustomComponentInfo implements Cloneable {
    // tag of the componentTab, [128-255]

    private byte componentTag;
    // number of bytes in the componentTab
    private short size;
    // number of bytes in the AID item [5-16]
    private byte aidLength;
    // JCard platform name of the componentTab
    private ArrayList<Byte> aid = new ArrayList<Byte>();

    /**
     * Get the value of componentTag
     *
     * @return the value of componentTag
     */
    public byte getComponentTag() {
        return componentTag;
    }

    /**
     * Set the value of componentTag
     *
     * @param newVar the new value of componentTag
     */
    public void setComponentTag(byte newVar) {
        componentTag = newVar;
    }

    /**
     * Get the value of size
     *
     * @return the value of size
     */
    public short getSize() {
        return size;
    }

    /**
     * Set the value of size
     *
     * @param newVar the new value of size
     */
    public void setSize(short newVar) {
        size = newVar;
    }

    /**
     * Get the value of aidLength
     *
     * @return the value of aidLength
     */
    public byte getAidLength() {
        return aidLength;
    }

    /**
     * Set the value of aidLength
     *
     * @param newVar the new value of aidLength
     */
    public void setAidLength(byte newVar) {
        aidLength = newVar;
    }

    /**
     * Get the value of aid
     *
     * @return the value of aid
     */
    public ArrayList<Byte> getAid() {
        return aid;
    }

    /**
     * Set the value of aid
     *
     * @param newVar the new value of aid
     */
    public void setAid(ArrayList<Byte> newVar) {
        aid = newVar;
    }

    /*
     * (non-Javadoc) @see java.lang.Object#toString()
     */
    public String toString() {
        String rl = "\n\t";
        StringBuffer res = new StringBuffer("\tcustom_component_info = {").append(rl);
        res.append("\tcomponent_tag    : ").append(this.componentTag).append(rl);
        res.append("\tsize             : ").append(this.size).append(rl);
        res.append("\tAID_length       : ").append(this.aidLength).append(rl);
        res.append("\tAID              : {");

        for (int i = 0; i < this.aidLength; i++) {
            res.append(this.aid.get(i)).append(";");
        }

        res.append("}");

        res.append("}\n");

        return res.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomComponentInfo that = (CustomComponentInfo) o;

        if (aidLength != that.aidLength) return false;
        if (componentTag != that.componentTag) return false;
        if (size != that.size) return false;
        if (aid != null ? !aid.equals(that.aid) : that.aid != null) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        CustomComponentInfo out = new CustomComponentInfo();

        out.setComponentTag(this.getComponentTag());
        out.setSize(this.getSize());

        ArrayList<Byte> aid = new ArrayList<Byte>();
        for(Byte b: this.getAid()) {
            aid.add(b.byteValue());
        }
        out.setAid(aid);

        return out;
    }
}
