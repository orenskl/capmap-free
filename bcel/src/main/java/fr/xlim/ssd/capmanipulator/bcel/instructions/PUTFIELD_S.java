package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class PUTFIELD_S extends FieldInstruction implements ExceptionThrower, PopInstruction {

    public PUTFIELD_S(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.PUTFIELD_S);
        index = byteArray.get(offSet + 1);
    }
}