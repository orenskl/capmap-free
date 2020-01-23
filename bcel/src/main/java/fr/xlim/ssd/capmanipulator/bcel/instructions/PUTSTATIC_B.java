package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class PUTSTATIC_B extends FieldInstruction implements ExceptionThrower, PopInstruction {

    public PUTSTATIC_B(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.PUTSTATIC_B);
        index = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}