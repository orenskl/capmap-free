/**
 * LineInfo.java
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

import javax.sound.sampled.Line;

/**
 * LineInfo
 * <p/>
 * represents a mapping of a range of bytecode instructions to a
 * particular line in the source file that contains the method.
 *
 * @author Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 */
public class LineInfo implements Cloneable {
    // byte offset of the first bytecode i the range of instructions

    private short startPc;
    // byte offset of the last operand of the last bytecode in the
    // range of instruction
    private short endPc;
    // line number in the source file
    private short sourceLine;

    public short getStartPc() {
        return startPc;
    }

    public void setStartPc(short startPc) {
        this.startPc = startPc;
    }

    public short getEndPc() {
        return endPc;
    }

    public void setEndPc(short endPc) {
        this.endPc = endPc;
    }

    public short getSourceLine() {
        return sourceLine;
    }

    public void setSourceLine(short sourceLine) {
        this.sourceLine = sourceLine;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        LineInfo out = new LineInfo();

        out.startPc = this.startPc;
        out.endPc = this.endPc;
        out.sourceLine = this.sourceLine;

        return out;
    }
}
