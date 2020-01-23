package fr.xlim.ssd.expreader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a field in an export file.
 */
class ExpFieldInfo {

    byte token;
    short access_flags;
    short name_index;
    short descriptior_index;
    short attributes_count;
    List<ExpAttributeConstant> attributes = new ArrayList<ExpAttributeConstant>();

    public ExpFieldInfo() {
    }

    public ExpFieldInfo(ExpExportFileStream in) throws IOException {
        setToken(in.readByte());
        setAccess_flags(in.readShort());
        setName_index(in.readShort());
        setDescriptior_index(in.readShort());

        setAttributes_count(in.readShort());
        for(int count = 0; count < attributes_count; count++) {

            /* TODO
            * Verify that constant Attribute is the only one available attribute */
            if(((access_flags & 8)!=0) && ((access_flags & 1)!=0))
                attributes.add(new ExpAttributeConstant(in));
            else
                attributes.add(new ExpAttributeConstant(in));
        }
    }

    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append("Field info {\n");

        out.append("\t\t\t\t\tToken: " + token + "\n");
        out.append("\t\t\t\t\tAccess flags: 0x" + Integer.toHexString(access_flags) + "\n");
        out.append("\t\t\t\t\tName index: " + name_index + "\n");
        out.append("\t\t\t\t\tDescriptor index: " + descriptior_index + "\n");

        out.append("\t\t\t\t\tAttributes count: " + attributes_count + "\n");
        out.append("\t\t\t\t\tAttributes info {\n");
        for(int count = 0; count < attributes_count; count++) {
            out.append("\t\t\t\t\t\t#" + count + " " + attributes.get(count).toString());
        }
        out.append("\t\t\t\t\t}\n");

        out.append("\t\t\t\t}\n");

        return out.toString();
    }

    /**
     * Returns the name of the field.
     * @param constantPool the constant pool used to get the name of the field.
     * @return the name of the field.
     */
    public String getName(List<ExpCpInfo> constantPool) {
        return ((ExpConstantUtf8) constantPool.get(name_index)).getBytesString();
    }

    /**
     * Returns the type of the field.
     * @param constantPool the constant pool used ti get the type of the field.
     * @return the type of the field.
     */
    public String getDescriptor(List<ExpCpInfo> constantPool) {
        return ((ExpConstantUtf8) constantPool.get(descriptior_index)).getBytesString();
    }

    public Boolean isPublic() {
        if ((access_flags & 1) != 0)
            return true;
        else
            return false;
    }

    public Boolean isProtected() {
        if ((access_flags & 4) != 0)
            return true;
        else
            return false;
    }

    public Boolean isStatic() {
        if ((access_flags & 8) != 0)
            return true;
        else
            return false;
    }

    public Boolean isFinal() {
        if ((access_flags & 16) != 0)
            return true;
        else
            return false;
    }

    public byte getToken() {
        return token;
    }

    public void setToken(byte token) {
        this.token = token;
    }

    public short getAccess_flags() {
        return access_flags;
    }

    public void setAccess_flags(short access_flags) {
        this.access_flags = access_flags;
    }

    public short getName_index() {
        return name_index;
    }

    public void setName_index(short name_index) {
        this.name_index = name_index;
    }

    public short getDescriptior_index() {
        return descriptior_index;
    }

    public void setDescriptior_index(short descriptior_index) {
        this.descriptior_index = descriptior_index;
    }

    public short getAttributes_count() {
        return attributes_count;
    }

    public void setAttributes_count(short attributes_count) {
        this.attributes_count = attributes_count;
    }

    public List<ExpAttributeConstant> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ExpAttributeConstant> attributes) {
        this.attributes = attributes;
    }
}