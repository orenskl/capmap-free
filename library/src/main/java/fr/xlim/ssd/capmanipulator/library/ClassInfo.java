/**
 * ClassInfo.java
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
 * Class_info
 * <p/>
 * represents classes
 */
public class ClassInfo implements Cloneable {

    private int offset;

    // Fields
    private byte flags;
    // -> { bit[4] flags; bit[4] interface_count }

    // super class of this class (value 0xFFFF if this class does not have a
    // superclass
    private ClassRef superClassRef;

    // number of 16 bit cells required to represent the instance fields
    // declared by this class
    private byte declaredInstanceSize;

    // instance field token value of the first reference type instance field
    // defined by this class
    private byte firstReferenceToken;

    // number of reference type instance field defined by this class
    private byte referenceCount;

    // equal to the virtual method token value of the first method in the
    // public_virtual_method_table array
    private byte publicMethodTableBase;

    // number of entries in the public_virtual_method_table[]
    private byte publicMethodTableCount;

    // equal to the virtual method token value of the first entry in the
    // package_virtual_method_table array
    private byte packageMethodTableBase;

    // number of entries in the package_virtual_method_table array
    private byte packageMethodTableCount;

    // array of public and protected virtual methods. size:
    // public_method_tabl_count
    private ArrayList<Short> publicVirtualMethodTable = new ArrayList<Short>();

    // array of package visible virtual methods. size :
    // package_method_table_count
    private ArrayList<Short> packageVirtualMethodTable = new ArrayList<Short>();

    // contains an entry for each of the directly implemented
    // interfaces/size : interface_count
    private ArrayList<ImplementedInterfaceInfo> interfaces = new ArrayList<ImplementedInterfaceInfo>();

    // information required if this class or any of it's super classes
    // implements a remote interface
    private RemoteInterfaceInfo remoteInterfacesInfo;

    /**
     * Get flags and interface count values
     *
     * @return flags and interface count values
     */
    public byte getFlags() {
        return flags;
    }

    /**
     * Set flags and interface count values
     *
     * @param flags new flags and interface count values
     */
    public void setFlags(byte flags) {
        this.flags = flags;
    }

    /**
     * Get Super Class Ref
     *
     * @return Super Class Ref
     */
    public ClassRef getSuperClassRef() {
        return superClassRef;
    }

    /**
     * Set Super Class Ref
     *
     * @param superClassRef new Super Class Ref
     */
    public void setSuperClassRef(ClassRef superClassRef) {
        this.superClassRef = superClassRef;
    }

    /**
     * Get Declared Instance Size
     *
     * @return Declared Instance Size value
     */
    public byte getDeclaredInstanceSize() {
        return declaredInstanceSize;
    }

    /**
     * Set Declared Instance Size
     *
     * @param declaredInstanceSize new Declared Instance Size value
     */
    public void setDeclaredInstanceSize(byte declaredInstanceSize) {
        this.declaredInstanceSize = declaredInstanceSize;
    }

    /**
     * Get First Reference Token
     *
     * @return First Reference Token value
     */
    public byte getFirstReferenceToken() {
        return firstReferenceToken;
    }

    /**
     * Set First Reference Token value
     *
     * @param firstReferenceToken new First Reference Token value
     */
    public void setFirstReferenceToken(byte firstReferenceToken) {
        this.firstReferenceToken = firstReferenceToken;
    }

    /**
     * Get Reference count
     *
     * @return Reference count value
     */
    public byte getReferenceCount() {
        return referenceCount;
    }

    /**
     * Set Reference count
     *
     * @param referenceCount new Reference count value
     */
    public void setReferenceCount(byte referenceCount) {
        this.referenceCount = referenceCount;
    }

    /**
     * Get Public Method Table Base
     *
     * @return Public Method Table Base value
     */
    public byte getPublicMethodTableBase() {
        return publicMethodTableBase;
    }

    /**
     * Set Public Method Table Base
     *
     * @param publicMethodTableBase new Public Method Table Base value
     */
    public void setPublicMethodTableBase(byte publicMethodTableBase) {
        this.publicMethodTableBase = publicMethodTableBase;
    }

    /**
     * Get Public Method Table Base Count
     *
     * @return Public Method Table Count value
     */
    public byte getPublicMethodTableCount() {
        return publicMethodTableCount;
    }

    /**
     * Set Public Method Table Count
     *
     * @param publicMethodTableCount new Public Method Table count value
     */
    public void setPublicMethodTableCount(byte publicMethodTableCount) {
        this.publicMethodTableCount = publicMethodTableCount;
    }

    /**
     * Get Package Method Table Base
     *
     * @return Package Method Table Base value
     */
    public byte getPackageMethodTableBase() {
        return packageMethodTableBase;
    }

    /**
     * Set Package Method Table Base
     *
     * @param packageMethodTableBase new Package Method Table Base value
     */
    public void setPackageMethodTableBase(byte packageMethodTableBase) {
        this.packageMethodTableBase = packageMethodTableBase;
    }

    /**
     * Get Package Method Table Count
     *
     * @return Package Method Table Count value
     */
    public byte getPackageMethodTableCount() {
        return packageMethodTableCount;
    }

    /**
     * Set Package Method Table Count
     *
     * @param packageMethodTableCount new Package Method Table Count value
     */
    public void setPackageMethodTableCount(byte packageMethodTableCount) {
        this.packageMethodTableCount = packageMethodTableCount;
    }

    /**
     * Get Public Virtual Method Table
     *
     * @return Public Virtual Method Table value
     */
    public ArrayList<Short> getPublicVirtualMethodTable() {
        return publicVirtualMethodTable;
    }

    /**
     * Set Public Virtual Method Table
     *
     * @param publicVirtualMethodTable new Public Virtual Method Table value
     */
    public void setPublicVirtualMethodTable(
            ArrayList<Short> publicVirtualMethodTable) {
        this.publicVirtualMethodTable = publicVirtualMethodTable;
    }

    /**
     * Get Package Virtual Method Table
     *
     * @return Package Virtual Method Table value
     */
    public ArrayList<Short> getPackageVirtualMethodTable() {
        return packageVirtualMethodTable;
    }

    /**
     * Set Package Virtual Method Table
     *
     * @param packageVirtualMethodTable new Package Virtual Method Table value
     */
    public void setPackageVirtualMethodTable(
            ArrayList<Short> packageVirtualMethodTable) {
        this.packageVirtualMethodTable = packageVirtualMethodTable;
    }

    /**
     * Get Interfaces
     *
     * @return Interfaces values
     */
    public ArrayList<ImplementedInterfaceInfo> getInterfaces() {
        return interfaces;
    }

    /**
     * Set Interfaces values
     *
     * @param interfaces new Interfaces values
     */
    public void setInterfaces(ArrayList<ImplementedInterfaceInfo> interfaces) {
        this.interfaces = interfaces;
    }

    /**
     * Get Remote Interfaces Info
     *
     * @return Remote Interfaces Info value
     */
    public RemoteInterfaceInfo getRemoteInterfacesInfo() {
        return remoteInterfacesInfo;
    }

    /**
     * Set Remote Interfaces Info
     *
     * @param remoteInterfacesInfo new Remote Interfaces Info value
     */
    public void setRemoteInterfacesInfo(
            RemoteInterfaceInfo remoteInterfacesInfo) {
        this.remoteInterfacesInfo = remoteInterfacesInfo;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        String rl = "\n\t";
        StringBuffer res = new StringBuffer();


        res.append("\tflags = (0x").append(Integer.toHexString(flags & 0x0F)).append(")");
        if ((flags & 0x8) != 0)
            res.append("ACC_INTERFACE ");
        if ((flags & 0x4) != 0)
            res.append("ACC_SHAREABLE ");
        if ((flags & 0x2) != 0)
            res.append("ACC_REMOTE");

        res.append(rl).append("\tinterface_count: ").append(interfaces.size()).append(rl);

        res.append("\tsuper_class_ref: ");

        if (superClassRef instanceof ExternalClassRef) {
            ExternalClassRef tmp = (ExternalClassRef) superClassRef;
            res.append("external class 0x").append(Integer.toHexString(0xff & tmp.getClassToken()));
            res.append(" of package 0x").append(Integer.toHexString(0xff & tmp.getPackageToken()));
        }
        if (superClassRef instanceof InternalClassRef) {
            InternalClassRef tmp = (InternalClassRef) superClassRef;
            res.append("internal class reference (offset = ");
            String hex = Integer.toHexString(0xff & tmp.getInternalClassRef());
            for (int i = hex.length(); i < 4; i++)
                hex = "0" + hex;
            res.append(hex).append(")");
        }
        res.append(rl);

        res.append("\tdeclared_instance_size     :").append(convertValue(declaredInstanceSize & 0x0FF)).append(rl);
        res.append("\tfirst_reference_index      :").append(convertValue(firstReferenceToken & 0x0FF)).append(rl);
        res.append("\treference_count            :").append(0xff & referenceCount).append(rl);
        res.append("\tpublic_method_table_base   :").append(convertValue(publicMethodTableBase)).append(rl);
        res.append("\tpublic_method_table_count  :").append(0xff & publicMethodTableCount).append(rl);
        res.append("\tpackage_method_table_base  :").append(convertValue(packageMethodTableBase)).append(rl);
        res.append("\tpackage_method_table_count :").append(0xff & packageMethodTableCount).append(rl);
        res.append("\tpublic_virtual_method_table = {").append(rl);

        for (int i = 0; i < publicMethodTableCount; i++) {
            String method = Integer.toHexString(0x000FFFF & publicVirtualMethodTable.get(i));
            res.append("\t\t");//public virtual method ");
            if ((publicVirtualMethodTable.get(i) & 0x0FFFF) == 0x00FFFF)
                res.append("inherited");
            else {
                for (int j = method.length(); j < 4; j++)
                    method = "0" + method;
                res.append("@").append(method);
            }
            res.append(rl);
        }
        res.append("\t}").append(rl);


        res.append("\tpackage_methods = {").append(rl);
        for (int i = 0; i < packageMethodTableCount; i++) {
            String method = Integer.toHexString(0xffff & packageVirtualMethodTable.get(i));
            res.append(rl).append("\t\tpublic method ");
            if (method.equals("ffff"))
                res.append("inherited");
            else {
                for (int j = method.length(); j < 4; j++)
                    method = "0" + method;
                res.append("@").append(method);
            }
            res.append(rl);
        }
        res.append("\t}").append(rl);

        res.append("\tinterfaces = {").append(rl);

        for (int i = 0; i < (flags & 0x0F); i++) {
            res.append(interfaces.get(i).toString()).append(rl);
        }
        res.append("\t}").append(rl);

        if (remoteInterfacesInfo != null)
            res.append(remoteInterfacesInfo.toString()).append(rl);


        return res.toString();

    }

    private String convertValue(int v) {
        if ((v & 0xff) == 0xff)
            return "-1";
        return Integer.toHexString(0xff & v);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassInfo classInfo = (ClassInfo) o;

        if (declaredInstanceSize != classInfo.declaredInstanceSize) return false;
        if (firstReferenceToken != classInfo.firstReferenceToken) return false;
        if (flags != classInfo.flags) return false;
        if (packageMethodTableBase != classInfo.packageMethodTableBase) return false;
        if (packageMethodTableCount != classInfo.packageMethodTableCount) return false;
        if (publicMethodTableBase != classInfo.publicMethodTableBase) return false;
        if (publicMethodTableCount != classInfo.publicMethodTableCount) return false;
        if (referenceCount != classInfo.referenceCount) return false;
        if (!interfaces.equals(classInfo.interfaces)) return false;
        if (!packageVirtualMethodTable.equals(classInfo.packageVirtualMethodTable)) return false;
        if (!publicVirtualMethodTable.equals(classInfo.publicVirtualMethodTable)) return false;
        if (remoteInterfacesInfo != null ? !remoteInterfacesInfo.equals(classInfo.remoteInterfacesInfo) : classInfo.remoteInterfacesInfo != null)
            return false;
        return superClassRef.equals(classInfo.superClassRef);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ClassInfo out = new ClassInfo();

        out.setFlags(this.getFlags());
        out.setSuperClassRef((ClassRef) this.getSuperClassRef().clone());
        out.setDeclaredInstanceSize(this.getDeclaredInstanceSize());
        out.setFirstReferenceToken(this.getFirstReferenceToken());
        out.setReferenceCount(this.getReferenceCount());
        out.setPublicMethodTableBase(this.getPublicMethodTableBase());
        out.setPublicMethodTableCount(this.getPublicMethodTableCount());
        out.setPackageMethodTableBase(this.getPackageMethodTableBase());
        out.setPackageMethodTableCount(this.getPackageMethodTableCount());

        ArrayList<Short> publicVirtualMethodTable = new ArrayList<>();
        for(Short s: this.getPublicVirtualMethodTable()) {
            publicVirtualMethodTable.add(s.shortValue());
        }
        out.setPublicVirtualMethodTable(publicVirtualMethodTable);

        ArrayList<Short> packageVirtualMethodTable = new ArrayList<>();
        for(Short s: this.getPackageVirtualMethodTable()) {
            packageVirtualMethodTable.add(s.shortValue());
        }
        out.setPublicVirtualMethodTable(packageVirtualMethodTable);

        ArrayList<ImplementedInterfaceInfo> interfaces = new ArrayList<>();
        for(ImplementedInterfaceInfo i: this.getInterfaces()) {
            interfaces.add((ImplementedInterfaceInfo) i.clone());
        }
        out.setInterfaces(interfaces);

        return out;
    }
}
