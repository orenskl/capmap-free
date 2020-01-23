package fr.xlim.ssd.capmanipulator.bcel;

import fr.xlim.ssd.capmanipulator.bcel.instructions.*;
import fr.xlim.ssd.capmanipulator.library.*;

import java.util.ArrayList;

public class CapMethod {

    MethodDescriptorInfo methodDescriptorInfo;
    MethodInfo methodInfo;
    ClassDescriptorInfo classDescriptorInfo;
    Short methodOffset;
    Short typeOffset;
    ArrayList<CapInstruction> instructionsList;

    public CapMethod(){
    }

    public CapMethod(ClassDescriptorInfo cdi, MethodDescriptorInfo mdi, int methodIndex){
        classDescriptorInfo = cdi;
        methodDescriptorInfo = mdi;
        methodOffset = methodDescriptorInfo.getMethodOffset();
        typeOffset = methodDescriptorInfo.getTypeOffset();
        methodInfo = CapFileFactory.getCapFile().getMethodComponent().getMethods().get(methodIndex);
		try {
			buildInstructionList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public byte getFlags(){
        return methodInfo.getMethodHeader().getFlags();
    }

    public byte getMaxStack(){
        return methodInfo.getMethodHeader().getMaxStack();
    }

    public byte getMaxLocals(){
        return methodInfo.getMethodHeader().getMaxLocals();
    }

    public byte getNargs(){
        return methodInfo.getMethodHeader().getNargs();
    }

    public byte getToken() {
        return methodDescriptorInfo.getToken();
    }

    public boolean isPublic(){

        if ((methodDescriptorInfo.getAccessFlags() & MethodComponent.ACC_PUBLIC) > 0){
            return true;
        }
        return false;
    }

    public boolean isPrivate(){

        if ((methodDescriptorInfo.getAccessFlags() & MethodComponent.ACC_PRIVATE) > 0){
            return true;
        }
        return false;
    }

    public boolean isProtected(){

        if ((methodDescriptorInfo.getAccessFlags() & MethodComponent.ACC_PROTECTED) > 0){
            return true;
        }
        return false;
    }

    public boolean isStatic(){

        if ((methodDescriptorInfo.getAccessFlags() & MethodComponent.ACC_STATIC) > 0){
            return true;
        }
        return false;
    }

    public boolean isFinal(){

        if ((methodDescriptorInfo.getAccessFlags() & MethodComponent.ACC_FINAL) > 0){
            return true;
        }
        return false;
    }

    public boolean isAbstract(){

        if ((methodDescriptorInfo.getAccessFlags() & MethodComponent.ACC_ABSTRACT) > 0){
            return true;
        }
        return false;
    }

    public boolean isInit(){

        if ((methodDescriptorInfo.getAccessFlags() & MethodComponent.ACC_INIT) > 0){
            return true;
        }
        return false;
    }

    public short getExceptionHandlerCount(){
        return methodDescriptorInfo.getExceptionHandlerCount();
    }

    public short getExceptionHandlerIndex(){
        return methodDescriptorInfo.getExceptionHandlerIndex();
    }

    public MethodDescriptorInfo getMethodDescriptorInfo() {
        return methodDescriptorInfo;
    }

    public ClassDescriptorInfo getClassDescriptorInfo() {
        return classDescriptorInfo;
    }

    public Short getMethodOffset() {
        return methodOffset;
    }

    public Short getTypeOffset() {
        return typeOffset;
    }

    public MethodInfo getMethodInfo() {
        return methodInfo;
    }

    public ArrayList<CapInstruction> getInstructionsList() {
        return instructionsList;
    }

    public void buildInstructionList() throws Exception {

        instructionsList = new ArrayList<CapInstruction>();
        ArrayList<Byte> byteList = methodInfo.getBytecodes();
        short currentByte;

        for (int i = 0; i < byteList.size(); i++){

            currentByte = (short) (byteList.get(i) & 0x00FF);

            if (currentByte == Constants.STABLESWITCH ||
                    currentByte == Constants.ITABLESWITCH ||
                    currentByte == Constants.SLOOKUPSWITCH ||
                    currentByte == Constants.ILOOKUPSWITCH ){

                switch (currentByte) {

                    case Constants.STABLESWITCH:

                        STABLESWITCH insSTABLESWITCH = new STABLESWITCH(i, byteList);

                        instructionsList.add(insSTABLESWITCH);

                        i += insSTABLESWITCH.getLength() - 1;

                        break;

                    case Constants.ITABLESWITCH:

                        ITABLESWITCH insITABLESWITCH = new ITABLESWITCH(i, byteList);

                        instructionsList.add(insITABLESWITCH);

                        i += insITABLESWITCH.getLength() - 1;

                        break;

                    case Constants.SLOOKUPSWITCH:

                        SLOOKUPSWITCH insSLOOKUPSWITCH = new SLOOKUPSWITCH(i, byteList);

                        instructionsList.add(insSLOOKUPSWITCH);

                        i += insSLOOKUPSWITCH.getLength() - 1;


                        break;

                    case Constants.ILOOKUPSWITCH:

                        ILOOKUPSWITCH insILOOKUPSWITCH = new ILOOKUPSWITCH(i, byteList);

                        instructionsList.add(insILOOKUPSWITCH);

                        i += insILOOKUPSWITCH.getLength() - 1;

                        break;

                    default :

                        throw new Exception("Roger, we got a problem here...");
                }

            } else {

                switch (currentByte) {

                    case Constants.NOP :

                        instructionsList.add(new NOP(i));
                        break;

                    case Constants.ACONST_NULL :

                        instructionsList.add(new ACONST_NULL(i));
                        break;

                    case Constants.SCONST_M1 :

                        instructionsList.add(new SCONST_M1(i));
                        break;

                    case Constants.SCONST_0	 :

                        instructionsList.add(new SCONST_0(i));
                        break;

                    case Constants.SCONST_1	:

                        instructionsList.add(new SCONST_1(i));
                        break;

                    case Constants.SCONST_2	:

                        instructionsList.add(new SCONST_2(i));
                        break;

                    case Constants.SCONST_3	:

                        instructionsList.add(new SCONST_3(i));
                        break;

                    case Constants.SCONST_4	:

                        instructionsList.add(new SCONST_4(i));
                        break;

                    case Constants.SCONST_5	:

                        instructionsList.add(new SCONST_5(i));
                        break;

                    case Constants.ICONST_M1 :

                        instructionsList.add(new ICONST_M1(i));
                        break;

                    case Constants.ICONST_0	:

                        instructionsList.add(new ICONST_0(i));
                        break;

                    case Constants.ICONST_1	:

                        instructionsList.add(new ICONST_1(i));
                        break;

                    case Constants.ICONST_2	:

                        instructionsList.add(new ICONST_2(i));
                        break;

                    case Constants.ICONST_3	:

                        instructionsList.add(new ICONST_3(i));
                        break;

                    case Constants.ICONST_4	:

                        instructionsList.add(new ICONST_4(i));
                        break;

                    case Constants.ICONST_5	:

                        instructionsList.add(new ICONST_5(i));
                        break;

                    case Constants.BSPUSH	:

                        instructionsList.add(new BSPUSH(i, byteList));
                        break;

                    case Constants.SSPUSH	:

                        instructionsList.add(new SSPUSH(i, byteList));
                        break;

                    case Constants.BIPUSH	:

                        instructionsList.add(new BIPUSH(i, byteList));
                        break;

                    case Constants.SIPUSH	:

                        instructionsList.add(new SIPUSH(i, byteList));
                        break;

                    case Constants.IIPUSH	:

                        instructionsList.add(new IIPUSH(i, byteList));
                        break;

                    case Constants.ALOAD :

                        instructionsList.add(new ALOAD(i, byteList));
                        break;

                    case Constants.SLOAD :

                        instructionsList.add(new SLOAD(i, byteList));
                        break;

                    case Constants.ILOAD :

                        instructionsList.add(new ILOAD(i, byteList));
                        break;

                    case Constants.ALOAD_0	:

                        instructionsList.add(new ALOAD_0(i));
                        break;

                    case Constants.ALOAD_1	:

                        instructionsList.add(new ALOAD_1(i));
                        break;

                    case Constants.ALOAD_2	:

                        instructionsList.add(new ALOAD_2(i));
                        break;

                    case Constants.ALOAD_3	:

                        instructionsList.add(new ALOAD_3(i));
                        break;

                    case Constants.SLOAD_0	:

                        instructionsList.add(new SLOAD_0(i));
                        break;

                    case Constants.SLOAD_1	:

                        instructionsList.add(new SLOAD_1(i));
                        break;

                    case Constants.SLOAD_2	:

                        instructionsList.add(new SLOAD_2(i));
                        break;

                    case Constants.SLOAD_3	:

                        instructionsList.add(new SLOAD_3(i));
                        break;

                    case Constants.ILOAD_0	:

                        instructionsList.add(new ILOAD_0(i));
                        break;

                    case Constants.ILOAD_1	:

                        instructionsList.add(new ILOAD_1(i));
                        break;

                    case Constants.ILOAD_2	:

                        instructionsList.add(new ILOAD_2(i));
                        break;

                    case Constants.ILOAD_3	:

                        instructionsList.add(new ILOAD_3(i));
                        break;

                    case Constants.AALOAD	:

                        instructionsList.add(new AALOAD(i));
                        break;

                    case Constants.BALOAD	:

                        instructionsList.add(new BALOAD(i));
                        break;

                    case Constants.SALOAD	:

                        instructionsList.add(new SALOAD(i));
                        break;

                    case Constants.IALOAD	:

                        instructionsList.add(new IALOAD(i));
                        break;

                    case Constants.ASTORE	:

                        instructionsList.add(new ASTORE(i, byteList));
                        break;

                    case Constants.SSTORE	:

                        instructionsList.add(new SSTORE(i, byteList));
                        break;

                    case Constants.ISTORE	:

                        instructionsList.add(new ISTORE(i, byteList));
                        break;

                    case Constants.ASTORE_0	:

                        instructionsList.add(new ASTORE_0(i));
                        break;

                    case Constants.ASTORE_1	:

                        instructionsList.add(new ASTORE_1(i));
                        break;

                    case Constants.ASTORE_2	:

                        instructionsList.add(new ASTORE_2(i));
                        break;

                    case Constants.ASTORE_3	:

                        instructionsList.add(new ASTORE_3(i));
                        break;

                    case Constants.SSTORE_0	:

                        instructionsList.add(new SSTORE_0(i));
                        break;

                    case Constants.SSTORE_1	:

                        instructionsList.add(new SSTORE_1(i));
                        break;

                    case Constants.SSTORE_2	:

                        instructionsList.add(new SSTORE_2(i));
                        break;

                    case Constants.SSTORE_3	:

                        instructionsList.add(new SSTORE_3(i));
                        break;

                    case Constants.ISTORE_0	:

                        instructionsList.add(new ISTORE_0(i));
                        break;

                    case Constants.ISTORE_1	:

                        instructionsList.add(new ISTORE_1(i));
                        break;

                    case Constants.ISTORE_2	:

                        instructionsList.add(new ISTORE_2(i));
                        break;

                    case Constants.ISTORE_3	:

                        instructionsList.add(new ISTORE_3(i));
                        break;

                    case Constants.AASTORE	:

                        instructionsList.add(new AASTORE(i));
                        break;

                    case Constants.BASTORE	:

                        instructionsList.add(new BASTORE(i));
                        break;

                    case Constants.SASTORE	:

                        instructionsList.add(new SASTORE(i));
                        break;

                    case Constants.IASTORE	:

                        instructionsList.add(new IASTORE(i));
                        break;

                    case Constants.POP		:

                        instructionsList.add(new POP(i));
                        break;

                    case Constants.POP2		:

                        instructionsList.add(new POP2(i));
                        break;

                    case Constants.DUP		:

                        instructionsList.add(new DUP(i));
                        break;

                    case Constants.DUP2		:

                        instructionsList.add(new DUP2(i));
                        break;

                    case Constants.DUP_X		:

                        instructionsList.add(new DUP_X(i, byteList));
                        break;

                    case Constants.SWAP_X	:

                        instructionsList.add(new SWAP_X(i, byteList));
                        break;

                    case Constants.SADD		:

                        instructionsList.add(new SADD(i));
                        break;

                    case Constants.IADD		:

                        instructionsList.add(new IADD(i));
                        break;

                    case Constants.SSUB		:

                        instructionsList.add(new SSUB(i));
                        break;

                    case Constants.ISUB		:

                        instructionsList.add(new ISUB(i));
                        break;

                    case Constants.SMUL		:

                        instructionsList.add(new SMUL(i));
                        break;

                    case Constants.IMUL		:

                        instructionsList.add(new IMUL(i));
                        break;

                    case Constants.SDIV		:

                        instructionsList.add(new SDIV(i));
                        break;

                    case Constants.IDIV		:

                        instructionsList.add(new IDIV(i));
                        break;

                    case Constants.SREM		:

                        instructionsList.add(new SREM(i));
                        break;

                    case Constants.IREM		:

                        instructionsList.add(new IREM(i));
                        break;

                    case Constants.SNEG		:

                        instructionsList.add(new SNEG(i));
                        break;

                    case Constants.INEG		:

                        instructionsList.add(new INEG(i));
                        break;

                    case Constants.SSHL		:

                        instructionsList.add(new SSHL(i));
                        break;

                    case Constants.ISHL		:

                        instructionsList.add(new ISHL(i));
                        break;

                    case Constants.SSHR		:

                        instructionsList.add(new SSHR(i));
                        break;

                    case Constants.ISHR		:

                        instructionsList.add(new ISHR(i));
                        break;

                    case Constants.SUSHR		:

                        instructionsList.add(new SUSHR(i));
                        break;

                    case Constants.IUSHR		:

                        instructionsList.add(new IUSHR(i));
                        break;

                    case Constants.SAND		:

                        instructionsList.add(new SAND(i));
                        break;

                    case Constants.IAND		:

                        instructionsList.add(new IAND(i));
                        break;

                    case Constants.SOR		:

                        instructionsList.add(new SOR(i));
                        break;

                    case Constants.IOR		:

                        instructionsList.add(new IOR(i));
                        break;

                    case Constants.SXOR		:

                        instructionsList.add(new SXOR(i));
                        break;

                    case Constants.IXOR		:

                        instructionsList.add(new IXOR(i));
                        break;

                    case Constants.SINC		:

                        instructionsList.add(new SINC(i, byteList));
                        break;

                    case Constants.IINC		:

                        instructionsList.add(new IINC(i, byteList));
                        break;

                    case Constants.S2B		:

                        instructionsList.add(new S2B(i));
                        break;

                    case Constants.S2I		:

                        instructionsList.add(new S2I(i));
                        break;

                    case Constants.I2B		:

                        instructionsList.add(new I2B(i));
                        break;

                    case Constants.I2S		:

                        instructionsList.add(new I2S(i));
                        break;

                    case Constants.ICMP		:

                        instructionsList.add(new ICMP(i));
                        break;

                    case Constants.IFEQ		:

                        instructionsList.add(new IFEQ(i, byteList));
                        break;

                    case Constants.IFNE		:

                        instructionsList.add(new IFNE(i, byteList));
                        break;

                    case Constants.IFLT		:

                        instructionsList.add(new IFLT(i, byteList));
                        break;

                    case Constants.IFGE		:

                        instructionsList.add(new IFGE(i, byteList));
                        break;

                    case Constants.IFGT	:

                        instructionsList.add(new IFGT(i, byteList));
                        break;

                    case Constants.IFLE	:

                        instructionsList.add(new IFLE(i, byteList));
                        break;

                    case Constants.IFNULL	:

                        instructionsList.add(new IFNULL(i, byteList));
                        break;

                    case Constants.IFNONNULL	:

                        instructionsList.add(new IFNONNULL(i, byteList));
                        break;

                    case Constants.IF_ACMPEQ		:

                        instructionsList.add(new IF_ACMPEQ(i, byteList));
                        break;

                    case Constants.IF_ACMPNE		:

                        instructionsList.add(new IF_ACMPNE(i, byteList));
                        break;

                    case Constants.IF_SCMPEQ		:

                        instructionsList.add(new IF_SCMPEQ(i, byteList));
                        break;

                    case Constants.IF_SCMPNE		:

                        instructionsList.add(new IF_SCMPNE(i, byteList));
                        break;

                    case Constants.IF_SCMPLT		:

                        instructionsList.add(new IF_SCMPLT(i, byteList));
                        break;

                    case Constants.IF_SCMPGE		:

                        instructionsList.add(new IF_SCMPGE(i, byteList));
                        break;

                    case Constants.IF_SCMPGT		:

                        instructionsList.add(new IF_SCMPGT(i, byteList));
                        break;

                    case Constants.IF_SCMPLE		:

                        instructionsList.add(new IF_SCMPLE(i, byteList));
                        break;

                    case Constants.GOTO			:

                        instructionsList.add(new GOTO(i, byteList));
                        break;

                    case Constants.JSR		:

                        instructionsList.add(new JSR(i, byteList));
                        break;

                    case Constants.RET		:

                        instructionsList.add(new RET(i, byteList));
                        break;

                    case Constants.ARETURN		:

                        instructionsList.add(new ARETURN(i));
                        break;

                    case Constants.SRETURN	:

                        instructionsList.add(new SRETURN(i));
                        break;

                    case Constants.IRETURN	:

                        instructionsList.add(new IRETURN(i));
                        break;

                    case Constants.RETURN	:

                        instructionsList.add(new RETURN(i));
                        break;

                    case Constants.GETSTATIC_A:

                        instructionsList.add(new GETSTATIC_A(i, byteList));
                        break;

                    case Constants.GETSTATIC_B:

                        instructionsList.add(new GETSTATIC_B(i, byteList));
                        break;

                    case Constants.GETSTATIC_S:

                        instructionsList.add(new GETSTATIC_S(i, byteList));
                        break;

                    case Constants.GETSTATIC_I:

                        instructionsList.add(new GETSTATIC_I(i, byteList));
                        break;

                    case Constants.PUTSTATIC_A:

                        instructionsList.add(new PUTSTATIC_A(i, byteList));
                        break;

                    case Constants.PUTSTATIC_B:

                        instructionsList.add(new PUTSTATIC_B(i, byteList));
                        break;

                    case Constants.PUTSTATIC_S:

                        instructionsList.add(new PUTSTATIC_S(i, byteList));
                        break;

                    case Constants.PUTSTATIC_I:

                        instructionsList.add(new PUTSTATIC_I(i, byteList));
                        break;

                    case Constants.GETFIELD_A:

                        instructionsList.add(new GETFIELD_A(i, byteList));
                        break;

                    case Constants.GETFIELD_B:

                        instructionsList.add(new GETFIELD_B(i, byteList));
                        break;

                    case Constants.GETFIELD_S:

                        instructionsList.add(new GETFIELD_S(i, byteList));
                        break;

                    case Constants.GETFIELD_I:

                        instructionsList.add(new GETFIELD_I(i, byteList));
                        break;

                    case Constants.PUTFIELD_A:

                        instructionsList.add(new PUTFIELD_A(i, byteList));
                        break;

                    case Constants.PUTFIELD_B:

                        instructionsList.add(new PUTFIELD_B(i, byteList));
                        break;

                    case Constants.PUTFIELD_S:

                        instructionsList.add(new PUTFIELD_S(i, byteList));
                        break;

                    case Constants.PUTFIELD_I:

                        instructionsList.add(new PUTFIELD_I(i, byteList));
                        break;

                    case Constants.INVOKEVIRTUAL:

                        instructionsList.add(new INVOKEVIRTUAL(i, byteList));
                        break;

                    case Constants.INVOKESPECIAL:

                        instructionsList.add(new INVOKESPECIAL(i, byteList));
                        break;

                    case Constants.INVOKESTATIC:

                        instructionsList.add(new INVOKESTATIC(i, byteList));
                        break;

                    case Constants.INVOKEINTERFACE:

                        instructionsList.add(new INVOKEINTERFACE(i, byteList));
                        break;

                    case Constants.NEW			:

                        instructionsList.add(new NEW(i, byteList));
                        break;

                    case Constants.NEWARRAY		:

                        instructionsList.add(new NEWARRAY(i, byteList));
                        break;

                    case Constants.ANEWARRAY		:

                        instructionsList.add(new ANEWARRAY(i, byteList));
                        break;

                    case Constants.ARRAYLENGTH:

                        instructionsList.add(new ARRAYLENGTH(i));
                        break;

                    case Constants.ATHROW		:

                        instructionsList.add(new ATHROW(i));
                        break;

                    case Constants.CHECKCAST		:

                        instructionsList.add(new CHECKCAST(i, byteList));
                        break;

                    case Constants.INSTANCEOF:

                        instructionsList.add(new INSTANCEOF(i, byteList));
                        break;

                    case Constants.SINC_W		:

                        instructionsList.add(new SINC_W(i, byteList));
                        break;

                    case Constants.IINC_W		:

                        instructionsList.add(new IINC_W(i, byteList));
                        break;

                    case Constants.IFEQ_W		:

                        instructionsList.add(new IFEQ_W(i, byteList));
                        break;

                    case Constants.IFNE_W		:

                        instructionsList.add(new IFNE_W(i, byteList));
                        break;

                    case Constants.IFLT_W		:

                        instructionsList.add(new IFLT_W(i, byteList));
                        break;

                    case Constants.IFGE_W		:

                        instructionsList.add(new IFGE_W(i, byteList));
                        break;

                    case Constants.IFGT_W		:

                        instructionsList.add(new IFGT_W(i, byteList));
                        break;

                    case Constants.IFLE_W		:

                        instructionsList.add(new IFLE_W(i, byteList));
                        break;

                    case Constants.IFNULL_W		:

                        instructionsList.add(new IFNULL_W(i, byteList));
                        break;

                    case Constants.IFNONNULL_W:

                        instructionsList.add(new IFNONNULL_W(i, byteList));
                        break;

                    case Constants.IF_ACMPEQ_W:

                        instructionsList.add(new IF_ACMPEQ_W(i, byteList));
                        break;

                    case Constants.IF_ACMPNE_W:

                        instructionsList.add(new IF_ACMPNE_W(i, byteList));
                        break;

                    case Constants.IF_SCMPEQ_W:

                        instructionsList.add(new IF_SCMPEQ_W(i, byteList));
                        break;

                    case Constants.IF_SCMPNE_W:

                        instructionsList.add(new IF_SCMPNE_W(i, byteList));
                        break;

                    case Constants.IF_SCMPLT_W:

                        instructionsList.add(new IF_SCMPLT_W(i, byteList));
                        break;

                    case Constants.IF_SCMPGE_W:

                        instructionsList.add(new IF_SCMPGE_W(i, byteList));
                        break;

                    case Constants.IF_SCMPGT_W:

                        instructionsList.add(new IF_SCMPGT_W(i, byteList));
                        break;

                    case Constants.IF_SCMPLE_W:

                        instructionsList.add(new IF_SCMPLE_W(i, byteList));
                        break;

                    case Constants.GOTO_W		:

                        instructionsList.add(new GOTO_W(i, byteList));
                        break;

                    case Constants.GETFIELD_A_W:

                        instructionsList.add(new GETFIELD_A_W(i, byteList));
                        break;

                    case Constants.GETFIELD_B_W:

                        instructionsList.add(new GETFIELD_B_W(i, byteList));
                        break;

                    case Constants.GETFIELD_S_W:

                        instructionsList.add(new GETFIELD_S_W(i, byteList));
                        break;

                    case Constants.GETFIELD_I_W:

                        instructionsList.add(new GETFIELD_I_W(i, byteList));
                        break;

                    case Constants.GETFIELD_A_THIS:

                        instructionsList.add(new GETFIELD_A_THIS(i, byteList));
                        break;

                    case Constants.GETFIELD_B_THIS:

                        instructionsList.add(new GETFIELD_B_THIS(i, byteList));
                        break;

                    case Constants.GETFIELD_S_THIS:

                        instructionsList.add(new GETFIELD_S_THIS(i, byteList));
                        break;

                    case Constants.GETFIELD_I_THIS:

                        instructionsList.add(new GETFIELD_I_THIS(i, byteList));
                        break;

                    case Constants.PUTFIELD_A_W:

                        instructionsList.add(new PUTFIELD_A_W(i, byteList));
                        break;

                    case Constants.PUTFIELD_B_W:

                        instructionsList.add(new PUTFIELD_B_W(i, byteList));
                        break;

                    case Constants.PUTFIELD_S_W:

                        instructionsList.add(new PUTFIELD_S_W(i, byteList));
                        break;

                    case Constants.PUTFIELD_I_W:

                        instructionsList.add(new PUTFIELD_I_W(i, byteList));
                        break;

                    case Constants.PUTFIELD_A_THIS:

                        instructionsList.add(new PUTFIELD_A_THIS(i, byteList));
                        break;

                    case Constants.PUTFIELD_B_THIS:

                        instructionsList.add(new PUTFIELD_B_THIS(i, byteList));
                        break;

                    case Constants.PUTFIELD_S_THIS:

                        instructionsList.add(new PUTFIELD_S_THIS(i, byteList));
                        break;

                    case Constants.PUTFIELD_I_THIS:

                        instructionsList.add(new PUTFIELD_I_THIS(i, byteList));
                        break;

                    case Constants.IMPDEP1		:

                        instructionsList.add(new IMPDEP1(i));
                        break;

                    case Constants.IMPDEP2		:

                        instructionsList.add(new IMPDEP2(i));
                        break;

                    default:

                        throw new Exception("Invalid opcode found : " + currentByte);

                }

                i += Constants.INSTRUCTION_LENGTH[currentByte] - 1;
            }
        }
    }

    public void setMethodInfo(MethodInfo methodInfo) {

        this.methodInfo = methodInfo;
    }
}