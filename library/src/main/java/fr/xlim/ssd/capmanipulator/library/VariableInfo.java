/**
 * VariableInfo.java
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

/**
 * VariableInfo
 * <p/>
 * describe a single local variable of a method. Indicates the index
 * into the local variables of the current frame at which the local
 * variable can be found, as well as the name and type of the
 * variable. It also indicates the range of bytecodes within which
 * the variable has a value
 *
 * @author Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 */
public class VariableInfo implements Cloneable {
    // index of the variable in the local stack frame, as used in
    // load and store bytecodes

    private byte index;
    // index to the name of the local variable in the stringsTable
    private short nameIndex;
    // index to the type of the local variable in the stringsTable
    private short descriptorIndex;
    // index of the first bytecode in which the variable is in-scope
    // and valid
    private short startPc;
    // number of bytecodes in which the variable is in-scope and
    // valid
    private short length;

    public byte getIndex() {
        return index;
    }

    public void setIndex(byte index) {
        this.index = index;
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

    public short getStartPc() {
        return startPc;
    }

    public void setStartPc(short startPc) {
        this.startPc = startPc;
    }

    public short getLength() {
        return length;
    }

    public void setLength(short length) {
        this.length = length;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        VariableInfo out = new VariableInfo();

        out.index = this.index;
        out.nameIndex = this.nameIndex;
        out.descriptorIndex = this.descriptorIndex;
        out.startPc = this.startPc;
        out.length = this.length;

        return out;
    }
}
