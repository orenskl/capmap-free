package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class GETFIELD_I_W extends FieldInstruction implements ExceptionThrower, StackConsumer, StackProducer {

    public GETFIELD_I_W(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.GETFIELD_I_W);
        index = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}