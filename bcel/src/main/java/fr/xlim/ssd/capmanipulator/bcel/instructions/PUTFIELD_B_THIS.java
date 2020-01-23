package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class PUTFIELD_B_THIS extends FieldInstruction implements ExceptionThrower, PopInstruction {

    public PUTFIELD_B_THIS(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.PUTFIELD_B_THIS);
        index = byteArray.get(offSet + 1);
    }
}