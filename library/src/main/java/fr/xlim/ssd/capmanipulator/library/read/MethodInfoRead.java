package fr.xlim.ssd.capmanipulator.library.read;

import fr.xlim.ssd.capmanipulator.library.MethodInfo;
import fr.xlim.ssd.capmanipulator.library.bytecodereader.*;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnknownBytecodeError;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnknownFlagException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MethodInfoRead {

    private static final Logger logger = LoggerFactory.getLogger(MethodInfoRead.class);

    /**
     * read the MethodInfo a cap file to set the values of the Method Info
     *
     * @param in    Cap File to read
     * @param start offset to method's begin
     * @param end   offset to method's end
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnknownFlagException
     */
    public MethodInfo load(CapInputStream in, final Short start, final Short end) throws UnableToReadCapFileException {
        try {

            MethodInfo methodInfo = new MethodInfo();

            byte bitfield = in.readByte();
            byte flags = (byte) ((bitfield & 0xF0) >>> 4);
            methodInfo.setBytecodes(new ArrayList<Byte>());

            methodInfo.setMethodInfoOffset(start);

            if ((flags == MethodInfo.ACC_EXTENDED)) {

                // extended method header info
                methodInfo.setMethodHeader(new ExtendedMethodHeaderInfoRead().load(in, bitfield));

                for (int i = (start + MethodInfo.EXTENDED_METHOD_HEADER_INFO_SIZE);
                     i < end; i++) {
                    methodInfo.getBytecodes().add(in.readByte());
                }


                //we generate the opcodeMap
                methodInfo.setFirstBytecodeOffset((short) (methodInfo.getMethodInfoOffset() +
                        MethodInfo.EXTENDED_METHOD_HEADER_INFO_SIZE));
                makeOpcodeArray(methodInfo);


            } else {
                methodInfo.setMethodHeader(new MethodHeaderInfoRead().load(in, bitfield));

                if (flags == MethodInfo.ACC) {

                    // method
                    for (int i = (start + MethodInfo.METHOD_HEADER_INFO_SIZE);
                         i < end; i++) {
                        methodInfo.getBytecodes().add(in.readByte());
                    }

                    //we generate the opcodeMap
                    methodInfo.setFirstBytecodeOffset((short) (methodInfo.getMethodInfoOffset() + MethodInfo.METHOD_HEADER_INFO_SIZE));
                    makeOpcodeArray(methodInfo);

                } else if (flags != MethodInfo.ACC_ABSTRACT) {
                    // not abstract method
                    throw new UnknownFlagException("unknown flag value: " + flags);
                }
            }

            return methodInfo;

        } catch (UnknownFlagException e) {
            throw new UnableToReadCapFileException("unknow access flag");
        }
    }

    /**
     * Fill the opcodeArray with the value of the bytecode array
     *
     * @throws Exception
     */
    public void makeOpcodeArray(MethodInfo methodInfo) {

        methodInfo.setOpcodeMap(new TreeMap<Short, OpCode>());

        short byteCodeOffset = methodInfo.getFirstBytecodeOffset();

        ByteCodeConfiguration bc = new ByteCodeConfiguration();
        Map<Byte, OpCode> mBytecode = bc.getmBytecode();

        short i = 0;


        //we treat the byteCode array
        while (i < methodInfo.getBytecodes().size()) {

            //we search in the map defining the bytecode if whe have the value read
            if (mBytecode.containsKey(methodInfo.getBytecodes().get(i))) {


                //we clone the object describing the opcode in the map
                OpCode myOp = (OpCode) mBytecode.get(methodInfo.getBytecodes().get(i)).clone();

                //we add it in our opcodeMap
                methodInfo.getOpcodeMap().put((short) (i + byteCodeOffset), myOp);

                i++;

                //we'll read the argument of the opcode
                for (Argument a : myOp.getArguments()) {
                    for (int j = 0; j < a.getExpected_size(); j++) {
                        a.getValue()[j] = methodInfo.getBytecodes().get(i++);
                    }
                }


                // specific case management
                // we will manage the case of opcode wich have
                // a variable number of argument
                switch (myOp.getValue()) {

                    case 0x73:    //case of stableswitch
                    case 0x74:    //case of itableswitch
                        short low = (short) ((myOp.getArguments().get(1).getValue()[0] << 8) | myOp.getArguments().get(1).getValue()[1]);
                        short high = (short) ((myOp.getArguments().get(2).getValue()[0] << 8) | myOp.getArguments().get(2).getValue()[1]);


                        //whe should add (high - low) + 1 pairs in the argument array
                        for (int j = 0; j < (high - low) + 1; j++) {

                            //we get the value of the pair
                            byte[] value = new byte[2];
                            value[0] = methodInfo.getBytecodes().get(i++);
                            value[1] = methodInfo.getBytecodes().get(i++);

                            Offset o = new Offset(value, true, Destination.BYTECODE);
                            myOp.getArguments().add(o);

                        }

                        break;

                    case 0x75: //case of slookupswitch
                    case 0x76: //case of ilookupswitch
                        short npair = (short) (myOp.getArguments().get(1).getValue()[0] >> 8 | myOp.getArguments().get(1).getValue()[1]);

                        for (int j = 0; j < npair; j++) {
                            //we create the operand describing the matchByte 1 and 2
                            byte[] value = new byte[2];
                            value[0] = methodInfo.getBytecodes().get(i++);
                            value[1] = methodInfo.getBytecodes().get(i++);

                            Operand op = new Operand(value, true);
                            myOp.getArguments().add(op);


                            //we create the offset
                            value = new byte[2];
                            value[0] = methodInfo.getBytecodes().get(i++);
                            value[1] = methodInfo.getBytecodes().get(i++);

                            Offset off = new Offset(value, true, Destination.BYTECODE);
                            myOp.getArguments().add(off);
                        }

                        break;


                    default:


                }
            } else {
                //if the map doesn't contain the value that we're looking for, an exception is thrown
                logger.debug("map size: {}", mBytecode.size());
                throw new UnknownBytecodeError("bytecode found: 0x" + Integer.toHexString(methodInfo.getBytecodes().get(i) & 0x00FF));
            }

        }
    }
}
