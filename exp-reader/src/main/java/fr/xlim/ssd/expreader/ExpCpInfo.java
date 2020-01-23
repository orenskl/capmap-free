package fr.xlim.ssd.expreader;


/**
 * Represents the generic constant pool info in an export file.
 */
public abstract class ExpCpInfo {

    public static final byte EXP_CONSTANT_UTF8 = 1;
    public static final byte EXP_CONSTANT_INTEGER = 3;
    public static final byte EXP_CONSTANT_CLASSREF = 7;
    public static final byte EXP_CONSTANT_PACKAGE = 13;

    byte tag;

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
         this.tag = tag;
    }
}