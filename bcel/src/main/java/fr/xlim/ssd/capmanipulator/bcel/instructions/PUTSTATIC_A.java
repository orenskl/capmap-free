package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class PUTSTATIC_A extends FieldInstruction implements ExceptionThrower, PopInstruction {

    public PUTSTATIC_A(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.PUTSTATIC_A);
        index = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}