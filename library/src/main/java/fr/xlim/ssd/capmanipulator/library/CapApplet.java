/**
 * CapApplet.java
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
 * Class describing an applet
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class CapApplet implements Cloneable {

    private byte aidLength; // number of bytes in the AID item
    // Java Card platform name of the applet
    private ArrayList<Byte> aid = new ArrayList<Byte>();
    // 16-bit offset into the info item of the Method Component
    private Short installMethodOffset;

    // the item at that offset must be the static install method of the applet

    /**
     * Get the value of aid
     *
     * @return the value of aid
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

    /**
     * Get the value of installMethodOffset
     *
     * @return the value of installMethodOffset
     */
    public Short getInstallMethodOffset() {
        return installMethodOffset;
    }

    /**
     * Set the value of installMethodOffset
     *
     * @param newVar the new value of installMethodOffset
     */
    public void setInstallMethodOffset(Short newVar) {
        installMethodOffset = newVar;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuffer ret = new StringBuffer();

        //ret.append(aidLength + "\n\t\t");

        ret.append("AID: ");

        //String aidStr = " -> \"";
        for (int i = 0; i < aidLength; i++) {

            byte chr = aid.get(i);


            String hex = Integer.toHexString(0xff & chr);
            ret.append((hex.length() == 1 ? "0" : "")).append(hex);

            if (i < aidLength - 1) {
                ret.append('.');
            }

            /*if (chr > 32) {
                aidStr += (char) ((int) aid.get(i));
            } else {
                aidStr += '.';
            }*/

        }

        //ret.append("] ");

        //aidStr += "\"";

        //ret.append(aidStr + "\n\t\t");


        String hex = Integer.toHexString(installMethodOffset);
        ret.append("\n\tinstall_method_offset: @");
        for (int i = hex.length(); i < 4; i++)
            ret.append("0");
        ret.append(hex);


        return ret.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CapApplet capApplet = (CapApplet) o;

        if (aidLength != capApplet.aidLength) return false;
        if (!aid.equals(capApplet.aid)) return false;
        if (!installMethodOffset.equals(capApplet.installMethodOffset)) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        CapApplet out = new CapApplet();

        out.setAidLength(this.getAidLength());
        ArrayList<Byte> aid = new ArrayList<Byte>();
        for(Byte b : this.getAid()) {
            aid.add(b.byteValue());
        }
        out.setInstallMethodOffset(this.getInstallMethodOffset());

        return out;
    }
}
