/**
 * MethodInfo.java
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

import fr.xlim.ssd.capmanipulator.library.bytecodereader.OpCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * method_info
 */
public class MethodInfo implements Cloneable {

    /*
     * FLAGS CONSTANTS VALUES
     */
    public static final byte ACC_EXTENDED = 0x08;
    public static final byte ACC_ABSTRACT = 0x04;
    public static final byte ACC = 0x00;
    /*
     * CLASS SIZE
     */
    // size in bytes
    public static final byte METHOD_HEADER_INFO_SIZE = 2;
    // size in bytes
    public static final byte EXTENDED_METHOD_HEADER_INFO_SIZE = 4;
    private final static Logger logger = LoggerFactory.getLogger(MethodInfo.class);
    // could be a method_header_info or an extend_method_header_info
    private MethodHeaderInfo methodHeader;
    // array of java card instruction that implement this method. zero
    // elements if the method is abstract
    private ArrayList<Byte> bytecodes;
    //beginning of the methodInfo in the MethodComponent
    private Short methodInfoOffset;
    //field use to construct the opCodeMap
    private Short firstBytecodeOffset;
    //map of short and bytecode providing an intelligible version of the bytecode
    //the short represent the opcode offset
    private TreeMap<Short, OpCode> opcodeMap;

    /*
     * (non-Javadoc) @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t\t";
        StringBuffer ret = new StringBuffer(rl);

        ret.append(this.getMethodHeader()).append("\n");

        // theoretically already construct during loading
        // new MethodInfoRead().makeOpcodeArray(this);

        for (Entry<Short, OpCode> CurrentEntry : opcodeMap.entrySet()) {
            ret.append(String.format("\t\t/*%04x*/", CurrentEntry.getKey())).append("       ").append(CurrentEntry.getValue());
        }


        return ret.toString();
    }

    /**
     * Get Method Header
     *
     * @return the method_header
     */
    public MethodHeaderInfo getMethodHeader() {
        return methodHeader;
    }

    /**
     * Set method Header
     *
     * @param methodHeader the method_header to set
     */
    public void setMethodHeader(MethodHeaderInfo methodHeader) {
        this.methodHeader = methodHeader;
    }

    /**
     * Get ByteCode
     *
     * @return the bytecodes
     */
    public ArrayList<Byte> getBytecodes() {
        return bytecodes;
    }

    /**
     * Set ByteCode
     *
     * @param bytecodes the bytecodes to set
     */
    public void setBytecodes(ArrayList<Byte> bytecodes) {
        this.bytecodes = bytecodes;
    }

    public Map<Short, OpCode> getOpcodeMap() {
        return opcodeMap;
    }

    public void setOpcodeMap(TreeMap<Short, OpCode> opcodeMap) {
        this.opcodeMap = opcodeMap;
    }

    public Short getMethodInfoOffset() {
        return methodInfoOffset;
    }

    public void setMethodInfoOffset(Short methodInfoOffset) {
        this.methodInfoOffset = methodInfoOffset;
    }

    public Short getFirstBytecodeOffset() {
        return firstBytecodeOffset;
    }

    public void setFirstBytecodeOffset(Short firstBytecodeOffset) {
        this.firstBytecodeOffset = firstBytecodeOffset;
    }

    public short getLastBytecodeOffset() {
        return opcodeMap.lastKey();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MethodInfo that = (MethodInfo) o;

        if (!bytecodes.equals(that.bytecodes)) return false;
        if (!firstBytecodeOffset.equals(that.firstBytecodeOffset)) return false;
        if (!methodHeader.equals(that.methodHeader)) return false;
        return methodInfoOffset.equals(that.methodInfoOffset);

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MethodInfo out = new MethodInfo();

        out.setFirstBytecodeOffset(this.getFirstBytecodeOffset());
        out.setMethodInfoOffset(this.getMethodInfoOffset().shortValue());
        out.setMethodHeader((MethodHeaderInfo) this.getMethodHeader().clone());

        ArrayList<Byte> bytecodes = new ArrayList<>();
        for (Byte b : this.getBytecodes()) {
            bytecodes.add(b.byteValue());
        }
        out.setBytecodes(bytecodes);

        TreeMap<Short, OpCode> opcodes = new TreeMap<>();
        for (Map.Entry<Short, OpCode> entry : this.getOpcodeMap().entrySet()) {
            opcodes.put(entry.getKey().shortValue(), (OpCode) entry.getValue().clone());
        }
        out.setOpcodeMap(opcodes);

        return out;
    }
}