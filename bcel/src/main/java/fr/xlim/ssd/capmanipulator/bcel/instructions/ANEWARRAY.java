package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class ANEWARRAY extends CPInstruction implements LoadClass, AllocationInstruction, ExceptionThrower, StackConsumer, StackProducer {

    public ANEWARRAY(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.ANEWARRAY);
        index = (byteArray.get(offSet + 1) << 8 ) | byteArray.get(offSet + 2);
    }
}