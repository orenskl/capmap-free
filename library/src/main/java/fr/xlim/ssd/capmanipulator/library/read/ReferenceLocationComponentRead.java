/**
 * ReferenceLocationComponentRead.java
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

package fr.xlim.ssd.capmanipulator.library.read;

import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.ComponentEnum;
import fr.xlim.ssd.capmanipulator.library.ReferenceLocationComponent;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

import java.util.ArrayList;

public class ReferenceLocationComponentRead extends ComponentRead {

    @Override
    public Component load(CapInputStream in) throws UnableToReadCapFileException {

        ReferenceLocationComponent referenceLocationComponent = new ReferenceLocationComponent();

        super.load((byte) ComponentEnum.REFERENCE_LOCATION_COMPONENT.getValue(), in, referenceLocationComponent);

        // we reset the count of byte read to zero
        in.resetCount();

        referenceLocationComponent.setByteIndexCount(in.readShort());
        referenceLocationComponent.setOffsetsToByteIndices(new ArrayList<Byte>(referenceLocationComponent.getByteIndexCount()));

        for (int i = 0; i < referenceLocationComponent.getByteIndexCount(); i++) {
            referenceLocationComponent.getOffsetsToByteIndices().add(in.readByte());
        }

        referenceLocationComponent.setByte2IndexCount(in.readShort());
        referenceLocationComponent.setOffsetsToByte2Indices(new ArrayList<Byte>(referenceLocationComponent.getByte2IndexCount()));

        for (int i = 0; i < referenceLocationComponent.getByte2IndexCount(); i++) {
            referenceLocationComponent.getOffsetsToByte2Indices().add(in.readByte());
        }

        checkSize(in, referenceLocationComponent);

        this.MakeGlobalByteArray(referenceLocationComponent);

        return referenceLocationComponent;
    }

    /**
     * Generating the global OffsetsToByteIndices and OffsetsToByte2Indices
     *
     * @param referenceLocationComponent The Reference Location Component where the Global OffsetsToByte*Indices are generated
     */
    public void MakeGlobalByteArray(ReferenceLocationComponent referenceLocationComponent) {

        int offset_total = 0;

        ArrayList<Integer> offsetList = new ArrayList<Integer>();

        for (Byte offset : referenceLocationComponent.getOffsetsToByteIndices()) {
            offset_total += offset.byteValue() & 0x00FF;
            if (offset == (byte) 0xFF) continue;
            offsetList.add(offset_total);
        }

        referenceLocationComponent.setOffsetsToByteIndicesGlobal(offsetList);

        offsetList = new ArrayList<Integer>();
        offset_total = 0;

        for (Byte offset : referenceLocationComponent.getOffsetsToByte2Indices()) {
            offset_total += offset.byteValue() & 0x00FF;
            if (offset == (byte) 0xFF) continue;
            offsetList.add(offset_total);
        }

        referenceLocationComponent.setOffsetsToByte2IndicesGlobal(offsetList);

    }

}
