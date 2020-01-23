/**
 * ClassDescriptor.java
 * <p>
 * Author: 2009 Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 * Author: 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
 * Author: 2012 Julien Iguchi-Cartigny <julien.cartigny@xlim.fr>
 * <p>
 * <p>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */

package fr.xlim.ssd.capmanipulator.library;

import java.util.ArrayList;

/**
 * Class_descriptor_info
 * <p/>
 * Used to describe a class or interface defined in this package
 */
public class ClassDescriptorInfo implements Cloneable {

    // class token of this class or interface
    private byte token;
    // mask of modifiers used to describe the access permission to and
    // properties of this class or interface
    private byte accesFlags;
    // indicate location of the class_info structure in the class_component
    private ClassRef thisClassRef;
    // number of entries in the interfaces array
    private byte interfaceCount;
    // number of entries in the fields array
    private short fieldCount;
    // number of entries in the methods array
    private short methodCount;
    // interfaces implemented by this class
    private ArrayList<ClassRef> interfaces;
    // lists each fields declared by this class
    private ArrayList<FieldDescriptorInfo> fields;
    // lists each methods declared by this class
    private ArrayList<MethodDescriptorInfo> methods;


    @Override
    public String toString() {
        String rl = "\n\t";
        StringBuffer ret = new StringBuffer(rl);

        ret.append("\ttoken        : ").append(this.getToken()).append(rl);
        ret.append("\taccess_flag  : ");
        if ((accesFlags & 0x80) != 0)
            ret.append("ACC_ABSTRACT ");
        if ((accesFlags & 0x40) != 0)
            ret.append("ACC_INTERFACE ");
        if ((accesFlags & 0x10) != 0)
            ret.append("ACC_FINAL ");
        if ((accesFlags & 0x1) != 0)
            ret.append("ACC_PUBLIC ");
        ret.append(rl);
        ret.append("\tthis_class_ref : ");
        if (this.getThisClassRef() instanceof ExternalClassRef) {
            ExternalClassRef tmp = (ExternalClassRef) this.getThisClassRef();
            ret.append("external class 0x").append(Integer.toHexString(0xff & tmp.getClassToken()));
            ret.append(" of package 0x").append(Integer.toHexString(0xff & tmp.getPackageToken()));
        }
        if (this.getThisClassRef() instanceof InternalClassRef) {
            InternalClassRef tmp = (InternalClassRef) this.getThisClassRef();
            ret.append("internal class reference (offset = ");
            String hex = Integer.toHexString(0xff & tmp.getInternalClassRef());
            for (int i = hex.length(); i < 4; i++)
                hex = "0" + hex;
            ret.append(hex).append(")");
        }
        ret.append(rl);

        ret.append("\tinterface_count  : ").append(this.getInterfaceCount()).append(rl);
        ret.append("\tfield_count  : ").append(this.getFieldCount()).append(rl);
        ret.append("\tmethod_count  : ").append(this.getMethodCount()).append(rl);

        int i = 0;

        for (ClassRef c : this.getInterfaces()) {
            ret.append("\tinterface[").append(i).append("] = {    ").append(rl);
            ret.append("\t").append(c).append(rl).append("\t}").append(rl);
            i++;
        }

        i = 0;

        for (FieldDescriptorInfo f : this.getFields()) {
            ret.append("\tfiels[").append(i).append("] = {    ").append(rl);
            ret.append("\t").append(f).append(rl).append("\t}").append(rl);
            i++;
        }

        i = 0;

        for (MethodDescriptorInfo m : this.getMethods()) {
            ret.append("\tmethod[").append(i).append("] = {    ").append(rl);
            ret.append("\t").append(m).append(rl).append("\t}").append(rl);
            i++;
        }

        return ret.toString();
    }

    /**
     * ACCESSORS METHODS
     */
    public byte getAccesFlags() {
        return accesFlags;
    }

    public void setAccesFlags(byte accesFlags) {
        this.accesFlags = accesFlags;
    }

    public short getFieldCount() {
        return fieldCount;
    }

    public void setFieldCount(short fieldCount) {
        this.fieldCount = fieldCount;
    }

    public ArrayList<FieldDescriptorInfo> getFields() {
        return fields;
    }

    public void setFields(ArrayList<FieldDescriptorInfo> fields) {
        this.fields = fields;
    }

    public byte getInterfaceCount() {
        return interfaceCount;
    }

    public void setInterfaceCount(byte interfaceCount) {
        this.interfaceCount = interfaceCount;
    }

    public ArrayList<ClassRef> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(ArrayList<ClassRef> interfaces) {
        this.interfaces = interfaces;
    }

    public short getMethodCount() {
        return methodCount;
    }

    public void setMethodCount(short methodCount) {
        this.methodCount = methodCount;
    }

    public ArrayList<MethodDescriptorInfo> getMethods() {
        return methods;
    }

    public void setMethods(ArrayList<MethodDescriptorInfo> methods) {
        this.methods = methods;
    }

    public ClassRef getThisClassRef() {
        return thisClassRef;
    }

    public void setThisClassRef(ClassRef thisClassRef) {
        this.thisClassRef = thisClassRef;
    }

    public byte getToken() {
        return token;
    }

    public void setToken(byte token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassDescriptorInfo that = (ClassDescriptorInfo) o;

        if (accesFlags != that.accesFlags) return false;
        if (fieldCount != that.fieldCount) return false;
        if (interfaceCount != that.interfaceCount) return false;
        if (methodCount != that.methodCount) return false;
        if (token != that.token) return false;
        if (!fields.equals(that.fields)) return false;
        if (!interfaces.equals(that.interfaces)) return false;
        if (!methods.equals(that.methods)) return false;
        if (!thisClassRef.equals(that.thisClassRef)) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ClassDescriptorInfo out = new ClassDescriptorInfo();

        out.setToken(this.getToken());
        out.setAccesFlags(this.getAccesFlags());
        out.setThisClassRef(this.getThisClassRef());
        out.setInterfaceCount(out.getInterfaceCount());
        out.setFieldCount(out.getFieldCount());
        out.setMethodCount(this.getMethodCount());

        ArrayList<ClassRef> interfaces = new ArrayList<>();
        for (ClassRef c : this.getInterfaces()) {
            interfaces.add((ClassRef) c.clone());
        }
        out.setInterfaces(interfaces);

        ArrayList<FieldDescriptorInfo> fields = new ArrayList<>();
        for (FieldDescriptorInfo f : this.getFields()) {
            fields.add((FieldDescriptorInfo) f.clone());
        }
        out.setFields(fields);

        ArrayList<MethodDescriptorInfo> methods = new ArrayList<>();
        for (MethodDescriptorInfo m : this.getMethods()) {
            methods.add((MethodDescriptorInfo) m.clone());
        }
        out.setMethods(methods);

        return out;
    }
}
