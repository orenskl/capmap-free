package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class GETFIELD_I extends FieldInstruction implements ExceptionThrower, StackConsumer, StackProducer {

    public GETFIELD_I(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.GETFIELD_I);
    }

}