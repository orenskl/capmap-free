/**
 * InterfaceInfo.java
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
 * Interface_info
 * <p/>
 * class who represent interfaces
 */
public class InterfaceInfo implements Cloneable {

    // Fields
    byte bitfield;
    // size : interface_count
    ArrayList<ClassRef> superInterfaces = new ArrayList<ClassRef>();
    // TODO: voire si on peut simplifier en n'utilisant
    // deux byte
    // -> { bit[4] flags; bit[4] interface_count }
    private int offset;
    // TODO: trouver fichier avec interface remote pour tester ca!
    // ArrayList<InterfaceNameInfo> interfaceName = new
    // ArrayList<InterfaceNameInfo>(); //required only if the interface is
    // remote (indicated by flag)
    // required only if the interface is remote (indicated by flag)
    private InterfaceNameInfo interfaceNameInfo;

    /**
     * Get flags and interface_count value
     *
     * @return flags and interface_count value
     */
    public byte getBitfield() {
        return bitfield;
    }

    /**
     * Set flags and interface_count value
     *
     * @param bitfield new flags and interface_count value
     */
    public void setBitfield(byte bitfield) {
        this.bitfield = bitfield;
    }

    /**
     * Get Super Interface value
     *
     * @return Super Interface value
     */
    public ArrayList<ClassRef> getSuperInterfaces() {
        return superInterfaces;
    }

    /**
     * Set Super Interface value
     *
     * @param superInterfaces new Super Interface value
     */
    public void setSuperInterfaces(ArrayList<ClassRef> superInterfaces) {
        this.superInterfaces = superInterfaces;
    }

    /**
     * Get Interface Name Info value
     *
     * @return Interface Name Info value
     */
    public InterfaceNameInfo getInterfaceNameInfo() {
        return interfaceNameInfo;
    }

    /**
     * Set Interface Name Info value
     *
     * @param interfaceNameInfo new Interface Name Info value
     */
    public void setInterfaceNameInfo(InterfaceNameInfo interfaceNameInfo) {
        this.interfaceNameInfo = interfaceNameInfo;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {

        String rl = "\n\t";
        StringBuffer ret = new StringBuffer();
        ret.append("\tbitfield : ").append(Integer.toHexString(bitfield & 0x00FF))
                .append("{").append(rl);

        ret.append("\t\t flag:").append(Integer.toHexString((bitfield >> 4) & 0x000F))
                .append(rl);
        ret.append("\t\t interface_count:").append(Integer.toHexString(bitfield & 0x000F))
                .append(rl).append("\t}").append(rl);


        ret.append("\tsuper_interfaces : [ ");

        for (int i = 0; i < (bitfield & 0x0F); i++) {
            ret.append(superInterfaces.get(i).toString()).append(" ");
        }

        ret.append("]").append(rl);

        // Not in 2.1 CAP file format
        // ret.append(interfaceNameInfo.toString());

        return ret.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        InterfaceInfo out = new InterfaceInfo();

        out.setBitfield(this.getBitfield());

        ArrayList<ClassRef> superinterfaces = new ArrayList<>();
        for (ClassRef c : this.getSuperInterfaces()) {
            superinterfaces.add((ClassRef) c.clone());
        }
        out.setSuperInterfaces(superinterfaces);

        // out.setInterfaceNameInfo((InterfaceNameInfo) this.getInterfaceNameInfo().clone());

        return out;
    }
}