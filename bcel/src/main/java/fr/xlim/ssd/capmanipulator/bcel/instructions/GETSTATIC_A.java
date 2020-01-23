package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class GETSTATIC_A extends FieldInstruction implements PushInstruction, ExceptionThrower {

    public GETSTATIC_A(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.GETSTATIC_A);
        index = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}