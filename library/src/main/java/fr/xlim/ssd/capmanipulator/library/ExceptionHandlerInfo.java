/**
 * ExceptionHandlerInfo.java
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
 * exception_handler_info
 */
public class ExceptionHandlerInfo implements Cloneable {
    // used with active_lenght to indicate the active range (try block) an
    // exception handler.
    private short startOffset;

    // union bitfield {
    // bit[1] stop_bit
    private byte stop_bit;
    // bit[15] active_length
    private short active_length;
    // }

    // byte offset into the info item of the Method_Component. Star of the
    // exception handler
    private short handlerOffset;

    // index into the constant_pool[] of the Constant Pool Component or
    // zero.
    private short catchTypeIndex;

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t\t";
        StringBuffer ret = new StringBuffer(rl);

        ret.append("start_offset     : 0x").append(Integer.toHexString(this.getStartOffset() & 0x00FFFF)).append(rl);
        ret.append("stop_bit         : ").append(this.getStopBit() & 0x01).append(rl);
        ret.append("active_length    : 0x").append(Integer.toHexString(this.getActiveLength() & 0x7FFF)).append(rl);
        ret.append("handler_offset   : 0x").append(Integer.toHexString(this.getHandlerOffset() & 0x00FFFF)).append(rl);
        ret.append("catch_type_index : 0x").append(Integer.toHexString(this.getCatchTypeIndex() & 0x00FFFF)).append(rl);

        return ret.toString();
    }

    /**
     * @return the startOffset
     */
    public short getStartOffset() {
        return startOffset;
    }

    /**
     * @param startOffset the startOffset to set
     */
    public void setStartOffset(short startOffset) {
        this.startOffset = startOffset;
    }

    /**
     * @return the bitfield
     */
    public short getBitfield() {
        return (short) ((this.active_length & 0x7FFF)
                | ((this.stop_bit & 0x01) << 15));
    }

    /**
     * @param bitfield the bitfield to set
     */
    public void setBitfield(short bitfield) {
        this.stop_bit = (byte) ((bitfield & 0x8000) == 0 ? 0 : 1);
        this.active_length = (short) (bitfield & 0x7FFF);
    }

    /**
     * @return the handlerOffset
     */
    public short getHandlerOffset() {
        return handlerOffset;
    }

    /**
     * @param handlerOffset the handlerOffset to set
     */
    public void setHandlerOffset(short handlerOffset) {
        this.handlerOffset = handlerOffset;
    }

    /**
     * @return the catchTypeIndex
     */
    public short getCatchTypeIndex() {
        return catchTypeIndex;
    }

    /**
     * @param catchTypeIndex the catchTypeIndex to set
     */
    public void setCatchTypeIndex(short catchTypeIndex) {
        this.catchTypeIndex = catchTypeIndex;
    }

    /**
     * Get the stop bit
     *
     * @return stop_bit value
     */
    public byte getStopBit() {
        return this.stop_bit;
    }

    /**
     * Set a new value for stop bit
     *
     * @param stop_bit new stop_bit value
     */
    public void setStopBit(byte stop_bit) {
        this.stop_bit = (byte) (stop_bit & 0x01);
    }

    /**
     * @return Get active length value
     */
    public short getActiveLength() {
        return active_length;
    }

    /**
     * Set a new value for active_length field
     *
     * @param active_length new value active_length value
     */
    public void setActiveLength(short active_length) {
        this.active_length = (short) (active_length & 0x7FFF);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExceptionHandlerInfo that = (ExceptionHandlerInfo) o;

        if (this.getBitfield() != that.getBitfield()) return false;
        if (catchTypeIndex != that.catchTypeIndex) return false;
        if (handlerOffset != that.handlerOffset) return false;
        if (startOffset != that.startOffset) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ExceptionHandlerInfo out = new ExceptionHandlerInfo();

        out.setStartOffset(this.getStartOffset());
        out.setBitfield(this.getBitfield());
        out.setHandlerOffset(this.getHandlerOffset());
        out.setCatchTypeIndex(this.getCatchTypeIndex());

        return out;
    }
}

