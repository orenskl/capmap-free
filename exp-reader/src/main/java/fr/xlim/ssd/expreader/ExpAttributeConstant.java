package fr.xlim.ssd.expreader;

import java.io.IOException;
import java.util.List;

/**
 * Represents a constant attribute of a field in an export file.
 */
public class ExpAttributeConstant{

    short attribute_name_index;
    int attribute_length;
    short constantValue ;

    public ExpAttributeConstant() {
    }

    public ExpAttributeConstant(ExpExportFileStream in) throws IOException {
        setAttribute_name_index(in.readShort());
        setAttribute_length(in.readInt());
        setConstantValue(in.readShort());
    }

    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append("Attribute Constant value {\n");

        out.append("\t\t\t\t\t\t\tAttribute Name index: " + attribute_name_index + "\n");
        out.append("\t\t\t\t\t\t\tAttribute length:" + attribute_length + "\n");
        out.append("\t\t\t\t\t\t\tConstant vlaue: " + constantValue + "\n");
        out.append("\t\t\t\t\t\t}\n");

        return out.toString();
    }

    /**
     * Returns the name of the attribute.
     * @param constantPool the constant pool used to get the name of the attriute.
     * @return the name of the attribute.
     */
    public String getAttributeName(List<ExpCpInfo> constantPool) {
        return ((ExpConstantUtf8) constantPool.get(attribute_name_index)).getBytesString();
    }

    public short getAttribute_name_index() {
        return attribute_name_index;
    }

    public void setAttribute_name_index(short attribute_name_index) {
        this.attribute_name_index = attribute_name_index;
    }

    public int getAttribute_length() {
        return attribute_length;
    }

    public void setAttribute_length(int attribute_length) {
        this.attribute_length = attribute_length;
    }

    public short getConstantValue() {
        return constantValue;
    }

    public void setConstantValue(short constantValue) {
        this.constantValue = constantValue;
    }
}
