/**
 * RemoteInterfaceInfo.java
 * <p>
 * Author: 2009 Guillaume Bouffard <guillaume.bouffard02@etu.unilim.fr>
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
 * RemoteInterfaceInfo
 */
public class RemoteInterfaceInfo implements Cloneable {

    // number of entires in the remote_methods array
    private byte remoteMethodsCount;
    // maps each remote_method available in the class to it's hash code
    // and it's type definition in the signature_pool[]
    private ArrayList<RemoteMethodInfo> remoteMethods = new ArrayList<RemoteMethodInfo>();
    // number of bytes in the following hash_modifier item
    private byte hashModifierLength;
    // variable length representation of the anticollision string in
    // UTF-8 format
    private ArrayList<Byte> hashModifier = new ArrayList<Byte>();
    // number of bytes used in the class_name[] item
    private byte classNameLength;
    // representation of the name of this class in UTF-8 format
    private ArrayList<Byte> className = new ArrayList<Byte>();
    // number of interfaces listed in remote_interfaces array
    private byte remoteInterfacesCount;
    private ArrayList<ClassRef> remoteInterfaces = new ArrayList<ClassRef>();

    /**
     * Get Remote Methods Count
     *
     * @return Remote Methods Count value
     */
    public byte getRemoteMethodsCount() {
        return remoteMethodsCount;
    }

    /**
     * Set Remote Methods Count
     *
     * @param remoteMethodsCount new Remote Methods Count value
     */
    public void setRemoteMethodsCount(byte remoteMethodsCount) {
        this.remoteMethodsCount = remoteMethodsCount;
    }

    /**
     * Get Remote Remote Methods
     *
     * @return Remote Methods values
     */
    public ArrayList<RemoteMethodInfo> getRemoteMethods() {
        return remoteMethods;
    }

    /**
     * Set Remote Methods
     *
     * @param remoteMethods new Remote Methods values
     */
    public void setRemoteMethods(
            ArrayList<RemoteMethodInfo> remoteMethods) {
        this.remoteMethods = remoteMethods;
    }

    /**
     * Get Hash Modifier Length
     *
     * @return Hash Modifier Length value
     */
    public byte getHashModifierLength() {
        return hashModifierLength;
    }

    /**
     * Set Hash Modifier Length
     *
     * @param hashModifierLength new Hash Modifier Length value
     */
    public void setHashModifierLength(byte hashModifierLength) {
        this.hashModifierLength = hashModifierLength;
    }

    /**
     * Get Hash Modifier
     *
     * @return Hash Modifier Length values
     */
    public ArrayList<Byte> getHashModifier() {
        return hashModifier;
    }

    /**
     * Set Hash Modifier
     *
     * @param hashModifier new Hash Modifier values
     */
    public void setHashModifier(ArrayList<Byte> hashModifier) {
        this.hashModifier = hashModifier;
    }

    /**
     * Get Class Name Length
     *
     * @return Class Name Length value
     */
    public byte getClassNameLength() {
        return classNameLength;
    }

    /**
     * Set Class Name Length
     *
     * @param classNameLength new Class Name Length value
     */
    public void setClassNameLength(byte classNameLength) {
        this.classNameLength = classNameLength;
    }

    /**
     * Get Class Name
     *
     * @return Class Name values
     */
    public ArrayList<Byte> getClassName() {
        return className;
    }

    /**
     * Set Class Name
     *
     * @param className new Class Name values
     */
    public void setClassName(ArrayList<Byte> className) {
        this.className = className;
    }

    /**
     * Get Remote Interfaces Count
     *
     * @return Remote Interfaces Count value
     */
    public byte getRemoteInterfacesCount() {
        return remoteInterfacesCount;
    }

    /**
     * Set Remote Interfaces Count
     *
     * @param remoteInterfacesCount new Remote Interfaces Count value
     */
    public void setRemoteInterfacesCount(byte remoteInterfacesCount) {
        this.remoteInterfacesCount = remoteInterfacesCount;
    }

    /**
     * Get Remote Interfaces
     *
     * @return Remote Interfaces values
     */
    public ArrayList<ClassRef> getRemoteInterfaces() {
        return remoteInterfaces;
    }

    /**
     * Set Remote Interfaces
     *
     * @param remoteInterfaces new Remote Interfaces values
     */
    public void setRemoteInterfaces(ArrayList<ClassRef> remoteInterfaces) {
        this.remoteInterfaces = remoteInterfaces;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {

        String rl = "\n\t\t\t";
        StringBuffer res = new StringBuffer();

        res.append("remote_interface_info : {").append(rl);

        res.append("remote_methods_count : ").append(
                Integer.toHexString(remoteMethodsCount)).append(rl);

        res.append("remote_methods : [ ");

        for (int i = 0; i < remoteMethodsCount; i++) {
            res.append(remoteMethods.toString()).append(" ");
        }
        res.append("]").append(rl);

        res.append("hash_modifier_length : ").append(
                Integer.toHexString(hashModifierLength)).append(rl);

        res.append("hash_modifier : [");
        for (int i = 0; i < hashModifierLength; i++) {
            res.append(Integer.toHexString(0xff & hashModifier.get(i))).append(" ");
        }
        res.append("]").append(rl);

        res.append("class_name_length : ").append(
                Integer.toHexString(classNameLength)).append(rl);

        res.append("class_modifier: [");
        for (int i = 0; i < classNameLength; i++) {
            res.append(Integer.toHexString(0xff
                    & className.get(i))).append(
                    " ");
        }
        res.append("]").append(rl);

        res.append("remote_interfaces_count : ").append(
                remoteInterfacesCount).append(rl);

        res.append("remote_interaces : [ ");

        for (int i = 0; i < remoteInterfacesCount; i++) {
            res.append(remoteInterfaces.get(i).toString()).append("  ");
        }

        res.append("]");

        res.append("\n\t\t}");

        return res.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RemoteInterfaceInfo that = (RemoteInterfaceInfo) o;

        if (classNameLength != that.classNameLength) return false;
        if (hashModifierLength != that.hashModifierLength) return false;
        if (remoteInterfacesCount != that.remoteInterfacesCount) return false;
        if (remoteMethodsCount != that.remoteMethodsCount) return false;
        if (!className.equals(that.className)) return false;
        if (!hashModifier.equals(that.hashModifier)) return false;
        if (!remoteInterfaces.equals(that.remoteInterfaces)) return false;
        if (!remoteMethods.equals(that.remoteMethods)) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        RemoteInterfaceInfo out = new RemoteInterfaceInfo();

        out.remoteMethodsCount = this.remoteMethodsCount;

        ArrayList<RemoteMethodInfo> remoteMethods = new ArrayList<RemoteMethodInfo>();
        for(RemoteMethodInfo r: this.remoteMethods) {
            remoteMethods.add((RemoteMethodInfo) r.clone());
        }
        out.setRemoteMethods(remoteMethods);

        out.hashModifierLength = this.hashModifierLength;

        ArrayList<Byte> hashModifier = new ArrayList<Byte>();
        for(byte b: this.hashModifier) {
            hashModifier.add(b);
        }
        out.setHashModifier(hashModifier);

        out.classNameLength = this.classNameLength;

        ArrayList<Byte> className = new ArrayList<Byte>();
        for(byte b: this.getClassName()) {
            className.add(b);
        }
        out.setClassName(className);

        out.remoteInterfacesCount = out.remoteInterfacesCount;

        ArrayList<ClassRef> remoteInterfaces = new ArrayList<ClassRef>();
        for(ClassRef c: this.remoteInterfaces) {
            remoteInterfaces.add((ClassRef) c.clone());
        }
        out.setRemoteInterfaces(remoteInterfaces);

        return out;
    }
}