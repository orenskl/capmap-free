/**
 * HeaderComponent.java
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * HeaderComponent class this class contains general information about the CAP
 * file and the package it defines
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class HeaderComponent extends Component {

    private final static Logger logger = LoggerFactory.getLogger(HeaderComponent.class);

    // supplies the magic number identifying the JCard CAP file format
    private int magic;
    private byte minorVersion;
    private byte majorVersion;

    // mask of modifiers that apply to this package
    private byte flags;

    // describes the package defined in this CAP file
    private PackageInfo thePackage;

    // describes the name of the package defined in this CAP file
    private PackageNameInfo packageName;

    /**
     * Get the value of magic
     *
     * @return the value of magic
     */
    public int getMagic() {
        return magic;
    }

    /**
     * Set the value of magic
     *
     * @param newVar the new value of magic
     */
    public void setMagic(int newVar) {
        magic = newVar;
    }

    /**
     * Get the value of minorVersion
     *
     * @return the value of minorVersion
     */
    public byte getMinorVersion() {
        return minorVersion;
    }

    /**
     * Set the value of minorVersion
     *
     * @param newVar the new value of minorVersion
     */
    public void setMinorVersion(byte newVar) {
        minorVersion = newVar;
    }

    /**
     * Get the value of majorVersion
     *
     * @return the value of majorVersion
     */
    public byte getMajorVersion() {
        return majorVersion;
    }

    /**
     * Set the value of majorVersion
     *
     * @param newVar the new value of majorVersion
     */
    public void setMajorVersion(byte newVar) {
        majorVersion = newVar;
    }

    /**
     * Get the value of flags
     *
     * @return the value of flags
     */
    public byte getFlags() {
        return flags;
    }

    /**
     * Set the value of flags
     *
     * @param newVar the new value of flags
     */
    public void setFlags(byte newVar) {
        flags = newVar;
    }

    /**
     * Get the value of thePackage
     *
     * @return the value of thePackage
     */
    public PackageInfo getThePackage() {
        return thePackage;
    }

    /**
     * Set the value of thePackage
     *
     * @param newVar the new value of thePackage
     */
    public void setThePackage(PackageInfo newVar) {
        thePackage = newVar;
    }

    /**
     * Get the value of packageName
     *
     * @return the value of packageName
     */
    public PackageNameInfo getPackageName() {
        return packageName;
    }

    /**
     * Set the value of packageName
     *
     * @param newVar the new value of packageName
     */
    public void setPackageName(PackageNameInfo newVar) {
        packageName = newVar;
    }

    /**
     * toString method
     *
     * @return a String object which describe the HeaderComponent
     */
    public String toString() {
        String rl = "\n\t";
        StringBuffer ret = new StringBuffer(".header = {").append(rl);

        //ret.append(super.toString()).append(rl);
        ret.append("magic             : ").append(Integer.toHexString(magic)).append(rl);
        ret.append("minor_version     : ").append(minorVersion).append(rl);
        ret.append("major_version     : ").append(majorVersion).append(rl);
        ret.append("flags             : ").append(flags).append(rl);

        ret.append(thePackage.toString());
        //ret.append(packageName.toString());

        ret.append("}\n");

        return ret.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeaderComponent that = (HeaderComponent) o;

        if (flags != that.flags) return false;
        if (magic != that.magic) return false;
        if (majorVersion != that.majorVersion) return false;
        if (minorVersion != that.minorVersion) return false;
        if (!packageName.equals(that.packageName)) return false;
        if (!thePackage.equals(that.thePackage)) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        HeaderComponent out = new HeaderComponent();

        out.setTag(this.getTag());
        out.setSize(this.getSize());
        out.setFlags(this.getFlags());
        out.setMagic(this.getMagic());
        out.setMajorVersion(this.getMajorVersion());
        out.setMinorVersion(this.getMinorVersion());

        if(this.getPackageName() != null) {
            out.setPackageName((PackageNameInfo) this.getPackageName().clone());
        }
        if(this.getThePackage() != null) {
            out.setThePackage((PackageInfo) this.getThePackage().clone());
        }

        return out;
    }
}
