package fr.xlim.ssd.expreader;

import java.io.IOException;
import java.util.List;
/**
 * Represents a package in the constant pool of an export file
 */
public class ExpConstantPackage extends ExpCpInfo{

    byte flags;
    short name_index;
    byte minor_version;
    byte major_version;
    byte aid_length;
    byte aid[];

    public ExpConstantPackage() {
        tag = EXP_CONSTANT_PACKAGE;
    }

    public ExpConstantPackage(ExpExportFileStream in) throws IOException {
        tag = EXP_CONSTANT_PACKAGE;

        setFlags(in.readByte());
        setName_index(in.readShort());
        setMinor_version(in.readByte());
        setMajor_version(in.readByte());
        
        setAid_length(in.readByte());
        aid = new byte[aid_length];
        for(int count = 0; count < aid_length; count++) {
            aid[count] = in.readByte();
        }
    }
    
    public String toString() {
        StringBuffer out = new StringBuffer();
        
        out.append("Constant Package {\n");
        out.append("\t\t\tFlags: 0x" + Integer.toHexString(flags).toUpperCase() + "\n");
        out.append("\t\t\tName index: " + name_index + "\n");
        out.append("\t\t\tVersion: " + major_version + "." + minor_version + "\n");
        out.append("\t\t\tAID length: " + aid_length);
        out.append("\t\t\tAID: " + Integer.toHexString(aid[0] & 0x0FF).toUpperCase());
        for(int count = 1; count < aid_length; count++) {
            out.append(":" + Integer.toHexString(aid[count] & 0x0FF).toUpperCase());
        }
        out.append("\n");
        out.append("\t\t}\n");

        return out.toString();
    }

    /**
     * Returns the name of the package
     *
     * @param constantPool the constant pool used to get the name of the package.
     * @return the name of the package
     */
    public String getName(List<ExpCpInfo> constantPool) {
        return ((ExpConstantUtf8) constantPool.get(name_index)).getBytesString();
    }

    public Boolean isLibrary() {
        if ((flags & 1) != 0)
            return true;
        else
            return false;
    }

    public byte getFlags() {
        return flags;
    }

    public void setFlags(byte flags) {
        this.flags = flags;
    }

    public short getName_index() {
        return name_index;
    }

    public void setName_index(short name_index) {
        this.name_index = name_index;
    }

    public byte getMinor_version() {
        return minor_version;
    }

    public void setMinor_version(byte minor_version) {
        this.minor_version = minor_version;
    }

    public byte getMajor_version() {
        return major_version;
    }

    public void setMajor_version(byte major_version) {
        this.major_version = major_version;
    }

    public byte getAid_length() {
        return aid_length;
    }

    public void setAid_length(byte aid_length) {
        this.aid_length = aid_length;
    }

    public byte[] getAid() {
        return aid;
    }

    public void setAid(byte[] aid) {
        this.aid = aid;
    }
}