/**
 * MethodDebugInfo.java
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
 * MethodDebugInfo
 * <p/>
 * describes a method of a class. It can describe methods that are
 * either virtual or non virtual
 *
 * @author Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 */
public class MethodDebugInfo implements Cloneable {

    public static final short ACC_PUBLIC = (short) 0x0001;
    public static final short ACC_PRIVATE = (short) 0x0002;
    public static final short ACC_PROTECTED = (short) 0x0004;
    public static final short ACC_STATIC = (short) 0x0008;
    public static final short ACC_FINAL = (short) 0x0010;
    public static final short ACC_NATIVE = (short) 0x0100;
    public static final short ACC_ABSTRACT = (short) 0x0400;

    // index to the simple name of the method in the stringsTable[]
    private short nameIndex;
    // index to the argument and return type of the method in
    // stringsTable[]
    private short descriptorIndex;
    // mask of modifiers
    private short accessFlags;
    // byte offset of the method_info structure for this method into the
    // info item of the Method Component
    private short location;
    // size in bytes of the header of the method (0 for abstract method)
    private byte headerSize;
    // size in bytes of the body of the method
    private short bodySize;
    // number of variables in the variableTable
    private short variableCount;
    // number of lineInfo entries in the lineTable
    private short lineCount;
    // list of variables in this method
    private ArrayList<VariableInfo> variableTable = new ArrayList<VariableInfo>();
    // map bytecode insructions of this method to lines in the class
    // source file
    private ArrayList<LineInfo> lineTable = new ArrayList<LineInfo>();

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

    public short getLocation() {
        return location;
    }

    public void setLocation(short location) {
        this.location = location;
    }

    public byte getHeaderSize() {
        return headerSize;
    }

    public void setHeaderSize(byte headerSize) {
        this.headerSize = headerSize;
    }

    public short getBodySize() {
        return bodySize;
    }

    public void setBodySize(short bodySize) {
        this.bodySize = bodySize;
    }

    public short getVariableCount() {
        return variableCount;
    }

    public void setVariableCount(short variableCount) {
        this.variableCount = variableCount;
    }

    public short getLineCount() {
        return lineCount;
    }

    public void setLineCount(short lineCount) {
        this.lineCount = lineCount;
    }

    public ArrayList<VariableInfo> getVariableTable() {
        return variableTable;
    }

    public void setVariableTable(ArrayList<VariableInfo> variableTable) {
        this.variableTable = variableTable;
    }

    public ArrayList<LineInfo> getLineTable() {
        return lineTable;
    }

    public void setLineTable(ArrayList<LineInfo> lineTable) {
        this.lineTable = lineTable;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MethodDebugInfo out = new MethodDebugInfo();

        out.nameIndex = this.nameIndex;
        out.descriptorIndex = this.descriptorIndex;
        out.accessFlags = this.accessFlags;
        out.location = this.location;
        out.headerSize = this.headerSize;
        out.bodySize = this.bodySize;
        out.variableCount = this.variableCount;
        out.lineCount = this.lineCount;

        ArrayList<VariableInfo> variableTable = new ArrayList<VariableInfo>();
        for (VariableInfo v: this.variableTable) {
            variableTable.add((VariableInfo) v.clone());
        }
        out.variableTable = variableTable;

        ArrayList<LineInfo> lineTable = new ArrayList<LineInfo>();
        for(LineInfo l: this.lineTable) {
            lineTable.add((LineInfo) l.clone());
        }
        out.lineTable = lineTable;

        return out;
    }
}
