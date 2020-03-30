/**
 * ByteCodeConverter.java
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

package fr.xlim.ssd.capmanipulator.library.bytecodereader;

import fr.xlim.ssd.capmanipulator.library.Instruction;
import fr.xlim.ssd.capmanipulator.library.exceptions.IllegalValueException;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnknownBytecodeError;
import org.apache.commons.collections.bidimap.TreeBidiMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class ByteCodeConverter {

    private static final Logger logger = LoggerFactory.getLogger(ByteCodeConverter.class);

    private TreeBidiMap mBytecode;

    /**
     * Constructor
     */
    public ByteCodeConverter(String xmlConf) {
        this.mBytecode = new TreeBidiMap(new ByteCodeConfiguration().getmBytecode());
    }

    public static ArrayList<Byte> OpcodeMapToByteArrayList(Map<Short, OpCode> mOpCode) {

        ArrayList<Byte> aByte = new ArrayList<Byte>();

        for (Entry<Short, OpCode> currentEntry : mOpCode.entrySet()) {
            aByte.addAll(currentEntry.getValue().getByteArrayValue());
        }

        return aByte;
    }

    public ArrayList<Byte> Opcode2ByteCode(String opcode) throws IllegalValueException {
        ArrayList<Byte> bytecode = new ArrayList<Byte>();
        String[] codes = opcode.split("\\s+");

        for (int i = 0; i < codes.length; i++) {
            Byte key;
            try {
                key = (Byte) this.mBytecode.getKey(new OpCode((byte) 0, codes[i], null));
            } catch (Exception e) {
                throw new IllegalValueException(codes[i] + " isn't a OpCode");
            }
            OpCode c = (OpCode) this.mBytecode.get(key);
            bytecode.add(c.getValue());
            for (int j = 0; j < c.getArguments().size(); j++) {
                i++;
                bytecode.add((byte) Integer.parseInt(codes[i], 16));
            }
        }

        return bytecode;
    }

    public String ByteCode2Opcode(ArrayList<Byte> bytecodes) throws Exception {
        StringBuilder opcode = new StringBuilder();

        short i = 0;

        //we treat the byteCode array
        while (i < bytecodes.size()) {

            //we search in the map defining the bytecode if we have the value read
            if (mBytecode.containsKey(bytecodes.get(i))) {

                OpCode myOp = (OpCode) mBytecode.get(bytecodes.get(i++));

                //we'll read the argument of the opcode
                for (Argument a : myOp.getArguments()) {
                    for (int j = 0; j < a.getExpected_size(); j++) {
                        a.getValue()[j] = bytecodes.get(i++);
                    }
                }

                // specific case management
                // we will manage the case of opcode wich have
                // a variable number of argument
                switch (Instruction.valueOfByOpcode(myOp)) {

                    case STABLESWITCH:    //case of stableswitch
                        short s_low = (short) ((myOp.getArguments().get(1).getValue()[0] << 8) | myOp.getArguments().get(1).getValue()[1]);
                        short s_high = (short) ((myOp.getArguments().get(2).getValue()[0] << 8) | myOp.getArguments().get(2).getValue()[1]);


                        //whe should add (high - low) + 1 pairs in the argument array
                        for (int j = 0; j < (s_high - s_low) + 1; j++) {

                            //we get the value of the pair
                            byte[] value = new byte[2];
                            value[0] = bytecodes.get(i++);
                            value[1] = bytecodes.get(i++);

                            Offset o = new Offset(value, true, Destination.BYTECODE);
                            myOp.getArguments().add(o);

                        }

                        break;
                    case ITABLESWITCH:    //case of itableswitch
                        int i_low = myOp.getArguments().get(1).getValue()[0] << 24
                                | myOp.getArguments().get(1).getValue()[1] << 16
                                | myOp.getArguments().get(1).getValue()[2] << 8
                                | myOp.getArguments().get(1).getValue()[3];
                        int i_high = myOp.getArguments().get(2).getValue()[0] << 24
                                | myOp.getArguments().get(2).getValue()[1] << 16
                                | myOp.getArguments().get(2).getValue()[2] << 8
                                | myOp.getArguments().get(2).getValue()[3];

                        //whe should add (high - low) + 1 pairs in the argument array
                        for (int j = 0; j < (i_high - i_low) + 1; j++) {

                            //we get the value of the pair
                            byte[] value = new byte[2];
                            value[0] = bytecodes.get(i++);
                            value[1] = bytecodes.get(i++);

                            Offset o = new Offset(value, true, Destination.BYTECODE);
                            myOp.getArguments().add(o);

                        }

                        break;

                    case SLOOKUPSWITCH: //case of slookupswitch
                        short s_npair = (short) (myOp.getArguments().get(1).getValue()[0] >> 8 | myOp.getArguments().get(1).getValue()[1]);

                        for (int j = 0; j < s_npair; j++) {
                            //we create the operand describing the matchByte 1 and 2
                            byte[] value = new byte[2];
                            value[0] = bytecodes.get(i++);
                            value[1] = bytecodes.get(i++);

                            Operand op = new Operand(value, true);
                            myOp.getArguments().add(op);


                            //we create the offset
                            value = new byte[2];
                            value[0] = bytecodes.get(i++);
                            value[1] = bytecodes.get(i++);

                            Offset off = new Offset(value, true, Destination.BYTECODE);
                            myOp.getArguments().add(off);
                        }

                        break;

                    case ILOOKUPSWITCH: //case of ilookupswitch
                        short i_npair = (short) (myOp.getArguments().get(1).getValue()[0] >> 8 | myOp.getArguments().get(1).getValue()[1]);

                        for (int j = 0; j < i_npair; j++) {
                            //we create the operand describing the matchByte 1 to 4
                            byte[] value = new byte[4];
                            value[0] = bytecodes.get(i++);
                            value[1] = bytecodes.get(i++);
                            value[2] = bytecodes.get(i++);
                            value[3] = bytecodes.get(i++);

                            Operand op = new Operand(value, true);
                            myOp.getArguments().add(op);


                            //we create the offset
                            value = new byte[2];
                            value[0] = bytecodes.get(i++);
                            value[1] = bytecodes.get(i++);

                            Offset off = new Offset(value, true, Destination.BYTECODE);
                            myOp.getArguments().add(off);
                        }

                        break;

                }

                opcode.append(myOp.getName());

                if (myOp.getArguments() != null) {
                    opcode.append("\t");
                }

                for (Argument a : myOp.getArguments()) {
                    opcode.append(argValue(a)).append(' ');
                }
                opcode.append("\n");

            } else {
                //if the map doesn't contain the value that we're looking for, an exception is thrown
                logger.debug("map size : {}", mBytecode.size());
                throw new UnknownBytecodeError("unknow opcode: " + bytecodes.get(i));

            }
        }

        return opcode.toString();
    }

    private String argValue(Argument a) {

        Integer intValue = 0;
        StringBuilder ret = new StringBuilder();

        for (int i = a.getExpected_size() - 1; i >= 0; i--) {
            if (a.isSigned()) {

                if (i != 0) {
                    intValue += (a.getValue()[i] & 0xff) << ((a.getExpected_size() - 1 - i) * 8);
                } else {
                    intValue += a.getValue()[i] << ((a.getExpected_size() - 1 - i) * 8);
                }

            } else {
                intValue += (a.getValue()[i] & 0xff) << ((a.getExpected_size() - 1 - i) * 8);
            }

        }

        if (intValue < 0) {
            ret.append("-").append(Integer.toHexString(Math.abs(intValue)));

        } else {
            ret.append(Integer.toHexString(intValue));
        }

        return ret.toString();
    }
}
