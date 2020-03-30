/**
 * FieldDescriptorInfo.java
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

/**
 * FieldDescriptorInfo
 * <p/>
 * used to describe a field defined in this package
 */
public class FieldDescriptorInfo implements Cloneable {

    public static final byte ACC_PUBLIC = 0x01;
    public static final byte ACC_PRIVATE = 0x02;
    public static final byte ACC_PROTECTED = 0x04;
    public static final byte ACC_STATIC = 0x08;
    public static final byte ACC_FINAL = 0x10;

    private byte token; // token of this field
    // mask of modifiers used to describe the access permission to and
    // properties of this field
    private byte accesFlags;
    private FieldRef fieldRef; // reference to a field
    private short type; // type of this field

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t\t";
        StringBuffer ret = new StringBuffer();

        ret.append("\ttoken          : ").append(this.getToken() & 0xFF).append(rl);
        ret.append("\taccess_flag    : ").append(this.getAccessFlags()).append(rl);

        if (this.getFieldRef() instanceof StaticField) {
            // Here FieldRef is a static_field
            ret.append("\tfield_ref      : ");
            StaticFieldRef sfr = ((StaticField) this.getFieldRef()).getStaticFieldRef();
            if (sfr instanceof InternalStaticFieldRef) {
                InternalStaticFieldRef inter = (InternalStaticFieldRef) sfr;
                ret.append(String.format("%02x ", inter.getPadding()));
                ret.append(String.format("%02x ", (inter.getOffset() >> 0xff) & 0xff));
                ret.append(String.format("%02x", inter.getOffset() & 0xff));
            }
            if (sfr instanceof ExternalStaticFieldRef) {
                ExternalStaticFieldRef exter = (ExternalStaticFieldRef) sfr;
                ret.append(String.format("%02x ", exter.getPackageToken()));
                ret.append(String.format("%02x ", exter.getClassToken()));
                ret.append(String.format("%02x ", exter.getToken()));
            }
            ret.append(rl);
        } else {
            // And here is just a instance_field
            ret.append("\tfield_ref      : ");
            if (((InstanceField) this.getFieldRef()).getClass_() instanceof ExternalClassRef) {
                ExternalClassRef tmp = (ExternalClassRef) ((InstanceField) this.getFieldRef()).getClass_();
                String hex = Integer.toHexString(0xff & tmp.getClassToken());
                for (int i = hex.length(); i < 4; i++)
                    hex = "0" + hex;
                hex = hex.substring(0, 2) + " " + hex.substring(2);
                ret.append(hex);
            }
            if (((InstanceField) this.getFieldRef()).getClass_() instanceof InternalClassRef) {
                InternalClassRef tmp = (InternalClassRef) ((InstanceField) this.getFieldRef()).getClass_();
                String hex = Integer.toHexString(0xff & tmp.getInternalClassRef());
                for (int i = hex.length(); i < 4; i++)
                    hex = "0" + hex;
                hex = hex.substring(0, 2) + " " + hex.substring(2);
                ret.append(hex);
            }
            ret.append(String.format(" %02x", ((InstanceField) this.getFieldRef()).getToken() & 0xff)).append(rl);
            //ret.append("   class : ").append(((InstanceField) this.getFieldRef()).getClass_()).append(rl);
            //ret.append("   token : ").append(((InstanceField) this.getFieldRef()).getToken() & 0xff).append(rl);
        }

        /*if ((this.getType() & 0x8000) > 0) {
            ret.append("   primitive_type : ").append(this.getType() & 0xFFFF);
        } else {
            ret.append("   reference_type : ").append(this.getType() & 0xFFFF);
        }*/
        ret.append("\ttype           : ").append(this.getType() & 0xFFFF);

        return ret.toString();
    }

    /**
     * Get Access Flags
     *
     * @return Access Flags value
     */
    public byte getAccessFlags() {
        return accesFlags;
    }

    /**
     * Set Access Flags
     *
     * @param accesFlags new Access Flags value
     */
    public void setAccesFlags(byte accesFlags) {
        this.accesFlags = accesFlags;
    }

    /**
     * Get Field Ref
     *
     * @return Field Ref value
     */
    public FieldRef getFieldRef() {
        return fieldRef;
    }

    /**
     * Set Field Ref
     *
     * @param fieldRef new Field Ref value
     */
    public void setFieldRef(FieldRef fieldRef) {
        this.fieldRef = fieldRef;
    }

    /**
     * Get token
     *
     * @return token value
     */
    public byte getToken() {
        return token;
    }

    /**
     * Set token
     *
     * @param token new token value
     */
    public void setToken(byte token) {
        this.token = token;
    }

    /**
     * Get type
     *
     * @return type value
     */
    public short getType() {
        return type;
    }

    /**
     * Set type
     *
     * @param type new type value
     */
    public void setType(short type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FieldDescriptorInfo that = (FieldDescriptorInfo) o;

        if (accesFlags != that.accesFlags) return false;
        if (token != that.token) return false;
        if (type != that.type) return false;
        return fieldRef.equals(that.fieldRef);

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        FieldDescriptorInfo out = new FieldDescriptorInfo();

        out.setToken(this.getToken());
        out.setAccesFlags(this.getAccessFlags());
        out.setFieldRef((FieldRef) this.getFieldRef().clone());
        out.setType(this.getType());

        return out;
    }
}
