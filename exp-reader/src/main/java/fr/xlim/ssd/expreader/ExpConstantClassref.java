package fr.xlim.ssd.expreader;

import java.io.IOException;
import java.util.List;

/**
 * Represents a class reference in the constant pool of an export file
 */
public class ExpConstantClassref extends ExpCpInfo{

    short name_index;

    public ExpConstantClassref() {
        tag = EXP_CONSTANT_CLASSREF;
    }

    public ExpConstantClassref(ExpExportFileStream in) throws IOException {
        tag = EXP_CONSTANT_CLASSREF;
        setName_index(in.readShort());
    }
    
    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append("Constant Class ref {\n");
        out.append("\t\t\tName index: " + name_index +"\n");
        out.append("\t\t}\n");
        return out.toString();
    }

    /**
     * Returns the name of the class
     *
     * @param constantPool the constant pool used to get the name of the class.
     * @return the name of the class
     */
    public String getName(List<ExpCpInfo> constantPool) {
        return ((ExpConstantUtf8) constantPool.get(name_index)).getBytesString();
    }

    public short getName_index() {
        return name_index;
    }

    public void setName_index(short name_index) {
        this.name_index = name_index;
    }
}