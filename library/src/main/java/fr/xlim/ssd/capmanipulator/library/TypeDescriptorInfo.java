/**
 * TypeDescriptorInfo.java
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
import java.util.Map;
import java.util.TreeMap;

/**
 * TypeDescriptorInfo
 * <p/>
 * represents types of the fields and signatures of methods defined in this
 * package
 */
public class TypeDescriptorInfo implements Cloneable {

    private short constantPoolCount; // number of entries in the
    // constantPoolTypes
    // array
    private ArrayList<Short> constantPoolTypes = new ArrayList<Short>(); // array describing types of
    // the
    // fields and methods referenced in
    // the constant pool componentTab
    private Map<Short, TypeDescriptor> typeDesc = new TreeMap<Short, TypeDescriptor>(); // array describing types

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t\t";
        StringBuffer ret = new StringBuffer(rl);

        if (this.getConstantPoolTypes().isEmpty()) {
            return ret.toString();
        }

        ret.append("Initial offset value = ").append(this.getConstantPoolTypes().get(0)).append(rl);

        ret.append("constant_pool_type :");

        int i = 0;
        for (short s : this.getConstantPoolTypes()) {
            ret.append(" ");
            if (s == -1)
                ret.append("ffff");
            else
                ret.append(Integer.toHexString(s));
            i++;
            if (i == 16) {
                i = 0;
                ret.append(rl).append("               ");
            }
        }

        ret.append("\n\t");

        i = 0;

        for (Map.Entry<Short, TypeDescriptor> e : this.getTypeDesc().entrySet()) {
            ret.append("\ttype_desc[").append(i).append("] = (offset = ").append(String.format("%02x", e.getKey())).append(")  ");
            TypeDescriptor td = e.getValue();
            ArrayList<Byte> types = new ArrayList<Byte>(td.getType().size() * 2);
            for (int j = 0; j < td.getType().size(); j++) {
                types.add((byte) ((td.getType().get(j) >> 4) & 0xF));
                types.add((byte) (td.getType().get(j) & 0xF));
            }
            for (int j = 0; j < types.size(); j++) {
                switch (types.get(j)) {
                    case 0x0:
                        ret.append("PADDING ");
                        break;
                    case 0x1:
                        ret.append("V ");
                        break;
                    case 0x2:
                        ret.append("Z ");
                        break;
                    case 0x3:
                        ret.append("B ");
                        break;
                    case 0x4:
                        ret.append("S ");
                        break;
                    case 0x5:
                        ret.append("I ");
                        break;
                    case 0x6:
                        ret.append("L  ");
                        if (j + 5 < types.size())
                            ret.append("(");
                        ret.append("PACKAGE_TOKEN= ").append(Integer.toHexString(types.get(++j))).append(Integer.toHexString(types.get(++j)));
                        ret.append(", CLASS_TOKEN= ").append(Integer.toHexString(types.get(++j))).append(Integer.toHexString(types.get(++j))).append(") ");
                        break;
                    case 0xA:
                        ret.append("[Z ");
                        break;
                    case 0xB:
                        ret.append("[B ");
                        break;
                    case 0xC:
                        ret.append("[S ");
                        break;
                    case 0xD:
                        ret.append("[I ");
                        break;
                    case 0xE:
                        ret.append("[L ");
                        ret.append(" (PACKAGE_TOKEN= ").append(Integer.toHexString(types.get(++j))).append(Integer.toHexString(types.get(++j)));
                        ret.append(", CLASS_TOKEN= ").append(Integer.toHexString(types.get(++j))).append(Integer.toHexString(types.get(++j))).append(") ");
                        break;
                }
            }

            ret.append("\n\t");
            i++;
        }

        return ret.toString();
    }

    /**
     * Get constant pool count
     *
     * @return the constant pool count
     */
    public short getConstantPoolCount() {
        return constantPoolCount;
    }

    /**
     * Set constant pool count
     *
     * @param constantPoolCount the constantPoolCount to set
     */
    public void setConstantPoolCount(short constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
    }

    /**
     * Get constant Pool types
     *
     * @return constant Pool types
     */
    public ArrayList<Short> getConstantPoolTypes() {
        return constantPoolTypes;
    }

    /**
     * Set constant Pool types
     *
     * @param constantPoolTypes the constant pool types to set
     */
    public void setConstantPoolTypes(ArrayList<Short> constantPoolTypes) {
        this.constantPoolTypes = constantPoolTypes;
    }

    /**
     * Get type desc
     *
     * @return type desc
     */
    public Map<Short, TypeDescriptor> getTypeDesc() {
        return typeDesc;
    }

    /**
     * Set type desc
     *
     * @param typeDesc the type desc to set
     */
    public void setTypeDesc(Map<Short, TypeDescriptor> typeDesc) {
        this.typeDesc = typeDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeDescriptorInfo that = (TypeDescriptorInfo) o;

        if (constantPoolCount != that.constantPoolCount) return false;
        if (!constantPoolTypes.equals(that.constantPoolTypes)) return false;
        if (!typeDesc.equals(that.typeDesc)) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TypeDescriptorInfo out = new TypeDescriptorInfo();

        out.setConstantPoolCount(this.getConstantPoolCount());

        ArrayList<Short> cp = new ArrayList<>();
        for(Short s: this.getConstantPoolTypes()) {
            cp.add(s.shortValue());
        }
        out.setConstantPoolTypes(cp);

        Map<Short, TypeDescriptor> typeDesc = new TreeMap<>();
        for(Map.Entry<Short, TypeDescriptor> entry : this.getTypeDesc().entrySet()) {
            typeDesc.put(entry.getKey().shortValue(), (TypeDescriptor) entry.getValue().clone());
        }
        out.setTypeDesc(typeDesc);

        return out;
    }
}
