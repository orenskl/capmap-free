/**
 * MethodInfoEditable.java
 * <p>
 * Author: 2013 Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 * <p>
 */

package fr.xlim.ssd.capmanipulator.library.editable;

import fr.xlim.ssd.capmanipulator.library.*;
import fr.xlim.ssd.capmanipulator.library.bytecodereader.Argument;
import fr.xlim.ssd.capmanipulator.library.bytecodereader.ByteCodeConverter;
import fr.xlim.ssd.capmanipulator.library.bytecodereader.Offset;
import fr.xlim.ssd.capmanipulator.library.bytecodereader.OpCode;
import fr.xlim.ssd.capmanipulator.library.read.MethodInfoRead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Class which contains some method to update bytecode array. The interdependances are handled by these methods
 *
 * @author Guillaume Bouffard <guillaume.bouffard@unilim.fr>
 */
public class MethodInfoEditable extends MethodInfo {

    private final static Logger logger = LoggerFactory.getLogger(MethodInfoEditable.class);
    private CapFile capFile;
    private MethodInfo methodInfo;

    /**
     * Default constructor
     *
     * @param capFile reference to the CapFile to update
     */
    public MethodInfoEditable(CapFile capFile) {
        this.capFile = capFile;
        this.methodInfo = null;
    }

    /**
     * Deprecated constructor
     *
     * @param capFile    reference to the CapFile to update
     * @param methodInfo byte code method where modification will referee
     */
    @Deprecated
    public MethodInfoEditable(CapFile capFile, MethodInfo methodInfo) {
        this.capFile = capFile;
        this.methodInfo = methodInfo;
    }

    /**
     * Method replacing the former bytecode by a new one and spread the
     * modification in the cap file
     *
     * @param newByteCode the new arrayList of bytecode
     */
    protected void editBytecode(ArrayList<Byte> newByteCode) {


        //we get the number of this method with the map offsetMethodToNumber
        int methodNumber = capFile.getOffsetMethodToNumber().get(methodInfo.getMethodInfoOffset());


        //if the size of the new bytecode is different from the size of the former bytecode
        //we compute the offset of the methods following this method
        if (newByteCode.size() != methodInfo.getBytecodes().size()) {

            int differenceSize = methodInfo.getBytecodes().size() - newByteCode.size();

            //we correct the descriptorComponent for the current method
            for (ClassDescriptorInfo cDesc : capFile.getDescriptorComponent().getClasses()) {
                for (MethodDescriptorInfo mDesc : cDesc.getMethods()) {
                    //we should check that the value of the offset is not 0
                    if (mDesc.getMethodOffset() == 0) {
                        continue;
                    }

                    if ((short) mDesc.getMethodOffset() == (short) capFile.getMethodComponent().getMethods().get(methodNumber).getMethodInfoOffset()) {
                        mDesc.setBytecodeCount((short) newByteCode.size());
                        break;
                    }
                }
            }

            // Updating begin method offset
            for (int i = methodNumber + 1; i < capFile.getMethodComponent().getMethods().size(); i++) {

                short newOffset = (short) (capFile.getMethodComponent().getMethods().get(i).getMethodInfoOffset() - differenceSize);
                logger.debug("method [{}] - offset: {}", i, Integer.toHexString(((int) this.capFile.getMethodComponent().getMethods().get(i).getMethodInfoOffset() & 0xFFFF)));

                //we correct the descriptorComponent
                for (ClassDescriptorInfo cDesc : capFile.getDescriptorComponent().getClasses()) {
                    for (MethodDescriptorInfo mDesc : cDesc.getMethods()) {
                        //we should check that the value of the offset is not 0
                        if (mDesc.getMethodOffset() == 0) {
                            continue;
                        }

                        if ((int) (mDesc.getMethodOffset() & 0x00FFFF) == ((int) capFile.getMethodComponent().getMethods().get(i).getMethodInfoOffset() & 0x00FFFF)) {
                            // mDesc.setBytecodeCount((short) mDesc);
                            mDesc.setMethodOffset(newOffset);
                            logger.debug("Updating method [{}] with value offset: {}", i, Integer.toHexString(((int) mDesc.getMethodOffset() & 0xFFFF)));
                        }
                    }
                }

                capFile.getMethodComponent().getMethods().get(i).setMethodInfoOffset(newOffset);
            }

            /*
            DescriptorComponent descriptorComponent = this.capFile.getDescriptorComponent();
            // correcting Descriptor component
            if (descriptorComponent != null) {
                DescriptorComponentEditable descriptorComponentEditable = new DescriptorComponentEditable(this.capFile);
                descriptorComponentEditable.correctingMethods();
            } */

            //we will also correct every part of the cap file which contains a reference to an offset methods
            correctMethodOffsetInOtherComponents(methodInfo.getMethodInfoOffset());


            //finaly we correct the sizes
            correctSize((short) (capFile.getMethodComponent().getSize() - differenceSize));

            methodInfo.setBytecodes(newByteCode);

            //and we regenerates the offsetMethodToNumberMap
            Map<Short, Integer> mapOffsetMethodToNumber = new HashMap<Short, Integer>();

            int methodCount = 0;
            for (MethodInfo mDes : capFile.getMethodComponent().getMethods()) {
                mapOffsetMethodToNumber.put(mDes.getMethodInfoOffset(), methodCount++);
            }

            capFile.setOffsetMethodToNumber(mapOffsetMethodToNumber);

            return;

        }

        methodInfo.setBytecodes(newByteCode);


    }

    /**
     * Search the method which contains the instruction to modify
     *
     * @param pc current PC contains by the method to modify
     * @return the method to modify
     */
    private MethodInfo searchMethodFromPC(int pc) {
        // search method to modify
        for (MethodInfo method : this.capFile.getMethodComponent().getMethods()) {

            if ((pc >= (method.getFirstBytecodeOffset().intValue() & 0x00FFFF))
                    && (pc <= (method.getLastBytecodeOffset() & 0x00FFFF))) {
                return method;
            }
        }
        return null;
    }

    /**
     * insert an opcode without parameter to a specific pc
     *
     * @param pc          Current PC where the instruction will add into the bytecode
     * @param instruction Instruction to add
     * @return new pc value increased by the size of inserted instruction
     */
    public int insertInstruction(int pc, Instruction instruction) {
        return this.insertInstruction(pc, instruction, null);
    }

    /**
     * insert an opcode with 1-byte parameter to a specific pc
     *
     * @param pc          Current PC where the instruction will add into the bytecode
     * @param instruction Instruction to add
     * @param argument    Instruction's argument
     * @return new pc value increased by the size of inserted instruction
     */
    public int insertInstruction(int pc, Instruction instruction, byte argument) {
        return this.insertInstruction(pc, instruction, new byte[]{argument});
    }

    /**
     * insert an opcode with 2-byte parameter to a specific pc
     *
     * @param pc          Current PC where the instruction will add into the bytecode
     * @param instruction Instruction to add
     * @param arguments   Instruction's argument
     * @return new pc value increased by the size of inserted instruction
     */
    public int insertInstruction(int pc, Instruction instruction, short arguments) {
        return this.insertInstruction(pc, instruction, new byte[]
                {(byte) ((arguments >> 8) & 0x00FF), (byte) (arguments & 0x00FF)});
    }

    /**
     * insert an opcode to a specific pc
     *
     * @param pc          Current PC where the instruction will add into the bytecode
     * @param instruction Instruction to add
     * @param arguments   Instruction's argument
     * @return new pc value increased by the size of inserted instruction
     */
    public int insertInstruction(int pc, Instruction instruction, byte[] arguments) {

        this.methodInfo = searchMethodFromPC(pc);

        ArrayList<Argument> args = new ArrayList<Argument>();
        Argument argument = new Argument(arguments, true);
        args.add(argument);
        OpCode opCode = new OpCode(instruction.getValue(), instruction.name(), args);
        this.addOpCode(pc, opCode);

        int new_pc = pc + 1;

        for (Argument arg : args)
            new_pc += arg.getSize();

        logger.debug("new pc = 0x" + Integer.toHexString(new_pc));

        return new_pc;
    }

    /**
     * @param pc          Current PC where the instruction will replace into the bytecode
     * @param instruction Instruction to add
     * @return new pc value increased by the size of inserted instruction
     */
    public int replaceInstruction(int pc, Instruction instruction) {
        return this.replaceInstruction(pc, instruction, null);
    }

    /**
     * replace an opcode to a specific pc by a new instruction with 1-byte
     *
     * @param pc          Current PC where the instruction will replace into the bytecode
     * @param instruction Instruction to add
     * @param argument    Instruction's argument
     * @return new pc value increased by the size of inserted instruction
     */
    public int replaceInstruction(int pc, Instruction instruction, byte argument) {
        return this.replaceInstruction(pc, instruction, new byte[]{argument});
    }

    /**
     * replace an opcode to a specific pc by a new instruction with 2-byte
     *
     * @param pc          Current PC where the instruction will replace into the bytecode
     * @param instruction Instruction to add
     * @param arguments   Instruction's argument
     * @return new pc value increased by the size of inserted instruction
     */
    public int replaceInstruction(int pc, Instruction instruction, short arguments) {
        return this.replaceInstruction(pc, instruction, new byte[]
                {(byte) ((arguments >> 8) & 0x00FF), (byte) (arguments & 0x00FF)});
    }

    /**
     * replace an opcode to a specific pc by a new instruction
     *
     * @param pc          Current PC where the instruction will replace into the bytecode
     * @param instruction Instruction to add
     * @param arguments   Instruction's argument
     * @return new pc value increased by the size of inserted instruction
     */
    public int replaceInstruction(int pc, Instruction instruction, byte[] arguments) {
        this.methodInfo = searchMethodFromPC(pc);

        short newOffset = (short) this.insertInstruction(pc, instruction, arguments);
        this.removeInstruction((int) newOffset);
        return (int) newOffset;
    }

    /**
     * Remove an instruction
     *
     * @param pc instruction to remove
     * @return new pc value
     */
    public int removeInstruction(int pc) {
        this.methodInfo = searchMethodFromPC(pc);
        this.removeOpCode(pc);
        return pc;
    }

    /**
     * Method which will add an opcode into the bytecode array and correct the
     * dependencies into this array
     *
     * @param pc     offset of the instruction to add into the bytecode
     * @param opCode instruction to add
     */
    protected void addOpCode(int pc, OpCode opCode) {

        logger.debug("Opcode to insert: " + opCode.getName()
                + " (0x" + Integer.toHexString(opCode.getValue())
                + " - size: " + Integer.toString(opCode.getOpcodeSize()) + ") at "
                + "0x" + Integer.toHexString(pc));

        //we correct the jump into the bytecode according to the new opcode
        new MethodInfoRead().makeOpcodeArray(methodInfo);

        this.correctJumpWhenAdd(pc, opCode.getOpcodeSize());

        //we regenerate the arrayList of Bytecode with the modified opCodeMap
        ArrayList<Byte> aCopyByteCode = ByteCodeConverter.OpcodeMapToByteArrayList(methodInfo.getOpcodeMap());

        //we add the element contained in the array list into the bytecode array copy
        if ((pc - methodInfo.getFirstBytecodeOffset()) == aCopyByteCode.size()) {
            aCopyByteCode.addAll(opCode.getByteArrayValue());
        } else {
            aCopyByteCode.addAll(pc - methodInfo.getFirstBytecodeOffset(),
                    opCode.getByteArrayValue());
        }

        //we correct the bytecode
        this.editBytecode(aCopyByteCode);

        //we correct the offset into the reference location componentTab
        ReferenceLocationComponentEditable re = new ReferenceLocationComponentEditable(this.capFile);
        re.correctReferenceLocationComponentOffset(pc, opCode.getOpcodeSize());

        updateInstructionOffset();
        updateExceptionHandler(pc, (short) opCode.getOpcodeSize());
    }

    /**
     * update instructions' offset
     */
    private void updateInstructionOffset() {
        new MethodInfoRead().makeOpcodeArray(methodInfo);

        for (int m_index = this.capFile.getMethodComponent().getMethods().indexOf(methodInfo) + 1;
             m_index < this.capFile.getMethodComponent().getMethods().size();
             m_index++) {
            MethodInfo current_method = this.capFile.getMethodComponent().getMethods().get(m_index);
            current_method.setMethodInfoOffset((short) (this.capFile.getMethodComponent().getMethods().get(m_index - 1).getLastBytecodeOffset() + 1));
            current_method.setFirstBytecodeOffset(
                    (short) (current_method.getMethodInfoOffset() +
                            (current_method.getMethodHeader() instanceof ExtendedMethodHeaderInfo ? 4 : 2))
            );
            new MethodInfoRead().makeOpcodeArray(current_method);
        }

    }

    private void updateExceptionHandler(int pc, short instruction_size) {
        if (this.capFile.getMethodComponent().getHandlerCount() == 0)
            return; // no exception handler to update

        /**
         * exception_handler[0] {
         *      u2 start_offset // start offset -> shall be updated according to the method modification
         *      u2 bitfield {
         *          bit[1]  stop_bit
         *          bit[15] active_length // length of the try statement -> shall be updated according to the method modification
         *      }
         *      u2 handler_offset // offset to the catch statement -> shall be updated according to the method modification
         *      u2 catch_type_index
         *  }
         */

        for (int i = 0; i < this.capFile.getMethodComponent().getHandlerCount(); i++) {

            short start_offset = this.capFile.getMethodComponent().getExceptionHandlers().get(i).getStartOffset();
            byte stop_bit = this.capFile.getMethodComponent().getExceptionHandlers().get(i).getStopBit();
            short active_length = this.capFile.getMethodComponent().getExceptionHandlers().get(i).getActiveLength();
            short handler_offset = this.capFile.getMethodComponent().getExceptionHandlers().get(i).getHandlerOffset();

            short end_offset = (short) (start_offset + active_length);

            // An instruction was added/removed BEFORE the try statement
            if (pc <= start_offset) {
                start_offset += instruction_size;
                handler_offset += instruction_size;
            }
            // An instruction was added/removed IN the try statement
            else if ((start_offset <= pc) && (pc < end_offset)) {
                active_length += instruction_size;
                handler_offset += instruction_size;
            }
            // An instruction was added/removed BETWEEN the try statement AND the catch statemetn
            else if ((pc >= end_offset) && (pc <= handler_offset)) {
                handler_offset += instruction_size;
            }

            /**
             * TODO: When the try statement becomes empty, the exception should be removed. In this case, if the stop
             * bit equals to 1, CapMap must check the previous exception handler. The previous one can be a statement
             * of the same try-catch statements. There, the previous exception handler should have its stop bit set to 1.
             */
            // si the size is null, so the try statement is empty => the exception becomes useless
            if (active_length <= 0) {
                if (stop_bit == 1) {
                    if (i > 0) {
                        // When the current Exception Handler is delete, and its stop_bit is set, the previous
                        // Exception Handler must be set too.
                        // TODO: This case is impossible
                        // this.capFile.getMethodComponent().getExceptionHandlers().get(i - 1).setStopBit((byte) 1);
                    }
                }
                this.capFile.getMethodComponent().getExceptionHandlers().remove(i);
                i--;
                continue;
            }

            this.capFile.getMethodComponent().getExceptionHandlers().get(i).setStartOffset(start_offset);
            this.capFile.getMethodComponent().getExceptionHandlers().get(i).setActiveLength(active_length);
            this.capFile.getMethodComponent().getExceptionHandlers().get(i).setHandlerOffset(handler_offset);

        }
    }

    /**
     * Method which will remove an opcode from the bytecode array and correct
     * the dependencies into this array
     *
     * @param pc offset of the instruction to remove
     */
    protected void removeOpCode(int pc) {

        OpCode opCode = methodInfo.getOpcodeMap().get((short) pc);

        logger.debug("Opcode to remove: " + opCode.getName()
                + " (0x" + Integer.toHexString((byte) (opCode.getValue() & 0x00ff))
                + " - size: " + Integer.toString(opCode.getOpcodeSize()) + ") at "
                + "0x" + Integer.toHexString((byte) (pc & 0x00ff)));

        //we correct the jump into the bytecode
        correctJumpWhenRemove(pc, opCode.getOpcodeSize());

        //we remove the opCode from the opCodeMap
        methodInfo.getOpcodeMap().remove((short) pc);

        //we regenerate the arrayList of Bytecode with the modified opCodeMap
        ArrayList<Byte> aCopyByteCode = ByteCodeConverter.OpcodeMapToByteArrayList(methodInfo.getOpcodeMap());

        //we correct the bytecode
        this.editBytecode(aCopyByteCode);

        //we correct the offset into the reference location componentTab
        logger.debug("relativeOffset : " + pc + " opCodeSize: " + opCode.getOpcodeSize());
        ReferenceLocationComponentEditable referenceLocationComponentEditable = new ReferenceLocationComponentEditable(this.capFile);
        referenceLocationComponentEditable.correctReferenceLocationComponentOffset(pc, -opCode.getOpcodeSize());

        updateInstructionOffset();
        updateExceptionHandler(pc, (short) -opCode.getOpcodeSize());
    }

    /**
     * Method recreating the bytecode array with the data contained in the
     * opCodeMap. this method should be used when the opCodeMap has been edited
     * and we want to save the methodInfo
     */
    public void regenerateByteCodeFromOpcodeMap() {
        //the opcodeMap is turned into a byte arrayList which is used to edit the bytecode array
        this.editBytecode(ByteCodeConverter.OpcodeMapToByteArrayList(methodInfo.getOpcodeMap()));

    }

    /**
     * Method which will correct opcode offset when an opocde is added
     *
     * @param addOffset  offset where the opCode is add
     * @param opCodeSize size of the opCode
     */
    private void correctJumpWhenAdd(int addOffset, int opCodeSize) {

        //we get every opCodeMap keys
        ArrayList<Short> aKeys = new ArrayList<Short>(methodInfo.getOpcodeMap().keySet());
        Collections.sort(aKeys);

        //we check that the bytecode is not empty
        if (methodInfo.getBytecodes().isEmpty()) {
            return;
        }

        //first loop which will treat positive offset
        int i = 0;
        int currentOffset = aKeys.get(i) /*- methodInfo.getFirstBytecodeOffset()*/;

        while (currentOffset < addOffset) {
            logger.trace("current offset : " + Integer.toHexString(currentOffset /*+ methodInfo.getFirstBytecodeOffset()*/) + "->" + methodInfo.getOpcodeMap().get(aKeys.get(i)).getName());
            //we will check every argument

            for (int j = 0; j < methodInfo.getOpcodeMap().get(aKeys.get(i)).getArguments().size(); j++) {

                //if it's an instance of Offset
                if (methodInfo.getOpcodeMap().get(aKeys.get(i)).getArguments().get(j) instanceof Offset) {

                    Offset of = (Offset) methodInfo.getOpcodeMap().get(aKeys.get(i)).getArguments().get(j);
                    //we check if the offset is an offset into the bytecode
                    switch (((Offset) of).getDestination()) {

                        case BYTECODE:
                            //if it's an offset into the bytecode we check if the
                            //sum  of currentOffset and offset is higher than the addOffset
                            if (of.getIntValue() + (currentOffset - methodInfo.getFirstBytecodeOffset()) > addOffset) {
                                methodInfo.getOpcodeMap().get(aKeys.get(i)).getArguments().get(j).setIntValue(of.getIntValue() + opCodeSize);
                                logger.debug("Correction: 0x" +
                                        Integer.toHexString(of.getIntValue()) + " -> " + of.toString());
                            } else {
                                logger.debug("Ok, no change: 0x" +
                                        Integer.toHexString(of.getIntValue() + currentOffset));
                            }

                            break;

                        default:
                            break;

                    }
                }
            }


            i++;

            //we check the case where the addOffset is at the end of the arrayList
            if (i >= aKeys.size() - 1) {
                break;
            }
            currentOffset = aKeys.get(i) /*- methodInfo.getFirstBytecodeOffset()*/;
        }

        //second loop which will treat negative offset
        while (i < aKeys.size() - 1) {
            currentOffset = aKeys.get(i) - methodInfo.getFirstBytecodeOffset();
            //we  check every argument
            for (Argument arg : methodInfo.getOpcodeMap().get(aKeys.get(i)).getArguments()) {

                //if it's an instance of Offset
                if (arg instanceof Offset) {
                    //we check if the offset is an offset into the bytecode
                    switch (((Offset) arg).getDestination()) {

                        case BYTECODE:
                            //if it's an offset into the bytecode we check if the
                            //sum  of currentOffset and offset is lower than the addOffset

                            if (arg.getIntValue() + currentOffset < addOffset) {
                                arg.setIntValue(arg.getIntValue() - opCodeSize);
                            }

                            break;

                        default:
                            break;

                    }
                }
            }

            i++;
        }
    }

    /**
     * method which will correct opcode offset when an opocde is removed
     *
     * @param addOffset  offset where the opCode is add
     * @param opCodeSize size of the opCode
     */
    private void correctJumpWhenRemove(int addOffset, int opCodeSize) {


        //we get every opCodeMap keys
        ArrayList<Short> aKeys = new ArrayList<Short>(methodInfo.getOpcodeMap().keySet());
        Collections.sort(aKeys);


        //first loop which will treat positive offset
        int i = 0;
        int currentOffset = aKeys.get(i) - methodInfo.getFirstBytecodeOffset();


        while (currentOffset < addOffset) {

            //we will check every argument

            for (int j = 0; j < methodInfo.getOpcodeMap().get(aKeys.get(i)).getArguments().size(); j++) {

                //if it's an instance of Offset
                if (methodInfo.getOpcodeMap().get(aKeys.get(i)).getArguments().get(j) instanceof Offset) {

                    Offset of = (Offset) methodInfo.getOpcodeMap().get(aKeys.get(i)).getArguments().get(j);
                    //we check if the offset is an offset into the bytecode
                    switch (((Offset) of).getDestination()) {

                        case BYTECODE:
                            //if it's an offset into the bytecode we check if the
                            //sum  of currentOffset and offset is higher than the addOffset
                            logger.debug(methodInfo.getOpcodeMap().get(aKeys.get(i)).getName() + " " + of.getIntValue());

                            if (of.getIntValue() + currentOffset > addOffset) {
                                methodInfo.getOpcodeMap().get(aKeys.get(i)).getArguments().get(j).setIntValue(of.getIntValue() - opCodeSize);
                                logger.debug("Correction: " + of.getIntValue() + " -> " + of.toString());
                            } else {
                                logger.debug("Ok, no change: " + of.getIntValue() + currentOffset);
                            }

                            break;

                        default:
                            break;
                    }
                }
            }

            i++;

            //we check the case where the addOffset is at the end of the arrayList
            if (i == aKeys.size() - 1) {
                break;
            }
            currentOffset = aKeys.get(i) - methodInfo.getFirstBytecodeOffset();
        }

        //second loop which will treat negative offset
        while (i < aKeys.size() - 1) {

            currentOffset = aKeys.get(i) - methodInfo.getFirstBytecodeOffset();
            //we  check every argument
            for (Argument arg : methodInfo.getOpcodeMap().get(aKeys.get(i)).getArguments()) {

                //if it's an instance of Offset
                if (arg instanceof Offset) {
                    //we check if the offset is an offset into the bytecode
                    switch (((Offset) arg).getDestination()) {

                        case BYTECODE:
                            //if it's an offset into the bytecode we check if the
                            //sum  of currentOffset and offset is lower than the addOffset

                            if (arg.getIntValue() + currentOffset < addOffset) {
                                arg.setIntValue(arg.getIntValue() + opCodeSize);
                            }

                            break;

                        default:
                            break;

                    }
                }
            }
            i++;
        }

    }

    /**
     * methods used to correct the size of the method components it will alose
     * correct the size mentionned in the directory componentTab
     *
     * @param newSize the new size of the componentTab
     */
    private void correctSize(short newSize) {

        capFile.getMethodComponent().setSize(newSize);
        capFile.getDirectoryComponent().setMethodComponentSize(newSize);
    }

    /**
     * methods used to correct the method offset present in the components of
     * the cap file (except the method componentTab). this method is called once
     * a byte has been edited
     *
     * @param methodOffsetWhereTheByteCodeWasInserted the method offset which has been edited
     */
    private void correctMethodOffsetInOtherComponents(int methodOffsetWhereTheByteCodeWasInserted) {

        /// XXX: Applet component may be null.
        if (capFile.getAppletComponent() != null) {
            //correction of the installMethodOffset in AppletComponent
            for (CapApplet ap : capFile.getAppletComponent().getApplets()) {
                int apMethodNumber = capFile.getOffsetMethodToNumber().get(ap.getInstallMethodOffset());

                //the offset needs to be corrected only if the methods is after the method that has been corrected
                if (methodOffsetWhereTheByteCodeWasInserted < ap.getInstallMethodOffset()) {
                    short newOffset = capFile.getMethodComponent().getMethods().get(apMethodNumber).getMethodInfoOffset();

                    ap.setInstallMethodOffset(newOffset);
                }

            }
        }

        //correction of the InternalStaticMethodRef in constantPool
        for (ConstantPoolInfo elem : capFile.getConstantPoolComponent().getConstantPool()) {

            if (elem instanceof ConstantStaticMethodRef) {

                ConstantStaticMethodRef tmp = (ConstantStaticMethodRef) elem;

                if (tmp.getStaticMethodRef() instanceof InternalStaticMethodRef) {
                    InternalStaticMethodRef tmp2 = (InternalStaticMethodRef) tmp.getStaticMethodRef();
                    int statMetNumber = capFile.getOffsetMethodToNumber().get(tmp2.getOffset());

                    //the offset needs to be corrected only if the methods is after the method that has been corrected
                    if (tmp2.getOffset() > methodOffsetWhereTheByteCodeWasInserted) {
                        short newOffset = capFile.getMethodComponent().getMethods().get(statMetNumber).getMethodInfoOffset();

                        tmp2.setOffset(newOffset);
                    }
                }
            }
        }

        //correction of the publicVirtualMethodTable and packageVirtualMethodTable in the classInfo section of the classComponent
        for (ClassInfo classInfo : capFile.getClassComponent().getClasses()) {

            for (int i = 0; i < classInfo.getPublicVirtualMethodTable().size(); i++) {

                //whe should check that the method offset is not 0xffff 
                short formerOffset = classInfo.getPublicVirtualMethodTable().get(i);

                if (formerOffset == (short) 0xffff) {
                    continue;
                }

                int cInfMethodNumber = capFile.getOffsetMethodToNumber().get(formerOffset);


                //the offset needs to be corrected only if the methods is after the method that has been corrected
                if (formerOffset > methodOffsetWhereTheByteCodeWasInserted) {

                    short newOffset = 0;
                    try {
                        newOffset = capFile.getMethodComponent().getMethods().get(cInfMethodNumber).getMethodInfoOffset();
                    } catch (Exception e) {
                        logger.error("exception : " + capFile.getOffsetMethodToNumber().get(formerOffset), e);
                    }


                    classInfo.getPublicVirtualMethodTable().set(i, newOffset);
                }
            }

            for (int i = 0; i < classInfo.getPackageVirtualMethodTable().size(); i++) {

                //whe should check that the method offset is not 0xffff
                short formerOffset = classInfo.getPackageVirtualMethodTable().get(i);

                if (formerOffset == (short) 0xffff) {
                    continue;
                }

                int cInfMethodNumber = capFile.getOffsetMethodToNumber().get(formerOffset);


                //the offset needs to be corrected only if the methods is after the method that has been corrected
                if (formerOffset > methodOffsetWhereTheByteCodeWasInserted) {

                    short newOffset = 0;
                    try {
                        newOffset = capFile.getMethodComponent().getMethods().get(cInfMethodNumber).getMethodInfoOffset();
                    } catch (Exception e) {
                        logger.error("exception : " + capFile.getOffsetMethodToNumber().get(formerOffset), e);
                    }


                    classInfo.getPackageVirtualMethodTable().set(i, newOffset);
                }
            }

        }

        //correction of the offset containd in the export Component
        if (capFile.getExportComponent() != null) {
            for (ClassExportsInfo cEx : capFile.getExportComponent().getClassExports()) {

                for (int i = 0; i < cEx.getStaticMethodOffsets().size(); i++) {
                    short formerOffset = cEx.getStaticMethodOffsets().get(i);
                    int exMethodNumber = capFile.getOffsetMethodToNumber().get(formerOffset);

                    //the offset needs to be corrected only if the methods is after the method that has been corrected
                    if (formerOffset > methodOffsetWhereTheByteCodeWasInserted) {
                        short newOffset = capFile.getMethodComponent().getMethods().get(exMethodNumber).getMethodInfoOffset();
                        cEx.getStaticMethodOffsets().set(i, newOffset);
                    }
                }
            }
        }
    }
}
