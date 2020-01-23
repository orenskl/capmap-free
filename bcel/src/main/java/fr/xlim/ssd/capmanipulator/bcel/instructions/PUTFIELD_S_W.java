package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class PUTFIELD_S_W extends FieldInstruction implements ExceptionThrower, PopInstruction {

    public PUTFIELD_S_W(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.PUTFIELD_S_W);
        index = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}