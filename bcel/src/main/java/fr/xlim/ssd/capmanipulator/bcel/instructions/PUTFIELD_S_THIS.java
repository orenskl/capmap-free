package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class PUTFIELD_S_THIS extends FieldInstruction implements ExceptionThrower, PopInstruction {

    public PUTFIELD_S_THIS(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.PUTFIELD_S_THIS);
        index = byteArray.get(offSet + 1);
    }
}