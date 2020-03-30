/**
 * ClassDebugInfo.java
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

import java.util.ArrayList;

/**
 * ClassDebugInfo
 * <p/>
 * Contains all the debugging information for a class or interface. It also
 * contains table of debugging information for all its classes fields and
 * methods
 *
 * @author Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 */
public class ClassDebugInfo implements Cloneable {
    // index in the stringsTable[] to the fully qualified name of this class

    private short nameIndex;
    // mask of modifiers
    private short accessFlags;
    // byte offset of the classInfo or interfaceInfo record for this class
    // or interface into the info item of the class componentTab
    private short location;
    // index in the stringsTable[] to the fully qualified name of the super
    // class of this class
    private short superNameIndex;
    // index into the strings_table[] to the name of the source file in with
    // this class is defined
    private short sourceFileIndex;
    // number of entries in the interfaceNameIndexes
    private byte interfaceCount;
    // number of entries in fields table
    private short fieldCount;
    // number of method in the methods table
    private short methodCount;
    // indexes in the stringsTable[] to the name of an interface implemented
    // by this class
    private ArrayList<Short> interfaceNamesIndexes = new ArrayList<Short>();
    // fieldDebugInfo for all the fields declared by this class
    private ArrayList<FieldDebugInfo> fields = new ArrayList<FieldDebugInfo>();
    // methodDebugInfo for all the methods declared or defined in this class
    private ArrayList<MethodDebugInfo> methods = new ArrayList<MethodDebugInfo>();

    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
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

    public short getSuperNameIndex() {
        return superNameIndex;
    }

    public void setSuperNameIndex(short superNameIndex) {
        this.superNameIndex = superNameIndex;
    }

    public short getSourceFileIndex() {
        return sourceFileIndex;
    }

    public void setSourceFileIndex(short sourceFileIndex) {
        this.sourceFileIndex = sourceFileIndex;
    }

    public byte getInterfaceCount() {
        return interfaceCount;
    }

    public void setInterfaceCount(byte interfaceCount) {
        this.interfaceCount = interfaceCount;
    }

    public short getFieldCount() {
        return fieldCount;
    }

    public void setFieldCount(short fieldCount) {
        this.fieldCount = fieldCount;
    }

    public short getMethodCount() {
        return methodCount;
    }

    public void setMethodCount(short methodCount) {
        this.methodCount = methodCount;
    }

    public ArrayList<Short> getInterfaceNamesIndexes() {
        return interfaceNamesIndexes;
    }

    public ArrayList<FieldDebugInfo> getFields() {
        return fields;
    }

    public void setFields(ArrayList<FieldDebugInfo> fields) {
        this.fields = fields;
    }

    public ArrayList<MethodDebugInfo> getMethods() {
        return methods;
    }

    public void setMethods(ArrayList<MethodDebugInfo> methods) {
        this.methods = methods;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ClassDebugInfo out = new ClassDebugInfo();

        out.nameIndex = this.nameIndex;
        out.accessFlags = this.accessFlags;
        out.location = this.location;
        out.superNameIndex = this.superNameIndex;
        out.sourceFileIndex = this.sourceFileIndex;
        out.interfaceCount = this.interfaceCount;
        out.fieldCount = this.fieldCount;
        out.methodCount = this.methodCount;
        ArrayList<Short> interfaceNamesIndexes = new ArrayList<Short>();
        for (short s : this.interfaceNamesIndexes) {
            interfaceNamesIndexes.add(s);
        }
        out.interfaceNamesIndexes = interfaceNamesIndexes;

        ArrayList<FieldDebugInfo> fields = new ArrayList<FieldDebugInfo>();
        for (FieldDebugInfo f : this.fields) {
            fields.add((FieldDebugInfo) f.clone());
        }
        out.fields = fields;

        ArrayList<MethodDebugInfo> methods = new ArrayList<MethodDebugInfo>();
        for(MethodDebugInfo m: this.methods) {
            methods.add((MethodDebugInfo) m.clone());
        }
        out.methods = methods;

        return out;
    }
}
