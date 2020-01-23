/**
 * PackageInfo.java
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


import org.apache.tools.ant.taskdefs.Pack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


public class PackageInfo implements Comparable, Cloneable {

    private final static Logger logger = LoggerFactory.getLogger(PackageInfo.class);


    private byte minorVersion;
    private byte majorVersion;

    // represents the number of bytes in the AID item (Valid values are
    // between 5 and 16)
    private byte aidLength;

    // the JCard platform name of the packages
    private ArrayList<Byte> lAid = new ArrayList<Byte>();

    /**
     * get the value of minorVersion
     *
     * @return value of minorVersion
     */
    public byte getMinorVersion() {
        return minorVersion;
    }

    /**
     * set the value of minorVersion
     *
     * @param newVal value of minorVersion
     */
    public void setMinorVersion(byte newVal) {
        minorVersion = newVal;
    }

    /**
     * get the value of majorVersion
     *
     * @return value of majorVersion
     */
    public byte getMajorVersion() {
        return majorVersion;
    }

    /**
     * set the value of majorVersion
     *
     * @param newVal value of majorVersion
     */
    public void setMajorVersion(byte newVal) {
        majorVersion = newVal;
    }

    /**
     * get the value of AIDLength
     *
     * @return value of AIDLength
     */
    public byte getAIDLength() {
        return aidLength;
    }

    /**
     * set the value of AIDLength
     *
     * @param newVal value of AIDLenght
     */
    public void setAIDLength(byte newVal) {
        aidLength = newVal;
    }

    /**
     * get the value of AID
     *
     * @return value of AID
     */
    public ArrayList<Byte> getAID() {
        return lAid;
    }

    /**
     * set the value of AID
     *
     * @param newVal value of AID
     */
    public void setAID(ArrayList<Byte> newVal) {
        lAid = newVal;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t";
        StringBuffer str = new StringBuffer();

        str.append("pkg_minor_version : ").append(minorVersion).append(rl);
        str.append("pkg_major_version : ").append(majorVersion).append(rl);
        str.append("pkg_AID_length    : ").append(Integer.toHexString(aidLength)).append(rl);
        str.append("pkg_AID           : ");

        //String aidStr = " -> \"";

        for (byte i = 0; i < aidLength; i++) {

            byte chr = lAid.get(i);

            String hex = Integer.toHexString(0xff & chr);
            str.append((hex.length() == 1 ? "0" : "")).append(hex);


            /*if (chr > 32) {
                aidStr += (char) ((int) lAid.get(i));
            } else {
                aidStr += ".";
            }*/

            if (i < aidLength - 1) {
                str.append(".");
            }

        }

        //aidStr += "\"";

        //str.append("]").append(aidStr).append(rl);
        str.append("\n");

        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof PackageInfo)) return false;

        PackageInfo that = (PackageInfo) o;

        if (this.majorVersion != that.majorVersion) return false;
        if (this.minorVersion != that.minorVersion) return false;
        if (this.aidLength != that.aidLength) return false;

        if(this.lAid == null) {
            return (that.getAID() == null);
        }

        return lAid.equals(that.lAid);
    }

    @Override
    public int compareTo(Object o) {
        PackageInfo that = (PackageInfo) o;

        if (this.lAid.equals(that.getAID())) {
            if (this.getMajorVersion() < that.getMajorVersion()) {
                return -1;
            }

            if (this.getMajorVersion() == that.getMajorVersion()) {
                return 0;
            }

            if (this.getMajorVersion() > that.getMajorVersion()) {
                return 1;
            }
        }

        if (this.aidLength < that.aidLength) {
            return -1;
        } else if (this.aidLength > that.aidLength) {
            return 1;
        }

        for (int index = 0; index < this.lAid.size(); index++) {
            if(this.lAid.get(index) == that.lAid.get(index)) {
                continue;
            }

            if(this.lAid.get(index) < that.lAid.get(index)) {
                return -1;
            }

            return 1;
        }

        return 0;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        PackageInfo out = new PackageInfo();

        out.setAIDLength(this.getAIDLength());
        out.setAID((ArrayList<Byte>) this.getAID().clone());
        out.setMajorVersion(this.getMajorVersion());
        out.setMinorVersion(this.getMinorVersion());

        return out;
    }
}

