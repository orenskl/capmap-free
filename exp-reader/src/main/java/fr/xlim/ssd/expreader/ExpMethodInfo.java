package fr.xlim.ssd.expreader;

import java.io.IOException;
import java.util.List;

/**
 * Represents a method in an export file.
 */
public class ExpMethodInfo {

    byte token;
    short access_flags;
    short name_index;
    short descriptior_index;

    public ExpMethodInfo() {
    }

    public ExpMethodInfo(ExpExportFileStream in) throws IOException {
        setToken(in.readByte());
        setAccess_flags(in.readShort());
        setName_index(in.readShort());
        setDescriptior_index(in.readShort());
    }

    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append("Method info {\n");

        out.append("\t\t\t\t\tToken: " + token + "\n");
        out.append("\t\t\t\t\tAccess flags: 0x" + Integer.toHexString(access_flags) + "\n");
        out.append("\t\t\t\t\tName index: " + name_index + "\n");
        out.append("\t\t\t\t\tDescriptor index: " + descriptior_index + "\n");

        out.append("\t\t\t\t}\n");

        return out.toString();
    }

    /**
     * Returns the name of the method.
     * @param constantPool the constant pool used to get the name of the method.
     * @return the name of the method.
     */
    public String getName(List<ExpCpInfo> constantPool) {
        return ((ExpConstantUtf8) constantPool.get(name_index)).getBytesString();
    }

    /**
     * Returns the signature of the method.
     * @param constantPool the constant pool use to get the signature of the method.
     * @return the signature of the method.
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

    public Boolean isAbstract() {
        if ((access_flags & 1024) != 0)
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
}