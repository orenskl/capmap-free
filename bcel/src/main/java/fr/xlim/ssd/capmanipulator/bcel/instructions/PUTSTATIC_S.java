package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class PUTSTATIC_S extends FieldInstruction implements ExceptionThrower, PopInstruction {

    public PUTSTATIC_S(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.PUTSTATIC_S);
        index = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}