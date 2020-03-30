/**
 * ConstantPoolComponent.java
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
 * Constant_Pool_Component class This class contains an entry for each of the
 * classes, methods and fields referenced by elements in the Method Component.
 * Entries in the constant pool componentTab reference elements in the Class
 * Component, Method Component, and static Field Component. The import Component
 * is also accessed using a package token to describe references to classes,
 * methods and fields defined in imported packages.
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class ConstantPoolComponent extends Component {

    // constants declaration
    public static final byte TAG_CLASS_REF = 1;
    public static final byte TAG_INSTANCE_FIELD_REF = 2;
    public static final byte TAG_VIRTUAL_METHOD_REF = 3;
    public static final byte TAG_SUPER_METHOD_REF = 4;
    public static final byte TAG_STATIC_FIELD_REF = 5;
    public static final byte TAG_STATIC_METHOD_REF = 6;
    // fields declaration
    // number of items in the constant_pool array [0-65535]
    private short count;

    private ArrayList<ConstantPoolInfo> constantPool;

    private ArrayList<Short> offsetMethodList;

    /**
     * Get the value of count
     *
     * @return the value of count
     */
    public short getCount() {
        return count;
    }

    /**
     * Set the value of count
     *
     * @param newVar the new value of count
     */
    public void setCount(short newVar) {
        count = newVar;
    }

    /**
     * Verify if an index exists in the constant pool componentTab
     *
     * @param index token value to verofy
     * @return true if the token exist
     */
    public boolean offsetExist(short index) {
        return ((index >= 0) & (index < this.getConstantPool().size()));
    }

    /**
     * Returns the Constant Element linked by a token
     *
     * @param index the token
     * @return the Constant Element linked by a token
     */
    public ConstantPoolInfo getToken(short index) {
        return this.getConstantPool().get(index);
    }

    /**
     * Get the value of constantPool
     *
     * @return the value of constantPool
     */
    public ArrayList<ConstantPoolInfo> getConstantPool() {
        return constantPool;
    }

    /**
     * Set the value of constantPool
     *
     * @param newVar the new value of constantPool
     */
    public void setConstantPool(ArrayList<ConstantPoolInfo> newVar) {
        constantPool = newVar;
    }

    /**
     * Get Offset Method List
     *
     * @return Offset Method List values
     */
    public ArrayList<Short> getOffsetMethodList() {
        return offsetMethodList;
    }

    /**
     * Set Offset Method List
     *
     * @param offsetMethodList new Offset Method List values
     */
    public void setOffsetMethodList(ArrayList<Short> offsetMethodList) {
        this.offsetMethodList = offsetMethodList;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xlim.ssd.capmanipulator.library.Component#toString()
     */
    public String toString() {

        String rl = "\n\t";
        StringBuffer ret = new StringBuffer();

        ret.append(".ConstantPool = {\n");

        //ret.append(super.toString()).append(rl);
        //ret.append("count           : ").append(count).append(rl);

        for (int i = 0; i < count; i++) {
            //ret.append(String.format("%-3d - ", i)).append(constantPool.get(i).toString()).append(rl);
            String tmp = Integer.toHexString(i * 4);
            ret.append("\t/* ");
            for (int j = tmp.length(); j < 4; j++)
                ret.append("0");
            ret.append(tmp).append(",");
            tmp = "" + i;
            for (int j = tmp.length(); j < 4; j++)
                ret.append(" ");
            ret.append(tmp).append(" */ ");
            ret.append(constantPool.get(i).toString()).append("\n");
        }

        ret.append("}\n");
        return ret.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConstantPoolComponent that = (ConstantPoolComponent) o;

        if (count != that.count) return false;
        if (!constantPool.equals(that.constantPool)) return false;
        return offsetMethodList.equals(that.offsetMethodList);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ConstantPoolComponent out = new ConstantPoolComponent();

        out.setTag(this.getTag());
        out.setSize(this.getSize());
        out.setCount(this.getCount());

        ArrayList<ConstantPoolInfo> constant_pool = new ArrayList<ConstantPoolInfo>();
        for (ConstantPoolInfo c : this.getConstantPool()) {
            constant_pool.add((ConstantPoolInfo) c.clone());
        }
        out.setConstantPool(constant_pool);

        return out;
    }
}
