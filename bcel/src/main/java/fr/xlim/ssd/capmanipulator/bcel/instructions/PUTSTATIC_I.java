package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class PUTSTATIC_I extends FieldInstruction implements ExceptionThrower, PopInstruction {

    public PUTSTATIC_I(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.PUTSTATIC_I);
        index = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}