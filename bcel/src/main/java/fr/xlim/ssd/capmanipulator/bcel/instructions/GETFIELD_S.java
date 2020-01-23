package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class GETFIELD_S extends FieldInstruction implements ExceptionThrower, StackConsumer, StackProducer {

    public GETFIELD_S(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.GETFIELD_S);
        index = byteArray.get(offSet + 1);
    }
}