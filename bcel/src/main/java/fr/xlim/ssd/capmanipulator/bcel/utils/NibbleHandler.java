/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.xlim.ssd.capmanipulator.bcel.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allow an easy manipulation of nibbles.
 * Used in <em>SignatureBuilder</em>.
 *
 * @author Jean-Baptiste Machemie
 */
public class NibbleHandler {


    private byte NIBBLE_SHIFT   = 4;
    private byte BYTE_SHIFT     = 8;
    private byte SHORT_SHIFT    = 12;

    byte NIBBLE_MASK    = 0x0F;

    private List<Byte> nibbleList = new ArrayList<Byte>();
    private Integer nibbleCount;

    /**
     * Constructor by copy
     *
     * @param nibbleList
     * @param nibbleCount
     */
    public NibbleHandler(List<Byte> nibbleList, Integer nibbleCount) {
        this.nibbleList = nibbleList;
        this.nibbleCount = nibbleCount;
    }

    /**
     * Empty constructor
     *
     */
    public NibbleHandler() {

    }

    /**
     * Constructor from a Byte.
     * Extract each nibble based on the Byte in parameter (2 nibbles).
     *
     * @param source
     */
    public NibbleHandler(Byte source) {

        nibbleList.add((byte) ((source >> NIBBLE_SHIFT) & NIBBLE_MASK));
        nibbleList.add((byte) (source & NIBBLE_MASK));
    }

    /**
     * Constructor from a Short.
     * Extract each nibble based on the Short in parameter (4 nibbles).
     *
     * @param source
     */
    public NibbleHandler(Short source) {

        nibbleList.add((byte) ((source >> SHORT_SHIFT ) & NIBBLE_MASK));
        nibbleList.add((byte) ((source >> BYTE_SHIFT  ) & NIBBLE_MASK));
        nibbleList.add((byte) ((source >> NIBBLE_SHIFT) & NIBBLE_MASK));
        nibbleList.add((byte) (source & NIBBLE_MASK));

    }


    /**
     * Convert the <em>Lisr</em>
     *
     * @return
     */
    public List<Character> toCharArray() {

        List<Character> ret = new ArrayList<Character>();

        for (Byte element : nibbleList) {

            ret.add(Integer.toHexString(element).charAt(0));
        }

        return ret;
    }


    public Integer getNibbleCount() {
        return nibbleCount;
    }

    public void setNibbleCount(Integer nibbleCount) {
        this.nibbleCount = nibbleCount;
    }

    public List<Byte> getNibbleList() {
        return nibbleList;
    }

    public void setNibbleList(List<Byte> nibbleList) {
        this.nibbleList = nibbleList;
    }

}
