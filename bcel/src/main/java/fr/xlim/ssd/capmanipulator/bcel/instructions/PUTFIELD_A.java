package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class PUTFIELD_A extends FieldInstruction implements ExceptionThrower, PopInstruction {

    public PUTFIELD_A(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.PUTFIELD_A);
        index = byteArray.get(offSet + 1);
    }
}