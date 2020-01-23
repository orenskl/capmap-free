package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class GETFIELD_A extends FieldInstruction implements ExceptionThrower, StackConsumer, StackProducer {

    public GETFIELD_A(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.GETFIELD_A);
        index = byteArray.get(offSet + 1);
    }
}