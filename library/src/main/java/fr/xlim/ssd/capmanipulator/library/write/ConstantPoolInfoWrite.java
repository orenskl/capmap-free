package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.*;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class ConstantPoolInfoWrite {

    /**
     * Write Constant Pool Info
     *
     * @param out Cap File Stream
     * @throws java.io.IOException
     */
    public void write(CapOutputStream out, ConstantPoolInfo constantPoolInfo) throws UnableToWriteCapFileException {
        out.writeByte(constantPoolInfo.getTag());

        if (constantPoolInfo instanceof ConstantClassRef) {
            ConstantClassRef constantClassRef = (ConstantClassRef) constantPoolInfo;
            new ClassRefWrite().write(out, constantClassRef.getClassRef());
            out.writeByte(constantClassRef.getPadding());
        } else if (constantPoolInfo instanceof ConstantStaticFieldRef) {
            ConstantStaticFieldRef constantStaticFieldRef = (ConstantStaticFieldRef) constantPoolInfo;
            new StaticFieldRefWrite().write(out, constantStaticFieldRef.getStaticFieldRef());
        } else if (constantPoolInfo instanceof ConstantSuperMethodRef) {
            ConstantSuperMethodRef constantSuperMethodRef = (ConstantSuperMethodRef) constantPoolInfo;
            new ClassRefWrite().write(out, constantSuperMethodRef.getAssociatedClass());
            out.writeByte(constantSuperMethodRef.getToken());
        } else if (constantPoolInfo instanceof ConstantVirtualMethodRef) {
            ConstantVirtualMethodRef constantVirtualMethodRef = (ConstantVirtualMethodRef) constantPoolInfo;
            new ClassRefWrite().write(out, constantVirtualMethodRef.getAssociatedClass());
            out.writeByte(constantVirtualMethodRef.getToken());
        } else if (constantPoolInfo instanceof ConstantStaticMethodRef) {
            ConstantStaticMethodRef constantStaticMethodRef = (ConstantStaticMethodRef) constantPoolInfo;
            new StaticMethodRefWrite().write(out, constantStaticMethodRef.getStaticMethodRef());
        } else if (constantPoolInfo instanceof ConstantInstanceFieldRef) {
            ConstantInstanceFieldRef constantInstanceFieldRef = (ConstantInstanceFieldRef) constantPoolInfo;
            new ClassRefWrite().write(out, constantInstanceFieldRef.getAssociatedClass());
            out.writeByte(constantInstanceFieldRef.getToken());
        } else {
            throw new IllegalArgumentException("not expecting this kind of Constant pool info entry");
        }
    }
}
