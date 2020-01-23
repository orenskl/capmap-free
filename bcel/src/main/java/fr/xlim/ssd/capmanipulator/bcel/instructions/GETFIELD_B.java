package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class GETFIELD_B extends FieldInstruction implements ExceptionThrower, StackConsumer, StackProducer {

    public GETFIELD_B(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.GETFIELD_B);
        index = byteArray.get(offSet + 1);
    }
}