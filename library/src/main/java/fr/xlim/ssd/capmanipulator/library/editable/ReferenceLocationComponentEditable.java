/**
 * MethodInfoEditable.java
 * <p>
 * Copyright (C) 2013 Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 * <p>
 * Xlim - Université de Limoges
 */

package fr.xlim.ssd.capmanipulator.library.editable;

import fr.xlim.ssd.capmanipulator.library.CapFile;
import fr.xlim.ssd.capmanipulator.library.ReferenceLocationComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

/**
 * Class which contains some method to update Reference Location component.
 *
 * @author Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 */
public class ReferenceLocationComponentEditable extends ReferenceLocationComponent {

    private final static Logger logger = LoggerFactory.getLogger(ReferenceLocationComponentEditable.class);
    private CapFile capFile;
    private ReferenceLocationComponent referenceLocationComponent;

    /**
     * Default constructor
     *
     * @param capFile reference to the CapFile to update
     */
    public ReferenceLocationComponentEditable(CapFile capFile) {
        this.capFile = capFile;
        this.referenceLocationComponent = capFile.getReferenceLocationComponent();
    }

    /**
     * this function edit the offset_to_byte_indices array and update the size of the componentTab
     *
     * @param offsetToByteIndicesArray new offset_to_byte_indices array
     */
    protected void editOffsetsToByteIndices(ArrayList<Short> offsetToByteIndicesArray) {

        //we create a temporary List
        ArrayList<Byte> arrayTemp = new ArrayList<Byte>();

        byte formerOffset = 0;

        for (short s : offsetToByteIndicesArray) {


            while (((s - formerOffset) & 0xff) >= (short) 0xff) {
                arrayTemp.add((byte) 0xff);
                s -= (short) 0xff;
            }
            arrayTemp.add((byte) (s - formerOffset));
            formerOffset += (s - formerOffset);
        }

        this.referenceLocationComponent.setOffsetsToByteIndices(arrayTemp);
        this.referenceLocationComponent.setByteIndexCount((short) arrayTemp.size());
        this.calculateSize();

    }

    /**
     * this function edit the offset_to_byte2_indices array and update the size of the componentTab
     *
     * @param offsetToByte2Indices new offset_to_byte2_indices array
     */
    protected void editOffsetsToByte2Indices(ArrayList<Short> offsetToByte2Indices) {

        //we create a temporary List
        ArrayList<Byte> arrayTemp = new ArrayList<Byte>();

        byte formerOffset = 0;

        for (short s : offsetToByte2Indices) {


            while (((s - formerOffset) & 0xff) >= (short) 0xff) {
                System.err.println(Integer.toHexString(s));
                arrayTemp.add((byte) 0xff);
                s -= (short) 0xff;
            }
            arrayTemp.add((byte) (s - formerOffset));
            formerOffset += (s - formerOffset);
        }

        this.referenceLocationComponent.setOffsetsToByte2Indices(arrayTemp);
        this.referenceLocationComponent.setByte2IndexCount((short) arrayTemp.size());
        this.calculateSize();
    }

    /**
     * Update Reference Location Size into the Directory Component
     */
    protected void calculateSize() {

        short newSize = 2; // size of byteIndexCount
        newSize += this.referenceLocationComponent.getOffsetsToByteIndices().size();
        newSize += 2; // size of bite2IndexCount
        newSize += this.referenceLocationComponent.getOffsetsToByte2Indices().size();

        // we update the size of the componentTab
        logger.trace("Updating Reference Location Component size");
        this.referenceLocationComponent.setSize(newSize);

        this.referenceLocationComponent.setByteIndexCount((short) this.referenceLocationComponent.getOffsetsToByteIndices().size());
        this.referenceLocationComponent.setByte2IndexCount((short) this.referenceLocationComponent.getOffsetsToByte2Indices().size());

        // we also update this value in the Directory componentTab
        logger.trace("Updating Reference Location Component size into the Directory Component");
        this.capFile.getDirectoryComponent().setReferenceLocationComponentSize(this.referenceLocationComponent.getSize());
    }

    /**
     * method correcting the offset, to the methodComponent, into the reference
     * location componentTab, once and opcode has been added
     *
     * @param pcAddedInstruction offset where the instruction was added
     * @param size_new_element   the added opcode size_new_element (should be <0 when you delete and opcode)
     */
    public void correctReferenceLocationComponentOffset(int pcAddedInstruction, int size_new_element) {

        // Computing Global Byte Arrays
        MakeGlobalByteArray(this.referenceLocationComponent);

        logger.trace("Updating OffsetsToByteIndices");

        ListIterator iterator = this.referenceLocationComponent.getOffsetsToByteIndicesGlobal().listIterator();

        while (iterator.hasNext()) {
            int offset = (Integer) iterator.next();
            if (offset >= pcAddedInstruction) {
                iterator.set(offset + size_new_element);
            }
        }

        logger.trace("Updating OffsetsToByteIndices2");
        iterator = this.referenceLocationComponent.getOffsetsToByte2IndicesGlobal().listIterator();

        logger.debug("pc ins to add 0x" + Integer.toHexString(pcAddedInstruction));

        while (iterator.hasNext()) {
            int offset = (Integer) iterator.next();
            if (offset >= pcAddedInstruction) {
                iterator.set(offset + size_new_element);
            }
        }

        logger.trace("Updating Reference Location's sizes");
        Collections.sort(this.referenceLocationComponent.getOffsetsToByteIndicesGlobal());
        this.capFile.getReferenceLocationComponent().setOffsetsToByteIndices(this.updateOffsetsToByteIndices(this.referenceLocationComponent.getOffsetsToByteIndicesGlobal()));
        Collections.sort(this.referenceLocationComponent.getOffsetsToByte2IndicesGlobal());
        this.capFile.getReferenceLocationComponent().setOffsetsToByte2Indices(this.updateOffsetsToByteIndices(this.referenceLocationComponent.getOffsetsToByte2IndicesGlobal()));
        this.calculateSize();
    }

    /**
     * Method correcting the offset, to the methodComponent, into the reference
     * location componentTab, once and opcode has been removed
     *
     * @param addOffset offset where the instruction was removed
     * @param size      the removed opcode size
     */
    @Deprecated
    public void correctReferenceLocationComponentOffsetWhenRemove(int addOffset, int size) {

        logger.trace("Updating OffsetsToByteIndices");
        //correctReferenceLocationComponentOffsetWhenRemove2(addOffset, size, capFile.getReferenceLocationComponent().getOffsetsToByteIndices());

        MakeGlobalByteArray(this.referenceLocationComponent);

        ListIterator iterator = this.referenceLocationComponent.getOffsetsToByteIndicesGlobal().listIterator();

        while (iterator.hasNext()) {
            Integer offset = (Integer) iterator.next();
            if (offset == (addOffset + 1)) {
                iterator.remove();
                continue;
            }

            if (offset > addOffset) {
                iterator.set(offset - size);
            }
        }

        logger.trace("Updating OffsetsToByte2Indices");
        //correctReferenceLocationComponentOffsetWhenRemove2(addOffset, size, capFile.getReferenceLocationComponent().getOffsetsToByte2Indices());

        iterator = this.referenceLocationComponent.getOffsetsToByte2IndicesGlobal().listIterator();

        while (iterator.hasNext()) {
            Integer offset = (Integer) iterator.next();
            if (offset == (addOffset + 1)) {
                iterator.remove();
                continue;
            }

            if (offset > addOffset) {
                iterator.set(new Integer(offset - size));
            }
        }

        logger.trace("Updating Reference Location's sizes");
        Collections.sort(this.referenceLocationComponent.getOffsetsToByteIndicesGlobal());
        this.capFile.getReferenceLocationComponent().setOffsetsToByteIndices(this.updateOffsetsToByteIndices(this.referenceLocationComponent.getOffsetsToByteIndicesGlobal()));
        Collections.sort(this.referenceLocationComponent.getOffsetsToByte2IndicesGlobal());
        this.capFile.getReferenceLocationComponent().setOffsetsToByte2Indices(this.updateOffsetsToByteIndices(this.referenceLocationComponent.getOffsetsToByte2IndicesGlobal()));
        this.calculateSize();
    }

    /**
     * Generating the offsets to (2-)Byte Indices
     *
     * @param globalOffsets
     * @return (2 -)Byte offsets indices outputed
     */
    private ArrayList<Byte> updateOffsetsToByteIndices(ArrayList<Integer> globalOffsets) {
        ArrayList<Byte> offsetToIndices = new ArrayList<Byte>();

        if (globalOffsets.size() == 0) return offsetToIndices;

        // Creating the first offset
        Integer offset = globalOffsets.get(0);
        while (offset > 0x00FF) {
            offsetToIndices.add((byte) 0xFF);
            offset -= 0x00FF;
        }
        offsetToIndices.add((byte) (offset & 0x00FF));

        for (int index = 1; index < globalOffsets.size(); ++index) {
            offset = globalOffsets.get(index);
            short delta = (short) (offset - globalOffsets.get(index - 1));

            while (delta >= 0x00FF) {
                offsetToIndices.add((byte) 0xFF);
                delta -= 0x00FF;
            }
            offsetToIndices.add((byte) (delta & 0x00FF));

        }

        return offsetToIndices;

    }

    /**
     * Adding an offset into the OffsetsToByteIndices
     *
     * @param offset Offset to add into the OffsetsToByteIndices
     */
    public void add1ByteOffset(int offset) {
        MakeGlobalByteArray(this.referenceLocationComponent);
        ArrayList<Integer> offsets = this.referenceLocationComponent.getOffsetsToByteIndicesGlobal();
        offsets.add(offset);
        Collections.sort(offsets);
        this.capFile.getReferenceLocationComponent().setOffsetsToByteIndices(this.updateOffsetsToByteIndices(offsets));
        this.calculateSize();
    }

    /**
     * Removing an offset into the OffsetsToByteIndices
     *
     * @param offset Offset to remove into the OffsetsToByteIndices
     */
    public void remove1ByteOffset(int offset) {
        MakeGlobalByteArray(this.referenceLocationComponent);
        ArrayList<Integer> offsets = this.referenceLocationComponent.getOffsetsToByteIndicesGlobal();
        offsets.remove(offset);
        // Collections.sort(offsets); // XXX: useless!
        this.capFile.getReferenceLocationComponent().setOffsetsToByteIndices(this.updateOffsetsToByteIndices(offsets));
        this.calculateSize();
    }

    /**
     * Adding an offset into the OffsetsTo2ByteIndices
     *
     * @param offset Offset to add into the OffsetsTo2ByteIndices
     */
    public void add2ByteOffset(int offset) {
        MakeGlobalByteArray(this.referenceLocationComponent);
        ArrayList<Integer> offsets = this.referenceLocationComponent.getOffsetsToByte2IndicesGlobal();
        offsets.add(offset);
        Collections.sort(offsets);
        ArrayList<Byte> off = this.updateOffsetsToByteIndices(offsets);
        this.capFile.getReferenceLocationComponent().setOffsetsToByte2Indices(off);
        this.calculateSize();
    }

    /**
     * Removing an offset into the OffsetsTo2ByteIndices
     *
     * @param offset Offset to remove into the OffsetsTo2ByteIndices
     */
    public void remove2ByteOffset(int offset) {
        MakeGlobalByteArray(this.referenceLocationComponent);
        ArrayList<Integer> offsets = this.referenceLocationComponent.getOffsetsToByte2IndicesGlobal();
        offsets.remove(offset);
        // Collections.sort(offsets); // XXX: useless!
        this.capFile.getReferenceLocationComponent().setOffsetsToByte2Indices(this.updateOffsetsToByteIndices(offsets));
        this.calculateSize();
    }

    /**
     * Generating the global OffsetsToByteIndices and OffsetsToByte2Indices
     *
     * @param referenceLocationComponent The Reference Location Component where the Global OffsetsToByte*Indices are generated
     */
    protected void MakeGlobalByteArray(ReferenceLocationComponent referenceLocationComponent) {

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
