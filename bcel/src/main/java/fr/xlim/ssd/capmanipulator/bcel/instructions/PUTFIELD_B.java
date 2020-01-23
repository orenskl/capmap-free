package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class PUTFIELD_B extends FieldInstruction implements ExceptionThrower, PopInstruction {

    public PUTFIELD_B(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.PUTFIELD_B);
        index = byteArray.get(offSet + 1);
    }
}