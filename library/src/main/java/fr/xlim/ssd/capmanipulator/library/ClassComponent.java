/**
 * ClassComponent.java
 * <p/>
 * Author: 2009 Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 * Author: 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
 * Author: 2012 Julien Iguchi-Cartigny <julien.cartigny@xlim.fr>
 * <p/>
 * <p/>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */

package fr.xlim.ssd.capmanipulator.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassComponent
 * <p/>
 * It describes each of the classes and interfaces defined in this package. It
 * does not contain complete acess information and content details fro each
 * class and interface.
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class ClassComponent extends Component {

    // constant
    public static final byte ACC_INTERFACE = (byte) 0x80;
    public static final byte ACC_SHAREABLE = (byte) 0x40;
    public static final byte ACC_REMOTE = (byte) 0x20;

    // attributes
    // number of bytes in the signature_pool[] item
    private short signaturePoolLength;
    // list of descriptor which represents signatures of the remote methods
    private ArrayList<TypeDescriptor> signaturePool = new ArrayList<>();
    private ArrayList<ClassInfo> classes;
    private ArrayList<InterfaceInfo> interfaces;

    /**
     * Get the value of signaturePoolLength
     *
     * @return the value of signaturePoolLength
     */
    public short getSignaturePoolLength() {
        return signaturePoolLength;
    }

    /**
     * Set the value of signaturePoolLength
     *
     * @param newVar the new value of signaturePoolLength
     */
    public void setSignaturePoolLength(short newVar) {
        signaturePoolLength = newVar;
    }

    /**
     * Get the value of signaturePool
     *
     * @return the value of signaturePool
     */
    public ArrayList<TypeDescriptor> getSignaturePool() {
        return signaturePool;
    }

    /**
     * Set the value of signaturePool
     *
     * @param newVar the new value of signaturePool
     */
    public void setSignaturePool(ArrayList<TypeDescriptor> newVar) {
        signaturePool = newVar;
    }

    /**
     * Get the value of classes
     *
     * @return the value of classes
     */
    public ArrayList<ClassInfo> getClasses() {
        return classes;
    }

    /**
     * Set the value of classes
     *
     * @param newVar the new value of classes
     */
    public void setClasses(ArrayList<ClassInfo> newVar) {
        classes = newVar;
    }

    /**
     * Get the Class Map Offset
     *
     * @retun the class map offset
     */
    Map<Short, ClassInfo> getClassMapOffset() {
        Map<Short, ClassInfo> classOffsetMap = new HashMap<Short, ClassInfo>();
        for (ClassInfo classInfo : this.getClasses()) {
            classOffsetMap.put((short) classInfo.getOffset(), classInfo);
        }
        return classOffsetMap;
    }

    /**
     * Get the value of interfaces
     *
     * @return the value of interfaces
     */
    public ArrayList<InterfaceInfo> getInterfaces() {
        return interfaces;
    }

    /**
     * Set the value of interfaces
     *
     * @param newVar the new value of interfaces
     */
    public void setInterfaces(ArrayList<InterfaceInfo> newVar) {
        interfaces = newVar;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xlim.ssd.capmanipulator.library.Component#toString()
     */
    @Override
    public String toString() {

        String rl = "\n\t";
        StringBuffer ret = new StringBuffer();

        ret.append(".class { // @0000").append(rl);

        //ret.append(super.toString()).append(rl);
        int offset = 3; // size(TAG) + size(LENGTH)

        for (int i = 0; i < interfaces.size(); i++) {
            InterfaceInfo interfaceInfo = interfaces.get(i);
            ret.append("interface [").append(i).append("]: { //@").append(String.format("%04x", interfaceInfo.getOffset() & 0x0FFFF)).append(rl);
            ret.append(interfaceInfo.toString()).append(rl);
            ret.append("}").append(rl);
            offset += 1 // sizeOf(bitfield)
                    + (interfaceInfo.getBitfield() & 0x0F) * 2; // sizeOf(superinterfaces[interface_count])
        }

        int nbCarClass = (int) Math.ceil(Math.log10(classes.size())) + 1;

        for (int i = 0; i < classes.size(); i++) {
            ClassInfo classInfo = classes.get(i);
            ret.append("classes [").append(i).append("]: { //@").append(String.format("%04x", classInfo.getOffset() & 0x0FFFF)).append(rl);
            ret.append(classInfo);
            if (i + 1 < classes.size())
                ret.append(rl);
            ret.append("}").append('\n');
            offset += 1 // sizeOf(bitfield)
                    + 2 // sizeOf(super_class_ref)
                    + 1 // sizeOf(declared_instance_size)
                    + 1 // sizeOf(first_reference_token)
                    + 1 // sizeOf(reference_count)
                    + 1 // sizeOf(public_method_table_base)
                    + 1 // sizeOf(public_method_table_count)
                    + 1 // sizeOf(package_method_table_base)
                    + 1 // sizeOf(package_method_table_count)
                    + 2 * classInfo.getPublicVirtualMethodTable().size() // sizeOf(public_virtual_method_table[public_method_table_count])
                    + 2 * classInfo.getPackageVirtualMethodTable().size();// sizeOf(public_virtual_method_table[public_method_table_count])

            for (ImplementedInterfaceInfo interfaceInfo : classInfo.getInterfaces()) {
                offset += 2 // sizeOf(interface)
                        + 1 // sizeOf(count)
                        + interfaceInfo.getIndex().size(); // sizeOf(index)
            }


        }


        ret.append("}\n");
        return ret.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ClassComponent out = new ClassComponent();

        out.setTag(this.getTag());
        out.setSize(this.getSize());

        ArrayList<InterfaceInfo> interfaces = new ArrayList<>();
        for (InterfaceInfo i : this.getInterfaces()) {
            interfaces.add((InterfaceInfo) i.clone());
        }
        out.setInterfaces(interfaces);

        ArrayList<ClassInfo> classes = new ArrayList<>();
        for (ClassInfo c : this.getClasses()) {
            classes.add((ClassInfo) c.clone());
        }
        out.setClasses(classes);

        out.setSignaturePoolLength(this.getSignaturePoolLength());
        ArrayList<TypeDescriptor> signatures = new ArrayList<>();
        /*
        for (TypeDescriptor t : this.getSignaturePool()) {
            signatures.add((TypeDescriptor) t.clone());
        }
        out.setSignaturePool(signatures);
         */

        return out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassComponent that = (ClassComponent) o;

        if (signaturePoolLength != that.signaturePoolLength) return false;
        if (!classes.equals(that.classes)) return false;
        if (!interfaces.equals(that.interfaces)) return false;
        if (!signaturePool.equals(that.signaturePool)) return false;

        return true;
    }
}