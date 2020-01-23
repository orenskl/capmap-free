package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class GETFIELD_A_THIS extends FieldInstruction implements ExceptionThrower, StackConsumer, StackProducer {

    public GETFIELD_A_THIS(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.GETFIELD_A_THIS);
        index = byteArray.get(offSet + 1);
    }
}