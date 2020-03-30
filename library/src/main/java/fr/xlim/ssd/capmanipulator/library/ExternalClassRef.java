/**
 * ExternalClassRef.java
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

/**
 * ExternalClassRef
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class ExternalClassRef extends ClassRef {
    // package_token represents a package token defined in the Import Component
    // value must be between and 127
    private byte packageToken;

    // token of the class or interface of the referenced class or interface.
    // has the value of the class token of the class as defined in the Export
    // file of the imported package
    private byte classToken;

    public ExternalClassRef() {
    }

    /**
     * Get Class Token
     *
     * @return Class Token value
     */
    public byte getClassToken() {
        return classToken;
    }

    /**
     * Set class Token
     *
     * @param classToken new class Token value
     */
    public void setClassToken(byte classToken) {
        this.classToken = classToken;
    }

    /**
     * Get Package Token
     *
     * @return Package Token value
     */
    public byte getPackageToken() {
        return packageToken;
    }

    /**
     * Set Package Token
     *
     * @param packageToken new package Token
     */
    public void setPackageToken(byte packageToken) {
        this.packageToken = packageToken;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuffer ret = new StringBuffer("external: ");

        ret.append("0x").append(Integer.toHexString(0xff & packageToken));
        ret.append(", 0x").append(Integer.toHexString(0xff & classToken));

        return ret.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExternalClassRef that = (ExternalClassRef) o;

        if (classToken != that.classToken) return false;
        if (packageToken != that.packageToken) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ExternalClassRef out = new ExternalClassRef();

        out.setPackageToken(this.getPackageToken());
        out.setClassToken(this.getClassToken());

        return out;
    }
}
