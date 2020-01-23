package fr.xlim.ssd.expreader;

import java.io.IOException;
/**
 * Represents an integer in the constant pool of an export file
 */
public class ExpConstantInteger extends ExpCpInfo{

    int bytes;

    public ExpConstantInteger() {
        tag = EXP_CONSTANT_INTEGER;
    }

    public ExpConstantInteger(ExpExportFileStream in) throws IOException {
        tag = EXP_CONSTANT_INTEGER;
        setBytes(in.readInt());
    }

    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append("Constant Integer {\n");
        out.append("\t\t\tBytes: " + bytes + "\n");
        out.append("\t\t}\n");
        return out.toString();
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }
}