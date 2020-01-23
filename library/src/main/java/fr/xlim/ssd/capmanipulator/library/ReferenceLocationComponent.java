/**
 * ReferenceLocationComponent.java
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
 * ReferenceLocationComponent
 * <p/>
 * this componentTab represents list of offsets into the info item of the Method
 * Component to items that contain indices into the constant_pool[] array of the
 * Constant Pool Component. This includes all constant pool index operands of
 * instructions, and all non-zero cath_type_index items of the
 * exception_handlers array
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class ReferenceLocationComponent extends Component {

    // number of elements in the offsets_to_byte_indices array
    private short byteIndexCount;
    // array of 1-byte jump offsets into the info item of the Method Component
    // to each 1-byte constant_pool[] array index. Each entry represents the
    // number of bytes between the current index to the next
    private ArrayList<Byte> offsetsToByteIndices;
    // array of 1-byte offsets. This array contains the offset of each 1-byte
    // token into the Method Component
    private ArrayList<Integer> offsetsToByteIndicesGlobal;
    // number of elements in the offsets_to_byte2_indices array
    private short byte2IndexCount;
    // array of 1-byte jump offsets into the info item of the Method Component
    // to each 2-byte constant_pool[] array index. Each entry represents the
    // number of bytes between the current index to the next
    private ArrayList<Byte> offsetsToByte2Indices;
    // array of 2-byte offsets. This array contains the offset of each 2-byte
    // token into the Method Component
    private ArrayList<Integer> offsetsToByte2IndicesGlobal;

    /**
     * Get the Global OffsetsToByteIndices which contains a entry for each 1-byte token offset.
     *
     * @return The Global OffsetsToByteIndices which contains a entry for each 1-byte token offset.
     */
    public ArrayList<Integer> getOffsetsToByteIndicesGlobal() {
        return offsetsToByteIndicesGlobal;
    }

    /**
     * Set the Global OffsetsToByteIndices which contains a entry for each 1-byte token offset.
     *
     * @param offsetsToByteIndicesGlobal The new global OffsetsToByteIndices which contains a entry for each 1-byte token offset.
     */
    public void setOffsetsToByteIndicesGlobal(ArrayList<Integer> offsetsToByteIndicesGlobal) {
        this.offsetsToByteIndicesGlobal = offsetsToByteIndicesGlobal;
    }

    /**
     * Get the Global OffsetsTo2ByteIndices which contains a entry for each 1-byte token offset.
     *
     * @return The Global OffsetsTo2ByteIndices which contains a entry for each 1-byte token offset.
     */
    public ArrayList<Integer> getOffsetsToByte2IndicesGlobal() {
        return offsetsToByte2IndicesGlobal;
    }

    /**
     * Set the Global OffsetsToByte2Indices which contains a entry for each 1-byte token offset.
     *
     * @param offsetsToByte2IndicesGlobal The new global OffsetsToByte2Indices which contains a entry for each 1-byte token offset.
     */
    public void setOffsetsToByte2IndicesGlobal(ArrayList<Integer> offsetsToByte2IndicesGlobal) {
        this.offsetsToByte2IndicesGlobal = offsetsToByte2IndicesGlobal;
    }

    /* (non-Javadoc)
     * @see fr.xlim.ssd.capmanipulator.library.Component#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t";
        StringBuffer ret = new StringBuffer();

        ret.append(".ReferenceLocationComponent = {").append(rl);

        //ret.append(super.toString()).append(rl);

        //ret.append("byte_index_count : ").append(this.getByteIndexCount()).append(rl);

        ret.append("offsets_to_byte_indices = {");

        int offset = 0;
        int i = 0;

        if (this.getOffsetsToByteIndices().size() != 0)
            ret.append(rl).append("\t");
        for (int j = 0; j < this.getOffsetsToByteIndices().size(); j++) {
            byte b = this.getOffsetsToByteIndices().get(j);
            offset += (0xff) & b;

            /*if ((b ^ (byte) 0xFF) == 0)
                ret.append(String.format(" @%04x", b & 0xff));
            else
                ret.append(String.format(" @%04x(->@%04x)", b & 0xff, offset));*/
            ret.append(String.format("  @%04x", offset));

            i++;
            if (i > 7 && j + 1 < this.getOffsetsToByteIndices().size()) {
                ret.append(rl).append("\t");
                i = 0;
            }
        }

        ret.append(rl).append("}").append(rl);
        //ret.append("byte2_index_count : ").append(this.getByte2IndexCount()).append(rl);
        ret.append("offsets_to_byte2_indices = {");

        i = 0;
        offset = 0;

        if (this.getOffsetsToByte2Indices().size() != 0)
            ret.append(rl).append("\t");
        for (int j = 0; j < this.getOffsetsToByte2Indices().size(); j++) {
            byte b = this.getOffsetsToByte2Indices().get(j);

            offset += (int) (b & 0xFF);

            /*if (b == 0xFF)
                ret.append(String.format(" @%04x", b & 0xff));
            else
                ret.append(String.format(" @%04x(->@%04x)", b & 0xff, offset));*/
            ret.append(String.format("  @%04x", offset));

            i++;
            if (i > 7 && j + 1 < this.getOffsetsToByte2Indices().size()) {
                ret.append(rl).append("\t");
                i = 0;
            }
        }

        ret.append(rl).append("}");

        ret.append("\n}\n");

        return ret.toString();
    }

    /**
     * Get the value of byteIndexCount
     *
     * @return the value of byteIndexCount
     */
    public short getByteIndexCount() {
        return byteIndexCount;
    }

    /**
     * Set the value of byteIndexCount
     *
     * @param byteIndexCount the new value of byteIndexCount
     */
    public void setByteIndexCount(short byteIndexCount) {
        this.byteIndexCount = byteIndexCount;
    }

    /**
     * Get the value of offsetsToByteIndices
     *
     * @return the value of offsetsToByteIndices
     */
    public ArrayList<Byte> getOffsetsToByteIndices() {
        return offsetsToByteIndices;
    }

    /**
     * Set the value of offsetsToByteIndices
     *
     * @param byte2IndexCount the new value of offsetsToByteIndices
     */
    public void setOffsetsToByteIndices(ArrayList<Byte> byte2IndexCount) {
        this.offsetsToByteIndices = byte2IndexCount;
    }

    /**
     * Get the value of byte2IndexCount
     *
     * @return the value of byte2IndexCount
     */
    public short getByte2IndexCount() {
        return byte2IndexCount;
    }

    /**
     * Set the value of byte2IndexCount
     *
     * @param byte2IndexCount the new value of byte2IndexCount
     */
    public void setByte2IndexCount(short byte2IndexCount) {
        this.byte2IndexCount = byte2IndexCount;
    }

    /**
     * Get the value of offsetsToByte2Indices
     *
     * @return the value of offsetsToByte2Indices
     */
    public ArrayList<Byte> getOffsetsToByte2Indices() {
        return this.offsetsToByte2Indices;
    }

    /**
     * Set the value of offsetsToByte2Indices
     *
     * @param offsetsToByte2Indices the new value of offsetsToByte2Indices
     */
    public void setOffsetsToByte2Indices(ArrayList<Byte> offsetsToByte2Indices) {
        this.offsetsToByte2Indices = offsetsToByte2Indices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReferenceLocationComponent that = (ReferenceLocationComponent) o;

        if (byte2IndexCount != that.byte2IndexCount) return false;
        if (byteIndexCount != that.byteIndexCount) return false;
        if (!offsetsToByte2Indices.equals(that.offsetsToByte2Indices)) return false;
        if (!offsetsToByteIndices.equals(that.offsetsToByteIndices)) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ReferenceLocationComponent out = new ReferenceLocationComponent();

        out.setTag(this.getTag());
        out.setSize(this.getSize());

        out.setByteIndexCount(this.getByteIndexCount());

        ArrayList<Byte> offsetsToByteIndices = new ArrayList<>();
        for (Byte b : this.getOffsetsToByteIndices()) {
            offsetsToByteIndices.add(b.byteValue());
        }
        out.setOffsetsToByteIndices(offsetsToByteIndices);

        out.setByte2IndexCount(this.getByte2IndexCount());
        ArrayList<Byte> offsetsToByte2Indices = new ArrayList<>();
        for (Byte b : this.getOffsetsToByte2Indices()) {
            offsetsToByte2Indices.add(b.byteValue());
        }
        out.setOffsetsToByte2Indices(offsetsToByte2Indices);

        return out;
    }
}
