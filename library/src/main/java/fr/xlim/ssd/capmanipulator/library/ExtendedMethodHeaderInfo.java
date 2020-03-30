/**
 * ExtendedMethodHeaderInfo.java
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
 * extended_method_header_info
 */
public class ExtendedMethodHeaderInfo extends MethodHeaderInfo {
    private byte padding;

    /* (non-Javadoc)
     * @see fr.xlim.ssd.capmanipulator.library.MethodComponent.MethodInfo.MethodHeaderInfo#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t\t";
        StringBuffer ret = new StringBuffer(rl);

        ret.append("flags      : ").append(this.getFlags()).append(rl);
        ret.append("padding    : ").append(this.getPadding()).append(rl);
        ret.append("max_stack  : ").append(this.getMaxStack()).append(rl);
        ret.append("nargs      : ").append(this.getNargs()).append(rl);
        ret.append("max_locals : ").append(this.getMaxLocals()).append(rl);

        return ret.toString();
    }

    /**
     * Get padding
     *
     * @return the padding
     */
    public byte getPadding() {
        return padding;
    }

    /**
     * Set padding
     *
     * @param padding the padding to set
     */
    public void setPadding(byte padding) {
        this.padding = padding;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ExtendedMethodHeaderInfo out = new ExtendedMethodHeaderInfo();

        out.setFlags(this.getFlags());
        out.setMaxLocals(this.getMaxLocals());
        out.setMaxStack(this.getMaxStack());
        out.setNargs(this.getNargs());
        out.setPadding(this.getPadding());

        return out;
    }
}
