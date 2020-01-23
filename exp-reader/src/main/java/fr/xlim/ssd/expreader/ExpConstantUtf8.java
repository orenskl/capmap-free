package fr.xlim.ssd.expreader;

import java.io.IOException;

/**
 * Represents a package in the constant pool of an export file
 */
public class ExpConstantUtf8 extends ExpCpInfo{

    short length;
    byte bytes[];

    public ExpConstantUtf8() {
        tag = EXP_CONSTANT_UTF8;
    }

    public ExpConstantUtf8(ExpExportFileStream in) throws IOException {
        tag = EXP_CONSTANT_UTF8;
        setLength(in.readShort());
        bytes = new byte[length];
        for(int count = 0; count < length; count++) {
            bytes[count] = in.readByte();
        }
    }

    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append("Constant Utf8 {\n");
        out.append("\t\t\tLength: " + length + "\n");
        out.append("\t\t\tbytes: " + Integer.toHexString(bytes[0] & 0x0FF));
        for(int count = 1; count < length; count++) {
            out.append(" " + Integer.toHexString(bytes[count] & 0x0FF).toUpperCase());
        }
        out.append("\t" + getBytesString());
        out.append("\n");
        out.append("\t\t}\n");
        return out.toString();
    }

    /**
     * Returns the utf8 string
     * @return the utf8 string
     */
    public String getBytesString() {
        StringBuffer bytesString = new StringBuffer();

        for (int i=0; i<length; i++) {
            bytesString.append((char) bytes[i]);
        }

        return bytesString.toString();
    }
    
    public short getLength() {
        return length;
    }
    public void setLength(short length) {
        this.length = length;
    }
    public byte[] getBytes() {
        return bytes;
    }
    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}