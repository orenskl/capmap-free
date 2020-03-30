/**
 * ExternalStaticMethodRef.java
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
 * ExternalStaticMethoddRef represents a reference to a static method defined in an
 * imported package
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class ExternalStaticMethodRef extends StaticMethodRef {
    // represents a package token defined in the import componentTab
    private byte packageToken;

    // represents the token of the referenced class (this class must defined the referenced method)
    private byte classToken;

    // represents a static method token
    private byte token;

    /**
     * Constructor
     *
     * @param packageToken Package Token value
     * @param classToken   Class Token value
     * @param token        Token value
     */
    protected ExternalStaticMethodRef(byte packageToken, byte classToken,
                                      byte token) {
        super();
        this.packageToken = packageToken;
        this.classToken = classToken;
        this.token = token;
    }

    public ExternalStaticMethodRef() {
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
     * @param packageToken new Package Token value
     */
    public void setPackageToken(byte packageToken) {
        this.packageToken = packageToken;
    }

    /**
     * Get Class Token value
     *
     * @return Class Token value
     */
    public byte getClassToken() {
        return classToken;
    }

    /**
     * Set Class Token value
     *
     * @param classToken new Class Token value
     */
    public void setClassToken(byte classToken) {
        this.classToken = classToken;
    }

    /**
     * Get Token
     *
     * @return Token value
     */
    public byte getToken() {
        return token;
    }

    /**
     * Set Token
     *
     * @param token new Token value
     */
    public void setToken(byte token) {
        this.token = token;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuffer ret = new StringBuffer("external: ");

        ret.append("0x").append(Integer.toHexString(0xff & packageToken));
        ret.append(", 0x").append(Integer.toHexString(0xff & classToken));
        ret.append(", 0x").append(Integer.toHexString(0xff & token));

        return ret.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExternalStaticMethodRef that = (ExternalStaticMethodRef) o;

        if (classToken != that.classToken) return false;
        if (packageToken != that.packageToken) return false;
        if (token != that.token) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ExternalStaticMethodRef out = new ExternalStaticMethodRef();

        out.setPackageToken(this.getPackageToken());
        out.setClassToken(this.getClassToken());
        out.setToken(this.getToken());

        return out;
    }
}
