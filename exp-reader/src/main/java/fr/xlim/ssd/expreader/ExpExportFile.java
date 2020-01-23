package fr.xlim.ssd.expreader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 * Represents a Export File for a Javacard Applet or Library.
 */
public class ExpExportFile {

    int magic;
    byte minor_version;
    byte major_version;
    short constant_pool_count;
    List<ExpCpInfo> constant_pool = new ArrayList<ExpCpInfo>();
    short this_package;
    byte export_class_count;
    List<ExpClassInfo> classes = new ArrayList<ExpClassInfo>();

    /**
     * Create a new empty ExpExportFile instance.
     */
    public ExpExportFile() {
    }

    /**
     * Create a new ExpExportFile instance from a file stream.
     *
     * @param   in  an export file input stream.
     */
    public ExpExportFile(ExpExportFileStream in) throws IOException {
        setMagic(in.readInt());
        setMinor_version(in.readByte());
        setMajor_version(in.readByte());
        setConstant_pool_count(in.readShort());

        for(int count = 0; count < constant_pool_count; count++) {
            byte tag = in.readByte();
            ExpCpInfo elem = null;
            switch (tag){
                case 1:
                    elem = new ExpConstantUtf8(in);
                    break;
                case 3:
                    elem = new ExpConstantInteger(in);
                    break;
                case 7:
                    elem = new ExpConstantClassref(in);
                    break;
                case 13:
                    elem = new ExpConstantPackage(in);
                    break;
                default:
                    //need to throw custom exception
            }
            if(elem != null)
                constant_pool.add(elem);
        }

        setThis_package(in.readShort());
        setExport_class_count(in.readByte());

        for(int count = 0; count < export_class_count; count++) {
            classes.add(new ExpClassInfo(in));
        }
    }

    /**
     * @return  the string representation of the export file.
     */
    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append("Export File {\n");
        out.append("\tMagic number: 0x" + (Integer.toHexString(magic)).toUpperCase() + "\n");
        out.append("\tVersion: " + major_version + "." + minor_version + "\n");

        out.append("\tConstant Pool count: " + constant_pool_count + "\n");
        out.append("\tConstant Pool {\n");
        for(int count = 0; count < constant_pool_count; count++) {
            out.append("\t\t#" + count + " " + constant_pool.get(count).toString());
        }
        out.append("\t}\n");

        out.append("\tThis package: " + this_package + "\t" + getThisPackageName() +"\n");

        out.append("\tExport Class count:" + export_class_count + "\n");
        out.append("\tConstant Pool {\n");
        for(int count = 0; count < export_class_count; count++) {
            out.append("\t\t#" + count + " " + classes.get(count).toString());
        }
        out.append("\t}\n");
        out.append("}\n");

        return out.toString();
    }

    /**
     *
     * @return  the name of the package.
     */
    public String getThisPackageName() {
        return ((ExpConstantPackage) constant_pool.get(this_package)).getName(constant_pool);
    }

    /**
     * Returns the token of a class from the name of a class. If the class doesn't exist in this package,
     * null is returned
     *
     * @param ClassName     the name of the class
     * @return              the token of the class, null if the class doesn't exist in this export file.
     */
    public Byte getClassToken(String ClassName) {
        for(ExpClassInfo ClassInfo : classes) {
            if(ClassInfo.getName(constant_pool).equals(ClassName))
                return ClassInfo.getToken();
        }
        return null;
    }

    /**
     * Returns the name of a class from the token of a class. If the class doesn't exist in this package,
     * null is returned
     *
     * @param ClassToken    the token of the class
     * @return              the name of the class, null if the class doesn't exist in this export file.
     */
    public String getClassName(Byte ClassToken) {
        for(ExpClassInfo ClassInfo : classes) {
            if(ClassInfo.getToken() == ClassToken) {
                return ClassInfo.getName(constant_pool);
            }
        }
        return null;
    }

    /**
     * Returns the token of a method from the name of a class and a name of a method.
     * If the class doesn't exist in this package, null is returned
     *
     * @param   ClassName   the name of the class
     * @param   MethodName  the name of the method
     * @return              the token of the method, null if the class or the method doesn't exist in this export file.
     */
    public Byte getMethodToken(String ClassName, String MethodName) {
        for(ExpClassInfo ClassInfo : classes) {
            if(ClassInfo.getName(constant_pool).equals(ClassName)) {
                for(ExpMethodInfo Method : ClassInfo.getMethods()){
                    if(Method.getName(constant_pool).equals(MethodName)) {
                    return Method.getToken();
                    }
                }
            }
        }
        return null;
    }

    /**
     * Returns the name of a method from the token of a class and the token of a method. If the class doesn't exist in this package,
     * null is returned
     *
     * @param   ClassToken  the token of the class
     * @param   MethodToken the token of th method
     * @return              the name of the method, null if the class or the method doesn't exist in this export file.
     */
    public String getMethodName(Byte ClassToken, Byte MethodToken) {
        for(ExpClassInfo ClassInfo : classes) {
            if(ClassInfo.getToken() == ClassToken) {
                for(ExpMethodInfo Method : ClassInfo.getMethods()){
                    if(Method.getToken() == MethodToken) {
                        return Method.getName(constant_pool);
                    }
                }
            }
        }
        return null;
    }

    /**
     * Returns the token of a field from the name of a class and a name of a field.
     * If the class doesn't exist in this package, null is returned
     *
     * @param   ClassName   the name of the class
     * @param   FieldName   the name of the field
     * @return              the token of the method, null if the class or the method doesn't exist in this export file.
     */
    public Byte getFieldToken(String ClassName, String FieldName) {
        for(ExpClassInfo ClassInfo : classes) {
            if(ClassInfo.getName(constant_pool).equals(ClassName)) {
                for(ExpFieldInfo FieldInfo : ClassInfo.getFields()){
                    if(FieldInfo.getName(constant_pool).equals(FieldName)) {
                    return FieldInfo.getToken();
                    }
                }
            }
        }
        return null;
    }

    /**
     * Returns the name of a field from the token of a class and the token of a field.
     * If the class doesn't exist in this package, null is returned
     *
     * @param   ClassToken  the token of the class
     * @param   FieldToken  the token of the field
     * @return              the name of the field, null if the class or the field doesn't exist in this export file.
     */
    public String getFieldName(Byte ClassToken, Byte FieldToken) {
        for(ExpClassInfo ClassInfo : classes) {
            if(ClassInfo.getToken() == ClassToken) {
                for(ExpFieldInfo FieldInfo : ClassInfo.getFields()){
                    if(FieldInfo.getToken() == FieldToken) {
                        return FieldInfo.getName(constant_pool);
                    }
                }
            }
        }
        return null;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
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

    public short getConstant_pool_count() {
        return constant_pool_count;
    }

    public void setConstant_pool_count(short constant_pool_count) {
        this.constant_pool_count = constant_pool_count;
    }

    public List<ExpCpInfo> getConstant_pool() {
        return constant_pool;
    }

    public void setConstant_pool(List<ExpCpInfo> constant_pool) {
        this.constant_pool = constant_pool;
    }

    public short getThis_package() {
        return this_package;
    }

    public void setThis_package(short this_package) {
        this.this_package = this_package;
    }

    public byte getExport_class_count() {
        return export_class_count;
    }

    public void setExport_class_count(byte export_class_count) {
        this.export_class_count = export_class_count;
    }

    public List<ExpClassInfo> getClasses() {
        return classes;
    }

    public void setClasses(List<ExpClassInfo> classes) {
        this.classes = classes;
    }
}
