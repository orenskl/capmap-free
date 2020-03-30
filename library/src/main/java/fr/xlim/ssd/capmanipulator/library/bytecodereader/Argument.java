/**
 * Argument.java
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

package fr.xlim.ssd.capmanipulator.library.bytecodereader;

/**
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class Argument implements Cloneable {

    private byte[] value;
    private boolean signed;
    private short size;
    private short expected_size;

    /**
     * Constructor
     *
     * @param value  Bytecode value
     * @param signed Argument is signing ?
     */
    public Argument(byte[] value, boolean signed) {
        this.value = value;
        this.signed = signed;
        if (this.value == null)
            this.size = 0;
        else
            this.size = (short) this.value.length;
        this.expected_size = this.size;
    }

    /**
     * Constructor
     *
     * @param expected_size expected parameter size
     * @param signed        Argument is signing ?
     */
    protected Argument(short expected_size, boolean signed) {
        this.setValue(new byte[expected_size]);
        this.signed = signed;
        this.expected_size = expected_size;
    }

    /**
     * @return the value
     */
    public byte[] getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(byte[] value) {
        this.value = value;
        if (this.value == null)
            this.size = 0;
        else
            this.size = (short) this.value.length;
    }

    /**
     * @return the signed
     */
    public boolean isSigned() {
        return signed;
    }

    /**
     * @param signed the signed to set
     */
    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public Object clone() {

        byte[] value = null;

        if (this.value != null) {
            value = this.value.clone();
        }

        return new Argument(value, this.signed);
    }

    public String toString() {

        StringBuilder ret = new StringBuilder();

        Integer intValue = 0;

        int size = this.value.length;

        ret.append("0x");

        for (int i = 0; i <= size - 1; i++) {
            ret.append(String.format("%02x", value[i] & 0x00FF));
        }

        for (int i = size - 1; i >= 0; i--) {
            if (isSigned()) {

                if (i != 0) {
                    intValue += (value[i] & 0xff) << ((size - 1 - i) * 8);
                } else {
                    intValue += value[i] << ((size - 1 - i) * 8);
                }

            } else {
                intValue += (value[i] & 0xff) << ((size - 1 - i) * 8);
            }

        }

        /*if (intValue < 0) {
            ret += "-" + Integer.toHexString(Math.abs(intValue));

        } else {
            ret += Integer.toHexString(intValue);
        }*/
        // ret += intValue;


        return ret.toString();
    }

    /**
     * method returning the value of the argument in a int
     *
     * @return the argument value into an int
     */
    public int getIntValue() {
        int intValue = 0;

        int size = this.value.length;

        for (int i = size - 1; i >= 0; i--) {
            if (isSigned()) {

                if (i != 0) {
                    intValue += (this.getValue()[i] & 0xff) << ((size - 1 - i) * 8);
                } else {
                    intValue += (this.getValue()[i]) << ((size - 1 - i) * 8);
                }
            } else {
                intValue += (this.getValue()[i] & 0xff) << ((size - 1 - i) * 8);
            }

        }

        return intValue;
    }

    /**
     * method setting the value byte array with an int value
     *
     * @param intValue
     */
    public void setIntValue(int intValue) {

        for (int i = this.value.length - 1; i >= 0; i--) {
            value[i] = (byte) ((intValue >>> (i * 8)) & 0xff);
        }

    }

    public short getSize() {
        return size;
    }

    public void setSize(short size) {
        this.size = size;
    }

    public short getExpected_size() {
        return expected_size;
    }

    public void setExpected_size(short expected_size) {
        this.expected_size = expected_size;
    }
}
