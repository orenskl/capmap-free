package fr.xlim.ssd.capmanipulator.bcel;

import fr.xlim.ssd.capmanipulator.bcel.exceptions.CapFieldException;
import fr.xlim.ssd.capmanipulator.bcel.utils.TypeDescriptorConverter;
import fr.xlim.ssd.capmanipulator.library.*;

public class CapField {

    private ClassDescriptorInfo classDescriptorInfo;
    private FieldDescriptorInfo fieldDescriptorInfo;
    private int type;

    private static final short ACC_PUBLIC    = 0x01;
    private static final short ACC_PRIVATE   = 0x02;
    private static final short ACC_PROTECTED = 0x04;
    private static final short ACC_STATIC    = 0x08;
    private static final short ACC_FINAL     = 0x10;

    private static final short VALUE_BOOLEAN = 0x0002;
    private static final short VALUE_BYTE    = 0x0003;
    private static final short VALUE_SHORT   = 0x0004;
    private static final short VALUE_INT     = 0x0005;

    private static final int VALUE_REF_MASK  = 0x00008000;
    private static final int REF_MASK        = 0x00007FFF;
    private static final int PRIM_MASK       = 0x0000000F;

    public CapField(ClassDescriptorInfo classDescriptorInfo, FieldDescriptorInfo fieldDescriptorInfo) {
        this.classDescriptorInfo = classDescriptorInfo;
        this.fieldDescriptorInfo = fieldDescriptorInfo;
        type = fieldDescriptorInfo.getType();
    }

    public int getType(){
        return type;
    }

    public String getTypeToString() throws CapFieldException {

        int prim_ref_mask = type & VALUE_REF_MASK;
        int masked_type = type & PRIM_MASK;

        if (prim_ref_mask > 0) {

                switch (masked_type) {
                    case VALUE_BOOLEAN:
                        return "Boolean";

                    case VALUE_BYTE:
                        return "Byte";

                    case VALUE_SHORT:
                        return "Short";

                    case VALUE_INT:
                        return "Integer";
                    default:
                        throw new CapFieldException("Unknown primitive value found");
                }

        } else if (prim_ref_mask == 0) {
                    TypeDescriptorConverter tdc = new TypeDescriptorConverter(CapFileFactory.getCapFile().getDescriptorComponent().getTypes().getTypeDesc().get((short)(type & REF_MASK)));
                    return tdc.toString();
        } else {
                throw new CapFieldException("You're not supposed to be here! Back off. NOW!");
        }
    }

    public ClassDescriptorInfo getClassDescriptorInfo() {
        return classDescriptorInfo;
    }

    public FieldDescriptorInfo getFieldDescriptorInfo() {
        return fieldDescriptorInfo;
    }

    public short getToken(){
        return fieldDescriptorInfo.getToken();
    }

    public boolean isPublic(){

        if ((fieldDescriptorInfo.getAccessFlags() & ACC_PUBLIC) > 0){
            return true;
        }
        return false;
    }

    public boolean isPrivate(){

        if ((fieldDescriptorInfo.getAccessFlags() & ACC_PRIVATE) > 0){
            return true;
        }
        return false;
    }

    public boolean isProtected(){

        if ((fieldDescriptorInfo.getAccessFlags() & ACC_PROTECTED) > 0){
            return true;
        }
        return false;
    }

    public boolean isStatic(){

        if ((fieldDescriptorInfo.getAccessFlags() & ACC_STATIC) > 0){
            return true;
        }
        return false;
    }

    public boolean isFinal(){

        if ((fieldDescriptorInfo.getAccessFlags() & ACC_FINAL) > 0){
            return true;
        }
        return false;
    }

    public void print() {

        try {
            System.out.print(getTypeToString());

            if (isPublic()) System.out.print(" Public");
            if (isProtected()) System.out.print(" Protected");
            if (isPrivate()) System.out.print(" Private");
            if (isStatic()) System.out.print(" Static");
            if (isFinal()) System.out.println(" Final");

            System.out.println("");
        } catch (CapFieldException e) {
            e.printStackTrace();
        }
    }
}
