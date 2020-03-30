/**
 * DescriptorComponent.java
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Map;

/**
 * Descriptor_Component
 * <p/>
 * The Descriptor Components provides sufficient information to parse and verify
 * all elements of the CAP file. It references, and therefore describes,
 * elements in the Constant Pool Component, Class Component, Method Component,
 * and Static Field Component
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class DescriptorComponent extends Component {

    private static Logger logger = LoggerFactory.getLogger(DescriptorComponent.class);

    // number of entries in the classes table
    private byte classCount;

    // Each class and interface defined
    // in this package is represented in the table
    private ArrayList<ClassDescriptorInfo> classes;

    // list the set of field types and method
    // signatures of the fields
    // and methods defined or referenced in this package
    private TypeDescriptorInfo types;

    /*
     * (non-Javadoc)
     *
     * @see fr.xlim.ssd.capmanipulator.library.Component#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t";
        StringBuffer ret = new StringBuffer(".DescriptorComponent = {")
                .append(rl);

        //ret.append(super.toString()).append(rl);
        ret.append("count : ").append(this.getClassCount()).append(rl);

        int i = 0;

        for (ClassDescriptorInfo cdi : this.getClasses()) {
            ret.append("class_descriptor_info[").append(i).append("] = {    ").append(rl);

            ret.append("\ttoken        : ").append(cdi.getToken()).append(rl);
            ret.append("\taccess_flag  : ");
            if ((cdi.getAccesFlags() & 0x80) != 0)
                ret.append("ACC_ABSTRACT ");
            if ((cdi.getAccesFlags() & 0x40) != 0)
                ret.append("ACC_INTERFACE ");
            if ((cdi.getAccesFlags() & 0x10) != 0)
                ret.append("ACC_FINAL ");
            if ((cdi.getAccesFlags() & 0x1) != 0)
                ret.append("ACC_PUBLIC ");
            ret.append(rl);
            ret.append("\tthis_class_ref : ");
            if (cdi.getThisClassRef() instanceof ExternalClassRef) {
                ExternalClassRef tmp = (ExternalClassRef) cdi.getThisClassRef();
                ret.append("external class 0x").append(Integer.toHexString(0xff & tmp.getClassToken()));
                ret.append(" of package 0x").append(Integer.toHexString(0xff & tmp.getPackageToken()));
            }
            if (cdi.getThisClassRef() instanceof InternalClassRef) {
                InternalClassRef tmp = (InternalClassRef) cdi.getThisClassRef();
                ret.append("internal class reference (offset = ");
                String hex = Integer.toHexString(0x00FFFF & tmp.getInternalClassRef());
                for (int j = hex.length(); j < 4; j++)
                    hex = "0" + hex;
                ret.append(hex).append(")");
            }
            ret.append(rl);

            ret.append("\tinterface_count  : ").append(cdi.getInterfaceCount()).append(rl);
            ret.append("\tfield_count  : ").append(cdi.getFieldCount()).append(rl);
            ret.append("\tmethod_count  : ").append(cdi.getMethodCount()).append(rl);

            int j = 0;

            for (ClassRef c : cdi.getInterfaces()) {
                ret.append("\tinterface[").append(j).append("] = {    ").append(rl);
                ret.append("\t").append(c).append(rl).append("\t}").append(rl);
                j++;
            }

            j = 0;

            for (FieldDescriptorInfo f : cdi.getFields()) {
                ret.append("\tfiels[").append(j).append("] = {    ").append(rl);
                ret.append("\t").append(f).append(rl).append("\t}").append(rl);
                j++;
            }

            j = 0;

            for (MethodDescriptorInfo m : cdi.getMethods()) {
                ret.append("\tmethod[").append(j).append("] = {    ").append(rl).append("\t");

                ret.append("\ttoken          : ").append(m.getToken() & 0xff).append("\n\t\t");
                ret.append("\taccess_flag    : (").append(Integer.toHexString(m.getAccessFlags() & 0xff)).append(") ");
                if ((m.getAccessFlags() & 0x80) != 0)
                    ret.append("ACC_INIT ");
                if ((m.getAccessFlags() & 0x40) != 0)
                    ret.append("ACC_ABSTRACT ");
                if ((m.getAccessFlags() & 0x10) != 0)
                    ret.append("ACC_FINAL ");
                if ((m.getAccessFlags() & 0x08) != 0)
                    ret.append("ACC_STATIC ");
                if ((m.getAccessFlags() & 0x04) != 0)
                    ret.append("ACC_PROTECTED ");
                if ((m.getAccessFlags() & 0x02) != 0)
                    ret.append("ACC_PRIVATE ");
                if ((m.getAccessFlags() & 0x01) != 0)
                    ret.append("ACC_PUBLIC ");
                ret.append("\n\t\t");
                ret.append("\tmethod_offset  : 0x").append(Integer.toHexString(m.getMethodOffset() & 0xffff)).append("\n\t\t");
                ret.append("\ttype_offset    : /* ").append(m.getTypeOffset() & 0xffff).append("*/ (");
                for (Map.Entry<Short, TypeDescriptor> e : this.getTypes().getTypeDesc().entrySet()) {
                    if (e.getKey() == m.getTypeOffset()) {
                        TypeDescriptor td = e.getValue();
                        ArrayList<Byte> types = new ArrayList<Byte>(td.getType().size() * 2);
                        for (int k = 0; k < td.getType().size(); k++) {
                            types.add((byte) ((td.getType().get(k) >> 4) & 0xF));
                            types.add((byte) (td.getType().get(k) & 0xF));
                        }
                        if (types.size() == 2 && types.get(1) == 0x0)
                            ret.append(" )");
                        for (int k = 0; k < types.size(); k++) {
                            switch (types.get(k)) {
                                case 0x1:
                                    ret.append(" V");
                                    break;
                                case 0x2:
                                    ret.append(" Z");
                                    break;
                                case 0x3:
                                    ret.append(" B");
                                    break;
                                case 0x4:
                                    ret.append(" S");
                                    break;
                                case 0x5:
                                    ret.append(" I");
                                    break;
                                case 0x6:
                                    ret.append(" L");
                                    ret.append(Integer.toHexString(types.get(++k))).append(Integer.toHexString(types.get(++k)));
                                    ret.append(".").append(Integer.toHexString(types.get(++k))).append(Integer.toHexString(types.get(++k)));
                                    break;
                                case 0xA:
                                    ret.append(" [Z");
                                    break;
                                case 0xB:
                                    ret.append(" [B");
                                    break;
                                case 0xC:
                                    ret.append(" [S");
                                    break;
                                case 0xD:
                                    ret.append(" [I");
                                    break;
                                case 0xE:
                                    ret.append(" [L");
                                    ret.append(Integer.toHexString(types.get(++k))).append(Integer.toHexString(types.get(++k)));
                                    ret.append(".").append(Integer.toHexString(types.get(++k))).append(Integer.toHexString(types.get(++k)));
                                    break;
                            }
                            if (types.get(k) != 0x0 && (k + 2 < types.size() || (k + 2 == types.size() && types.get(k + 1) != 0x0)))
                                ret.append(";");
                            if (k + 2 == types.size() && types.get(k + 1) != 0x0)
                                ret.append(" )");
                        }
                    }
                }
                ret.append("\n\t\t\tbytecode_count : ").append(m.getBytecodeCount()).append("\n\t\t");
                ret.append("\texception_handler_count : ").append(m.getExceptionHandlerCount()).append("\n\t\t");
                ret.append("\texception_handler_index : ").append(Integer.toHexString(m.getExceptionHandlerIndex()));

                ret.append(rl).append("\t}").append(rl);
                j++;
            }

            ret.append("}").append(rl);
            i++;
        }

        ret.append("type_descriptor_info = {    ").append(this.getTypes()).append("}");

        ret.append("\n}\n");

        return ret.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        DescriptorComponent out = new DescriptorComponent();

        out.setTag(this.getTag());
        out.setSize(this.getSize());
        out.setClassCount(this.getClassCount());

        ArrayList<ClassDescriptorInfo> classes = new ArrayList<>();
        for(ClassDescriptorInfo cdi: this.getClasses()) {
            classes.add((ClassDescriptorInfo) cdi.clone());
        }
        out.setClasses(classes);

        out.setTypes((TypeDescriptorInfo) this.getTypes().clone());

        return out;
    }

    /**
     * Get Classes
     *
     * @return classes descriptions
     */
    public ArrayList<ClassDescriptorInfo> getClasses() {
        return classes;
    }

    /**
     * Set Classes
     *
     * @param classes new Classes descriptions
     */
    public void setClasses(ArrayList<ClassDescriptorInfo> classes) {
        this.classes = classes;
    }

    /**
     * Get Types
     *
     * @return Type descriptor info
     */
    public TypeDescriptorInfo getTypes() {
        return types;
    }

    /**
     * Set Types
     *
     * @param types new Type descriptor info
     */
    public void setTypes(TypeDescriptorInfo types) {
        this.types = types;
    }

    /**
     * Get the value of classCount number of entries in the classes table
     *
     * @return the value of classCount
     */
    public byte getClassCount() {
        return classCount;
    }

    /**
     * Set the value of classCount number of entries in the classes table
     *
     * @param newVar the new value of classCount
     */
    public void setClassCount(byte newVar) {
        classCount = newVar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DescriptorComponent that = (DescriptorComponent) o;

        if (classCount != that.classCount) return false;
        if (!classes.equals(that.classes)) return false;
        if (!types.equals(that.types)) return false;

        return true;
    }
}
