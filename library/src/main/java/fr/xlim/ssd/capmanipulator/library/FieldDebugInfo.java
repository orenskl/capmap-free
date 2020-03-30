/**
 * FieldDebugInfo.java
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
 * FieldDebugInfo
 * <p/>
 * describes a field in a class. It can describe either an instance
 * field, a static field or a constant (primitive final static) field
 *
 * @author Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 */
public class FieldDebugInfo implements Cloneable {

    public static final short ACC_PUBLIC = (short) 0x0001;
    public static final short ACC_PRIVATE = (short) 0x0002;
    public static final short ACC_PROTECTED = (short) 0x0004;
    public static final short ACC_STATIC = (short) 0x0008;
    public static final short ACC_FINAL = (short) 0x0010;

    // index to the name of the field in the stringsTable[]
    private short nameIndex;
    // index to the type of the field in stringsTable[]
    private short descriptorIndex;
    // mask of modifiers
    private short accessFlags;
    // information about the field
    private int contents;
    private TokenVar token_var;
    private LocationVar location_var;
    // signed 32-bit constant
    private int const_value;

    public int getConst_value() {
        return const_value;
    }

    public void setConst_value(int const_value) {
        this.const_value = const_value;
    }

    public int getContents() {
        return contents;
    }

    public void setContents(int contents) {
        this.contents = contents;
    }

    public TokenVar getToken_var() {
        return token_var;
    }

    public void setToken_var(byte pad1, byte pad2, byte pad3, byte token) {
        this.token_var = new TokenVar(pad1, pad2, pad3, token);
    }

    public LocationVar getLocation_var() {
        return location_var;
    }

    public void setLocation_var(short pad, short location) {
        this.location_var = new LocationVar(pad, location);
    }

    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(short descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public short getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(short accessFlags) {
        this.accessFlags = accessFlags;
    }

    public int getConstValue() {
        return const_value;
    }

    public void setConstValue(int const_value) {
        this.const_value = const_value;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        FieldDebugInfo out = new FieldDebugInfo();

        out.nameIndex = this.nameIndex;
        out.descriptorIndex = this.descriptorIndex;
        out.accessFlags = this.accessFlags;
        out.contents = this.contents;
        out.token_var = (TokenVar) this.token_var.clone();
        out.location_var = (LocationVar) this.location_var.clone();
        out.const_value = this.const_value;

        return out;
    }

    public class TokenVar implements Cloneable {
        // case of instance field
        private byte pad1; // value ignored
        // case of instance field
        private byte pad2; // value ignored
        // case of instance field
        private byte pad3; // value ignored
        // instance field token of the field case of static field
        private byte token;

        public TokenVar(byte pad1, byte pad2, byte pad3, byte token) {
            this.pad1 = pad1;
            this.pad2 = pad2;
            this.pad3 = pad3;
            this.token = token;
        }

        private TokenVar() {}

        public byte getPad1() {
            return pad1;
        }

        public void setPad1(byte pad1) {
            this.pad1 = pad1;
        }

        public byte getPad2() {
            return pad2;
        }

        public void setPad2(byte pad2) {
            this.pad2 = pad2;
        }

        public byte getPad3() {
            return pad3;
        }

        public void setPad3(byte pad3) {
            this.pad3 = pad3;
        }

        public byte getToken() {
            return token;
        }

        public void setToken(byte token) {
            this.token = token;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            TokenVar out = new TokenVar();

            out.pad1 = this.pad1;
            out.pad2 = this.pad2;
            out.pad3 = this.pad3;
            out.token = this.token;

            return out;
        }
    }

    public class LocationVar implements Cloneable {
        private short pad; // value ignored
        // byte offset to the location of this field in the static field
        // image defined by the static field componentTab case of constant
        private short location;

        public LocationVar(short pad, short location) {
            this.pad = pad;
            this.location = location;
        }

        private LocationVar() {
        }

        public short getPad() {
            return pad;
        }

        public void setPad(short pad) {
            this.pad = pad;
        }

        public short getLocation() {
            return location;
        }

        public void setLocation(short location) {
            this.location = location;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            LocationVar out = new LocationVar();

            out.pad = this.pad;
            out.location = this.location;

            return out;
        }
    }
}
