/**
 * MethodHeaderInfo.java
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
 * method_header_info
 */
public class MethodHeaderInfo implements Cloneable {
    // bit[4] -> flags
    // bit[4] -> max_stack;
    private byte flags; // 4 bits value : 0x4

    // 4 bits max number of words required on the operand stack during
    // execution of this method
    private byte maxStack;

    // 4 bits number of words required to represent the parameters
    // passed to this method (including "this" if it's a virtual method)
    private byte nargs;

    // 4 bits number of words required to represent the local variables
    // declared by this method
    private byte maxLocals;

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t\t";
        StringBuffer ret = new StringBuffer();

        ret.append("// flags     : ").append(this.getFlags()).append(rl);
        ret.append("// max_stack : ").append(this.getMaxStack()).append(rl);
        ret.append("// nargs     : ").append(this.getNargs()).append(rl);
        ret.append("// max_locals: ").append(this.getMaxLocals());

        return ret.toString();
    }

    /**
     * Get Flags
     *
     * @return the flags
     */
    public byte getFlags() {
        return flags;
    }

    /**
     * Set Flag
     *
     * @param flags the flags to set
     */
    public void setFlags(byte flags) {
        this.flags = flags;
    }

    /**
     * Get max Stack
     *
     * @return the maxStack
     */
    public byte getMaxStack() {
        return maxStack;
    }

    /**
     * Set max Stack
     *
     * @param maxStack the maxStack to set
     */
    public void setMaxStack(byte maxStack) {
        this.maxStack = maxStack;
    }

    /**
     * Get nargs
     *
     * @return the nargs
     */
    public byte getNargs() {
        return nargs;
    }

    /**
     * Set nargs
     *
     * @param nargs the nargs to set
     */
    public void setNargs(byte nargs) {
        this.nargs = nargs;
    }

    /**
     * Get max Locals
     *
     * @return the maxLocals
     */
    public byte getMaxLocals() {
        return maxLocals;
    }

    /**
     * Set max locals
     *
     * @param maxLocals the maxLocals to set
     */
    public void setMaxLocals(byte maxLocals) {
        this.maxLocals = maxLocals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MethodHeaderInfo that = (MethodHeaderInfo) o;

        if (flags != that.flags) return false;
        if (maxLocals != that.maxLocals) return false;
        if (maxStack != that.maxStack) return false;
        if (nargs != that.nargs) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MethodHeaderInfo out = new MethodHeaderInfo();

        out.setFlags(this.getFlags());
        out.setMaxLocals(this.getMaxLocals());
        out.setMaxStack(this.getMaxStack());
        out.setNargs(this.getNargs());

        return out;
    }
}
