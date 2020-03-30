/**
 * OpCode.java
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

import java.util.ArrayList;

/**
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class OpCode implements Cloneable, Comparable {

    private byte value;
    private String name;
    private ArrayList<Argument> arguments;

    /**
     * Constructor
     *
     * @param value     Bytecode value
     * @param name      instruction name
     * @param arguments arguments list
     */
    public OpCode(byte value, String name, ArrayList<Argument> arguments) {
        this.value = value;
        this.name = name;
        this.arguments = arguments;
    }

    /**
     * @return the value
     */
    public byte getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(byte value) {
        this.value = value;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the arguments
     */
    public ArrayList<Argument> getArguments() {
        return arguments;
    }

    /**
     * @param arguments the arguments to set
     */
    public void setArguments(ArrayList<Argument> arguments) {
        this.arguments = arguments;
    }

    /**
     * method returning the opocode size in byte (size of the opcode + its
     * arguments)
     *
     * @return opcode size
     */
    public int getOpcodeSize() {

        int opCodeSize = 1; //size of the opCode

        for (Argument arg : this.getArguments()) {
            opCodeSize += arg.getSize();
        }

        return opCodeSize;
    }

    /**
     * method returning an array of byte describing the opcode
     *
     * @return the opdcode as a byte arraylist
     */
    public ArrayList<Byte> getByteArrayValue() {


        //we'll transform the opcode into a byte array
        ArrayList<Byte> aByte = new ArrayList<Byte>();

        aByte.add(this.getValue());

        for (Argument arg : this.getArguments()) {

            if (arg.getValue() == null) continue;

            for (Byte b : arg.getValue()) {
                aByte.add(b);
            }
        }

        return aByte;
    }

    /*
     * (non-Javadoc) @see java.lang.Object#clone()
     */
    public Object clone() {

        ArrayList<Argument> arguments = new ArrayList<Argument>();

        for (Argument a : this.arguments) {
            arguments.add((Argument) a.clone());
        }

        return new OpCode(this.value, this.name, arguments);

    }

    /*
     * (non-Javadoc) @see java.lang.Object#toString()
     */
    public String toString() {

        //String ret = String.format("[%02x] %-16s", 0xff & value, name);
        String ret = String.format("%-16s", name);


        for (int i = 0; i < arguments.size(); i++) {
            if (i != 0)
                ret += ", ";
            ret += arguments.get(i);


        }

        ret += "\n";

        return ret;
    }

    /*
     * (non-Javadoc) @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Object o) {

        if (!(o instanceof OpCode)) {
            throw new ClassCastException("A OpCode object expected");
        }

        return this.name.compareTo(((OpCode) o).getName());
    }
}
