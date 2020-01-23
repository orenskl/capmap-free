package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class NEW extends CPInstruction implements LoadClass, AllocationInstruction, ExceptionThrower, StackProducer {

    public NEW(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.NEW);
        index = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}