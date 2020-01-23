package fr.xlim.ssd.expreader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a class in the export file
 */
public class ExpClassInfo {

    byte token;
    short access_flags;
    short name_index;
    short export_supers_count;
    short supers[];
    byte export_interfaces_count;
    short interfaces[];
    short export_fields_count;
    List<ExpFieldInfo> fields = new ArrayList<ExpFieldInfo>();
    short export_methods_count;
    List<ExpMethodInfo> methods = new ArrayList<ExpMethodInfo>();

    public ExpClassInfo() {
    }

    public ExpClassInfo(ExpExportFileStream in) throws IOException {
        setToken(in.readByte());
        setAccess_flags(in.readShort());
        setName_index(in.readShort());

        setExport_supers_count(in.readShort());
        supers = new short[export_supers_count];
        for(int count = 0; count < export_supers_count; count++) {
            supers[count] = in.readShort();
        }
        
        setExport_interfaces_count(in.readByte());
        interfaces = new short[export_interfaces_count];
        for(int count = 0; count < export_interfaces_count; count++) {
            interfaces[count] = in.readShort();
        }
        
        setExport_fields_count(in.readShort());
        for(int count = 0; count < export_fields_count; count++) {
            fields.add(new ExpFieldInfo(in));
        }
        
        setExport_methods_count(in.readShort());
        for(int count = 0; count < export_methods_count; count++) {
            methods.add(new ExpMethodInfo(in));
        }
    }

    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append("Class info {\n");
        
        out.append("\t\t\tToken: " + token + "\n");
        out.append("\t\t\tName index: " + name_index + "\n");
        
        out.append("\t\t\tExport Supers count: " + export_supers_count + "\n");
        if(export_supers_count > 0) {
            out.append("\t\t\tExport Supers: " + supers[0]);
            for(int count = 1; count < export_supers_count; count++) {
                out.append(", " + supers[count]);
            }
            out.append("\n");
        }

        out.append("\t\t\tExport Interfaces count: " + export_interfaces_count + "\n");
        if(export_interfaces_count > 0) {
            out.append("\t\t\tExport Interfaces: " + interfaces[0]);
            for(int count = 1; count < export_interfaces_count; count++) {
                out.append(", " + interfaces[count]);
            }
            out.append("\n");
        }

        out.append("\t\t\tExport Fields count: " + export_fields_count + "\n");
        if(export_fields_count > 0) {
            out.append("\t\t\tExport Fields {\n");
            for(int count = 0; count < export_fields_count; count++) {
                out.append("\t\t\t\t#" + count + " " + fields.get(count).toString());
            }
            out.append("\t\t\t}\n");
        }

        out.append("\t\t\tExport Methods count: " + export_methods_count + "\n");
        if(export_methods_count > 0) {
            out.append("\t\t\tExport Methods {\n");
            for(int count = 0; count < export_methods_count; count++) {
                out.append("\t\t\t\t#" + count + " " + methods.get(count).toString());
            }
            out.append("\t\t\t}\n");
        }

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
        return ((ExpConstantClassref) constantPool.get(name_index)).getName(constantPool);
    }

    public Boolean isPublic() {
        if ((access_flags & 1) != 0)
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

    public Boolean isInterface() {
        if ((access_flags & 512) != 0)
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

    public Boolean isShareable() {
        if ((access_flags & 2048) != 0)
            return true;
        else
            return false;
    }

    public Boolean isRemote() {
        if ((access_flags & 4096) != 0)
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

    public short getExport_supers_count() {
        return export_supers_count;
    }

    public void setExport_supers_count(short export_supers_count) {
        this.export_supers_count = export_supers_count;
    }

    public short[] getSupers() {
        return supers;
    }

    public void setSupers(short[] supers) {
        this.supers = supers;
    }

    public byte getExport_interfaces_count() {
        return export_interfaces_count;
    }

    public void setExport_interfaces_count(byte export_interfaces_count) {
        this.export_interfaces_count = export_interfaces_count;
    }

    public short[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(short[] interfaces) {
        this.interfaces = interfaces;
    }

    public short getExport_fields_count() {
        return export_fields_count;
    }

    public void setExport_fields_count(short export_fields_count) {
        this.export_fields_count = export_fields_count;
    }

    public List<ExpFieldInfo> getFields() {
        return fields;
    }

    public void setFields(List<ExpFieldInfo> fields) {
        this.fields = fields;
    }

    public short getExport_methods_count() {
        return export_methods_count;
    }

    public void setExport_methods_count(short export_methods_count) {
        this.export_methods_count = export_methods_count;
    }

    public List<ExpMethodInfo> getMethods() {
        return methods;
    }

    public void setMethods(List<ExpMethodInfo> methods) {
        this.methods = methods;
    }
}