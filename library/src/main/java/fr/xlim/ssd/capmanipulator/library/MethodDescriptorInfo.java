/**
 * MethodDescriptorInfo.java
 * <p>
 * Copyright (C) 2009 Guillaume Bouffard <guillaume.bouffard02@etu.unilim.fr>
 * Copyright (C) 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
 * Copyright (C) 2012 Julien Iguchi-Cartigny <julien.cartigny@xlim.fr>
 * <p>
 * Xlim - Université de Limoges
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
 * MethodDescriptorInfo
 * <p/>
 * used to describe a method defined in this package, it contains sufficient
 * informations to locate and parse the methods in the Method Component
 */
public class MethodDescriptorInfo implements Cloneable {

    /// Constants
    public static final byte ACC_INIT = (byte) 0x00;
    public static final byte ACC_PUBLIC = (byte) 0x01;
    public static final byte ACC_PRIVATE = (byte) 0x02;
    public static final byte ACC_PROTECTED = (byte) 0x04;
    public static final byte ACC_STATIC = (byte) 0x08;
    public static final byte ACC_FINAL = (byte) 0x10;
    public static final byte ACC_ABSTRACT = (byte) 0x40;

    // static method token or virtual method token or interface method
    // token of this method

    private byte token;
    // mask of modifiers used to describe the access permission to and
    // properties of this method
    private byte accessFlags;
    // byte offset into the info item of the Method componentTab. 0 is the
    // method is an interface
    private Short methodOffset;
    // offset into the type_descriptor_info structure. this type
    // represent the signature of the method
    private short typeOffset;
    // number of bytecodes in this method
    private short bytecodeCount;
    // number of exception handlers implemented by this method
    private short exceptionHandlerCount;
    // index to the first exceptionHandlers table entry in the method
    // componentTab implemented by this method
    private short exceptionHandlerIndex;

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t\t";
        StringBuffer ret = new StringBuffer();

        ret.append("\ttoken          : ").append(Integer.toHexString(this.getToken() & 0xff)).append(rl);
        ret.append("\taccess_flag    : (").append(Integer.toHexString(this.getAccessFlags() & 0xff)).append(") ");
        if ((accessFlags & 0x80) != 0)
            ret.append("ACC_INIT ");
        if ((accessFlags & 0x40) != 0)
            ret.append("ACC_ABSTRACT ");
        if ((accessFlags & 0x10) != 0)
            ret.append("ACC_FINAL ");
        if ((accessFlags & 0x08) != 0)
            ret.append("ACC_STATIC ");
        if ((accessFlags & 0x04) != 0)
            ret.append("ACC_PROTECTED ");
        if ((accessFlags & 0x02) != 0)
            ret.append("ACC_PRIVATE ");
        if ((accessFlags & 0x01) != 0)
            ret.append("ACC_PUBLIC ");
        ret.append(rl);
        ret.append("\tmethod_offset  : ").append(this.getMethodOffset() & 0xffff).append(rl);
        ret.append("\ttype_offset    : @").append(String.format("0x%04x", this.getTypeOffset() & 0x000ffff)).append(rl);
        ret.append("\tbytecode_count : ").append(this.getBytecodeCount()).append(rl);
        ret.append("\texception_handler_count : ").append(this.getExceptionHandlerCount()).append(rl);
        ret.append("\texception_handler_index : ").append(String.format("0x%04x", this.getExceptionHandlerIndex() & 0x000ffff));

        return ret.toString();
    }

    /**
     * Get Access Flags
     *
     * @return access flags value
     */
    public byte getAccessFlags() {
        return accessFlags;
    }

    /**
     * Set Access Flags
     *
     * @param accessFlags access flags to set
     */
    public void setAccessFlags(byte accessFlags) {
        this.accessFlags = accessFlags;
    }

    /**
     * Get Bytecode count
     *
     * @return bytecode count
     */
    public short getBytecodeCount() {
        return bytecodeCount;
    }

    /**
     * Set Bytecode count
     *
     * @param bytecodeCount bytecount to set
     */
    public void setBytecodeCount(short bytecodeCount) {
        this.bytecodeCount = bytecodeCount;
    }

    /**
     * Get exception Handler count
     *
     * @return exception Handler count
     */
    public short getExceptionHandlerCount() {
        return exceptionHandlerCount;
    }

    /**
     * Set exception Handler count
     *
     * @param exceptionHandlerCount exception handler count to set
     */
    public void setExceptionHandlerCount(short exceptionHandlerCount) {
        this.exceptionHandlerCount = exceptionHandlerCount;
    }

    /**
     * Get exception handler index
     *
     * @return exception handler index
     */
    public short getExceptionHandlerIndex() {
        return exceptionHandlerIndex;
    }

    /**
     * Set exception handler index
     *
     * @param exceptionHandlerIndex exception handler index to set
     */
    public void setExceptionHandlerIndex(short exceptionHandlerIndex) {
        this.exceptionHandlerIndex = exceptionHandlerIndex;
    }

    /**
     * Get method offset
     *
     * @return method offset
     */
    public Short getMethodOffset() {
        return methodOffset;
    }

    /**
     * Set method offset
     *
     * @param methodOffset method offset to set
     */
    public void setMethodOffset(Short methodOffset) {
        this.methodOffset = methodOffset;
    }

    /**
     * Get token
     *
     * @return token
     */
    public byte getToken() {
        return token;
    }

    /**
     * Set token
     *
     * @param token token to set
     */
    public void setToken(byte token) {
        this.token = token;
    }

    /**
     * Get type offset
     *
     * @return type offset
     */
    public short getTypeOffset() {
        return typeOffset;
    }

    /**
     * Set type offset
     *
     * @param typeOffset type offset to set
     */
    public void setTypeOffset(short typeOffset) {
        this.typeOffset = typeOffset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MethodDescriptorInfo that = (MethodDescriptorInfo) o;

        if (accessFlags != that.accessFlags) return false;
        if (bytecodeCount != that.bytecodeCount) return false;
        if (exceptionHandlerCount != that.exceptionHandlerCount) return false;
        if (exceptionHandlerIndex != that.exceptionHandlerIndex) return false;
        if (token != that.token) return false;
        if (typeOffset != that.typeOffset) return false;
        return methodOffset.equals(that.methodOffset);

    }

    @Override
    public int hashCode() {
        int result = (int) token;
        result = 31 * result + (int) accessFlags;
        result = 31 * result + methodOffset.hashCode();
        result = 31 * result + (int) typeOffset;
        result = 31 * result + (int) bytecodeCount;
        result = 31 * result + (int) exceptionHandlerCount;
        result = 31 * result + (int) exceptionHandlerIndex;
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MethodDescriptorInfo out = new MethodDescriptorInfo();

        out.setToken(this.getToken());
        out.setAccessFlags(this.getAccessFlags());
        out.setMethodOffset(this.getMethodOffset());
        out.setTypeOffset(this.getTypeOffset());
        out.setBytecodeCount(this.getBytecodeCount());
        out.setExceptionHandlerCount(this.getExceptionHandlerCount());
        out.setExceptionHandlerIndex(this.getExceptionHandlerIndex());

        return out;
    }
}
